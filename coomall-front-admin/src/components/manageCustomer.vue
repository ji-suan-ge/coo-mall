<template>
  <el-container>
    <el-header style="padding: 0; background-color: #777777;">
      <Header></Header>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <Navigator></Navigator>
      </el-aside>
      <el-container>
        <el-main>
          <el-row>
            <el-col :offset="4" :span="10">
              <el-input placeholder="请输入搜索内容" v-model="keyword"></el-input>
            </el-col>
            <el-col :span="4">
              <el-button type="primary" @click="search">查找</el-button>
            </el-col>
          </el-row>
          <div class="table">
            <el-table
              :data="tableData"
              border>
              <el-table-column
                fixed
                prop="id"
                label="编号"
                width="100">
              </el-table-column>
              <el-table-column
                prop="nickname"
                label="昵称"
                width="100">
              </el-table-column>
              <el-table-column
                prop="gender"
                label="性别"
                width="100">
              </el-table-column>
              <el-table-column
                prop="phoneNumber"
                label="联系电话"
                width="200">
              </el-table-column>
              <el-table-column
                prop="email"
                label="邮箱"
                width="300">
              </el-table-column>
              <el-table-column
                label="操作"
                width="100"
                fixed="right">
                <template slot-scope="scope">
                  <el-button type="text" size="primary" @click="remove(scope.row.id)">注销</el-button>
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
      keyword: ''
    }
  },
  methods: {
    handleCurrentChange (currentPage) {
      console.log(currentPage)
      this.currentPage = currentPage
      if (this.keyword === '') {
        this.findAll()
      } else {
        this.search()
      }
    },
    findAll: function () {
      let that = this
      that.axios.post('/custom/getByState', {
        state: 1,
        currentPage: that.currentPage,
        limit: that.limit
      }).then(
        res => {
          console.log(res.data.data)
          that.totalPage = res.data.data.totalPage
          let tempTableData = res.data.data.customList
          for (let i = 0; i < tempTableData.length; i++) {
            if (tempTableData[i].gender === 0) {
              tempTableData[i].gender = '男'
            } else {
              tempTableData[i].gender = '女'
            }
          }
          that.tableData = tempTableData
        }
      )
    },
    search () {
      let that = this
      that.axios.post('/custom/search', {
        nickName: that.keyword,
        phoneNumber: that.keyword,
        email: that.keyword,
        limit: that.limit,
        currentPage: that.currentPage
      }).then(res => {
        that.totalPage = res.data.data.totalPage
        let tempTableData = res.data.data.customList
        for (let i = 0; i < tempTableData.length; i++) {
          if (tempTableData[i].gender === 0) {
            tempTableData[i].gender = '男'
          } else {
            tempTableData[i].gender = '女'
          }
        }
        that.tableData = tempTableData
      })
    },
    remove (customID) {
      let that = this
      that.axios.post('/custom/remove', {
        customID
      }).then(res => {
        if (res.data.code === '0000') {
          that.$message({
            type: 'success',
            message: '注销客户成功！'
          })
        }
      })
      that.findAll()
    }
  },
  created () {
    this.findAll()
  },
  watch: {
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
