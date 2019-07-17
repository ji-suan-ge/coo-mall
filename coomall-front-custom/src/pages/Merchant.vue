<template>
  <el-container>
    <el-header style="padding: 0"><TopBar></TopBar></el-header>
    <el-main>
      <ProductList v-bind:list="productList" v-bind:tip="'该店铺没有商品'"></ProductList>
    </el-main>
    <el-footer><Footer></Footer></el-footer>
  </el-container>
</template>

<script>
import TopBar from '../components/Common/TopBar'
import Footer from '../components/Common/Footer'
import ProductList from '../components/Index/ProductList'
export default {
  name: 'Merchant',
  components: {ProductList, Footer, TopBar},
  data () {
    return {
      merchantID: null,
      productList: null
    }
  },
  methods: {
    getMerchantProductList (cur) {
      this.axios.post('/product/getByMerchantID', {
        merchantID: this.merchantID,
        currentPage: cur,
        limit: 28
      }).then(res => {
        this.productList = res.data.data.productList
      })
    }
  },
  created () {
    console.log(this.$route.query.merchantID)
    this.merchantID = this.$route.query.merchantID
    this.getMerchantProductList(1)
  }
}
</script>

<style scoped>

</style>
