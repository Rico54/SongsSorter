package tests;
import org.junit.Test;
import ratings.*;
import ratings.datastructures.LinkedListNode;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;

public class TestClasses3 {
    private void songEquals(Song expected, Song computed){
        if (expected == null) {
            assertNull(computed);
        }else {
            assertNotNull(computed);
            assertEquals(expected.getSongID(), computed.getSongID());
            assertEquals(expected.getTitle(), computed.getTitle());
            assertEquals(expected.getArtist(),computed.getArtist());
            assertEquals(expected.getRatings().getValue().getReviewerID(), computed.getRatings().getValue().getReviewerID());
        }
    }

    private void sameHelper(LinkedListNode<Rating>expected, LinkedListNode<Rating>computed){
        if (expected == null) {
            assertNull(computed);
        }else {
            assertNotNull(computed);
            assertEquals(expected.getValue().getReviewerID(), computed.getValue().getReviewerID());
            assertEquals(expected.getValue().getRating(), computed.getValue().getRating());
            sameHelper(expected.getNext(), computed.getNext());
        }
    }
    private void sameValues(ArrayList<Song> expected, ArrayList<Song> computed){
        assertEquals(expected.size(), computed.size());
        ArrayList<String> test = new ArrayList<>();
        for(int i =0;i < expected.size(); i++){
            test.add(computed.get(i).getSongID());
        }
        for(int x = 0; x< expected.size(); x++){
            assertTrue(test.contains(expected.get(x).getSongID()));
            int w = test.indexOf(expected.get(x).getSongID());
            songEquals(expected.get(x),computed.get(w));
            sameHelper(expected.get(x).getRatings(),computed.get(w).getRatings());
        }
    }
    private void testMovie(Movie expected, Movie computed){
        if (expected == null) {
            assertNull(computed);
        }else {
            assertEquals(expected.getTitle(), computed.getTitle());
            assertEquals(expected.getCast().size(), computed.getCast().size());
            for(int i =0; i<expected.getCast().size();i++){
                assertEquals(expected.getCast().get(i), computed.getCast().get(i));
                sameHelper(expected.getRatings(),computed.getRatings());
            }

        }
    }
    private void testSame(ArrayList<Movie> expected, ArrayList<Movie> computed) {
        assertEquals(expected.size(), computed.size());
        ArrayList<String> title = new ArrayList<>();
        for (int i = 0; i < expected.size(); i++) {
            title.add(computed.get(i).getTitle());
        }
        for (int x = 0; x < expected.size(); x++) {
            assertTrue(title.contains(expected.get(x).getTitle()));
            int w = title.indexOf(expected.get(x).getTitle());
            testMovie(expected.get(x), computed.get(w));

        }
    }
    public void testTopK(ArrayList<Ratable> expected, ArrayList<Ratable>computed){
        if (expected == null && expected.get(0) == null) {
            assertNull(computed);
        }else {
            assertNotNull(computed);
            assertEquals(expected.size(),computed.size());
                for (int i = 0; i < expected.size(); i++) {
                    assertEquals(expected.get(i).getTitle(), computed.get(i).getTitle());
                }

        }

    }

    @Test
    public void testEmptySongList(){
        String filename = "data/nonexistance.csv";
        ArrayList<Song> expected = new ArrayList<>();
        ArrayList<Song> computed =  FileReader.readSongs(filename);
        assertEquals(expected.size(),computed.size());

    }
    @Test
    public void testSingleSongList(){
        String filename = "data/testsinglesong.csv";
        //0EtcGmf2mVZbHWq2ZGP3t7,Jessie Ware,Spotlight,137,5
        Song test = new Song("Spotlight","Jessie Ware", "0EtcGmf2mVZbHWq2ZGP3t7");
        Rating rating = new Rating("137", 5);
        test.addRating(rating);
        ArrayList<Song> expected = new ArrayList<>();
        expected.add(test);
        ArrayList<Song> computed =  FileReader.readSongs(filename);
        assertEquals(expected.size(),computed.size());
        if(expected.get(0).getSongID() == computed.get(0).getSongID()){
            songEquals(expected.get(0),computed.get(0));
            sameHelper(expected.get(0).getRatings(), computed.get(0).getRatings());
        }else {
            assertEquals(expected.get(0).getSongID(), computed.get(0).getSongID());
        }

    }

