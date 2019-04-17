package xmlserializeproba;

import java.io.Serializable;
import java.util.List;

public class Movie {
    String title;
    int year;
    int length;
    double imdb_rating;
    List<Person> director;
    List<Person> cast;
    Genre genre;
    double rotten_tomatoes_rating;

    public Movie() {
    }

    public Movie(String title,
                 int year,
                 int length,
                 double imdb_rating,
                 List<Person> director,
                 List<Person> cast,
                 Genre genre,
                 double rotten_tomatoes_rating) {
        this.title = title;
        this.year = year;
        this.length = length;
        this.imdb_rating = imdb_rating;
        this.director = director;
        this.cast = cast;
        this.genre = genre;
        this.rotten_tomatoes_rating = rotten_tomatoes_rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public double getImdb_rating() {
        return imdb_rating;
    }

    public void setImdb_rating(double imdb_rating) {
        this.imdb_rating = imdb_rating;
    }

    public List<Person> getDirector() {
        return director;
    }

    public void setDirector(List<Person> director) {
        this.director = director;
    }

    public List<Person> getCast() {
        return cast;
    }

    public void setCast(List<Person> cast) {
        this.cast = cast;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public double getRotten_tomatoes_rating() {
        return rotten_tomatoes_rating;
    }

    public void setRotten_tomatoes_rating(double rotten_tomatoes_rating) {
        this.rotten_tomatoes_rating = rotten_tomatoes_rating;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", year=" + year +
                ", length=" + length +
                ", imdb_rating=" + imdb_rating +
                ", director=" + director +
                ", cast=" + cast +
                ", genre=" + genre +
                ", rotten_tomatoes_rating=" + rotten_tomatoes_rating +
                '}';
    }
}


