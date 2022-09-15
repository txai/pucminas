import { createApp } from 'vue'
import App from './App.vue'
import auth from '@/plugins/auth'

const receba = createApp(App)

receba.use(auth)

receba.mount("#app")