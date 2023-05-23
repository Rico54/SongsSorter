package ratings;
import ratings.Rating;

public class Reviewer {

    private String reviewerID;

    public Reviewer(String ID){
        this.reviewerID = ID;
    }
    public String getReviewerID(){
        return this.reviewerID;
    }
    public void setReviewerID(String ID){
        this.reviewerID = ID;
    }
    public Rating rateSong(int any){
        Rating yes = new Rating (this.reviewerID, any);
        return yes;
    }


}
