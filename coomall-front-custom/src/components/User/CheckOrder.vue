<template>
  <div>
    <el-table :data="orderFormInfo" max-height="100%"
              :fit="true" :row-style="rowStyle" id="productInfo" stripe>
      <el-table-column prop="orderID"
                       class="table_row" label="订单编号"></el-table-column>
      <el-table-column prop="productName"
                       class="table_row" label="商品名称"></el-table-column>
      <el-table-column prop="productStyle"
                       class="table_row" label="规格分类"></el-table-column>
      <el-table-column prop="address"
                       class="table_row" label="收货地址"></el-table-column>
      <el-table-column prop="price"
                       class="table_row" label="单价"></el-table-column>
      <el-table-column prop="amount"
                       class="table_row" label="数量"></el-table-column>
      <el-table-column prop="subTotal"
                       class="table_row" label="小计"></el-table-column>
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
      <el-table-column class="table_row" label="操作">
        <template slot-scope="scope">
          <el-row  v-if="checkState(1)">
            <el-col>
              <el-button @click="purchaseHandler(scope.row.orderID)">付款</el-button>
            </el-col>
            <el-col>
              <el-button @click="cancelHandler(scope.row.orderID)">取消</el-button>
            </el-col>
          </el-row>
          <el-row  v-show="checkState(3)">
            <el-col>
              <el-button @click="signedHandler(scope.row.orderID)">签收</el-button>
            </el-col>
          </el-row>
          <el-row  v-if="checkState(4)">
            <el-col>
              <el-button @click="completeHandler(scope.row.orderID)">完成</el-button>
            </el-col>
            <el-col>
              <el-button @click="returnHandler(scope.row.orderID)">退货</el-button>
            </el-col>
          </el-row>
          <el-row  v-if="checkState(6)">
            <el-col>
              <el-button @click="confirmReturnHandler(scope.row.orderID)">确认退货</el-button>
            </el-col>
          </el-row>
        </template>
      </el-table-column>
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
      this.getOrderData(1)
    }
  },
  created () {
    // console.log('navigate to CheckOrder with state of ' + this.$route.query.state)
    // this.state = this.$route.query.state
    this.getOrderData(1)
  },
  methods: {
    getOrderData (cur) {
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
            that.orderFormInfo = response.data.data.orderReturnList
            if (response.data.data.orderReturnList != null && response.data.data.orderReturnList[0] != null) {
              that.orderFormInfo[0].subTotal = that.orderFormInfo[0].price * that.orderFormInfo[0].amount
            }
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    changeDataHandler () {
      this.getOrderData(this.currentPage)
    },
    checkState (check) {
      // console.log(parseInt(this.state))
      // console.log(parseInt(check))
      // console.log(parseInt(this.state) === parseInt(check))
      return parseInt(this.state) === parseInt(check)
    },
    purchaseHandler (orderID) {
      this.$message.error('当前不可执行该操作')
    },
    cancelHandler (orderID) {
      let that = this
      that.axios.post('order/changeState', {
        orderID: orderID,
        state: 0
      }).then(res => {
        console.log('Change order:' + orderID + ' to state ' + 0)
        if (res.data.code === '0000') {
          this.$message({message: '取消订单成功', type: 'success'})
        } else {
          this.$message.error('系统繁忙，请求失败')
        }
      })
    },
    signedHandler (orderID) {
      let that = this
      that.axios.post('order/changeState', {
        orderID: orderID,
        state: 4
      }).then(res => {
        console.log('Change order:' + orderID + ' to state ' + 4)
        if (res.data.code === '0000') {
          this.$message({message: '订单已签收', type: 'success'})
        } else {
          this.$message.error('系统繁忙，请求失败')
        }
      })
    },
    completeHandler (orderID) {
      let that = this
      that.axios.post('order/changeState', {
        orderID: orderID,
        state: 5
      }).then(res => {
        console.log('Change order:' + orderID + ' to state ' + 5)
        if (res.data.code === '0000') {
          this.$message({message: '订单已完成', type: 'success'})
        } else {
          this.$message.error('系统繁忙，请求失败')
        }
      })
    },
    returnHandler (orderID) {
      let that = this
      that.axios.post('order/changeState', {
        orderID: orderID,
        state: 6
      }).then(res => {
        console.log('Change order:' + orderID + ' to state ' + 6)
        if (res.data.code === '0000') {
          this.$message({message: '退货申请成功', type: 'success'})
        } else {
          this.$message.error('系统繁忙，请求失败')
        }
      })
    },
    confirmReturnHandler (orderID) {
      let that = this
      that.axios.post('order/changeState', {
        orderID: orderID,
        state: 7
      }).then(res => {
        console.log('Change order:' + orderID + ' to state ' + 7)
        if (res.data.code === '0000') {
          this.$message({message: '确认退货成功', type: 'success'})
        } else {
          this.$message.error('系统繁忙，请求失败')
        }
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
