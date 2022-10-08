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
    url: 'http://localhost:8888',
    clientId: 'receba-client',
    realm: 'receba'
  },
  logout: {
    post_logout_redirect_uri : 'http://localhost:8080'
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
