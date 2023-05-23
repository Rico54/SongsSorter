package ratings.datastructures;

import ratings.Ratable;

public class RatableBayesianRatingComparator implements Comparator<Ratable>{

    @Override
    public boolean compare(Ratable a, Ratable b) {
        double first = a.bayesianAverageRating(2,3);
        double second = b.bayesianAverageRating(2,3);
        return first > second;
    }
}
