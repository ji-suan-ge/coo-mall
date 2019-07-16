<template>
  <el-container class="container">
    <el-header  class="header">
      <el-row>
        <div>
          <el-col :span="2">
            <img src="../assets/coo.png" height="50px" />
          </el-col>
          <el-col :span="8" :push="5">
            <h3>欢迎来到CooMall商家管理页面</h3>
          </el-col>
          <el-col :span="4" :push="5">
            <h3>{{ merchant.ownerName }}[{{ merchant.phoneNumber }}]</h3>
          </el-col>
          <el-col :span="2" :push="5">
            <router-link to="/modifyPassword">
              <el-button type="warning" size="small" round>修改密码</el-button>
            </router-link>
          </el-col>
          <el-col :span="2" :push="5">
            <el-button type="warning" size="small"
                       @click="logout" round>退出系统</el-button>
          </el-col>
        </div>
      </el-row>

    </el-header>
    <el-container class="container">
      <el-aside width="202px" height="700px">
          <el-menu
            default-active="0"
            background-color="#ff4400"
            text-color="#fff"
            class="left-menu"
            active-text-color="#ffd04b">
            <el-submenu index="1">
              <template slot="title">商品管理</template>
              <router-link to="/homePage/productsManage">
                <el-menu-item index="1-1">查看商品</el-menu-item>
              </router-link>
              <router-link to="/homePage/productsAdd">
                <el-menu-item index="1-2">上架商品</el-menu-item>
              </router-link>
            </el-submenu>
            <el-submenu index="2">
              <template slot="title">订单管理</template>
                <el-submenu index="2-1">
                  <template slot="title">进行中订单</template>
                  <router-link to="/homePage/waitPay">
                    <el-menu-item index="2-1-1">待付款</el-menu-item>
                  </router-link>
                  <router-link to="/homePage/waitShip">
                    <el-menu-item index="2-1-2">待发货</el-menu-item>
                  </router-link>
                  <router-link to="/homePage/shipped">
                    <el-menu-item index="2-1-3">已发货</el-menu-item>
                  </router-link>
                  <router-link to="/homePage/signed">
                    <el-menu-item index="2-1-4">已签收</el-menu-item>
                  </router-link>
                </el-submenu>
                <el-submenu index="2-2">
                  <template slot="title">已完成订单</template>
                  <router-link to="/homePage/finished">
                    <el-menu-item index="2-2-1">已完成</el-menu-item>
                  </router-link>
                </el-submenu>
                <el-submenu index="2-3">
                  <template slot="title">退货订单</template>
                  <router-link to="/homePage/waitReturn">
                    <el-menu-item index="2-3-1">待退货</el-menu-item>
                  </router-link>
                  <router-link to="/homePage/returning">
                    <el-menu-item index="2-3-2">退货中</el-menu-item>
                  </router-link>
                  <router-link to="/homePage/returned">
                    <el-menu-item index="2-3-3">已退货</el-menu-item>
                  </router-link>
                </el-submenu>
                <el-submenu index="2-4">
                  <template slot="title">已取消订单</template>
                  <router-link to="/homePage/canceled">
                    <el-menu-item index="2-4-1">已取消</el-menu-item>
                  </router-link>
                </el-submenu>
            </el-submenu>
            <router-link to="/homePage/reportForm">
              <el-menu-item index="3">报表</el-menu-item>
            </router-link>
            <router-link to="/homePage/merchantInfo">
              <el-menu-item index="4">商家信息</el-menu-item>
            </router-link>
          </el-menu>
      </el-aside>
      <div class="main">
        <router-view :productFromFather="product" @submitData="getProductFromProductsManage"></router-view>
      </div>
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'homePage',
  data () {
    return {
      merchant: JSON.parse(sessionStorage.getItem('merchant')),
      product: {}
    }
  },
  methods: {
    logout () {
      let that = this
      that.axios.post('/merchant/logout')
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            sessionStorage.removeItem('merchant')
            that.$router.replace('/login')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    getProductFromProductsManage (product) {
      console.log('得到子组件参数')
      console.log(product)
      this.product = product
    }
  }
}
</script>

<style scoped>
  * {
    padding: 0;
    margin: 0;
  }
  .main {
    width: 100%;
    text-align: center;
  }
  .container {
    text-align: center;
  }
  .header {
    padding-top: 13px;
    background-color: #ff5000;
    color: #fff;
    vertical-align: middle;
    text-align: right;
  }
  .left-menu {
    width: 200px;
    text-align: center;
  }
  a {
    text-decoration: none;
  }

</style>
