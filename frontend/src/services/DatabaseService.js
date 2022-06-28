import axios from 'axios';

const http = axios.create({
    baseURL: "http://localhost:8080/movies"
});

export default {
    saveMovie(movie) {
        return http.post("/add", movie);
    },
    getKey() {
        return http.get("/key");
    }
}