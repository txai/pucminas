import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import 'leaflet/dist/leaflet.css'
import VueKeyCloak from '@dsb-norge/vue-keycloak-js'

import router from './router'

Vue.use(VueKeyCloak, {
  init: {
    onLoad: 'check-sso',
    silentCheckSsoRedirectUri: window.location.origin + '/silent-check-sso.html'
  },
  config: {
    url: 'http://18.231.1.252:8080',
    clientId: 'receba-client',
    realm: 'receba'
  },
  logout: {
    //redirectUri : 'http://receba.s3-website-sa-east-1.amazonaws.com'
   redirectUri: 'http://172.24.187.234:8080'
  },
  onReady () {
    new Vue({
      vuetify,
      router,
      render: h => h(App)
    }).$mount('#app')
  }
})

Vue.config.productionTip = false
