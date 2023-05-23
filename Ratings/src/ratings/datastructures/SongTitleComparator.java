package ratings.datastructures;

import ratings.Song;

public class SongTitleComparator implements Comparator<Song>{
    @Override
    public boolean compare(Song a, Song b) {

            String first = a.getTitle();
            String second = b.getTitle();
            return first.compareToIgnoreCase(second) < second.compareToIgnoreCase(first);


    }



}