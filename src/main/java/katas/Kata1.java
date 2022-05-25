package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Movie;
import util.DataUtil;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//import static java.util.stream.Nodes.collect;

/*
    Goal: use map() to project an array of videos into an array of {id, title}-pairs
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", "5", "title", "Bad Boys")
*/
public class Kata1 {
    public static List<Map> execute() {
        List<Movie> movies = DataUtil.getMovies();

        return movies.stream()
                .map(movie -> Map.of("id", movie.getId(), "title", movie.getTitle()))
                .collect(Collectors.toList());
//        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "Bad Boys"));
    }
}
