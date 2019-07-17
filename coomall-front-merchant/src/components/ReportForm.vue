<template>
  <div>
    <el-row>
      <el-col>
          <h3>年份</h3>
          <el-date-picker
            v-model="year"
            align="center"
            type="year"
            @change="choose"
            value-format="yyyy"
            placeholder="选择年份">
          </el-date-picker>
      </el-col>
    </el-row>
    <el-table :data="reportForm" max-height="100%"
              :fit="true" :row-style="rowStyle" id="reportForm" stripe>
      <el-table-column prop="lowPrice"
                       class="table_row" label="日最高销售额"></el-table-column>
      <el-table-column prop="highPrice"
                       class="table_row" label="日最低销售额"></el-table-column>
      <el-table-column prop="dailyAverage"
                       class="table_row" label="日均销售额"></el-table-column>
      <el-table-column prop="monthAmount"
                       class="table_row" label="月销售量"></el-table-column>
      <el-table-column prop="monthSale"
                       class="table_row" label="月销售额"></el-table-column>
      <el-table-column prop="month"
                       class="table_row" label="月份"></el-table-column>
    </el-table>
  </div>
</template>

<script>
export default {
  name: 'reportForm',
  data () {
    return {
      reportForm: [
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '1'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '2'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '3'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '4'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '5'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '6'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '7'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '8'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '9'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '10'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '11'
        },
        {
          lowPrice: '0',
          highPrice: '0',
          dailyAverage: '0',
          monthAmount: '0',
          monthSale: '0',
          month: '12'
        }
      ],
      rowStyle: {
        height: '50px'
      },
      year: '',
      monthDay: [31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    }
  },
  methods: {
    choose () {
      let that = this
      that.axios.post('/bill/get', {
        year: that.year
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            for (var p in that.reportForm) {
              that.reportForm[p].dailyAverage = 0
              that.reportForm[p].hignPrice = 0
              that.reportForm[p].lowPrice = 0
              that.reportForm[p].monthAmount = 0
              that.reportForm[p].monthSale = 0
              for (var b in response.data.data.billList) {
                if (that.reportForm[p].month === response.data.data.billList[b].month) {
                  that.reportForm[p] = response.data.data.billList[b]
                  that.reportForm[p].dailyAverage = that.reportForm[p].monthSale / that.monthDay[parseInt(that.reportForm[p].month)]
                }
              }
            }
          } else {
            that.$message({
              type: 'error',
              message: '系统繁忙，请求数据失败！'
            })
          }
        })
        .catch(function (err) {
          console.log(err)
        })
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
