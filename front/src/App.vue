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
    >
      <v-list 
        nav
      >
        <v-list-item link >
          <v-list-item-title>Home</v-list-item-title>
        </v-list-item>
        <v-list-item link >
          <v-list-item-title>Meu perfil</v-list-item-title>
        </v-list-item>
        <v-list-item link >
          <v-list-item-title>Minhas iniciativas de doação</v-list-item-title>
        </v-list-item>
      </v-list>
    </v-navigation-drawer>

    <v-main>
      <HomeView></HomeView>
    </v-main>
  </v-app>
</template>

<script>
  import HomeView from './views/HomeView.vue'
  export default {
    components: {
    HomeView
  },
    data: () => ({ drawer: null }),
  }
</script>
