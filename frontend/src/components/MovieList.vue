<template>
  <div id="main">
    <h1>Top 250 Movies</h1>
    <div class="top-250-list">
        <movie-card v-for="movie in allMovies" 
          :movie="movie"
          :key="movie.id">
        </movie-card>
    </div>
    
  </div>
</template>

<script>
import MovieCard from '../components/MovieCard.vue'
// import movieService from '../services/MovieService.js';

export default {
  name: "list-movies",
  components: {
    MovieCard
  },
  data() {
    return {
      allMovies: this.$store.state.movies
    }
  },
  // created() {
  //   movieService.getAllMovies().then((response) => {
  //     this.allMovies = response.data.items;
  //   });
  // }

}
</script>

<style>
  .top-250-list {
    display: flex;
    flex-wrap: wrap;
    justify-content: space-evenly;
    gap: 20px;
  }
</style>