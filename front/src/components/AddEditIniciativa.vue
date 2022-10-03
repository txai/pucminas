<template>
    <AddEditDialog :title="title" v-model="show" @save="onSave">
        <v-text-field v-model="idc.nome" label="Nome" />
        <v-text-field v-model="idc.dataDistribuicao" label="Data de distribuição" />
    </AddEditDialog>
</template>

<script>
    import AddEditDialog from "./AddEditDialog.vue"
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
            this.idc = this.extIdc === undefined ? {} : this.extIdc
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
        components: {
            AddEditDialog
        },
        methods: {
            onSave() {
                this.$emit('save', this.idc)
            }
        }
    }
</script>