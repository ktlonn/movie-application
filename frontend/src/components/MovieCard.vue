<template>
  <div class="card" v-on:click="viewMovieDetails(movie.id)">
    <img :src="movie.image" alt="movie image" />
    <h3>{{movie.title}} ({{movie.year}})</h3>
  </div>
</template>

<script>
export default {
    name: "movie-card",
    props: {
        movie: Object
    },
    methods: {
        viewMovieDetails(id) {
            this.$router.push(`/movie/${id}`);
        }
    }
}
</script>

<style>
    .card {
        width: 210px;
        height: 320px;
        padding: 10px;
        margin: 10px;
    }

    .card > img {
        width: 200px;
        height: auto;
        border-radius: 5px;
        
    }
</style>