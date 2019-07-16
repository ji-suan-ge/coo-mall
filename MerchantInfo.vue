<template>
  <el-container class="container">
    <el-header class="header">
      <el-row>
        <el-col>
          <h3>商家信息维护</h3>
          <hr />
        </el-col>
      </el-row>
    </el-header>
    <el-main class="main">
      <el-row>
        <div class="row">
          <el-col :span="3" :offset="8">商铺名:</el-col>
          <el-col :span="6">
            <el-input v-model="merchant.shopName"
                      class="inputEmail"></el-input>
          </el-col>
        </div>
        <hr />
      </el-row>
      <el-row>
        <div class="row">
          <el-col :span="3" :offset="8">评分:</el-col>
          <el-col :span="6">{{ merchant.score }}</el-col>
        </div>
        <hr />
      </el-row>
      <el-row>
        <div class="row">
          <el-col :span="3" :offset="8">姓名:</el-col>
          <el-col :span="6">{{ merchant.ownerName }}</el-col>
        </div>
        <hr />
      </el-row>
      <el-row>
        <div class="row">
          <el-col :span="3" :offset="8">身份证号:</el-col>
          <el-col :span="6">{{ merchant.identityNumber }}</el-col>
        </div>
        <hr />
      </el-row>
      <el-row>
        <div class="row">
          <el-col :span="3" :offset="8">手机号:</el-col>
          <el-col :span="6">
            <el-input v-model="merchant.phoneNumber"
                      class="inputEmail"></el-input>
          </el-col>
        </div>
        <hr />
      </el-row>
      <el-row>
      <div class="row">
        <el-col :span="3" :offset="8">电子邮箱:</el-col>
        <el-col :span="6">
          <el-input v-model="merchant.email"
                    class="inputEmail"></el-input>
        </el-col>
      </div>
      <hr />
    </el-row>
      <el-row>
        <div class="row">
          <el-col :span="3" :offset="8">家庭住址:</el-col>
          <el-col :span="6">
            <el-input v-model="merchant.address"
                      class="inputAddress"></el-input>
          </el-col>
        </div>
        <hr />
      </el-row>
      <el-row>
        <div class="areaRow">
          <el-col :span="3" :offset="8">商家简介:</el-col>
          <el-input
            class="inputIntroduce"
            type="textarea"
            :rows="4"
            v-model="merchant.intro">
          </el-input>
        </div>
        <hr />
      </el-row>
    </el-main>
    <el-footer>
      <el-button type="success" @click="modify" round>保存</el-button>
    </el-footer>
  </el-container>
</template>

<script>
export default {
  name: 'merchantInfo',
  data () {
    return {
      merchant: JSON.parse(sessionStorage.getItem('merchant'))
    }
  },
  methods: {
    modify () {
      let that = this
      that.axios.post('/merchant/edit', {
        shopName: that.merchant.shopName,
        phoneNumber: that.merchant.phoneNumber,
        intro: that.merchant.intro,
        address: that.merchant.address,
        email: that.merchant.email
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            sessionStorage.setItem('merchant', JSON.stringify(that.merchant))
            alert('信息修改成功')
            that.$router.push('/homePage')
          } else {
            alert('系统繁忙，稍后重试')
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
  hr {
    color: gray;
  }
  .row {
    height: 40px;
    color: gray;
    margin-top: 10px;
    vertical-align: middle;
  }
  .areaRow {
    height: 100px;
    color: gray;
    margin-top: 10px;
    vertical-align: middle;
  }
  .header {
     text-align: center;
     height: 100px;
   }
  .container {
    height: 100%;
    width: 100%;
  }
  .inputEmail {
    height: 30px;
    width: 180px;
    margin-bottom: 10px;
  }
  .inputAddress {
    height: 30px;
    width: 300px;
    margin-bottom: 10px;
  }
  .main {
    text-align: left;
  }
  .inputIntroduce {
    width: 400px;
  }
</style>
