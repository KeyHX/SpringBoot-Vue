<template>
      <el-container style="height: 500px; border: 1px solid #eee">
        <el-aside width="200px" style="background-color: rgb(238, 241, 246)">
          <el-menu router>
            <!--
                index是下标，用来解决点击导航页的时候两个目录同时展开的问题
                $router.options.routes这个是index.js里面的内容
            -->
            <el-submenu v-for="(item,index) in $router.options.routes" :index="String(index)" v-if="item.show">
              <template slot="title"><i class="el-icon-message"></i>{{item.name}}</template>
              <!--
                  :index值决定跳转的路径
                  :class="$route.path==item.path?'is-active':''  用来给显示页面的添加选中的颜色
                  $route是用来获取当前浏览器中选中的地址
              -->
              <el-menu-item v-for="(item2,index2) in item.children" :index="item2.path" :class="$route.path==item.path?'is-active':''">{{item2.name}}</el-menu-item>
            </el-submenu>
          </el-menu>
        </el-aside>
        <el-main>
          <!--
              再搞一个容器，给其他页面显示
          -->
          <router-view></router-view>
        </el-main>
      </el-container>
</template>

<script>
export default {
  name: "index"
}
</script>

<style scoped>

</style>