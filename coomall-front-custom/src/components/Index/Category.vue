<template>
  <el-row id="categoryContainer">
    <el-row>
      <el-col :offset="6" style="font-size: 30px; margin-bottom: 20px" :span="5">分类列表</el-col>
    </el-row>
    <el-row>
      <el-col :span="12" :offset="6">
        <el-row :gutter="10">
          <el-col :span="6" v-for="(o) in categoryList" :key="o.id" style="margin-bottom: 5px;">
            <el-card :body-style="{ padding: '0px' }">
              <img src="https://shadow.elemecdn.com/app/element/hamburger.9cf7b091-55e9-11e9-a976-7f4d0b07eef6.png"
                   class="image"
                   @click.prevent="categoryClickedHandler(o.id)">
              <el-row style="padding-top: 5px">
                <span v-text="o.text" style="font-size: 20px; text-align: center; display: block;"
                   @click.prevent="categoryClickedHandler(o.id)"></span>
              </el-row>
            </el-card>
          </el-col>
        </el-row>
      </el-col>
    </el-row>
  </el-row>
</template>

<script>
export default {
  name: 'Category',
  data () {
    return {
      categoryList: [
        {
          id: 1,
          image: '/assets/logo.png',
          text: '电子产品'
        }, {
          id: 2,
          image: '',
          text: '食品'
        }, {
          id: 3,
          image: '',
          text: '服饰'
        }, {
          id: 4,
          image: '',
          text: '化妆品'
        }, {
          id: 5,
          image: '',
          text: '家电'
        }, {
          id: 6,
          image: '',
          text: '图书'
        }, {
          id: 7,
          image: '',
          text: '百货'
        }, {
          id: 8,
          image: '',
          text: '鞋子'
        }
      ]
    }
  },
  methods: {
    categoryClickedHandler (categoryID) {
      console.log(categoryID)
      let that = this
      that.axios.post('/product/getByCategory', {
        category: categoryID,
        currentPage: 1,
        limit: 28
      }).then(res => {
        that.$emit('submitData', res.data.data)
        that.$router.push({
          name: 'result'
        })
      })
    }
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
