<template>
    <v-container fluid style="max-width: 90%;">
        <v-card>
            <v-app-bar flat dense color="white">
                <v-app-bar-title>{{ idc.nome }}</v-app-bar-title>
                <v-spacer />
                <v-btn icon @click="editDialog=true"><v-icon>mdi-pencil</v-icon></v-btn>
                <AddEditIniciativa v-model="editDialog" @save="onEdition" :ext-idc="idc"></AddEditIniciativa>
                <v-dialog width="500" v-model="deleteDialog">
                    <template v-slot:activator="{on, attrs}">
                        <v-btn icon v-bind="attrs" v-on="on">
                            <v-icon>mdi-delete</v-icon>
                        </v-btn>
                    </template>
                    <v-card>
                        <v-card-title class="text-h6 warning" dense>Apagar iniciativa</v-card-title>
                        <v-divider vertical />
                        <v-card-text>Tem certeza que deseja apagar a iniciativa {{ idc.nome }} ?</v-card-text>
                        
                        <v-card-actions>
                            <v-spacer />
                            <v-btn text @click="onDelete">Sim</v-btn>
                            <v-btn text @click="deleteDialog = false">Não</v-btn>
                        </v-card-actions>
                    </v-card>
                </v-dialog>
            </v-app-bar>
            <v-card-title></v-card-title>
            <v-card-subtitle>{{ idc.dataDistribuicao }}</v-card-subtitle>
        </v-card>
    </v-container>
</template>

<script>
import AddEditIniciativa from './AddEditIniciativa.vue';
    export default {
    name: "CardIniciativa",
    data() {
        return {
            deleteDialog: false,
            editDialog: false,
            localIdc: {}
        };
    },
    mounted() {
        this.localIdc = this.idc
    },
    props: {
        idc: Object
    },
    methods: {
        onDelete() {
            this.$emit('deleted', this.localIdc);
        },
        onEdition(idc) {
            this.localIdc = idc
            this.$emit('edited', this.localIdc);
            this.editDialog = false
        }
    },
    components: { AddEditIniciativa }
}
</script>