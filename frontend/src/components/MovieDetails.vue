<template>
  <div id="main">
    <h1>Movie Details</h1>
    <div class="content">
        <img :src="movie.image" alt="movie image" />
        <div id="movie-details" :key="movieId">
            <h2>{{movie.title}}</h2>
            <h5>{{movie.year}}</h5>
            <h5>{{movie.genres}}</h5>
            <div id="stars" v-for="star in movie.starList" :key="star.id">
                <p>{{star.name}}</p>
            </div>
        </div>
    </div>
    <button v-on:click="saveMovie">Add to favorites</button>
  </div>
</template>

<script>
import MovieService from "../services/MovieService";
import DatabaseService from "../services/DatabaseService"

export default {
    name: "movie-details",
    data() {
        return {
            movie: Object,
            movieId: 0
        };
    },
    created() {
        this.movieId = this.$route.params.titleId;
        DatabaseService.getKey().then ((key) => {
            MovieService.getMovieDetails(key.data, this.movieId).then((response) => {
            this.movie = response.data;
            console.log(this.movie);
            });
        });
        
    },
    methods: {
        saveMovie() {
            const movieToSave = {
                titleId: this.movie.id,
                title: this.movie.title,
                year: this.movie.year,
                image: this.movie.image,
                genres: this.movie.genres,
                starlist: this.movie.stars
            }
            DatabaseService.saveMovie(movieToSave)
                .then((response) => {
                    if (response.status === 201) {
                        alert(this.movie.title + " has been added to favorites!");
                        this.$router.push("/movies");
                    }
                })
                .catch((error) => {
                    if (error.response.status === 409) {
                        alert(error.response.data.message);
                    } else {
                        alert("ERROR!" + error.response.status)
                    }
                    this.$router.push("/movies");
                });
        }
    }
}
</script>

<style>
    .content {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        gap: 40px;
        margin: 50px;
    }

    img {
        height: 300px;
        width: auto;
        border-radius: 5px;
    }

    #movie-details {
        text-align: left;
    }

    p {
        font-size: 14px;
    }

</style>