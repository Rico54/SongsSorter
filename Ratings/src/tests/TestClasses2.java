package tests;
import ratings.Movie;
import ratings.Song;
import ratings.Rating;
import ratings.Reviewer;
import org.junit.Test;
import ratings.datastructures.SongBayesianRatingComparator;
import ratings.datastructures.SongTitleComparator;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
public class TestClasses2 {
    private final double EPSILON = 0.001;

    public void compareDoubles(double d1, double d2) {
        assertTrue(d1 + " and " + d2 + " are not within " + EPSILON, Math.abs(d1 - d2) < EPSILON);

    }

    @Test
    public void testBayesianAverageRating(){
        Song song = new Song("Come As You Are", "Nirvana", "vabnZ9-ex7o");
        double expected = 0.0;
        double computed = song.bayesianAverageRating(0,3);
        compareDoubles(expected, computed);
        expected = 3.0;
        computed = song.bayesianAverageRating(2,3);
        compareDoubles(expected, computed);
        song.addRating(new Rating("second", 5));
        song.addRating(new Rating("person", 4));
        expected = 3.75;
        computed = song.bayesianAverageRating(2,3);
        compareDoubles(expected , computed);
        expected = 4.1666;
        computed = song.bayesianAverageRating(4,4);
        compareDoubles(expected, computed);
        expected = 4.5;
        computed = song.bayesianAverageRating(0,2);
        compareDoubles(expected, computed);
        song.addRating(new Rating("nice", 3));
        expected = 3.25;
        computed = song.bayesianAverageRating(1,1);
        compareDoubles(expected, computed);


    }
    @Test
    public void testMovie() {
        ArrayList<String> tests = new ArrayList<>(Arrays.asList("Chris Pratt", "Zoe Saldana", "Dave Bautista"));
        ArrayList<String> acttests = new ArrayList<>(Arrays.asList("nice name", "good name", "David david", "shazam two"));
        ArrayList<String> sectests = new ArrayList<>(Arrays.asList("chris pratt", "zoe saldana", "dave bautista"));
        ArrayList<String> thirdtests = new ArrayList<>(Arrays.asList("CHRIS pratt", "ZoE SalDANA", "dAVE bautistA"));
        Movie movie = new Movie("movie", tests);
        double expected = 0.0;
        double computed = movie.bayesianAverageRating(0,3);
        compareDoubles(expected, computed);
        expected = 3.0;
        computed = movie.bayesianAverageRating(2,3);
        compareDoubles(expected, computed);
        movie.addRating(new Rating("person", 4));
        movie.addRating(new Rating("second", 5));
        expected = 3.75;
        computed = movie.bayesianAverageRating(2, 3);
        compareDoubles(expected, computed);
        expected = 4.1666;
        computed = movie.bayesianAverageRating(4,4);
        compareDoubles(expected, computed);
        expected = 4.5;
        computed = movie.bayesianAverageRating(0,2);
        compareDoubles(expected, computed);
        movie.addRating(new Rating("nice", 3));
        expected = 3.25;
        computed = movie.bayesianAverageRating(1,1);
        compareDoubles(expected, computed);
        String name = "movie";
        assertTrue(name.equals(movie.getTitle()));
        for (int i = 0; i < movie.getCast().size(); i++) {
            assertTrue((tests.get(i).equalsIgnoreCase(movie.getCast().get(i))));
        }
        for (int i = 0; i < movie.getCast().size(); i++) {
            assertTrue((sectests.get(i).equalsIgnoreCase(movie.getCast().get(i))));
        }
        for (int i = 0; i < movie.getCast().size(); i++) {
            assertTrue((thirdtests.get(i).equalsIgnoreCase(movie.getCast().get(i))));
        }
        tests = new ArrayList<>(Arrays.asList("NICE NAME", "good naMe", "DavId david", "shazam tWo"));
        Movie movie2 = new Movie("movie2", tests);
        name = "movie2";
        assertTrue(name.equals(movie2.getTitle()));
        for (int i = 0; i < movie2.getCast().size(); i++) {
            assertTrue((acttests.get(i).equalsIgnoreCase(movie2.getCast().get(i))));
        }
        acttests = new ArrayList<>(Arrays.asList("lONg", "ASS", "movIE", "cast", "PlEase", "pass", "thank", "you", "SIR", "Yes", "pLz"));
        tests = new ArrayList<>(Arrays.asList("long", "ASS", "movie", "cast", "please", "PASS", "THANk", "you", "sir", "yes", "plz" ));
        Movie yessir = new Movie("long", tests);
        name = "long";
        assertTrue(name.equals(yessir.getTitle()));
        for (int i = 0; i < yessir.getCast().size(); i++) {
            assertTrue((acttests.get(i).equalsIgnoreCase(yessir.getCast().get(i))));
        }
        acttests = new ArrayList<>(Arrays.asList("sOlo"));
        tests = new ArrayList<>(Arrays.asList("soLo"));
        Movie alone = new Movie("one", tests);
        name = "one";
        assertTrue(name.equals(alone.getTitle()));
        for (int i = 0; i < alone.getCast().size(); i++) {
            assertTrue((acttests.get(i).equalsIgnoreCase(alone.getCast().get(i))));
        }
        acttests = new ArrayList<>(Arrays.asList("VTwo", "ssAme ba"));
        tests = new ArrayList<>(Arrays.asList("vtWO", "ssame ba"));
        Movie empty = new Movie("empty", tests);
        name = "empty";
        assertTrue(name.equals(empty.getTitle()));
        for (int i = 0; i < empty.getCast().size(); i++) {
            assertTrue((acttests.get(i).equalsIgnoreCase(empty.getCast().get(i))));
        }
        acttests = new ArrayList<>(Arrays.asList("", "bigName dess", "SHot", "FOUR"));
        tests = new ArrayList<>(Arrays.asList("" ,"biGname deSS", "shot", "fOur"));
        Movie bigbig = new Movie("big", tests);
        name = "big";
        assertTrue(name.equals(bigbig.getTitle()));
        for (int i = 0; i < bigbig.getCast().size(); i++) {
            assertTrue((acttests.get(i).equalsIgnoreCase(bigbig.getCast().get(i))));
        }
        acttests = new ArrayList<>(Arrays.asList("bruh sir", "i hope this works", "idk man", "pain pain"));

        tests = new ArrayList<>(Arrays.asList("BRUH SIR", "I HOPE THIS WORKS", "IDK MAN", "PAIN PAIN"));
        Movie sir = new Movie("ugh", tests);
        name = "ugh";
        assertTrue(name.equals(sir.getTitle()));
        for (int i = 0; i < sir.getCast().size(); i++) {
            assertTrue((acttests.get(i).equalsIgnoreCase(sir.getCast().get(i))));
        }






    }
    @Test
    public void testSongTitleComparator(){
        Song down = new Song("goes", "jay", "aaa1231dfs");
        Song sec = new Song("SeCet", "metwo", "sheesh");
        Song same = new Song("GOES", "Jayz","sussy" );
        Song noname = new Song("", "dang", "son" );
        Song a = new Song("A", "ahh", "oooh");
        Song aa = new Song("aAaaAaa", "mult", "shoot");
        Song last = new Song("Xox", "lastly", "theend");
        SongTitleComparator test = new SongTitleComparator();
        boolean expected = true;
        boolean computed = test.compare(down, sec);
        assertEquals(expected, computed);
        expected = false;
        computed = test.compare(down, same);
        assertEquals(expected, computed);
        expected = true;
        computed = test.compare(noname, a);
        assertEquals(expected, computed);
        expected = false;
        computed = test.compare(aa, a);
        assertEquals(expected, computed);
        expected = true;
        computed = test.compare(a, last);
        assertEquals(expected, computed);




    }

