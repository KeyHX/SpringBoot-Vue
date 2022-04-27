<template>
<!--  template只能有一个根节点，所以要添加一个div标签-->
  <div>
    <el-table
        :data="tableData"
        border
        style="width: 100%">
      <el-table-column
          fixed
          prop="emp_id"
          label="编号"
          width="150">
      </el-table-column>
      <el-table-column
          prop="emp_name"
          label="姓名"
          width="120">
      </el-table-column>
      <el-table-column
          prop="gender"
          label="性别"
          width="120">
      </el-table-column>
      <el-table-column
          prop="email"
          label="电子邮箱"
          width="200">
      </el-table-column>
      <el-table-column
          prop="d_id"
          label="部门"
          width="120">
      </el-table-column>
      <el-table-column
          label="操作"
          width="100">
        <template slot-scope="scope">
          <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
          <el-button @click="deleteEmployee(scope.row)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    <el-pagination
        background
        layout="prev, pager, next"
        page-size="6"
        :total= total
        @current-change="page">
    </el-pagination>
  </div>
</template>

<script>
export default {
  methods: {
    deleteEmployee(row) {
      const _this = this;
      axios.delete('http://localhost:8181/employee/deleteById/' + row.emp_id).then(function (resp) {
          _this.$alert(row.emp_name + "删除成功！", 'success', {
            confirmButtonText: '确定',
            callback: action => {
              //动态刷新
              window.location.reload();
            }
          })
      })
    },
    edit(row) {
      //点击修改跳转页面
      this.$router.push({
        path:'/update',
        query: {
          //添加参数
          id:row.emp_id
        }
      })
      //row.emp_id
    },
    page(currentpage){
      const _this = this
      axios.get('http://localhost:8181/employee/findAll/' + currentpage +'/6').then(function (resp) {
        _this.tableData = resp.data.content
        _this.total = resp.data.totalElements
      })
    }
  },
  created() {
    const _this = this
    axios.get('http://localhost:8181/employee/findAll/1/6').then(function (resp) {
      _this.tableData = resp.data.content
      _this.total = resp.data.totalElements
    })
  },
  data() {
    return {
      total:null,
      tableData: null
    }
  }
}
</script>