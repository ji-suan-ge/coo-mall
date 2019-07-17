<template>
  <el-col class="productPreview" :span="6">
    <div v-bind:key="item.id" class="resultItem">
      <a href="#" style="text-decoration: none" @click.prevent="productClickedHandler">
        <img :src="item.avatar" class="ItemImage">
      </a>
      <div>
        <span class="rank">评分{{item.rank}}</span>
      </div>
      <p style="margin: 0;">
        <span v-text="item.name.length <= 13 ? item.name : item.name.substring(0, 13) + '...'"
              class="productName" @click.prevent="productClickedHandler"
        style="font-size: 14px; overflow: hidden;"></span>
      </p>
      <p style="margin: 0;display: block;">
        <router-link to="item.merchantLink" style="text-decoration: none" v-text="item.merchant" class="merchantName">
        </router-link>
      </p>
      <div class="productStatus">
        <span
      style="font-size: 12px;">
          月成交
          <em
      style="font-size: 14px;">{{item.sale}}笔</em>
        </span>
      </div>
    </div>
  </el-col>
</template>

<script>
export default {
  name: 'ProductPreview',
  props: ['item'],
  methods: {
    productClickedHandler () {
      this.$router.push({
        path: '/product/detail',
        query: {
          id: this.item.id
        }
      })
    }
  }
}
</script>

<style scoped>
  .resultItem{
    height: 250px;
    width: 210px;
    float: left;
    display: inline-block;
    margin: 0 0 10px 10px;
    border: 1px solid #eee;
    padding-top: 5px;
    padding-left: 10px;
    /*border-radius: 5px;*/
  }
  .ItemImage{
    height: 200px;
    width: 200px;
  }
  .price{
    margin: 2px;
    font-size: 20px;
    color: #ff0036;
  }
  .rank{
    clear: none;
    float: right;
    font-size: 12px;
    color: #ff0036;
  }
  .productName{
    color: black;
    font-size: 12px;
    font-family: 微软雅黑;
    line-height: 14px;
    overflow: hidden;
  }
  .productName:hover{
    color: #ff0036 !important;
  }
  .merchantName{
    color: #999;
    font-size: 10px;
    font-family: 微软雅黑;
    line-height: 14px;
    overflow: hidden;
  }
  .merchantName:hover{
    color: #ff0036 !important;
  }
  .productStatus{
    position: relative;
    height: 32px;
    border: none;
    border-top: 1px solid #eee;
    margin-bottom: 0;
    color: #999;
  }
  .productStatus span {
    float: left;
    display: inline-block;
    border-right: 1px solid #eee;
    width: 49%;
    padding: 7px 1px 0 0;
    line-height: 12px;
    text-align: left;
    white-space: nowrap;
    font-size: 12px;
  }
  .productStatus a{
    margin-top: 0;
    font-family: arial;
    font-size: 14px;
    font-weight: 700;
    color: #38b;
    text-decoration: none;
  }
  .productStatus a:hover{
    text-decoration: underline;
  }
  .productStatus em {
    margin-top: 0;
    font-family: arial;
    font-size: 14px;
    font-weight: 700;
    color: #b57c5b;
  }
</style>
