<template>
  <div>
    <el-table :data="addressFormInfo" max-height="100%"
              :fit="true" :row-style="rowStyle" id="productInfo" stripe>
      <el-table-column prop="address"
                       class="table_row" label="收货地址"></el-table-column>
      <el-table-column prop="name"
                       class="table_row" label="联系人"></el-table-column>
      <el-table-column prop="phoneNumber"
                       class="table_row" label="联系电话"></el-table-column>
      <el-table-column class="table_row" label="操作">
      </el-table-column>
    </el-table>
    <el-row>
      <el-col>
        <el-button @click="addAddress">新增收货地址</el-button>
      </el-col>
    </el-row>
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
  name: 'address',
  data () {
    return {
      addressFormInfo: [
        {
          ID: '',
          customID: '',
          merchantID: '',
          addressID: '',
          remark: '',
          createTime: '',
          sendTime: '',
          returnTim: '',
          completeRime: '',
          cancelTile: '',
          state: ''
        }
      ],
      rowStyle: {
        height: '50px'
      },
      total: null
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
      that.axios.post('/address/find', {
        currentPage: cur,
        limit: 20
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            that.total = parseInt(response.data.data.totalPage) * 20
            that.addressFormInfo = response.data.data.addressList
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    changeDataHandler () {
      this.getAddressData(this.currentPage)
    },
    addAddress () {
      this.$router.push({path: '/User/addAddress'})
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
