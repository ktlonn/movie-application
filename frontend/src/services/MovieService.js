import axios from 'axios';

const http = axios.create({
    baseURL: "https://imdb-api.com/en/API/"
});

export default {
    getAllMovies(key) {
        return http.get(`Top250Movies/${key}`);
    },
    getMovieDetails(key, id) {
        return http.get(`title/${key}/${id}`)
    }
}