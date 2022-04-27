<template>
  <!--
      :model="ruleForm"是用来绑定表单里面数据的
      :rules="rules"是用来绑定校验规则的
      ref="ruleForm":这个必须要加，上面两个的使用需要靠这个
  -->
  <el-form style="width: 30%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
    <!--    prop是校验的规则
            v-model="ruleForm.name"是绑定的数据
    -->
    <el-form-item label="编号">
      <el-input v-model="ruleForm.emp_id" readonly></el-input>
    </el-form-item>
    <el-form-item label="姓名" prop="name">
      <el-input v-model="ruleForm.emp_name"></el-input>
    </el-form-item>
    <el-form-item style="width: 80%" label="性别" prop="gender">
      <el-select v-model="ruleForm.gender" placeholder="请选择性别">
        <el-option label="男" value="M"></el-option>
        <el-option label="女" value="F"></el-option>
      </el-select>
    </el-form-item>
    <el-form-item label="电子邮箱" prop="email">
      <el-input v-model="ruleForm.email"></el-input>
    </el-form-item>
    <el-form-item label="部门" prop="d_id">
      <el-input v-model="ruleForm.d_id"></el-input>
    </el-form-item>
    <el-form-item>
      <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
      <el-button @click="resetForm('ruleForm')">重置</el-button>
    </el-form-item>
  </el-form>
</template>

<script>
export default {
  data() {
    return {
      //里面存储表单输入的数据
      ruleForm: {
        emp_id:'',
        emp_name: '',
        gender: '',
        email: '',
        d_id: ''
      },
      rules: {
        //required: true表示为必填项，message：提示信息,trigger触发事件：blur失去焦点事件
        emp_name: [
          { required: true, message: '请输入姓名', trigger: 'blur' },
          { min: 3, max: 5, message: '长度为3-5',trigger: 'blur'}
        ],
        gender: [
          { required: true, message: '请输入性别', trigger: 'change' }
        ],
        email: [
          { require:true , required: true, message: '请输入邮箱', trigger: 'blur' }
        ],
        d_id: [
          { required: true, message: '请输入部门', trigger: 'blur' },
        ],
      }
    };
  },
  methods: {
    //定义提交，forname是上面表单传过来的值
    submitForm(formName) {
      const _this = this;
      //判断当前所有表单项是否通过验证
      this.$refs[formName].validate((valid) => {
        if (valid) {
          //发送数据到后端进行保存
          axios.put('http://localhost:8181/employee/update',this.ruleForm).then(function (resp) {
            //添加成功
            if (resp.data == 'success') {
              _this.$alert(_this.ruleForm.emp_name + "修改成功！", 'success', {
                confirmButtonText: '确定',
                callback: action => {
                  //跳转到查询页面
                  _this.$router.push('/pageone');
                }
              });

            }
          })
        }else {
          return false;
        }
      });
    },
    resetForm(formName) {
      this.$refs[formName].resetFields();
    }
  },
  created() {
    //获取点击修改时候传过来的参数
    //alert(this.$route.query.id);
    const _this = this;
    axios.get('http://localhost:8181/employee/findById/' + this.$route.query.id).then(function (resp) {
      _this.ruleForm = resp.data;
    })
  }
}
</script>