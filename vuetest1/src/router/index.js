import Vue from 'vue'
import VueRouter from 'vue-router'
import PageOne from "../views/PageOne"
import PageThree from "@/views/PageThree"
import PageFour from "@/views/PageFour"
import pageTwo from "@/views/PageTwo"
import index from "../views/index"
import Update from "../views/Update"

Vue.use(VueRouter)

const routes = [
  {
    show:true,
    path: "/",
    name:"员工管理",
    component:index,
    //什么都不写的时候就默认跳转pageone
    redirect:"/pageone",
    children:[
      {
        path: "/pageone",
        name:"查询员工",
        component: PageOne
      },
      {
        path: "/pagetwo",
        name:"添加员工",
        component: pageTwo
      }
    ]
  },
  {
    show:true,
    path: "/navigation",
    name:"打酱油",
    component: index,
    children: [
      {
        path: "/pagethree",
        name:"页面3",
        component: PageThree
      },
      {
        path: "/pagefour",
        name:"页面4",
        component: PageFour
      }
    ]
  },
  {
    path: '/wahaha',
    component: index,
    children: [
      {
        path:'/update',
        component: Update,
        show:false
      }
    ]

  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
