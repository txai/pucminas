<template>
    <v-container fluid style="max-width: 960px;">
        <v-data-iterator
            :items="idcs"
            :search="search"
            hide-default-footer
            no-data-text="Não existem iniciativas cadastradas"
            no-results-text="Nenhuma iniciativa encontrada"
        >
            <template v-slot:header>
                <v-text-field
                    v-model="search"
                    clearable
                    flat
                    hide-details="auto"
                    append-icon="mdi-magnify"
                />
            </template>
            <template v-slot:default="props">
                <v-list>
                    <v-list-item v-for="item in props.items" :key="item.nome">
                        <CardIniciativa :idc="item" @deleted="onDeleteItem" @edited="onEditItem"></CardIniciativa>
                    </v-list-item>
                </v-list>
            </template>
        </v-data-iterator>
        <AddButton @clicked="addDialog=true" />
        <AddEditIniciativa v-model="addDialog" @save="onAddItem"></AddEditIniciativa>
    </v-container>
</template>

<script>
    import CardIniciativa from '@/components/CardIniciativa.vue';
    import AddButton from '@/components/AddButton.vue';
    import AddEditIniciativa from '@/components/AddEditIniciativa.vue';
    import axios from 'axios';

    //const iniciativaServiceUri = 'http://ec2-18-231-1-252.sa-east-1.compute.amazonaws.com:8090'
    const iniciativaServiceUri = 'http://localhost:8090'

    export default {
        data() {
            return {
                idcs: [],
                search: '',
                filter: {},
                addDialog: false,
            }
        },
        created() {
            axios.get(`${iniciativaServiceUri}/iniciativas`)
                 .then(response => {
                    this.idcs = response.data
                 })
                 .catch(error => console.error(error))
        },
        components: {
            CardIniciativa,
            AddButton,
            AddEditIniciativa
        },
        methods: {
            onDeleteItem(idc) {
                axios.delete(`${iniciativaServiceUri}/iniciativas/${idc.id}`)
                     .then(() => {
                        console.info(`${idc.nome} Excluido com sucesso`)
                        this.idcs = this.idcs.filter(item => item.nome !== idc.nome);
                     })
                     .catch(error => console.error(error))
            },
            onAddItem(idc) {
                axios.post(`${iniciativaServiceUri}/iniciativas`, idc)
                     .then(response => {
                        console.info(`${idc.nome} adicionado com sucesso`)
                        idc.id = response.data.id
                        this.idcs.push(idc)
                        this.addDialog = false
                     })
                     .catch(error => console.error(error))                
            },
            onEditItem(idc) {
                axios.put(`${iniciativaServiceUri}/iniciativas/${idc.id}`, idc)
                     .then(response => {
                        idc = response.data
                        const idcIndex = this.idcs.findIndex(o => {
                            return o.id === idc.id
                        })
                        if(idcIndex !== -1) {
                            this.idcs.splice(idcIndex, 1, idc)
                        }   
                     })
                     .catch(error => console.error(error)) 
            }
        }
    }
</script>