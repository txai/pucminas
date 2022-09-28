<template>
    <v-container>
    <v-row>
        <v-col xs="12">
        <v-card>
            <v-card-title>{{ idc.nome }}</v-card-title>
            <v-card-subtitle>{{ idc.dataDistribuicao }}</v-card-subtitle>
        </v-card>
        </v-col>
    </v-row>
</v-container>
</template>

<script>
    export default {
        name: "ItemIDC",
        data() {
            return {}
        },
        props: {
            idc: Object
        }
    }
</script>