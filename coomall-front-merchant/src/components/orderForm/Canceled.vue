<template>
  <el-table :data="orderFormInfo" max-height="100%"
            :fit="true" :row-style="rowStyle" id="productInfo" stripe>
    <el-table-column prop="orderFormID"
                     class="table_row" label="订单编号"></el-table-column>
    <el-table-column prop="createTime"
                     class="table_row" label="创建时间"></el-table-column>
    <el-table-column prop="shipTime"
                     class="table_row" label="发货时间"></el-table-column>
    <el-table-column prop="finishTime"
                     class="table_row" label="完成时间"></el-table-column>
    <el-table-column prop="cancelTime"
                     class="table_row" label="取消时间"></el-table-column>
    <el-table-column prop="returnTime"
                     class="table_row" label="退货时间"></el-table-column>
    <el-table-column prop="state"
                     class="table_row" label="订单状态"></el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'canceled',
  data () {
    return {
      orderFormInfo: [
        {
          orderFormID: '',
          createTime: '',
          shipTime: '',
          finishTime: '',
          cancelTime: '',
          returnTime: '',
          state: ''
        }
      ],
      rowStyle: {
        height: '50px'
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
    height: 50px;
  }
</style>
