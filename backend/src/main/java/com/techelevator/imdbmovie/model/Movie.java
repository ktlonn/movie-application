package com.techelevator.imdbmovie.model;

public class Movie {

    private Long id;
    private String titleId;
    private String title;
    private String year;
    private String image;
    private String genres;
    private String starlist;

   public Movie() {}

    public Movie(Long id, String titleId, String title, String year, String image, String genres, String starlist) {
        this.id = id;
        this.titleId = titleId;
        this.title = title;
        this.year = year;
        this.image = image;
        this.genres = genres;
        this.starlist = starlist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getGenres() {
        return genres;
    }

    public void setGenres(String genres) {
        this.genres = genres;
    }

    public String getStarlist() {
        return starlist;
    }

    public void setStarlist(String starlist) {
        this.starlist = starlist;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", titleId='" + titleId + '\'' +
                ", title='" + title + '\'' +
                ", year='" + year + '\'' +
                ", image='" + image + '\'' +
                ", genres='" + genres + '\'' +
                ", starlist='" + starlist + '\'' +
                '}';
    }

}
