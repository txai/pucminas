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
                        <ItemIDC :idc="item" @deleted="onDeleteItem"></ItemIDC>
                    </v-list-item>
                </v-list>
            </template>
        </v-data-iterator>
        <v-dialog
            fullscreen
            hide-overlay
            v-model="addDialog"
        >
            <template v-slot:activator="{on, attrs}">
                <v-btn 
                    x-large
                    fab
                    bottom
                    right
                    fixed
                    color="secondary"
                    v-bind="attrs"
                    v-on="on"
                >
                    <v-icon>mdi-plus</v-icon>
                </v-btn>
            </template>
            <v-card>
                <v-toolbar color="secondary">
                    <v-spacer />
                    <v-toolbar-title>Adicionar iniciativa</v-toolbar-title>
                    <v-spacer />
                    <v-btn icon @click="addDialog = false"><v-icon>mdi-close</v-icon></v-btn>
                    <v-btn icon @click="addDialog = false"><v-icon>mdi-check</v-icon></v-btn>
                </v-toolbar>
            </v-card>
        </v-dialog>
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
                filter: {},
                addDialog: false
            }
        },
        components: {
            ItemIDC
        },
        methods: {
            onDeleteItem(idc) {
                this.idcs = this.idcs.filter(item => item.nome !== idc.nome);
            }
        }
    }
</script>