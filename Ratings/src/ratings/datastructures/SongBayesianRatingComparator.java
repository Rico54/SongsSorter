package ratings.datastructures;

import ratings.Song;

public class SongBayesianRatingComparator implements Comparator<Song> {

    @Override
    public boolean compare(Song a, Song b){
        double first = a.bayesianAverageRating(2,3);
        double second = b.bayesianAverageRating(2,3);
        return first > second;
    }

}