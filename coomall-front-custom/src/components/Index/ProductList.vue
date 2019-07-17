<template>
  <el-row id="resultContainer">
    <el-row>
      <span v-if="!list || list.length === 0" id="noProductTip" v-text="tip"></span>
    </el-row>
    <el-row class="productList">
      <el-col :span="16" :offset="4">
        <el-row>
          <ProductPreview v-for="item in list"
                          v-bind:item="item"
                          :key="item.id">
          </ProductPreview>
        </el-row>
      </el-col>
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
  }
}
</script>

<style scoped>
  #resultContainer {
    margin-top: 20px;
  }
  #noProductTip {
    display: block;
    font-size: 30px;
    margin: 20px auto;
    text-align: center;
  }
</style>
