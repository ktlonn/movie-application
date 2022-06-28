<template>
  <div id="app">
    <nav>
      <router-link to="/">Home</router-link> | 
      <router-link to="/movies">Top Movies</router-link>
    </nav>
    <router-view/>
  </div>
</template>

<script>
import movieService from './services/MovieService.js';
import databaseService from './services/DatabaseService.js'

export default {
  created() {
    databaseService.getKey().then((key) => {
      movieService.getAllMovies(key.data).then((movieData) => {
      const allMovies = movieData.data.items;
      this.$store.commit("SET_MOVIES", allMovies);
      });
    });
  }
};
</script>

<style>
@import url('https://fonts.googleapis.com/css2?family=Lato&display=swap');

#app {
  font-family: 'Lato', sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #151313;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #595457;
}

nav a.router-link-exact-active {
  color: #C49799;
}
</style>
