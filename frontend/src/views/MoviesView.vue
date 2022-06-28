<template>
  <div id="main">
    <movie-list />
  </div>
</template>

<script>
import MovieList from '../components/MovieList.vue'
export default {
    name: "movies-view",
    components: { 
      MovieList 
    },
};
</script>

<style>

</style>