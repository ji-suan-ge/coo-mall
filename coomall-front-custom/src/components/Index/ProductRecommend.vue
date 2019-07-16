<template>
  <el-row>
    <Category @submitData="getDataFromCategory"></Category>
    <el-row>
      <el-col :offset="6" style="font-size: 30px; margin-top: 20px" >推荐列表</el-col>
    </el-row>
    <ProductList :list="recommendList" :tip="'没有商品推荐'"></ProductList>
  </el-row>
</template>

<script>
import Category from './Category'
import ProductList from './ProductList'
export default {
  name: 'ProductRecommand',
  components: {ProductList, Category},
  data () {
    return {
      recommendList: [],
      list: []
    }
  },
  methods: {
    getDataFromCategory (obj) {
      console.log('getDataFromCategory')
      this.$emit('submitData', obj)
    }
  },
  created () {
    console.log('加载recommendList...')
    let that = this
    that.axios.post('/product/getByRandom', {
      number: 32
    }).then(res => {
      that.recommendList = res.data.data.productList
      that.$emit('submitData', {
        productList: that.recommendList,
        totalPage: res.data.data.totalPage
      })
      console.log(that.recommendList)
    })
  }
}
</script>

<style scoped>
</style>
