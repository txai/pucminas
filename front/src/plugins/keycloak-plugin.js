import Keycloak from 'keycloak-js';

const _keycloak = new Keycloak({
  url: 'http://127.0.0.1:8888',
  clientId: 'receba-client',
  realm: 'receba'
})

export default {
  install(Vue) {
    Vue.$keycloak = _keycloak
  }
}

