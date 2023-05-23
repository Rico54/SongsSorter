package tests;
import org.junit.Test;
import ratings.DegreesOfSeparation;
import ratings.FileReader;
import ratings.Movie;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TestDataStructures3 {


    private void testMovie(Movie expected, Movie computed){
        if (expected == null) {
            assertNull(computed);
        }else {
            assertEquals(expected.getTitle(), computed.getTitle());
            assertEquals(expected.getCast().size(), computed.getCast().size());
            for(int i =0; i<expected.getCast().size();i++){
                assertEquals(expected.getCast().get(i), computed.getCast().get(i));
            }

        }
    }
    private void testSame(ArrayList<Movie> expected, ArrayList<Movie> computed){
        assertEquals(expected.size(), computed.size());
        ArrayList<String> title = new ArrayList<>();
        for(int i =0;i < expected.size(); i++){
            title.add(computed.get(i).getTitle());
        }
        for(int x = 0; x< expected.size(); x++){
            assertTrue(title.contains(expected.get(x).getTitle()));
            int w = title.indexOf(expected.get(x).getTitle());
            testMovie(expected.get(x),computed.get(w));

        }



    }




    @Test
    public void testEmptyMovieList(){
        String filename = "data/nonexistance.csv";
        ArrayList<Movie> expected = new ArrayList<>();
        ArrayList<Movie> computed =  FileReader.readMovies(filename);
        assertEquals(expected.size(),computed.size());

    }

    @Test
    public void testOneMovieList(){
    String filename = "data/testmovies.csv";
    ArrayList<Movie> expected = new ArrayList<>();
    ArrayList<Movie> computed =  FileReader.readMovies(filename);
    ArrayList<String> cast = new ArrayList<>(Arrays.asList("Tom Hanks","Tim Allen","Don Rickles","Wallace Shawn","John Ratzenberger","Annie Potts","John Morris","Laurie Metcalf","R. Lee Ermey","Penn Jillette"));
    //Toy Story,Tom Hanks,Tim Allen,Don Rickles,Wallace Shawn,John Ratzenberger,Annie Potts,John Morris,Laurie Metcalf,R. Lee Ermey,Penn Jillette
    Movie first = new Movie("Toy Story", cast );
    expected.add(first);
    testSame(expected, computed);
    }

    @Test
    public void testSameDegrees(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("same one", "same one");
        int expected = 0;
        assertEquals(expected, computed);
    }
    @Test
    public void testOneDegrees(){
        String filename ="data/movies.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("Tom Hanks", "Tim Allen");
        int expected = 1;
        assertEquals(expected, computed);
    }
    @Test
    public void testMultipleDegrees(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("same one", "different1 one");
        int expected = 3;
        assertEquals(expected, computed);
    }
    @Test
    public void testThreeDegrees(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("same one", "hello world");
        int expected = 3;
        assertEquals(expected, computed);
    }
    @Test
    public void noConnectionDegrees(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("same one", "hello axz");
        int expected = -1;
        assertEquals(expected, computed);

    }
    @Test
    public void testDegreeTwo(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("random name", "hello world");
        int expected = 2;
        assertEquals(expected, computed);
    }
    @Test
    public void testdegreeNextTo(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("the same", "not same");
        int expected = 2;
        assertEquals(expected, computed);
    }
    @Test
    public void TestDegreeTest3(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("same one", "same1 one");
        int expected = 1;
        assertEquals(expected, computed);
    }
    @Test
    public void testDegreeTest4(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("different act", "same act");
        int expected = -1;
        assertEquals(expected, computed);
    }
    @Test
    public void degreesNotdetected(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("not in ", "same act");
        int expected = -1;
        assertEquals(expected, computed);
    }
    @Test
    public void TestDegreesOne(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("same one", "same1 one");
        int expected = 1;
        assertEquals(expected, computed);
    }
    @Test
    public void testDegreesSeven(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("villager good", "same two");
        int expected = 7;
        assertEquals(expected, computed);
    }
    @Test
    public void testNoCast(){
        String filename ="data/testdegrees.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("doesn't exist", "same two");
        int expected = -1;
        assertEquals(expected, computed);
    }
    @Test
    public void testKevinCast(){
        String filename ="data/movies.csv";
        ArrayList<Movie> list =  FileReader.readMovies(filename);
        DegreesOfSeparation degrees = new DegreesOfSeparation(list);
        int computed = degrees.degreesOfSeparation("Kevin Bacon", "Yuko Miyamura");
        int expected = 4;
        assertEquals(expected, computed);
    }
}
