<template>
  <el-table :data="productInfo" max-height="100%"
            :fit="true" :row-style="rowStyle" id="productInfo" stripe>
    <el-table-column prop="productName"
                     class="table_row" label="商品名称"></el-table-column>
    <el-table-column prop="price"
                     class="table_row" label="商品价格"></el-table-column>
    <el-table-column prop="inventory"
                     class="table_row" label="商品库存"></el-table-column>
    <el-table-column prop="monthlySales"
                     class="table_row" label="月销量"></el-table-column>
    <el-table-column prop="sort"
                     class="table_row" label="分类"></el-table-column>
    <el-table-column prop="pattern"
                     class="table_row" label="商品款式"></el-table-column>
    <el-table-column prop="detailedInfomation"
                     class="table_row" label="详细信息"></el-table-column>
    <el-table-column prop="productComment"
                     class="table_row" label="商品评价"></el-table-column>
    <el-table-column prop="productState"
                     class="table_row" label="商品状态"></el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'productsManage',
  data () {
    return {
      productInfo: [{
        productName: '',
        price: '',
        inventory: '',
        monthlySales: '',
        sort: '',
        pattern: '',
        detailedInfomation: '',
        productComment: '',
        productState: ''
      }, {
        productName: '1',
        price: '1',
        inventory: '1',
        monthlySales: '1',
        sort: '1',
        pattern: '1',
        detailedInfomation: '1',
        productComment: '1',
        productState: '1'
      }],
      rowStyle: {
        height: '70px'
      }
    }
  }
}
</script>

<style scoped>
  #productInfo {
    width: 100%;
    text-align: center;
  }
  .table_row {
  }

</style>
