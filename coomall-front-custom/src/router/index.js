import Vue from 'vue'
import Router from 'vue-router'
import Index from '../pages/Index'
import Login from '../pages/Login'
import findPassword from '../pages/FindPassword'
import ProductList from '../components/Index/ProductList'
import ProductRecommend from '../components/Index/ProductRecommend'
import Product from '../pages/Product'
import ProductDetail from '../components/Product/ProductDetail'
import ShoppingCar from '../pages/ShoppingCar'
import User from '../pages/User'
import PersonalInfo from '../components/User/PersonalInfo'
import CheckOrder from '../components/User/CheckOrder'
import Address from '../components/User/Address'
import AddAddress from '../components/User/AddAddress'
import Register from '../pages/Register'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      redirect: '/index/recommend'
    }, {
      path: '/index',
      name: 'index',
      component: Index,
      redirect: '/index/recommend',
      children: [
        {
          path: 'recommend',
          name: 'recommend',
          component: ProductRecommend
        }, {
          path: 'result',
          name: 'result',
          component: ProductList
        }
      ]
    },
    {
      path: '/product',
      name: 'product',
      component: Product,
      children: [
        {
          path: 'detail',
          name: 'productDetail',
          component: ProductDetail
        }
      ]
    }, {
      path: '/User',
      name: 'User',
      component: User,
      redirect: '/User/PersonalInfo',
      children: [
        {
          path: 'personalInfo',
          name: 'personalInfo',
          component: PersonalInfo
        }, {
          path: 'checkOrder',
          name: 'checkOrder',
          component: CheckOrder
        }, {
          path: 'address',
          name: 'address',
          component: Address
        }, {
          path: 'addAddress',
          name: 'addAddress',
          component: AddAddress
        }
      ]
    }, {
      path: '/shoppingCar',
      name: 'shoppingCar',
      component: ShoppingCar
    }, {
      path: '/login',
      name: 'login',
      component: Login
    }, {
      path: '/findPassword',
      name: 'findPassword',
      component: findPassword
    }, {
      path: '/register',
      name: 'register',
      component: Register
    }
  ]
})
