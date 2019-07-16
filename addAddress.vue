<template>
  <div>
    <el-table :data="productInfo" max-height="100%"
              :row-style="rowStyle" id="productInfo" stripe>
      <el-table-column prop="name"
                       class="table_row" label="商品名称">
        <template slot-scope="scope">
          <el-input type="text" v-model="productInfo[scope.$index].name" class="input_width"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="price"
                       class="table_row" label="商品价格">
        <template slot-scope="scope">
          <el-input type="text" v-model="productInfo[scope.$index].price" class="input_width"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="quantity"
                       class="table_row" label="商品库存">
        <template slot-scope="scope">
          <el-input type="text" v-model="productInfo[scope.$index].quantity" class="input_width"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="category"
                       class="table_row" label="分类">
        <template slot-scope="scope">
          <el-select v-model="productInfo[scope.$index].category" placeholder="请选择">
            <el-option
              v-for="item in options"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </template>
      </el-table-column>
      <el-table-column prop="detail"
                       class="table_row" label="详细信息">
        <template slot-scope="scope">
          <el-input type="text" v-model="productInfo[scope.$index].detail" class="input_width"></el-input>
        </template>
      </el-table-column>
      <el-table-column prop="avatar"
                       class="table_row" label="商品图片">
        <template slot-scope="scope">
          <el-input type="text" v-model="productInfo[scope.$index].avatar" class="input_width"></el-input>
        </template>
      </el-table-column>
      <el-table-column
        fixed="right"
        label="操作"
        width="150">
        <template slot-scope="scope">
          <el-button type="primary" size="small" @click="add(scope.$index, scope.row)">上架</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-row class="table_bottom"></el-row>
    <el-button type="primary" size="middle" @click="addAll()">一键上架</el-button>
  </div>
</template>

<script>
export default {
  name: 'productsAdd',
  data () {
    return {
      productInfo: [
        {
          name: '',
          price: '',
          quantity: '',
          category: 1,
          detail: '',
          avatar: ''
        },
        {
          name: '',
          price: '',
          quantity: '',
          category: 1,
          detail: '',
          avatar: ''
        },
        {
          name: '',
          price: '',
          quantity: '',
          category: 1,
          detail: '',
          avatar: ''
        },
        {
          name: '',
          price: '',
          quantity: '',
          category: 1,
          detail: '',
          avatar: ''
        },
        {
          name: '',
          price: '',
          quantity: '',
          category: 1,
          detail: '',
          avatar: ''
        },
        {
          name: '',
          price: '',
          quantity: '',
          category: 1,
          detail: '',
          avatar: ''
        }
      ],
      total: 1,
      rowStyle: {
        height: '50px'
      },

      options: [{
        value: 1,
        label: '电子产品'
      }, {
        value: 2,
        label: '食品'
      }, {
        value: 3,
        label: '服饰'
      }, {
        value: 4,
        label: '化妆品'
      }, {
        value: 5,
        label: '家电'
      }, {
        value: 6,
        label: '图书'
      }, {
        value: 7,
        label: '百货'
      }]
    }
  },
  methods: {
    add (index, row) {
      let that = this
      that.axios.post('/product/add', {
        name: that.productInfo[index].name,
        price: that.productInfo[index].price,
        quantity: that.productInfo[index].quantity,
        category: that.productInfo[index].category,
        detail: that.productInfo[index].detail,
        avatar: that.productInfo[index].avatar
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            alert('上架成功')
            that.$router.go(0)
          } else {
            alert('系统繁忙，稍后重试')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    },
    addAll () {
      let that = this
      for (var p in that.productInfo) {
        let that = this
        if (that.productInfo[p].name !== '') {
          console.log('开始提交数据')
          that.axios.post('/product/add', {
            name: that.productInfo[p].name,
            price: that.productInfo[p].price,
            quantity: that.productInfo[p].quantity,
            category: that.productInfo[p].category,
            detail: that.productInfo[p].detail,
            avatar: that.productInfo[p].avatar
          })
            .then(function (response) {
              if (response.data.msg === '请求成功') {
              } else {
                alert('系统繁忙，稍后重试')
              }
            })
            .catch(function (error) {
              console.log(error)
            })
        }
      }
      alert('全部上架成功')
      that.$router.go(0)
    }
  }
}
</script>

<style scoped>
  #productInfo {
    width: 100%;
    text-align: center;
  }
  .table_row {
  }
  .table_bottom {
    height: 40px;
  }
  .input_width {
    width: 170px;
  }
</style>
