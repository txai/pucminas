import Vue from 'vue'
import Router from 'vue-router'
import HomeView from './views/HomeView.vue'
import MinhasIniciativas from './views/MinhasIniciativas.vue'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomeView
    },
    {
      path: '/iniciativas',
      name: 'iniciativas',
      component: MinhasIniciativas, meta: { title: "Minhas iniciativas", requiresAuth: true }
    }
  ]
})

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms))
}

router.beforeEach(async (to, from, next) => {
  if (to.matched.some(record => record.meta.requiresAuth)) {
    
    while (router.app.$keycloak.createLoginUrl === null) {
      await sleep(100)
    }
    if (router.app.$keycloak.authenticated) {
      next()
    } else {
      const loginUrl = router.app.$keycloak.createLoginUrl()
      window.location.replace(loginUrl)
    }
  } else {
    next()
  }
})

export default router