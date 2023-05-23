package ratings;

import ratings.datastructures.LinkedListNode;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;

public class FileReader {

    public static ArrayList<Song> readSongs(String filename) {
        try {
            //1GfBLbAhZUWdseuDqhocmn,Skrillex,Rumble,321,4
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));;
            ArrayList<Song> allsong = new ArrayList<>();
            HashMap<String,Song> notready =new HashMap<>();
            for (String line : lines) {
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String songID = splits.get(0);
                String artist = splits.get(1);
                String title = splits.get(2);
                String reviewerID = splits.get(3);

                int rating = Integer.parseInt(splits.get(4));
                Song song = new Song (title, artist,songID);
                if(!(notready.containsKey(songID))){
                    song.addRating(new Rating(reviewerID, rating));
                    notready.put(songID,song);
                }else{
                    notready.get(songID).addRating(new Rating(reviewerID, rating));
                }

            }
            for (Song i : notready.values()){
                allsong.add(i);

            }
            return allsong;
            }
        catch (IOException e) {
            return new ArrayList<>();
            }
    }

    public static ArrayList<Movie> readMovies (String filename){
        try {
            ArrayList<String> lines = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            ArrayList<Movie> allMovies = new ArrayList<>();
            for (String line: lines){
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String title = splits.get(0);
                splits.remove(0);
                allMovies.add(new Movie(title, splits));

            }
            return allMovies;
        } catch (IOException e){
            return new ArrayList<>();
        }
    }

    public static ArrayList<Movie> readMovieRatings(ArrayList<Movie> lom, String filename){
        try {
//            filename = "System.out.println(returns)";
            ArrayList<String> allmovie = new ArrayList<>(Files.readAllLines(Paths.get(filename)));
            HashMap<String,Movie> notready =new HashMap<>();
            ArrayList<Movie> returns = new ArrayList<>();
            for (int i = 0; i<lom.size(); i++){
                notready.put(lom.get(i).getTitle(),lom.get(i));
            }
            for (String line : allmovie) {
                ArrayList<String> splits = new ArrayList<>(Arrays.asList(line.split(",")));
                String title = splits.get(0);
                String reviewerid = splits.get(1);
                int rating = Integer.parseInt(splits.get(2));
                if (notready.containsKey(title)) {
                    if (notready.get(title).getRatings() == null) {
                        notready.get(title).addRating(new Rating(reviewerid, rating));
                        returns.add(notready.get(title));
                    } else {
                        notready.get(title).addRating(new Rating(reviewerid, rating));
                    }


                }
            }
            return returns;

        } catch (IOException e){
            return new ArrayList<>();
        }

    }
}
