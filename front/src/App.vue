<template>
  <v-app id="app">
    <v-navigation-drawer
      v-model="drawer"
      app
    >
      <!--  -->
    </v-navigation-drawer>

    <v-app-bar app color="primary">
      <v-app-bar-nav-icon @click="drawer = !drawer"></v-app-bar-nav-icon>

      <v-toolbar-title>ReCeBa</v-toolbar-title>
    </v-app-bar>

    <v-main>
      <MainMap></MainMap>
    </v-main>
  </v-app>
</template>

<script>
  import MainMap from './components/MainMap.vue'
  export default {
    components: {
      MainMap
    },
    data: () => ({ drawer: null }),
  }
</script>
