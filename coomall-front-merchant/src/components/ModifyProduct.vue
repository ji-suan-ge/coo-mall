<template>
  <el-table :data="productInfo" max-height="100%"
            :row-style="rowStyle" id="productInfo" stripe>
    <el-table-column class="table_row" label="商品编号">
      <template slot-scope="scope">
        <el-input type="text" v-model="productInfo[scope.$index].id" class="input_width" disabled></el-input>
      </template>
    </el-table-column>
    <el-table-column class="table_row" label="商品名称">
      <template slot-scope="scope">
        <el-input type="text" v-model="productInfo[scope.$index].name" class="input_width" disabled></el-input>
      </template>
    </el-table-column>
    <el-table-column class="table_row" label="商品价格">
      <template slot-scope="scope">
        <el-input type="text" v-model="productInfo[scope.$index].price" class="input_width"></el-input>
      </template>
    </el-table-column>
    <el-table-column class="table_row" label="商品库存">
      <template slot-scope="scope">
        <el-input type="text" v-model="productInfo[scope.$index].quantity" class="input_width"></el-input>
      </template>
    </el-table-column>
    <el-table-column class="table_row" label="分类">
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
    <el-table-column class="table_row" label="详细信息">
      <template slot-scope="scope">
        <el-input type="text" v-model="productInfo[scope.$index].detail" class="input_width"></el-input>
      </template>
    </el-table-column>
    <el-table-column
      fixed="right"
      label="操作"
      width="150">
      <template slot-scope="scope">
        <el-button type="primary" size="small" @click="modify(scope.$index, scope.row)">保存修改</el-button>
      </template>
    </el-table-column>
  </el-table>
</template>
<script>
export default {
  name: 'modifyProduct',
  props: ['productFromFather'],
  data () {
    return {
      productInfo: [{
        name: '',
        price: '',
        quantity: '',
        category: '',
        detail: '',
        avatar: ''
      }],
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
  created () {
    let that = this
    that.productInfo = [that.productFromFather]
  },
  methods: {
    modify (index, row) {
      let that = this
      that.axios.post('/product/edit', {
        productID: that.productInfo[index].id,
        price: that.productInfo[index].price,
        quantity: that.productInfo[index].quantity,
        detail: that.productInfo[index].detail
      })
        .then(function (response) {
          if (response.data.msg === '请求成功') {
            alert('修改成功')
            that.$router.go(-1)
          } else {
            alert('系统繁忙，稍后重试')
          }
        })
        .catch(function (error) {
          console.log(error)
        })
    }
  }
}
</script>

<style scoped>
  #productInfo {
    width: 100%;
    text-align: center;
    vertical-align: center;
  }
  .table_row {
  }
  .input_width {
    width: 120px;
  }
</style>
