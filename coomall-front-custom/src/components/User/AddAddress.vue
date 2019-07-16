<template>
  <div class="">
    <el-row>
      <el-col :span="12">详细地址</el-col>
      <el-col :span="4">联系人</el-col>
      <el-col :span="4">联系电话</el-col>
      <el-col :span="4">添加</el-col>
    </el-row>
    <el-row>
      <el-col :span="12">
        <el-input ></el-input>
      </el-col>
      <el-col :span="4">联系人</el-col>
      <el-col :span="4">联系电话</el-col>
      <el-col :span="4">添加</el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'productsAdd',
  data () {
    return {
      addressInfo: {
        address: '',
        name: '',
        phoneNumber: ''
      },
      total: 1,
      rowStyle: {
        height: '50px'
      }
    }
  },
  methods: {
    add () {
      let that = this
      that.axios.post('/product/add', that.addressInfo)
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            that.$message({message: '添加成功', type: 'success'})
            that.$router.push('/User/Address')
          } else {
            that.$message.error('系统繁忙，请稍后重试')
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
  }
  .table_bottom {
    height: 40px;
  }
  .input_width {
    width: 170px;
  }
</style>
