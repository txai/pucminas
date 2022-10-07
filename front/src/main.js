import Vue from 'vue'
import App from './App.vue'
import vuetify from './plugins/vuetify'
import 'leaflet/dist/leaflet.css'
import KeycloakPlugin from './plugins/keycloak-plugin'

import router from './router'

Vue.use(KeycloakPlugin)

Vue.config.productionTip = false

Vue.$keycloak.init({
    onLoad: 'check-sso',
    silentCheckSsoRedirectUri: window.location.origin + '/silent-check-sso.html',
    checkLoginIframe: false
  })
  .then()
  .catch(() => console.log("Erro no init"))

new Vue({
  vuetify,
  router,
  render: h => h(App)
}).$mount('#app')
