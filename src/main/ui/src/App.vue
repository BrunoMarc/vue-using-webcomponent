<template>
  <div id="app">
    <Detran />
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'

import Detran from './components/Detran.vue'


export default {
  name: 'App',
  components: {
    Detran
  }
}
</script>

<style>
  @import './assets/styles/global.css';
</style>