import Vue from 'vue'
import Router from 'vue-router'
import Test from '@/pages/Test'
import Login from '@/pages/Login'
import Apply from '@/pages/Apply'
import HomePage from '@/pages/HomePage'
import ProductsManage from '@/components/ProductsManage'
import ReportForm from '@/components/ReportForm'
import MerchantInfo from '@/components/MerchantInfo'
import WaitPay from '@/components/orderForm/WaitPay'
import WaitShip from '@/components/orderForm/WaitShip'
import Shipped from '@/components/orderForm/Shipped'
import Finished from '@/components/orderForm/Finished'
import Returning from '@/components/orderForm/Returning'
import Returned from '@/components/orderForm/Returned'
import Canceled from '@/components/orderForm/Canceled'
import FindPassword from '@/pages/FindPassword'
import ModifyPassword from '@/pages/ModifyPassword'
import WelcomePage from '@/components/WelcomePage'
import ProductsAdd from '@/components/ProductsAdd'
import ModifyProduct from '@/components/ModifyProduct'
import ModifyStyle from '@/components/ModifyStyle'
import ModifyDetail from '@/components/ModifyDetail'

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
      path: '/findPassword',
      name: 'findPassword',
      component: FindPassword
    },
    {
      path: '/modifyPassword',
      name: 'modifyPassword',
      component: ModifyPassword
    },
    {
      path: '/apply',
      name: 'apply',
      component: Apply
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
      redirect: '/homePage/welcomePage',
      children: [
        {
          path: 'welcomePage',
          name: 'welComePage',
          component: WelcomePage
        },
        {
          path: 'modifyStyle',
          name: 'modifyStyle',
          component: ModifyStyle
        },
        {
          path: 'modifyDetail',
          name: 'modifyDetail',
          component: ModifyDetail
        },
        {
          path: 'modifyProduct',
          name: 'modifyProduct',
          component: ModifyProduct
        },
        {
          path: 'productsAdd',
          name: 'productsAdd',
          component: ProductsAdd
        },
        {
          path: 'productsManage',
          name: 'productsManage',
          component: ProductsManage
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
          path: 'waitPay',
          name: 'waitPay',
          component: WaitPay
        },
        {
          path: 'waitShip',
          name: 'waitShip',
          component: WaitShip
        },
        {
          path: 'shipped',
          name: 'shipped',
          component: Shipped
        },
        {
          path: 'finished',
          name: 'finished',
          component: Finished
        },
        {
          path: 'returning',
          name: 'returning',
          component: Returning
        },
        {
          path: 'returned',
          name: 'returned',
          component: Returned
        },
        {
          path: 'canceled',
          name: 'canceled',
          component: Canceled
        }
      ]
    }
  ]
})
