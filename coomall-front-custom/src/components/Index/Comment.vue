<template>
    <div class="comments">
      <h2>累计评论({{comments.length}})</h2>
      <table>
        <tbody>
          <th>评论内容</th><th>下单信息</th><th>评论用户</th>
          <tr v-for="comment in comments" v-bind:key="comment.ID">
            <td class="tb-item text">
              <p v-text="comment.text"></p>
            </td>
            <td class="tb-item meta">
              <p>规格种类：{{comment.style}}</p>
              <p>购买日期：{{comment.time}}</p>
            </td>
            <td class="tb-item author">
              <p v-if="comment.isAnonymous">匿名买家</p>
              <p v-else v-text="comment.username"></p>
            </td>
          </tr>
        </tbody>
      </table>
    </div>
</template>

<script>
export default {
  name: 'Comment',
  props: ['comments']
}
</script>

<style scoped>
  .comments{
    width: 930px;
    margin: 50px auto;
    overflow: hidden;
    border: 2px solid black;
    padding-left: 5px;
  }
  .tb-item{
    margin: 5px 5px 10px 10px;
    border-top: 1px solid #c9c9c9;
  }
  .text{
    width: 650px;
    height: 100px;
    border-right: 1px dashed #c9c9c9;
  }
  .meta{
    width: 150px;
    height: 100px;
    border-right: 1px dashed #c9c9c9;
  }
  .author{
    width: 100px;
    height: 100px;
  }
</style>
