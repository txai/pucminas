<template>
    <v-main>
        <v-autocomplete>Buscar</v-autocomplete>
        <ListaIDC></ListaIDC>
    </v-main>
</template>

<script>
    import ListaIDC from '@/components/ListaIDC.vue';
    export default {
        data() {
            return {}
        },
        components: {
            ListaIDC
        }
    }
</script>