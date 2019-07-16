<template>
  <el-row id="categoryContainer">
    <el-col :span="12" :offset="6">
      <el-row :gutter="10">
        <el-col :span="6" v-for="(o) in categoryList" :key="o.id" style="margin-bottom: 5px;">
          <el-card :body-style="{ padding: '0px' }">
            <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png" class="image">
            <div style="padding: 14px;">
              <span v-text="o.text"></span>
              <div class="bottom clearfix">
                <time class="time">{{ currentDate }}</time>
                <el-button type="text" class="button">操作按钮</el-button>
              </div>
            </div>
          </el-card>
        </el-col>
      </el-row>
    </el-col>
  </el-row>
</template>

<script>
export default {
  name: 'Category',
  data () {
    return {
      categoryList: [
        {
          ID: 1,
          image: '/assets/logo.png',
          text: '电子产品'
        }, {
          ID: 2,
          image: '',
          text: '食品'
        }, {
          ID: 3,
          image: '',
          text: '服饰'
        }, {
          ID: 4,
          image: '',
          text: '化妆品'
        }, {

          ID: 5,
          image: '',
          text: '家电'
        }, {
          ID: 6,
          image: '',
          text: '图书'
        }, {
          ID: 7,
          image: '',
          text: '百货'
        }, {
          ID: 8,
          image: '',
          text: '鞋子'
        }
      ],
      currentDate: '2017-10-30'
    }
  },
  methods: {
  }
}
</script>

<style scoped>
  #categoryContainer {
    margin-top: 50px;
  }
  .time {
    font-size: 13px;
    color: #999;
  }

  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
  }

  .clearfix:after {
    clear: both
  }
</style>
