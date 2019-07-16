<template>
  <el-container>
    <el-header style="padding: 0; background-color: #545c64;">
      <Header></Header>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <Navigator></Navigator>
      </el-aside>
      <el-container>
        <el-main>
          <el-radio-group v-model="state" size="medium" style="margin-bottom: 10px">
            <el-radio-button :label="2">已入驻商家</el-radio-button>
            <el-radio-button :label="1">待审核商家</el-radio-button>
          </el-radio-group>
          <el-row>
            <el-col :span="10">
              <el-input placeholder="请输入搜索内容" v-model="keyword"></el-input>
            </el-col>
            <el-col :span="4">
              <el-button type="primary" @click="search()">查找</el-button>
            </el-col>
          </el-row>
          <div class="table">
            <el-table
              :data="tableData"
              border>
              <el-table-column
                fixed
                prop="id"
                label="商家编号"
                width="80">
              </el-table-column>
              <el-table-column
                prop="shopName"
                label="店铺名称"
                width="100">
              </el-table-column>
              <el-table-column
                prop="ownerName"
                label="商家姓名"
                width="100">
              </el-table-column>
              <el-table-column
                prop="phoneNumber"
                label="联系电话"
                width="115">
              </el-table-column>
              <el-table-column
                prop="intro"
                label="商家简介"
                width="180">
              </el-table-column>
              <el-table-column
                prop="address"
                label="商家地址"
                width="300">
              </el-table-column>
              <el-table-column
                prop="email"
                label="商家邮箱"
                width="200">
              </el-table-column>
              <el-table-column
                prop="score"
                label="商家评分"
                width="80">
              </el-table-column>
              <el-table-column
                prop="identityNumber"
                label="身份证号码"
                width="180">
              </el-table-column>
              <el-table-column
                label="操作"
                width="100"
                fixed="right">
                <template slot-scope="scope">
                  <el-button type="text" size="primary" @click="clickOp(state, scope.row.id)"
                  v-text="state === 1 ? '同意' : '注销'">
                  </el-button>
                </template>
              </el-table-column>
            </el-table>
          </div>
        </el-main>
        <el-footer>
          <el-row type="flex" justify="center">
            <el-col :span="10" style="text-align: center">
              <el-pagination
                background
                layout="prev, pager, next"
                :page-count="totalPage"
                @current-change="handleCurrentChange">
              </el-pagination>
            </el-col>
          </el-row>
        </el-footer>
      </el-container>
    </el-container>
  </el-container>
</template>

<script>
import Navigator from '../components/Navigator'
import Header from './Header'
import Footer from './Footer'
export default {
  components: {
    Footer,
    Header,
    Navigator
  },
  data () {
    return {
      currentPage: 1,
      totalPage: 1,
      limit: 20,
      tableData: [],
      state: 2,
      keyword: ''
    }
  },
  methods: {
    handleCurrentChange (currentPage) {
      console.log(currentPage)
      this.currentPage = currentPage
      this.findAll()
    },
    findAll: function () {
      let that = this
      that.axios.post('/merchant/getByState', {
        state: that.state,
        currentPage: that.currentPage,
        limit: that.limit
      }).then(
        res => {
          console.log(res.data.data)
          that.totalPage = res.data.data.totalPage
          that.tableData = res.data.data.merchantList
        }
      )
    },
    clickOp (state, merchantID) {
      let that = this
      let url
      let message
      if (state === 2) {
        url = '/merchant/remove'
        message = '商家注销成功'
      } else {
        message = '同意成功'
        url = '/merchant/agree'
      }
      that.axios.post(url, {
        merchantID
      }).then(res => {
        if (res.data.code === '0000') {
          that.$message({
            type: 'success',
            message
          })
        }
      })
      that.findAll()
    },
    search () {
      let that = this
      that.axios.post('/merchant/search', {
        shopName: that.keyword,
        ownerName: that.keyword,
        intro: that.keyword,
        address: that.keyword,
        identityNumber: that.keyword,
        email: that.keyword,
        limit: that.limit,
        currentPage: that.currentPage
      }).then(res => {
        that.totalPage = res.data.data.totalPage
        that.tableData = res.data.data.merchantList
      })
    }
  },
  created () {
    this.findAll()
  },
  watch: {
    state () {
      console.log(this.state)
      this.findAll()
    },
    keyword () {
      if (this.keyword === '') {
        return
      }
      this.search()
    }
  }
}

</script>

<style scoped>
  .table {
    margin-top: 7px;
  }
</style>
