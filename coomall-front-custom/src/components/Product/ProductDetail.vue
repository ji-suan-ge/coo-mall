<template>
  <el-container>
    <el-container>
      <el-col :offset="5" :span="5">
        <el-aside style=" overflow: hidden" id="detailAside">
          <el-image
            style="width: 300px; height: 300px;"
            :src="product.avatar"
            fit="fill"></el-image>
        </el-aside>
      </el-col>
<!--      <el-col :offset="1" :span="15">-->
        <el-main>
          <el-row>
            <h1 v-text="product.name" style="font-size: 30px;"></h1>
          </el-row>
          <el-row>
            <span>店铺：</span><router-link
            id="merchant"
            :to="'/merchant?merchantID='+product.merchantID"
            v-text="merchantName"></router-link>
          </el-row>
          <el-row>
            <span>价格：</span><span id="price">&yen; {{ product.price }}</span>
          </el-row>
          <el-row>
            <el-col :span="10">
              <p v-text="product.detail"></p>
            </el-col>
          </el-row>
          <el-row style="margin-top: 50px">
            <el-col :span="10">
              <ul class="tm-ind-panel" data-spm-anchor-id="a220o.1000855.0.i2.72ec4795vUVhwC" style="list-style: none">
                <li class="tm-ind-item tm-ind-sellCount" data-label="月销量">
                  <div class="tm-indcon" data-spm-anchor-id="a220o.1000855.0.i6.72ec4795vUVhwC">
                    <span class="tm-label">月销量</span>
                    <span class="tm-count" data-spm-anchor-id="a220o.1000855.0.i3.72ec4795vUVhwC" v-text="product.sale"></span></div></li>
                <li class="tm-ind-item tm-ind-reviewCount canClick tm-line3" id="J_ItemRates">
                  <div class="tm-indcon">
                    <span class="tm-label">累计评价</span>
                    <span class="tm-count" v-text="product.score"></span></div></li>
              </ul>
            </el-col>
          </el-row>
          <el-row>
            <el-radio-group v-model="styleChoice" size="small" class="itemGroup">
              <el-radio v-for="item in productStyleList" :label="item.id" :key="item.id" border>{{ item.style }}</el-radio>
            </el-radio-group>
          </el-row>
          <el-row>
            <el-input-number size="medium" v-model="buyNumber" style="margin-top: 10px"
                             :min="1"></el-input-number>
          </el-row>
          <el-row style="margin-top: 5px">
            <el-select v-model="addressChoice" placeholder="请选择">
              <el-option
                v-for="item in addressList"
                :key="item.id"
                :label="item.address + ' - ' + item.name + ' - ' + item.phoneNumber"
                :value="item.id">
              </el-option>
            </el-select>
          </el-row>
          <el-row class="itemGroup">
            <el-button plain type="primary" @click="purchase">立即购买</el-button>
<!--            <el-button type="primary">加入购物车</el-button>-->
          </el-row>
        </el-main>
<!--      </el-col>-->
    </el-container>
  </el-container>
</template>

<script>
export default {
  name: 'ProductDetail',
  // props: ['product'],
  data () {
    return {
      product: {
        id: 1,
        sale: 1009,
        score: 7.5,
        intro: '一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品' +
          '一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品一个商品' +
          '一个商品一个商品一个商品一个商品一个商品一个商品一个商品'
      },
      merchantName: null,
      styleChoice: null,
      addressChoice: null,
      buyNumber: 1,
      productStyleList: [],
      addressList: []
    }
  },
  methods: {
    getStyle () {
      let that = this
      that.axios.post('/product/getStyle', {
        productID: that.product.id
      }).then(res => {
        that.productStyleList = res.data.data.productStyleList
        that.styleChoice = res.data.data.productStyleList[0].id
      })
    },
    getAddress () {
      let that = this
      this.axios.post('/address/get', {
      }).then(res => {
        console.log(res.data.data.addressList)
        that.addressList = res.data.data.addressList
        that.addressChoice = res.data.data.addressList[0].id
        console.log(that.addressChoice)
      })
    },
    getMerchantInfo () {
      let that = this
      this.axios.post('/merchant/getByID', {
        merchantID: this.product.merchantID
      }).then(res => {
        that.merchantName = res.data.data.shopName
        console.log(that.merchantName)
      })
    },
    purchase () {
      let that = this
      that.axios.post('/order/addByProduct', {
        productID: that.product.id,
        addressID: that.addressChoice,
        remark: '',
        style: that.styleChoice,
        amount: that.buyNumber
      }).then(res => {
        if (res.data.code === '0000') {
          this.$message('下单成功')
          this.$router.push({
            path: '/index',
            query: {
            }
          })
        } else {
          this.$message.error('系统正忙，请刷新页面重试')
        }
      })
    }
  },
  created () {
    console.log(this.$route.query.id)
    let that = this
    this.axios.post('/product/getByID', {
      productID: that.$route.query.id
    }).then(res => {
      that.product = res.data.data.product
      that.getStyle()
      that.getAddress()
      this.getMerchantInfo()
    })
  }
}
</script>

<style scoped>
  #price {
    vertical-align: middle;
    font-size: 30px;
    color: #FF0036;
    font-weight: bolder;
    font-family: Arial;
  }
  .itemGroup {
    margin-top: 20px;
  }
</style>
