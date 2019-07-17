<template>
  <div class="">
    <el-row :gutter="10">
      <el-col :span="12">详细地址</el-col>
      <el-col :span="4">联系人</el-col>
      <el-col :span="4">联系电话</el-col>
      <el-col :span="4">添加</el-col>
    </el-row>
    <el-row :gutter="10">
      <el-col :span="12">
        <el-input v-model="addressInfo.address"></el-input>
      </el-col>
      <el-col :span="4">
        <el-input v-model="addressInfo.name"></el-input>
      </el-col>
      <el-col :span="4">
        <el-input v-model="addressInfo.phoneNumber"></el-input>
      </el-col>
      <el-col :span="4">
        <el-button @click="add">添加</el-button>
      </el-col>
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
      console.log(that.addressInfo)
      that.axios.post('/address/add', that.addressInfo)
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
</style>
