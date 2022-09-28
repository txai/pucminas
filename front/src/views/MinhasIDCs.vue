<template>
    <v-container>
        <v-data-iterator
            :items="idcs"
            :search="search"
        >
            <template v-slot:header>
                <v-text-field
                    v-model="search"
                    label="Buscar"
                    clearable
                    flat
                    hide-details="auto"
                ></v-text-field>
            </template>
            <template v-slot:default="props">
                <v-list>
                    <v-list-item v-for="item in props.items" :key="item.nome">
                        <ItemIDC :idc="item"></ItemIDC>
                    </v-list-item>
                </v-list>
            </template>
            <template v-slot:no-results>
                <span>Nenhum resultado encontrado</span>
            </template>
        </v-data-iterator>
    </v-container>
</template>

<script>
    import ItemIDC from '@/components/ItemIDC.vue';
    const myIdcs = [
        {id: 1, nome: 'Igreja São João', dataDistribuicao: "27/05/2022", cestasRestantes: 3, composicaoCesta: ['Arroz', 'Feijão']},
        {id: 2, nome: 'Projeto lá de casa', dataDistribuicao: "27/05/2022", cestasRestantes: 1, composicaoCesta: ['Arroz', 'Feijão']}
    ]
    export default {
        data() {
            return {
                idcs: myIdcs,
                search: '',
                filter: {}
            }
        },
        components: {
            ItemIDC
        }
    }
</script>