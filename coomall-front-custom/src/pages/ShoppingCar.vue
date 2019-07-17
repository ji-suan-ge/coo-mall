<template>
  <el-container>
    <el-header><TopBar></TopBar></el-header>
    <el-main>
      <el-row>
        <el-row align="middle">
          <el-col :span="1">
            <el-checkbox
              :indeterminate="isIndeterminate"
              v-model="checkAll"
              @change="handleCheckAllChange">
              <span class="tb-header">全选</span>
            </el-checkbox>
          </el-col>
          <el-col span="8"><span class="tb-header">商品信息</span></el-col>
          <el-col span="3"><span class="tb-header">单价</span></el-col>
          <el-col span="3"><span class="tb-header">数量</span></el-col>
          <el-col span="3"><span class="tb-header">金额</span></el-col>
          <el-col span="3"><span class="tb-header">操作</span></el-col>
        </el-row>
        <el-row v-for="item in Options" v-bind:key="item.ID" >
          <el-col>
            <checkbox_button :v-model="item.checked"></checkbox_button>
          </el-col>
          <el-col span="8"><span class="tb-header">1</span></el-col>
          <el-col span="3"><span class="tb-header">2</span></el-col>
          <el-col span="3"><span class="tb-header">3</span></el-col>
          <el-col span="3"><span class="tb-header">4</span></el-col>
          <el-col span="3"><span class="tb-header">5</span></el-col>
        </el-row>
<!--          <table class="cart">-->
<!--            <tbody>-->
<!--            <tr class="header">-->
<!--              <td>-->
<!--                <el-checkbox-->
<!--                  :indeterminate="isIndeterminate"-->
<!--                  v-model="checkAll"-->
<!--                  @change="handleCheckAllChange">-->
<!--                  全选-->
<!--                </el-checkbox>-->
<!--              </td>-->
<!--              <td class="headerItem blockInfo">-->
<!--                <el-col>商品信息</el-col>-->
<!--              </td>-->
<!--              <td class="headerItem blockPrice">单价</td>-->
<!--              <td class="headerItem blockQuantity">数量</td>-->
<!--              <td class="headerItem blockSubtotal">金额</td>-->
<!--              <td class="headerItem blockOperation">操作</td>-->
<!--            </tr>-->
<!--            </tbody>-->
<!--          </table>-->

      </el-row>
      <el-row>
        <Pagination></Pagination>
      </el-row>
    </el-main>
    <el-footer><Footer></Footer></el-footer>
  </el-container>
</template>

<script>
import TopBar from '../components/Common/TopBar'
import Footer from '../components/Common/Footer'
import Pagination from '../components/Common/Pagination'
export default {
  name: 'ShoppingCar',
  components: {Pagination, Footer, TopBar},
  data () {
    return {
      checkAll: false,
      checkedOptions: null,
      options: this.Options,
      isIndeterminate: true,
      Options: null
    }
  },
  methods: {
    handleCheckAllChange (val) {
      this.checkedOptions = val ? this.Options : []
      this.isIndeterminate = false
    },
    handleCheckedChange (value) {
      let checkedCount = value.length
      this.checkAll = checkedCount === this.options.length
      this.isIndeterminate = checkedCount > 0 && checkedCount < this.options.length
    },
    getShoppingCarData (currentPage, pageLimit) {
      let that = this
      that.axios.post('/shoppingcar/find', {
        currentPage: currentPage,
        limit: pageLimit
      }).then(res => {
        console.log(res.data.data.shoppingcarList)
        for (var i = 0; i < res.data.data.shoppingcarList.length; i++) {
          that.Options[i] = res.data.data.shoppingcarList[i]
          that.Options[i].checked = false
        }
      })
    }
  },
  created () {
    this.getShoppingCarData(1, 30)
  }
}
</script>

<style scoped>
.tb-header{
  font-size: 16px;
}
</style>
