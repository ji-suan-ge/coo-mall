import Vue from 'vue'
import Router from 'vue-router'
import login from '../pages/login'
import adminHomepage from '../pages/adminHomepage'
import myInformation from '../components/myInformation'
import manageCustomer from '../components/manageCustomer'
import platformInformation from '../components/platformInformation'
import manageMerchant from '../components/manageMerchant'
import findPassword from '../pages/findPassword'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      redirect: '/platform'
    }, {
      path: '/login',
      name: 'login',
      component: login
    }, {
      path: '/homepage',
      name: 'adminHomepage',
      component: adminHomepage,
      meta: {
        requireAuth: true
      }
    }, {
      path: '/my',
      name: 'myInformation',
      component: myInformation,
      meta: {
        requireAuth: true
      }
    }, {
      path: '/customer',
      name: 'manageCustomer',
      component: manageCustomer,
      meta: {
        requireAuth: true
      }
    }, {
      path: '/platform',
      name: 'platformInformation',
      component: platformInformation,
      meta: {
        requireAuth: true
      }
    }, {
      path: '/merchant',
      name: 'manageMerchant',
      component: manageMerchant,
      meta: {
        requireAuth: true
      }
    }, {
      path: '/findPassword',
      name: findPassword,
      component: findPassword
    }
  ]
})
