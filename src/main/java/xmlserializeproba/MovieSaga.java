package xmlserializeproba;

import javax.print.ServiceUI;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MovieSaga implements Serializable {
    List<Movie> movies;

    public MovieSaga(List<Movie> movies) {
        this.movies = movies;
    }

    public MovieSaga() {
        this.movies = new ArrayList<Movie>();
    }

    public void addMovieToSaga(Movie movie){
        this.movies.add(movie);
    }



    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public String toString() {
        return "MovieSaga{" +
                "movies=" + movies +
                '}';
    }
}
