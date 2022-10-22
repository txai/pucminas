<template>
    <AddEditDialog :title="title" v-model="show" @save="onSave">
        <v-row>
            <v-col cols="6" md="6">
                <v-text-field v-model="idc.nome" label="Nome*" required />
                <v-text-field v-model="idc.dataDistribuicao" label="Data de distribuição*" required />
                <v-text-field v-model="idc.endereco" label="Endereço" append-icon="mdi-map-marker"/> <!-- Mudar para v-autocomplete -->
                <v-text-field v-model="idc.telefone" label="Telefone" append-icon="mdi-phone" />
                <v-text-field v-model="idc.email" label="E-mail" append-icon="mdi-email" />
            </v-col>
            <v-spacer />
            <v-divider :vertical=!$vuetify.breakpoint.xsOnly inset/>
            <v-col cols="6" md="6">
                <v-subheader>Composição</v-subheader>
                <v-text-field label="Adicionar item"/>
                <v-list dense>
                    <v-list-item v-for="item in idc.itensCesta" :key="item">
                        <v-list-item-title>{{item}}</v-list-item-title>
                        <v-list-item-icon><v-icon>mdi-close</v-icon></v-list-item-icon>
                    </v-list-item>
                </v-list>
            </v-col>
        </v-row>
        
    </AddEditDialog>
</template>

<script>
    import AddEditDialog from "./AddEditDialog.vue"
    let itemId = 0
    export default {
        
        data() {
            return {
                title: "Iniciativa",
                idc: {}
            }
        },
        props: {
            value: Boolean,
            extIdc: Object
        },
        mounted() {
            this.idc = this.extIdc === undefined ? {itensCesta: []} : structuredClone(this.extIdc)
        },
        computed: {
            show: {
                get() {
                    return this.value
                },
                set(value) {
                    this.$emit('input', value)
                }
            }
        },
        watch: {
            show(newState) {
                if(newState === false) {
                    this.idc = this.extIdc === undefined ? {itensCesta: []} : structuredClone(this.extIdc)
                }
            }
        },
        components: {
            AddEditDialog
        },
        methods: {
            onSave() {
                this.$emit('save', this.idc)
            },
            onAddItem(item) {
                item.id = itemId
                itemId++
                console.log(item)
                this.idc.itensCesta.push(item)
            }
        }
    }
</script>