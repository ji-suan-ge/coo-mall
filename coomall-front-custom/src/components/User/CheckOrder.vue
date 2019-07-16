<template>
  <div>
    <el-table :data="orderFormInfo" max-height="100%"
              :fit="true" :row-style="rowStyle" id="productInfo" stripe>
      <el-table-column prop="id"
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
    <el-pagination
      @current-change="changeDataHandler"
      :page-size="20"
      layout="prev, pager, next, jumper"
      :total="total">
    </el-pagination>
   </div>
</template>

<script>
export default {
  name: 'checkOrder',
  props: ['state'],
  data () {
    return {
      orderFormInfo: [
        {
          customID: '',
          merchantID: '',
          addressID: '',
          remark: '',
          createTime: '',
          sendTime: '',
          returnTime: '',
          completeRime: '',
          cancelTime: '',
          state: '',
          id: ''
        }
      ],
      rowStyle: {
        height: '50px'
      },
      total: null
    }
  },
  watch: {
    state (val) {
      console.log('State of CheckOrder change to ' + this.state)
      this.getAddressData(1)
    }
  },
  created () {
    // console.log('navigate to CheckOrder with state of ' + this.$route.query.state)
    // this.state = this.$route.query.state
    this.getAddressData(1)
  },
  methods: {
    getAddressData (cur) {
      let that = this
      that.axios.post('/order/getByCustomIDAndState', {
        customID: JSON.parse(localStorage.getItem('custom')).id,
        state: that.state,
        currentPage: cur,
        limit: 20
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            that.total = parseInt(response.data.data.totalPage) * 20
            that.orderFormInfo = response.data.data.orderList
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    changeDataHandler () {
      this.getAddressData(this.currentPage)
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
