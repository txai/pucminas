import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import 'leaflet/dist/leaflet.css'
import VueRouter from 'vue-router'

import HomeView from './views/HomeView.vue'
import MinhasIDCs from './views/MinhasIDCs.vue'

Vue.config.productionTip = false

Vue.use(VueRouter)

const routes = [
  { path: '/', component: HomeView},
  { path: '/iniciativas', component: MinhasIDCs, meta: { title: "Minhas iniciativas" } }
]

const router = new VueRouter({
  routes
})

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
