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
import WaitPay from '@/components/orderForm/WaitPay'
import WaitShip from '@/components/orderForm/WaitShip'
import Shipped from '@/components/orderForm/Shipped'
import Signed from '@/components/orderForm/Signed'
import Finished from '@/components/orderForm/Finished'
import WaitReturn from '@/components/orderForm/WaitReturn'
import Returning from '@/components/orderForm/Returning'
import Returned from '@/components/orderForm/Returned'
import Canceled from '@/components/orderForm/Canceled'
import FindPassword from '@/pages/FindPassword'
import ModifyPassword from '@/pages/ModifyPassword'
import ProductComment from '@/pages/ProductComment'

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
      path: '/productComment',
      name: 'productComment',
      component: ProductComment
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
          path: 'signed',
          name: 'signed',
          component: Signed
        },
        {
          path: 'finished',
          name: 'finished',
          component: Finished
        },
        {
          path: 'waitReturn',
          name: 'waitReturn',
          component: WaitReturn
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
