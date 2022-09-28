<template>
    <v-list>
        <v-list-item v-for="idc in idcs" :key="idc.id">{{idc.nome}}</v-list-item>
    </v-list>
</template>

<script>
    const myIdcs = [
        {id: 1, nome: 'Igreja São João', cestasRestantes: 3, composicaoCesta: ['Arroz', 'Feijão']},
        {id: 2, nome: 'Projeto lá de casa', cestasRestantes: 1, composicaoCesta: ['Arroz', 'Feijão']}
    ]
    export default {
        name: 'ListaIDC',
        data() {
            return {
                idcs: myIdcs
            }
        }
    }
</script>