<template>
  <div>
    <Category></Category>
    <ProductList :list="recommendList" :tip="'没有商品推荐'"></ProductList>
  </div>
</template>

<script>
import Category from './Category'
import ProductList from './ProductList'
export default {
  name: 'ProductRecommand',
  components: {ProductList, Category},
  data () {
    return {
      currentDate: '2017-10-30',
      recommendList: []
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
