<template>
  <div class="home">
    <img id="banner" alt="Photo by Felix Mooneeram on Unsplash" src="../assets/felix-mooneeram-evlkOfkQ5rE-unsplash.jpg">
    <!-- https://unsplash.com/photos/evlkOfkQ5rE -->
    <WelcomeMessage msg="Welcome to Cool Movie App"/>
  </div>
</template>

<script>
// @ is an alias to /src
import WelcomeMessage from '../components/WelcomeMessage.vue'

export default {
  name: 'HomeView',
  components: {
    WelcomeMessage
  }
}
</script>

<style>
  #banner {
    width: 400px;
    border-radius: 5px;
  }
</style>