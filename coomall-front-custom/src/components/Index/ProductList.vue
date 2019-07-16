<template>
  <el-row>
    <el-row id="resultContainer" type="flex" justify="center">
<!--      <el-row class="filter" v-if="list && list.length !== 0">-->
<!--        <el-col :offset="5" :span="6">-->
<!--          <el-radio-button class="filter-item" label="1" >销量降序</el-radio-button>-->
<!--          <el-radio-button class="filter-item" label="2">评分降序</el-radio-button>-->
<!--          <el-radio-button class="filter-item" label="3">价格降序</el-radio-button>-->
<!--          <el-radio-button class="filter-item" label="4">价格升序</el-radio-button>-->
<!--        </el-col>-->
<!--      </el-row>-->
      <span v-if="!list || list.length === 0" id="noProductTip" v-text="tip"></span>
      <el-row class="productList">
        <el-col :span="18" :offset="5">
          <ProductPreview v-for="item in list"
                          v-bind:item="item"
                          :key="item.id">
          </ProductPreview>
        </el-col>
      </el-row>
    </el-row>
  </el-row>
</template>

<script>
import ProductPreview from './ProductPreview'
export default {
  name: 'productList',
  props: ['list', 'tip'],
  components: {ProductPreview},
  data () {
    return {
    }
  },
  methods: {
    handleProductClicked (val) {
      console.log(val)
      this.$emit('productClicked', val)
    }
  }
}
</script>

<style scoped>
  #resultContainer {
    margin-top: 50px;
  }
  #noProductTip {
    display: block;
    font-size: 30px;
    margin: 20px auto;
    text-align: center;
  }
  /*.filter{*/
  /*  height: 50px;*/
  /*}*/
  /*.filter-item{*/
  /*  width: 80px;*/
  /*  height: 35px;*/
  /*  margin: 0;*/
  /*}*/
  .resultContainer{
  }
</style>
