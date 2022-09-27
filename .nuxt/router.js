import Vue from 'vue'
import Router from 'vue-router'
import { normalizeURL, decode } from 'ufo'
import { interopDefault } from './utils'
import scrollBehavior from './router.scrollBehavior.js'

const _feee11b2 = () => interopDefault(import('..\\pages\\lista-orcamentos.vue' /* webpackChunkName: "pages/lista-orcamentos" */))
const _6f0066de = () => interopDefault(import('..\\pages\\tela-dados.vue' /* webpackChunkName: "pages/tela-dados" */))
const _c49baf40 = () => interopDefault(import('..\\pages\\tela-orcamentos.vue' /* webpackChunkName: "pages/tela-orcamentos" */))
const _34a3af37 = () => interopDefault(import('..\\pages\\orcamento\\_orcamento.vue' /* webpackChunkName: "pages/orcamento/_orcamento" */))
const _64cb91a8 = () => interopDefault(import('..\\pages\\index.vue' /* webpackChunkName: "pages/index" */))

const emptyFn = () => {}

Vue.use(Router)

export const routerOptions = {
  mode: 'history',
  base: '/',
  linkActiveClass: 'nuxt-link-active',
  linkExactActiveClass: 'nuxt-link-exact-active',
  scrollBehavior,

  routes: [{
    path: "/lista-orcamentos",
    component: _feee11b2,
    name: "lista-orcamentos"
  }, {
    path: "/tela-dados",
    component: _6f0066de,
    name: "tela-dados"
  }, {
    path: "/tela-orcamentos",
    component: _c49baf40,
    name: "tela-orcamentos"
  }, {
    path: "/orcamento/:orcamento?",
    component: _34a3af37,
    name: "orcamento-orcamento"
  }, {
    path: "/",
    component: _64cb91a8,
    name: "index"
  }],

  fallback: false
}

export function createRouter (ssrContext, config) {
  const base = (config._app && config._app.basePath) || routerOptions.base
  const router = new Router({ ...routerOptions, base  })

  // TODO: remove in Nuxt 3
  const originalPush = router.push
  router.push = function push (location, onComplete = emptyFn, onAbort) {
    return originalPush.call(this, location, onComplete, onAbort)
  }

  const resolve = router.resolve.bind(router)
  router.resolve = (to, current, append) => {
    if (typeof to === 'string') {
      to = normalizeURL(to)
    }
    return resolve(to, current, append)
  }

  return router
}
