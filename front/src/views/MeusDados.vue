<template>
    <v-container fluid style="max-width: 600px;">
    <br><br>
        <v-text-field label="Nome" />
        <v-text-field label="CPF" />
        <v-text-field label="Data de Nascimento" />
        <v-text-field label="Endereço" append-icon="mdi-map-marker"/>
        <v-text-field label="Telefone" append-icon="mdi-phone" />
        <v-text-field label="E-mail" append-icon="mdi-email" />
    </v-container>
</template>

<script>
    export default {
        data() {
            return {}
        }
    }
</script>