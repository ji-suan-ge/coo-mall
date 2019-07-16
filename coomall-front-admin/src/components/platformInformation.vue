<template>
  <el-container>
    <el-header  style="padding: 0; background-color: #545c64;">
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
          value: 10092
        }, {
          id: 2,
          name: '日活跃用户数',
          value: 10292
        }, {
          id: 3,
          name: '商家数量',
          value: 101
        }, {
          id: 4,
          name: '商品总数',
          value: 121112
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
    }
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
