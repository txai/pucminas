<template>
  <v-app id="app">

    <v-app-bar
      app
      color="primary"
      clipped-left
    >
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>ReCeBa</v-toolbar-title>
    </v-app-bar>

    <v-navigation-drawer
      v-model="drawer"
      app
      clipped
      style="z-index:1001"
    >
      <v-list 
        nav
      >
        <v-list-item :to="{path: '/'}" link>
          <v-list-item-title>Início</v-list-item-title>
        </v-list-item>
        <v-list-item link >
          <v-list-item-title>Perfil</v-list-item-title>
        </v-list-item>
        <v-list-item :to="{path: '/idcs'}" link >
          <v-list-item-title>Iniciativas de doação</v-list-item-title>
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