    @Test
    public void testMulitpleSongs(){
        String filename = "data/testmultiplesong.csv";
        Song test = new Song("Spotlight","Jessie Ware", "0EtcGmf2mVZbHWq2ZGP3t7");
        Rating rating = new Rating("137", 5);
        test.addRating(rating);
        ArrayList<Song> expected = new ArrayList<>();
        ArrayList<Song> computed =  FileReader.readSongs(filename);
        expected.add(test);
        Song test1 = new Song("Rumble","Skrillex","1GfBLbAhZUWdseuDqhocmn");
        expected.add(test1);
        Rating rating1 = new Rating("321",4);
        Rating rating2 = new Rating("47",5);
        Rating rating3 = new Rating("165",5);
        Rating rating4 = new Rating("616",5);
        Rating rating5 = new Rating("350",3);
        Rating rating6 = new Rating("331", 4);
        Rating rating7 = new Rating("92",5);
        Rating rating8 = new Rating("537",5);
        Rating rating9 = new Rating("359",4);
        test1.addRating(rating1);
        test1.addRating(rating2);
        test1.addRating(rating3);
        test1.addRating(rating4);
        test1.addRating(rating5);
        test1.addRating(rating6);
        test1.addRating(rating7);
        test1.addRating(rating8);
        test1.addRating(rating9);
        Song test2 = new Song("Staring at the sun","Post Malone (ft. SZA)","5KE9b4x7Zj2A8XtbkqhqTe");
        expected.add(test2);
        Rating rating10 = new Rating("269",5);
        test2.addRating(rating10);
        Song test3 = new Song("Welcome to the Internet","Bo Burnham","25AvaE23MXl06YRtQcQoJS");
        expected.add(test3);
        Rating rating11 = new Rating("428",5);
        Rating rating12 = new Rating("23",1);
        test3.addRating(rating11);
        test3.addRating(rating12);
        Song test4 = new Song("Hope","X","2ZRo7axmMPeSVUvDbGkJah");
        expected.add(test4);
        Rating rating13 = new Rating("327", 5);
        test4.addRating(rating13);
        Song test5 = new Song("Forever","Lil Baby ft Fridayy","1T4k0sw0HldDg004Kw4Oct");
        expected.add(test5);
        Rating rating14 = new Rating("614", 4);
        test5.addRating(rating14);
        sameValues(expected, computed);
    }
    @Test
    public  void testEmptyMovieRating(){
        String filename = "data/nonexistance.csv";
        ArrayList<Movie> expected = new ArrayList<>();
        ArrayList<Movie> computed =  FileReader.readMovieRatings(FileReader.readMovies("data/movies.csv"),filename);
        assertEquals(expected.size(),computed.size());


    }
    @Test
    public  void testSingleMovieRating(){
        String filename = "data/testonemovierating.csv";
        ArrayList<Movie> expected = new ArrayList<>();
        ArrayList<Movie> computed =  FileReader.readMovieRatings(FileReader.readMovies("data/testonemovies.csv"),filename);
        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Sylvester Stallone","Talia Shire","Burt Young","Carl Weathers","Burgess Meredith","Tony Burton","Mr. T","Hulk Hogan"));
        Movie first = new Movie("Rocky III", cast);
        first.addRating(new Rating("1",2));
        //Rocky III,Sylvester Stallone,Talia Shire,Burt Young,Carl Weathers,Burgess Meredith,Tony Burton,Mr. T,Hulk Hogan
        expected.add(first);
        assertEquals(expected.get(0).getTitle(),computed.get(0).getTitle());
        testSame(expected,computed);



        //        String filename = "data/testsinglesong.csv";
        //        ArrayList<Movie> expected = new ArrayList<>();
        //        ArrayList<Movie> computed =  FileReader.readMovies(filename);
        //        ArrayList<String> cast = new ArrayList<>(Arrays.asList());
        //        Movie first = new Movie("Rocky III", cast);


    }

