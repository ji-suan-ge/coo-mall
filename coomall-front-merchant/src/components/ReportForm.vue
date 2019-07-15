<template>
  <el-table :data="reportForm" max-height="100%"
            :fit="true" :row-style="rowStyle" id="reportForm" stripe>
    <el-table-column prop="dailyMax"
                     class="table_row" label="日最高销售额"></el-table-column>
    <el-table-column prop="dailyMin"
                     class="table_row" label="日最低销售额"></el-table-column>
    <el-table-column prop="dailyAverage"
                     class="table_row" label="日均销售额"></el-table-column>
    <el-table-column prop="monthlySales"
                     class="table_row" label="月销量"></el-table-column>
    <el-table-column prop="month"
                     class="table_row" label="月份"></el-table-column>
  </el-table>
</template>

<script>
export default {
  name: 'reportForm',
  data () {
    return {
      reportForm: [
        {
          month: '5',
          monthlySales: '1000',
          dailyAverage: '33',
          dailyMax: '100',
          dailyMin: '50'
        }
      ]
    }
  }
}
</script>

<style scoped>
  #reportForm {
    width: 100%;
    text-align: center;
  }
  .table_row {
    height: 50px;
  }
</style>
