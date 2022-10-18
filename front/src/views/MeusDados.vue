<template>
    <v-container fluid style="max-width: 600px;">
    <br><br>
        <v-text-field label="Nome" v-model="user.name"/>
        <v-text-field label="CPF" v-model="user.cpf" />
        <v-text-field label="Data de Nascimento" v-model="user.dataNascimento"/>
        <v-text-field label="Endereço" append-icon="mdi-map-marker" v-model="user.endereco" />
        <v-text-field label="Telefone" append-icon="mdi-phone" v-model="user.telefone"/>
        <v-text-field label="E-mail" append-icon="mdi-email" v-model="user.email" />
    </v-container>
</template>

<script>
import router from '@/router';

    export default {
        data() {
            return { user: {} }
        },
        created() {
            console.log(router.app.$keycloak.tokenParsed)
            this.user.name = router.app.$keycloak.tokenParsed.name
            this.user.dataNascimento = router.app.$keycloak.tokenParsed.dob
            this.user.email = router.app.$keycloak.tokenParsed.email
            this.user.cpf = router.app.$keycloak.tokenParsed.cpf
            this.user.endereco = router.app.$keycloak.tokenParsed.address
            this.user.telefone = router.app.$keycloak.tokenParsed.phone
        }

    }
</script>