    @Test
    public void testMovieRating(){
        String filename = "data/moviemultrating.csv";
        ArrayList<Movie> expected = new ArrayList<>();
        ArrayList<Movie> computed =  FileReader.readMovieRatings(FileReader.readMovies("data/moviemult.csv"),filename);
        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Sylvester Stallone","Talia Shire","Burt Young","Carl Weathers","Burgess Meredith","Tony Burton","Mr. T","Hulk Hogan"));
        Movie first = new Movie("Rocky III", cast);
        first.addRating(new Rating("1",2));
        first.addRating(new Rating("3",5));
        first.addRating(new Rating("4",3));
        expected.add(first);
        ArrayList<String> cast1 = new ArrayList<>(Arrays.asList("Bruno Ganz","Peter Falk","Chick Ortega"));
        Movie second = new Movie("Wings of Desire",cast1);
        second.addRating(new Rating("5",2));
        second.addRating(new Rating("2",4));
        second.addRating(new Rating("3", 5));
        expected.add(second);
        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("George Clooney","Brad Pitt","Matt Damon","Andy Garcia","Julia Roberts","Casey Affleck","Scott Caan","Carl Reiner","Bernie Mac","Elliott Gould","Eddie Jemison","Henry Silva","Kerry Rossall","Tim Perez","Rusty Meyers","Don Cheadle","Shane West"));
        Movie third = new Movie("Ocean's Eleven", cast2);
        third.addRating(new Rating("11",3));
        third.addRating(new Rating("1",5));
        third.addRating(new Rating("2",5));
        expected.add(third);
        testSame(expected,computed);
    }

    @Test
    public void testEmptyTopK(){
        ArrayList<Ratable> expected = new ArrayList<>();
        MediaLibrary first = new MediaLibrary();
        first.populateLibrary("data/fsf.csv", "data/hh.csv", "data/ga.csv");
        ArrayList<Ratable> computed =first.topKRatables(3);
        assertEquals(expected,computed);

    }

    @Test
    public void testOneTopK(){
        ArrayList<Ratable> expected = new ArrayList<>();
        MediaLibrary first = new MediaLibrary();
        first.populateLibrary("data/testsinglesong.csv", "data/hh.csv", "data/ga.csv");
        ArrayList<Ratable> computed =first.topKRatables(1);
        Song test = new Song("Spotlight","Jessie Ware", "0EtcGmf2mVZbHWq2ZGP3t7");
        Ratable te = test;
        Rating rating = new Rating("137", 5);
        test.addRating(rating);
        expected.add(te);
        testTopK(expected,computed);

    }
    @Test
    public void testMultTopK(){
        ArrayList<Ratable> expected = new ArrayList<>();
        MediaLibrary media = new MediaLibrary();
        media.populateLibrary("data/songfortop.csv", "data/moviemult.csv", "data/moviemultrating.csv");
        ArrayList<String> cast = new ArrayList<>(Arrays.asList("Sylvester Stallone","Talia Shire","Burt Young","Carl Weathers","Burgess Meredith","Tony Burton","Mr. T","Hulk Hogan"));
        Movie first = new Movie("Rocky III", cast);
        first.addRating(new Rating("1",2));
        first.addRating(new Rating("3",5));
        first.addRating(new Rating("4",3));
        //3.2
        Ratable fir = first;

        ArrayList<String> cast1 = new ArrayList<>(Arrays.asList("Bruno Ganz","Peter Falk","Chick Ortega"));
        Movie second = new Movie("Wings of Desire",cast1);
        second.addRating(new Rating("5",2));
        second.addRating(new Rating("2",4));
        second.addRating(new Rating("3", 5));
        //3.4
        Ratable sec = second;

        ArrayList<String> cast2 = new ArrayList<>(Arrays.asList("George Clooney","Brad Pitt","Matt Damon","Andy Garcia","Julia Roberts","Casey Affleck","Scott Caan","Carl Reiner","Bernie Mac","Elliott Gould","Eddie Jemison","Henry Silva","Kerry Rossall","Tim Perez","Rusty Meyers","Don Cheadle","Shane West"));
        Movie third = new Movie("Ocean's Eleven", cast2);
        third.addRating(new Rating("11",3));
        third.addRating(new Rating("1",5));
        third.addRating(new Rating("2",5));
        //3.8
        Ratable thir = third;

        Song test = new Song("Spotlight","Jessie Ware", "0EtcGmf2mVZbHWq2ZGP3t7");
        Rating rating = new Rating("137", 5);
        Rating ratin = new Rating("138", 3);
        test.addRating(rating);
        test.addRating(ratin);
        //3.5
        Ratable ts = test;

        Song test1 = new Song("Rumble","Skrillex","1GfBLbAhZUWdseuDqhocmn");
        Rating rating1 = new Rating("321",4);
        Rating rating2 = new Rating("47",5);
        Rating rating3 = new Rating("165",5);
        Rating rating4 = new Rating("616",5);
        test1.addRating(rating1);
        test1.addRating(rating2);
        test1.addRating(rating3);
        test1.addRating(rating4);
        //4.1667
        Ratable ts1 = test1;

        Song test5 = new Song("Forever","Lil Baby ft Fridayy","1T4k0sw0HldDg004Kw4Oct");
        Rating rating14 = new Rating("614", 4);
        test5.addRating(rating14);
        //3.333
        Ratable ts2 = test5;
        expected.add(ts1);
        expected.add(thir);
        expected.add(ts);
        expected.add(sec);
        ArrayList<Ratable> computed = media.topKRatables(4);
        testTopK(expected,computed);


    }

}
