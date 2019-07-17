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
        <el-button @click="editHandler">修改</el-button>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: 'editAddress',
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
    editHandler () {
      let that = this
      console.log(that.addressInfo)
      that.axios.post('/address/delete', {
        addressID: that.addressInfo.id
      })
        .then(function (response) {
          if (response.data.code === '0000') {
            that.axios.post('/address/add', {
              name: that.addressInfo.name,
              address: that.addressInfo.address,
              phoneNumber: that.addressInfo.phoneNumber
            }).then(res => {
              if (res.data.code === '0000') {
                that.$message({message: '修改成功', type: 'success'})
                that.$router.push('/User/Address')
              } else {
                that.$message.error('系统繁忙，请稍后重试')
              }
            })
              .catch(function (error) {
                console.log(error)
              })
          } else {
            that.$message.error('系统繁忙，请稍后重试')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  },
  created () {
    this.addressInfo = {
      address: this.$route.query.address,
      name: this.$route.query.name,
      phoneNumber: this.$route.query.phoneNumber,
      id: this.$route.query.id
    }
  }
}
</script>

<style scoped>
</style>
