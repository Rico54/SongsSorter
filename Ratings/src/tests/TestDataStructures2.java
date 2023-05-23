package tests;
import ratings.Playlist;
import ratings.Song;
import ratings.Rating;
import ratings.Reviewer;
import org.junit.Test;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import static org.junit.Assert.*;

public class TestDataStructures2 {
    private final double EPSILON = 0.001;

    public void compareDoubles(double d1, double d2) {
        assertTrue(d1 + " and " + d2 + " are not within " + EPSILON, Math.abs(d1 - d2) < EPSILON);
    }

    public void equalsList(LinkedListNode<Song> expected,LinkedListNode<Song> computed) {
        if (expected == null) {
            assertNull(computed);
        }else {
            assertNotNull(computed);
            assertEquals(expected.getValue().getTitle(), computed.getValue().getTitle());
            equalsList(expected.getNext(), computed.getNext());
        }
    }
    public void equalsList1(LinkedListNode<Song> expected,LinkedListNode<Song> computed) {
        if (expected == null) {
            assertNull(computed);
        }else {
            assertNotNull(computed);
            compareDoubles(expected.getValue().bayesianAverageRating(2,3), computed.getValue().bayesianAverageRating(2,3));
            equalsList(expected.getNext(), computed.getNext());
        }
    }

    @Test
    public void testPlaylistSongTitleComparator(){
        Song song1 = new Song("first", "Nirvana", "vabnZ9-ex7o");
        song1.addRating(new Rating("person", 4));
        song1.addRating(new Rating("person", 5));
        song1.bayesianAverageRating(2,3);
        Song song2 = new Song("sec", "bba", "sec");
        song2.addRating(new Rating("yessir", 5));
        song2.addRating(new Rating("nosir", 4));
        Song song3 = new Song("third", "three", "san");
        song3.addRating(new Rating("best", 3));
        song3.addRating(new Rating("ova", 1));
        Playlist first = new Playlist(new SongTitleComparator());
        LinkedListNode<Song> expected1 = null;
        LinkedListNode<Song> computed1 = first.getSongList();
        equalsList(expected1, computed1 );
        LinkedListNode<Song> expected = new LinkedListNode<>(song3, null);
        expected = new LinkedListNode<>(song2, expected);
        expected = new LinkedListNode<>(song1, expected);
        first.addSong(song2);
        first.addSong(song1);
        first.addSong(song3);
        LinkedListNode<Song> computed = first.getSongList();
        assertEquals(computed.size(), expected.size());
        equalsList(expected, computed);
        Song song4 = new Song("goddam", "thisis", "spartan");
        Song song5 = new Song("please", "work", "pretty");
        Song song6 = new Song("verify", "with", "me");
        Song song7 = new Song("this", "Song", "has");
        Song song8 = new Song("i", "dont", "like");
        Playlist next = new Playlist(new SongTitleComparator());
        next.addSong(song4);
        next.addSong(song5);
        next.addSong(song7);
        next.addSong(song6);
        next.addSong(song8);
        LinkedListNode<Song> newexpected = new LinkedListNode<>(song6, null);
        newexpected = new LinkedListNode<>(song7, newexpected);
        newexpected = new LinkedListNode<>(song5, newexpected);
        newexpected = new LinkedListNode<>(song8, newexpected);
        newexpected = new LinkedListNode<>(song4, newexpected);
        LinkedListNode<Song> computednew = next.getSongList();
        equalsList(newexpected, computednew);



    }
    @Test
    public void testPlaylistSongBayesianRatingComparator(){
        Song song1 = new Song("first", "Nirvana", "vabnZ9-ex7o");
        song1.addRating(new Rating("person", 4));
        song1.addRating(new Rating("person", 3));
        Song song2 = new Song("sec", "bba", "sec");
        song2.addRating(new Rating("yessir", 5));
        song2.addRating(new Rating("nosir", 5));
        Song song3 = new Song("third", "three", "san");
        song3.addRating(new Rating("best", 4));
        song3.addRating(new Rating("ova", 5));
        Playlist first = new Playlist(new SongBayesianRatingComparator());
        LinkedListNode<Song> expected1 = null;
        LinkedListNode<Song> computed1 = first.getSongList();
        equalsList1(expected1, computed1);
        first.addSong(song1);
        first.addSong(song2);
        first.addSong(song3);
        LinkedListNode<Song> expected = new LinkedListNode<>(song1, null);
        expected = new LinkedListNode<>(song3, expected);
        expected = new LinkedListNode<>(song2, expected);
        LinkedListNode<Song> computed = first.getSongList();
        equalsList1(expected,computed);
        Song song4 = new Song("goddam", "thisis", "spartan");
        song4.addRating(new Rating("person", 4));
        song4.addRating(new Rating("person", 3));
        Song song5 = new Song("please", "work", "pretty");
        song5.addRating(new Rating("yessir", 5));
        song5.addRating(new Rating("nosir", 5));
        Song song6 = new Song("verify", "with", "me");
        song6.addRating(new Rating("best", 4));
        song6.addRating(new Rating("ova", 5));
        Song song7 = new Song("this", "Song", "has");
        song7.addRating(new Rating("dam", 1));
        Song song8 = new Song("i", "dont", "like");
        Playlist next = new Playlist(new SongBayesianRatingComparator());
        next.addSong(song4);
        next.addSong(song6);
        next.addSong(song5);
        next.addSong(song7);
        next.addSong(song8);
        LinkedListNode<Song> newexpected = new LinkedListNode<>(song7, null);
        newexpected = new LinkedListNode<>(song8, newexpected);
        newexpected = new LinkedListNode<>(song4, newexpected);
        newexpected = new LinkedListNode<>(song6, newexpected);
        newexpected = new LinkedListNode<>(song5, newexpected);
        LinkedListNode<Song> computednew = next.getSongList();
        equalsList1(newexpected,computednew);








    }




}



