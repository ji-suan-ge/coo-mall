// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import axios from 'axios'
import VueAxios from 'vue-axios'

Vue.config.productionTip = false

Vue.use(VueAxios, axios)
Vue.use(ElementUI)
axios.defaults.baseURL = 'http://192.168.43.193:8001'
axios.defaults.withCredentials = true

axios.interceptors.response.use(
  response => {
    return response
  },
  error => {
    if (error.response) {
      switch (error.response.status) {
        case 401:
          router.replace({
            path: '/login',
            query: {redirect: router.currentRoute.fullPath}
          })
      }
    }
    return Promise.reject(error.response.data)
  })

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  merchant: {
    shopName: '',
    ownerName: '2',
    identityNumber: '',
    phoneNumber: '',
    email: '',
    address: '',
    registerTime: '',
    intro: ''
  },
  components: { App },
  template: '<App/>'
})
