<template>
  <el-container>
    <el-header style="padding: 0"><TopBar></TopBar></el-header>
    <el-main>
      <el-row>
        <el-col span="16" offset="4">
          <el-col span="12">
            <h1 v-text="merchantInfo.shopName" class="merchant-header"></h1>
          </el-col>
          <el-col span="12">
            <p class="merchant-intro">{{merchantInfo.intro}}</p>
            <p class="merchant-score">评分{{merchantInfo.score}}</p>
          </el-col>
        </el-col>
      </el-row>
      <el-row>
        <ProductList v-bind:list="productList" v-bind:tip="'该店铺暂无上架商品'"></ProductList>
      </el-row>
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
      merchantInfo: null,
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
    },
    getMerchantInfo () {
      let that = this
      this.axios.post('/merchant/getByID', {
        merchantID: this.merchantID
      }).then(res => {
        console.log(res.data.data)
        that.merchantInfo = res.data.data
        console.log(that.merchantInfo)
      })
    }
  },
  created () {
    console.log(this.$route.query.merchantID)
    this.merchantID = this.$route.query.merchantID
    this.getMerchantProductList(1)
    this.getMerchantInfo()
  }
}
</script>

<style scoped>
  .merchant-header{
    font-size: 30px;
    text-align: center;
  }
  .merchant-intro{
    color: #777777;
    text-align: center;
  }
  .merchant-score{
    font-size: 18px;
    color: #FF0036;
    text-align: center;
  }
</style>
