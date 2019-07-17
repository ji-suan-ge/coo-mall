<template>
  <div>
    <div class="block">
      <h3>按时间范围选择订单</h3>
      <el-date-picker
        v-model="value4"
        value-format="yyyy-MM-dd HH:mm:ss"
        type="datetimerange"
        :picker-options="pickerOptions2"
        range-separator="至"
        start-placeholder="开始日期"
        end-placeholder="结束日期"
        @change="choose"
        align="center">
      </el-date-picker>
    </div>
    <el-table :data="orderFormInfo" max-height="100%"
              :fit="true" :row-style="rowStyle" id="productInfo" stripe>
      <el-table-column prop="orderID"
                       class="table_row" label="订单编号"></el-table-column>
      <el-table-column prop="customName"
                       class="table_row" label="购买人"></el-table-column>
      <el-table-column prop="productID"
                       class="table_row" label="商品编号"></el-table-column>
      <el-table-column prop="address"
                       class="table_row" label="发货地址"></el-table-column>
      <el-table-column prop="remark"
                       class="table_row" label="用户备注"></el-table-column>
      <el-table-column prop="createTime"
                       class="table_row" label="创建时间"></el-table-column>
      <el-table-column prop="sendTime"
                       class="table_row" label="取消时间"></el-table-column>
    </el-table>
    <el-pagination
      @current-change="handleCurrentChange"
      :page-size="20"
      layout="prev, pager, next, jumper"
      :total="total">
    </el-pagination>
  </div>
</template>

<script>
export default {
  name: 'canceled',
  data () {
    return {
      orderFormInfo: [
        {
          orderID: '',
          customName: '',
          productName: '',
          productID: '',
          productStyle: '',
          address: '',
          remark: '',
          createTime: '',
          sendTime: '',
          returnTime: '',
          completeTime: '',
          price: '',
          amount: '',
          state: '',
          avatar: '',
          detail: '',
          category: ''
        }
      ],
      rowStyle: {
        height: '50px'
      },
      total: 1,
      pickerOptions2: {
        shortcuts: [{
          text: '最近一周',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 7)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近一个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 30)
            picker.$emit('pick', [start, end])
          }
        }, {
          text: '最近三个月',
          onClick (picker) {
            const end = new Date()
            const start = new Date()
            start.setTime(start.getTime() - 3600 * 1000 * 24 * 90)
            picker.$emit('pick', [start, end])
          }
        }]
      },
      value4: ''
    }
  },
  created () {
    let that = this
    that.axios.post('/order/getByMerchantIDAndState', {
      merchantID: JSON.parse(localStorage.getItem('merchant')).id,
      state: 0,
      currentPage: 1,
      limit: 20
    })
      .then(function (response) {
        console.log(response)
        if (response.data.msg === '请求成功') {
          that.total = parseInt(response.data.data.totalPage) * 20
          that.orderFormInfo = response.data.data.orderReturnList
        }
      })
      .catch(function (error) {
        console.log(error)
      })
  },
  methods: {
    handleCurrentChange (cur) {
      let that = this
      that.axios.post('/order/getByTime', {
        beginTime: that.value4[0],
        endTime: that.value4[1],
        state: 0,
        currentPage: cur,
        limit: 20
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            that.total = parseInt(response.data.data.totalPage) * 20
            that.orderFormInfo = response.data.data.orderReturnList
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    choose () {
      let that = this
      that.axios.post('/order/getByTime', {
        beginTime: that.value4[0],
        endTime: that.value4[1],
        state: 0,
        currentPage: 1,
        limit: 20
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            that.total = parseInt(response.data.data.totalPage) * 20
            that.orderFormInfo = response.data.data.orderReturnList
          }
        })
        .catch(function (error) {
          console.log(error)
        })
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
