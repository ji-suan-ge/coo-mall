<template>
  <div>
    <TopBar></TopBar>
    <SearchBar v-on:submitData="getDataFromSearch" :currentPage="currentPage"></SearchBar>
    <router-view v-bind:list="productList" v-bind:tip="'没有商品可以显示！'"
    v-on:submitData="getDataFromRouterView"></router-view>
    <Pagination v-on:submitData="getCurrentPageFromPagination" v-if="productList && productList.length !== 0"
    :totalPage="totalPage">
    </Pagination>
    <Footer></Footer>
  </div>
</template>

<script>
import TopBar from '../components/Common/TopBar'
import SearchBar from '../components/Index/SearchBar'
import Pagination from '../components/Common/Pagination'
import Footer from '../components/Common/Footer'
export default {
  name: 'index',
  components: {
    Footer,
    Pagination,
    TopBar,
    SearchBar
  },
  data () {
    return {
      productList: null,
      currentPage: 1,
      totalPage: 1
    }
  },
  methods: {
    getDataFromSearch: function (obj) {
      console.log('got product list from search')
      this.productList = obj.productList
      this.totalPage = obj.totalPage
      console.log(this.productList)
    },
    getCurrentPageFromPagination (currentPage) {
      console.log('got currentPage from pagination')
      this.currentPage = currentPage
      console.log(this.currentPage)
    },
    getDataFromRouterView (obj) {
      this.productList = obj.productList
      console.log(this.productList)
    }
  }
}
</script>

<style scoped>

</style>
