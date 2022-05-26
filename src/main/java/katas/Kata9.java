package katas;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import model.Bookmark;
import model.Movie;
import model.MovieList;
import util.DataUtil;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
    Goal: Retrieve each video's id, title, middle interesting moment time, and smallest box art url
    DataSource: DataUtil.getMovies()
    Output: List of ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl")
*/
public class Kata9 {
    public static List<Map> execute() {
        List<MovieList> movieLists = DataUtil.getMovieLists();

        return movieLists.stream()
                .map(movieList -> movieList.getVideos())
                .flatMap(List::stream)
                .map(movie -> ImmutableMap.of("id", movie.getId(), "title", movie.getTitle(), "time",
                        movie.getInterestingMoments().stream().filter(momentsTime -> momentsTime.getType() == "Middle")
                                .map(time -> time.getTime())
                                .findFirst()
                                .get()
                        , "url", movie.getBoxarts().stream()
                                .reduce((boxart1, boxart2) -> boxart1.getHeight()*boxart1.getWidth() > boxart2.getHeight()*boxart2.getWidth() ? boxart1 : boxart2)
                                .get()
                                .getUrl()))
                .collect(Collectors.toList());

//        return ImmutableList.of(ImmutableMap.of("id", 5, "title", "some title", "time", new Date(), "url", "someUrl"));
    }
}
