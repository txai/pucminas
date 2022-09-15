import Keycloak from "keycloak-js";


export default {
  install: (app) => {
    const _keycloak = new Keycloak({
      url: 'http://localhost:8888/',
      clientId: 'receba-client',
      realm: 'receba'
    });
    app.config.globalProperties.$keycloak = _keycloak;
    _keycloak.init({
      onLoad: 'login-required',
      checkLoginIframe: false
    }).then(() => app.mount("app")) 
  }
}