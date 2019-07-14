import Vue from 'vue'
import Router from 'vue-router'
import Test from '@/pages/Test'
import Login from '@/pages/Login'
import Apply from '@/pages/Apply'
import ApplyResult from '@/pages/ApplyResult'
import HomePage from '@/pages/HomePage'
import ProductsManage from '@/components/ProductsManage'
import OrderFormManage from '@/components/OrderFormManage'
import ReportForm from '@/components/ReportForm'
import MerchantInfo from '@/components/MerchantInfo'
import MerchantManage from '@/components/MerchantManage'

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
    },
    {
      path: '/apply',
      name: 'apply',
      component: Apply
    },
    {
      path: '/applyResult',
      name: 'applyResult',
      component: ApplyResult
    },
    {
      path: '/test',
      name: 'test',
      component: Test
    },
    {
      path: '/homePage',
      name: 'homePage',
      component: HomePage,
      redirect: 'homePage/productsManage',
      children: [
        {
          path: 'productsManage',
          name: 'productsManage',
          component: ProductsManage
        },
        {
          path: 'orderFormManage',
          name: 'orderFormManage',
          component: OrderFormManage
        },
        {
          path: 'reportForm',
          name: 'reportForm',
          component: ReportForm
        },
        {
          path: 'merchantInfo',
          name: 'merchantInfo',
          component: MerchantInfo
        },
        {
          path: 'merchantManage',
          name: 'merchantManage',
          component: MerchantManage
        }
      ]
    }
  ]
})
