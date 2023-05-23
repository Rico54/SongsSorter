package ratings;

import java.util.ArrayList;

public class Movie extends Ratable {
    private String title;
    private ArrayList<String> cast;
    public Movie(String movi, ArrayList<String> mo ){
        super(movi);
        this.cast = mo;

    }

    public ArrayList<String> getCast(){
        return this.cast;
    }

}
