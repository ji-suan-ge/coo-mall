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
        <template slot-scope="scope">
          <el-row>
            <el-col>
              <el-button @click="editHandler(scope.$index)">修改</el-button>
            </el-col>
            <el-col>
              <el-button @click="deleteHandler(scope.row.id)">删除</el-button>
            </el-col>
          </el-row>
        </template>
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
          id: '',
          name: '',
          phoneNumber: '',
          customID: '',
          address: ''
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
    },
    editHandler (Index) {
      let tmp = this.addressFormInfo[Index]
      this.$router.push({path: '/User/editAddress',
        query: {
          id: tmp.id,
          address: tmp.address,
          name: tmp.name,
          phoneNumber: tmp.phoneNumber}})
    },
    deleteHandler (ID) {
      console.log(ID)
      this.$confirm('永久删除该地址, 是否继续?', '确认删除', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning'
      }).then(() => {
        let that = this
        that.axios.post('address/delete', {
          addressID: ID
        }).then(res => {
          if (res.data.code === '0000') {
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
            this.$router.go(0)
          } else {
            that.$message.error('系统繁忙，请稍后重试')
          }
        })
          .catch(function (error) {
            console.log(error)
          })
      }).catch(() => {
        this.$message({
          type: 'info',
          message: '已取消删除'
        })
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
