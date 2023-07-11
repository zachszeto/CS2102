import java.util.LinkedList;

public class WritingResult extends AbsLiterature implements IChallenge {
    //Constructor
    WritingResult(double numWords, int dayNov) {
        this.day = dayNov;
        this.numWordsList.add(numWords);
    }

    //Methods
    /**
     * Calculates number of words written.
     * @return Sum of words written so far divided by day.
     */
    public double differenceFromGoal() {
        double sum = 0;
        //number of words written so far divided by the day in November they last wrote something
        for (Double thisDouble : this.numWordsList) {
            sum += thisDouble;
        }
        return sum;
    }

    /**
     * Adds the nextChapter item into list
     * @param aChapter
     * @return nextChapter (WritingResult)
     */
    public WritingResult nextChapter(double aChapter) {
        addToList(aChapter);
        return this;
    }
}
