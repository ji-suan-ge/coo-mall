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
      <el-table-column class="table_row" label="操作">
        <template slot-scope="scope">
          <el-row  v-if="checkState(1)">
            <el-col :span="12">
              <el-button @click="purchaseHandler(scope.row.id)">付款</el-button>
            </el-col>
            <el-col :span="12">
              <el-button @click="cancelHandler(scope.row.id)">取消</el-button>
            </el-col>
          </el-row>
        </template>
        <el-row  v-if="checkState(3)">
          <el-col>
            <el-button @click="signedHandler(scope.row.id)">签收</el-button>
          </el-col>
        </el-row>
        <el-row  v-if="checkState(4)">
        <el-col :span="12">
          <el-button @click="completeHandler(scope.row.id)">完成</el-button>
        </el-col>
        <el-col :span="12">
          <el-button @click="returnHandler(scope.row.id)">退货</el-button>
        </el-col>
      </el-row>
        <el-row  v-if="checkState(6)">
          <el-col>
            <el-button @click="confirmReturnHandler(scope.row.id)">确认退货</el-button>
          </el-col>
        </el-row>
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
    },
    checkState (check) {
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
        console.log('Change order:' + orderID + ' to state ' + 0)
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
        console.log('Change order:' + orderID + ' to state ' + 0)
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
        state: 5
      }).then(res => {
        console.log('Change order:' + orderID + ' to state ' + 0)
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
        state: 5
      }).then(res => {
        console.log('Change order:' + orderID + ' to state ' + 0)
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
