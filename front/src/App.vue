<template>
  <v-app id="app">

    <v-app-bar
      app
      color="secondary"
    >
      <v-app-bar-nav-icon v-if="$vuetify.breakpoint.xsOnly" @click="drawer = !drawer"></v-app-bar-nav-icon>
      <v-spacer />
      <v-toolbar-title style="text-align: center;">{{ $route.meta.title || "ReCeBa" }}</v-toolbar-title>
      <v-spacer />
      <v-btn v-if="!$keycloak.authenticated" @click="$keycloak.login">Entrar</v-btn>
      <v-btn v-else @click="$keycloak.logoutFn">Sair</v-btn>
    </v-app-bar>

    <v-navigation-drawer v-if="$keycloak.authenticated"
      v-model="drawer"
      app
      style="z-index:1001"
      color="primary"
      :permanent="!$vuetify.breakpoint.xsOnly"
    >
      <v-list 
        nav
      >
        <v-list-item :to="{path: '/'}" link>
          <v-list-item-title>Início</v-list-item-title>
        </v-list-item>
        <v-list-item :to="{path: '/perfil'}" link >
          <v-list-item-title>Meus dados</v-list-item-title>
        </v-list-item>
        <v-list-item :to="{path: '/iniciativas'}" link >
          <v-list-item-title>Minhas iniciativas</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <router-view />
    </v-main>
  </v-app>
</template>

<script>

  export default {
    data: () => ({ drawer: null }),
  }
</script>
