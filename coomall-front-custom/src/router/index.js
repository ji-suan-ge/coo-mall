import Vue from 'vue'
import Router from 'vue-router'
import A1 from '@/components/A1'
import A2 from '@/components/A2'
import Admin from '@/pages/admin'
import Login from '@/pages/login'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'index',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'login',
      component: Login
    }, {
      path: '/admin',
      name: 'admin',
      component: Admin,
      redirect: '/admin/a1',
      children: [
        {
          path: 'a1',
          component: A1
        }, {
          path: 'a2',
          component: A2
        }
      ]
    }
  ]
})
