package com.techelevator.imdbmovie.dao;
import com.techelevator.imdbmovie.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcMovieDao implements MovieDao{

    private JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Movie> retrieveAllMovies() {
        List<Movie> movies = new ArrayList<>();

        String sql = "SELECT id, title_id, title, year, image, genres, starlist FROM movie;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()) {
            Movie movie = movieObjectMapper(results);
            movies.add(movie);
        }
        return movies;
    }

    @Override
    public Movie retrieveMovieByTitleId(String titleId) {
        Movie movie = null;

        String sql = "SELECT id, title_id, title, year, image, genres, starlist FROM movie WHERE title_id = ?;";
        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, titleId);

        while(result.next()) {
            movie = movieObjectMapper(result);
        }
        return movie;
    }

    @Override
    public Movie addMovie(Movie movie) {
        String sql = "INSERT INTO movie (title_id, title, year, image, genres, starlist) " +
                "VALUES(?, ?, ?, ?, ?, ?) RETURNING id;";
        Long id = jdbcTemplate.queryForObject(sql, Long.class, movie.getTitleId(), movie.getTitle(), movie.getYear(),
                movie.getImage(), movie.getGenres(), movie.getStarlist());

        movie.setId(id);
        return movie;
    }

    @Override
    public boolean updateMovie(Movie movie) {
        String sql = "UPDATE movie SET title_id = ?, title = ?, year = ?, image = ?, genres = ?, starlist = ?" +
                "WHERE id = ?;";
        int rowUpdated = jdbcTemplate.update(sql, movie.getId(), movie.getTitleId(), movie.getTitle(), movie.getYear(), movie.getImage(),
                movie.getGenres(), movie.getStarlist());

        return rowUpdated == 1;
    }

    @Override
    public boolean deleteMovie(Long id) {
        String sql = "DELETE FROM movie WHERE id = ?;";
        int rowDeleted = jdbcTemplate.update(sql, id);
        return rowDeleted == 1;
    }

    private Movie movieObjectMapper(SqlRowSet rs) {

        Movie movie = new Movie();

        movie.setId(rs.getLong("id"));
        movie.setTitleId(rs.getString("title_id"));
        movie.setTitle(rs.getString("title"));
        movie.setYear(rs.getString("year"));
        movie.setImage(rs.getString("image"));
        movie.setGenres(rs.getString("genres"));
        movie.setStarlist(rs.getString("starlist"));

        return movie;
    }

}
