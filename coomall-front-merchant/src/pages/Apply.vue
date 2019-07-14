<template>
  <el-container>
    <el-header id="header">
      <h2>申请开店</h2>
    </el-header>
    <el-row id="header_bottom_row"></el-row>
    <el-main id="main">
      <el-form label-position="right" label-width="100px">
        <el-row type="flex" justify="center">
          <el-form-item label="商铺名">
            <el-input type="text" placeholder="请输入您的商铺名"
                      v-model="storeName" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="姓名">
            <el-input type="text" placeholder="请输入您的真实姓名"
                      v-model="name" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="手机号">
            <el-input type="text" placeholder="请输入您的手机号"
                      v-model="phone" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="密码">
            <el-input type="password" placeholder="请输入您的密码"
                      v-model="password" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="邮箱">
            <el-input type="text" placeholder="请输入您的邮箱"
                      v-model="mail" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="家庭住址">
            <el-input type="text" placeholder="请输入您的家庭住址"
                      v-model="phone" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row class="input_interval"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item label="身份证号">
            <el-input type="text" placeholder="请输入您的身份证号"
                      v-model="phone" class="input_width"></el-input>
          </el-form-item>
        </el-row>
        <el-row id="input_bottom"></el-row>
        <el-row type="flex" justify="center">
          <el-form-item>
            <el-button type="primary" id="bt_submit"
                       @click="onSubmit" round>申请</el-button>
          </el-form-item>
        </el-row>
      </el-form>
    </el-main>
  </el-container>
</template>

<script>
export default {
  name: 'apply',
  data () {
    return {
      storeName: '',
      name: '',
      phone: '',
      password: '',
      mail: '',
      address: '',
      IDNumber: '',
      dialogImageUrl: '',
      dialogVisible: false
    }
  },
  methods: {
    onSubmit: function () {
      let that = this
      this.axios.post('/apply', {
        storeName: that.storeName,
        name: that.name,
        phone: that.phone,
        password: that.password,
        mail: that.mail,
        address: that.address,
        IDNumber: that.IDNumber
      })
        .then(function (response) {
          this.$router.push('/applyResult')
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>

<style scoped>
  #header {
    margin-top: 20px;
    height: 100px;
    text-align: center
  }
  #header_bottom_row {
    height: 20px
  }
  #main {
    text-align: center
  }
  .input_width {
    width: 250px;
    margin-left: 20px
  }
  .input_interval {
    height: 15px
  }
  #input_bottom {
    height: 30px
  }
  #bt_submit {
    margin-right: 44px
  }
</style>
