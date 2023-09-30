//文件核心作用：导入App.vue文件，基于App.vue文件结构渲染index.xml

//1导入Vue核心包
import Vue from 'vue'

//2.导入App.vue根组件
import App from './App.vue'

//提示：当前处于什么环境（生产环境/开发环境）
Vue.config.productionTip = false

//3.Vue实例化，提供render方法>基于App.vue创建结构渲染index.xml
new Vue({
  //el: '#app' 相当于 .$mount('#app')
  render: h => h(App),
}).$mount('#app')