    @Test
    public void testSongBayesianRatingComparator(){
        Song first = new Song("first", "me", "1231dfs");
        first.addRating(new Rating("person", 4));
        first.addRating(new Rating("perdson", 5));

        Song sec = new Song("sec", "metwo", "sheesh");
        sec.addRating(new Rating("person", 2));
        first.addRating(new Rating("zen", 3));

        Song same = new Song("same", "rating", "dude");
        same.addRating(new Rating("same", 4));
        same.addRating(new Rating("saave", 5));


        Song zero = new Song("zero", "tat", "nosir");

        Song norate = new Song("new", "in the", "game");

        Song tired = new Song("ugh","yuck", "nahnah");
        tired.addRating(new Rating("nah mad", 2));

        Song another = new Song("aaa", "dying", "pain");



        SongBayesianRatingComparator tests = new SongBayesianRatingComparator();
        boolean expected = true;
        boolean computed = tests.compare(first, sec);
        assertEquals(expected, computed);
        expected = false;
        computed = tests.compare(first, same);
        assertEquals(expected, computed);
        expected = false;
        computed = tests.compare(zero,first);
        assertEquals(expected, computed);
        expected = false;
        computed = tests.compare(zero,norate);
        assertEquals(expected, computed);
        expected = true;
        computed = tests.compare(another, tired);
        assertEquals(expected, computed);

    }



}
