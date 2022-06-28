package com.techelevator.imdbmovie.dao;
import com.techelevator.imdbmovie.model.Movie;
import java.util.List;

public interface MovieDao {

    List<Movie> retrieveAllMovies();

    Movie retrieveMovieByTitleId(String titleId);

    Movie addMovie(Movie movie);

    boolean updateMovie(Movie movie);

    boolean deleteMovie(Long id);

}
