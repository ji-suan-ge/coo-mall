<template>
    <el-container>
      <el-header style="padding: 0; background-color: #545c64;">
        <Header></Header>
      </el-header>
      <el-container>
        <el-aside width="200px">
          <Navigator></Navigator>
        </el-aside>
        <el-main>
          <el-card class="my-card">
            <div slot="header" class="my-header">
              <span>个人信息</span>
            </div>
            <el-form label-width="70px" class="form">
              <el-form-item class="item">姓名:
                <span class="value">{{ admin.name }}</span>
              </el-form-item>
              <el-form-item class="item">性别:
                <span class="value">{{ admin.gender == 0 ? '男' : '女' }}</span>
              </el-form-item>
              <el-form-item class="item">联系电话:
                <span class="value">{{ admin.phoneNumber }}</span>
              </el-form-item>
              <el-form-item class="item">邮箱地址:
                <span class="value">{{ admin.email }}</span>
              </el-form-item>
            </el-form>
          </el-card>
        </el-main>
      </el-container>
    </el-container>
</template>

<script>
import Navigator from '../components/Navigator'
import Header from './Header'
export default {
  components: {
    Header,
    Navigator
  },
  name: 'adminInfo',
  data () {
    return {
      admin: {}
    }
  },
  methods: {
    modify () {
    }
  },
  created () {
    this.admin = JSON.parse(localStorage.getItem('admin'))
  }
}
</script>

<style scoped>
  .my-card {
    border-radius: 2px;
    box-shadow: 3px 3px 6px #666;
    background-color: white;
    width: 600px;
  }
  .form {
    margin: 5px 20px;
  }
  .value {
    text-align: left;
    margin-left: 50px;
  }
</style>
