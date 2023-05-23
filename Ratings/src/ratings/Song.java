package ratings;


public class Song extends Ratable {

    private String artist;
    private String songID;



    public Song(String tle, String art, String ID) {
        super(tle);
        this.artist = art;
        this.songID = ID;


    }



    public String getArtist() {
        return artist;
    }

    public void setArtist(String art) {
        this.artist = art;
    }

    public String getSongID() {
        return songID;
    }

    public void setSongID(String ID) {
        this.songID = ID;
    }



    }


