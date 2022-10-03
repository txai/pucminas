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
        <AddEditIniciativa v-model="addDialog" @save="onAddItem" :ext-idc="newIdc"></AddEditIniciativa>
    </v-container>
</template>

<script>
    import CardIniciativa from '@/components/CardIniciativa.vue';
    import AddButton from '@/components/AddButton.vue';
    import AddEditIniciativa from '@/components/AddEditIniciativa.vue';

    const myIdcs = [
        {id: 1, nome: 'Igreja São João', dataDistribuicao: "27/05/2022", cestasRestantes: 3, composicaoCesta: ['Arroz', 'Feijão']},
        {id: 2, nome: 'Projeto lá de casa', dataDistribuicao: "27/05/2022", cestasRestantes: 1, composicaoCesta: ['Arroz', 'Feijão']}
    ]
    export default {
        data() {
            return {
                idcs: myIdcs,
                search: '',
                filter: {},
                addDialog: false,
                newIdc: {}
            }
        },
        components: {
            CardIniciativa,
            AddButton,
            AddEditIniciativa
        },
        methods: {
            onDeleteItem(idc) {
                this.idcs = this.idcs.filter(item => item.nome !== idc.nome);
            },
            onAddItem(idc) {
                this.idcs.push(idc)
                this.addDialog = false
            },
            onEditItem(idc) {
                this.idcs[idc.nome] = idc
            }
        }
    }
</script>