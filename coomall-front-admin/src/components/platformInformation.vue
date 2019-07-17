<template>
  <el-container>
    <el-header  style="padding: 0; background-color: #777777;">
      <Header></Header>
    </el-header>
    <el-container>
      <el-aside width="200px">
        <Navigator></Navigator>
      </el-aside>
      <el-main>
        <el-row>
          <el-col :span="8" v-for="(o, index) in infoList" :key="o.id" :offset="index > 0 ? 2 : 0">
            <el-card :body-style="{ padding: '0px', height: '211px'}">
              <el-col style="padding: 14px;" type="flex" justify="center">
                <el-row type="flex" justify="center"><span v-text="o.name"></span></el-row>
                <el-row type="flex" justify="center" align="middle" style="height: 180px;">
                  <span v-text="o.value" style="font-size: 50px;"></span>
                </el-row>
              </el-col>
            </el-card>
          </el-col>
        </el-row>
      </el-main>
    </el-container>
  </el-container>
</template>

<script>
import Navigator from '../components/Navigator'
import Header from './Header'
export default {
  name: 'platformInformation',
  components: {
    Header,
    Navigator: Navigator
  },
  data () {
    return {
      infoList: [
        {
          id: 1,
          name: '用户数量',
          value: 233
        }, {
          id: 2,
          name: '总交易额',
          value: 233
        }, {
          id: 3,
          name: '商家数量',
          value: 233
        }, {
          id: 4,
          name: '商品总数',
          value: 233
        }
      ],
      platform: {
        customerNumber: '232323',
        activeCustomer: '11111',
        merchantNumber: '123456',
        productNumber: '666666666666',
        dailyTurnover: '123456'
      }
    }
  },
  methods: {
    modify () {
    },
    getBillData () {
      let that = this
      that.axios.post('bill/get')
        .then(res => {
          that.infoList[0].value = res.data.data.customNumber
          that.infoList[1].value = res.data.data.allSale
          that.infoList[2].value = res.data.data.merchantNumber
          that.infoList[3].value = res.data.data.productNumber
        })
    }
  },
  created () {
    this.getBillData()
  }
}
</script>

<style scoped>
  .platform-web {
    /*height: 100%;*/
    /*width: 100%;*/
    /*position: absolute;*/
    background-color: rgba(55,55,55,0.1);
  }
  .platform-carousel {
    /*width: 65%;*/
    /*height: 60%;*/
    /*position: absolute;*/
    /*left: 220px;*/
    /*top: 50px;*/
    border-radius: 2px;
    box-shadow: 3px 3px 6px #666;
  }
  .el-carousel__item span {
    color: #475669;
    font-size: 18px;
    opacity: 0.75;
    /*line-height: 550px;*/
    /*position: relative;*/
  }
  .item {
    color: #475669;
    font-size: 18px;
    background-color: #99a9bf;
    text-align: center;
  }

</style>
