package ratings;

import ratings.datastructures.LinkedListNode;

public class Ratable {
    private String title;
    private LinkedListNode<Rating> ratey;

    public Ratable(String tle){
        this.title = tle;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String le) {
        this.title = le;
    }

    public void addRating(Rating input) {
        if (this.ratey == null) {
            this.ratey = new LinkedListNode<>(input, null);
        } else if (!(didReviewerRateSong(input.getReviewerID()))){
            this.ratey.append(input);
        }
    }
    public LinkedListNode<Rating> getRatings() {
        return this.ratey;
    }

    public double averageRating() {
        double counter = 0;
        double add = 0.0;
        LinkedListNode<Rating> rati = this.ratey;
        while (rati != null) {
            Rating y = rati.getValue();
            add += y.getRating();
            counter += 1;
            rati = rati.getNext();
        }
        if (counter == 0) {
            return 0.0;
        } else {
            double aver = add / counter;
            return aver;
        }
    }
    public boolean didReviewerRateSong(String Id){
        LinkedListNode<Rating> y = this.ratey;
        while(y != null){
            Rating v = y.getValue();
            if(Id.equals(v.getReviewerID())){
                return true;
            }else{
                y = y.getNext();
            }
        }
        return false;
    }
    public void removeRatingByReviewer(Reviewer reviewer){
        LinkedListNode<Rating>pre = null;
        LinkedListNode<Rating>curr = this.ratey;

        while(!(curr.getValue().getReviewerID().equals(reviewer.getReviewerID())) && curr != null){
            pre = curr;
            curr = curr.getNext();
        }
        if(pre == null){
            this.ratey = curr.getNext();
        }else{
            pre.setNext(curr.getNext());
        }
    }

    public double bayesianAverageRating(int first, int sec){
        double counter = 0;
        double add = 0.0;
        LinkedListNode<Rating> rati = this.ratey;
        while (rati != null) {
            Rating y = rati.getValue();
            add += y.getRating();
            counter += 1;
            rati = rati.getNext();
        }
        if (counter == 0&& first ==0) {
            return 0.0;
        } else {
            double aver = (add+(sec*first)) / (counter+first);
            return aver;
        }

    }

}
