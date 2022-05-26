package katas;

import model.BoxArt;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.stream.Collectors;

/*
    Goal: Retrieve the url of the largest boxart using map() and reduce()
    DataSource: DataUtil.getMovieLists()
    Output: String
*/
public class Kata6 {
    public static String execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(movie -> movie.getBoxarts())
                .flatMap(List::stream)
                .reduce((boxart1, boxart2) -> boxart1.getWidth()*boxart1.getHeight() > boxart2.getWidth()*boxart2.getHeight() ? boxart1 : boxart2)
                .map(BoxArt::getUrl)
                .get();

//        return "someUrl";
    }
}
