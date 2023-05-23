package ratings;

public class Rating {
    private String reviewerID;
    private int rating;

    public Rating(String review, int rate){
        this.setReviewerID(review);
        this.setRating(rate);
    }
    public String getReviewerID(){
        return reviewerID;
    }
    public void setReviewerID(String review){
        this.reviewerID = review;
    }
    public int getRating(){
        return rating;
    }
    public void setRating(int rate){
        if (rate >= 1 && rate <= 5){
            this.rating = rate;
        }else {
            this.rating = -1;
        }
    }


}
