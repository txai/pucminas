import Vue from 'vue';
import Vuetify from 'vuetify/lib/framework';

Vue.use(Vuetify);

const greenTheme = {
    primary: '#cddc39',
    secondary: '#ffc107',
    accent: '#ff9800',
    error: '#f44336',
    warning: '#ff5722',
    info: '#8bc34a',
    success: '#4caf50'
};

const vuetify = new Vuetify({
  theme: {
    themes: {
      light: greenTheme
    }
  }
});
  
export default vuetify;
