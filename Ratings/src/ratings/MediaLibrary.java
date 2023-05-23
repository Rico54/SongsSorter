package ratings;

import ratings.datastructures.RatableBayesianRatingComparator;
import ratings.datastructures.SongBayesianRatingComparator;

import javax.print.attribute.standard.Media;
import java.util.ArrayList;
import java.util.Comparator;

public class MediaLibrary {
    private ArrayList<Song> allSong;
    private ArrayList<Movie> allMovie;
    public MediaLibrary(){

    }
    public void populateLibrary(String songs, String movie, String mwr){
        this.allSong = FileReader.readSongs(songs);
        ArrayList<Movie> tac = FileReader.readMovies(movie);

        this.allMovie = FileReader.readMovieRatings(tac, mwr);
    }

    public boolean compare(Ratable a, Ratable b) {
        double first = a.bayesianAverageRating(2,3);
        double second = b.bayesianAverageRating(2,3);
        return first > second;
    }



    public ArrayList<Ratable> topKRatables(int k) {
        ArrayList<Ratable> topk = new ArrayList<>();
        ArrayList<Ratable> tops = new ArrayList<>();
        for (int i = 0; i < this.allSong.size(); i++) {
            Ratable first = this.allSong.get(i);
            topk.add(first);
        }
        for (int x = 0; x < this.allMovie.size(); x++) {
            Ratable second = this.allMovie.get(x);
            topk.add(second);
        }
        ArrayList<Ratable> output = new ArrayList<>();
        for (Ratable valueToInsert : topk) {
            int location = 0;
            for (Ratable valueToCompare : output) {
                if (compare(valueToCompare, valueToInsert)) {
                    location++;
                }
            }
                output.add(location, valueToInsert);
        }
        if (!(output.isEmpty())) {
            for (int t = 0; t < k; t++) {
                tops.add(output.get(t));
            }
        }
        return tops;
    }

    public static void main(String[] args) {
        MediaLibrary media = new MediaLibrary();
        media.populateLibrary("data/ratings.csv", "data/movies.csv", "data/movie_ratings.csv");
        System.out.println(media.topKRatables(3));

    }
}
