package com.techelevator.imdbmovie.controller;
import com.techelevator.imdbmovie.dao.MovieDao;
import com.techelevator.imdbmovie.exception.MovieAlreadyExistsException;
import com.techelevator.imdbmovie.exception.MovieNotFoundException;
import com.techelevator.imdbmovie.model.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
@CrossOrigin
public class MovieController {

    private MovieDao movieDao;

    @Value("${imdb.api.key}")
    private String apiUrl;

    public MovieController(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @GetMapping(path="/key")
    public String getKey() {
        return apiUrl;
    }

    @GetMapping(path="/")
    public List<Movie> getMovies() {
        return movieDao.retrieveAllMovies();
    }

    @GetMapping(path="/{titleId}")
    public Movie getMovieByTitleId(@PathVariable String titleId) throws MovieNotFoundException {
        return movieDao.retrieveMovieByTitleId(titleId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(path="/add")
    public Movie addMovie(@RequestBody Movie movieToSave) throws MovieAlreadyExistsException {
        Movie movie = movieDao.retrieveMovieByTitleId(movieToSave.getTitleId());
        if (movie == null) {
            return movieDao.addMovie(movieToSave);
        } else {
            throw new MovieAlreadyExistsException();
        }
    }

    @PutMapping(path="/update")
    public boolean updateMovie(@RequestBody Movie movieToUpdate) throws MovieNotFoundException {
        return movieDao.updateMovie(movieToUpdate);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(path="/delete/{id}")
    public boolean deleteMovie(@PathVariable Long id) throws MovieNotFoundException {
        return movieDao.deleteMovie(id);
    }

}
