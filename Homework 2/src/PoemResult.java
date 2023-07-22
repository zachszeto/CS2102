import java.util.LinkedList;

public class PoemResult extends AbsLiterature implements IChallenge {
    //Fields
    int numWeeksSubmitted; //how many weeks have had a submitted poem

    //Constructor
    PoemResult(double numWords, int dayAug, int numWeeks) {
        this.numWordsList.add(numWords);
        this.day = dayAug;
        this.numWeeksSubmitted = numWeeks;
    }

    /**
     * If submitted, adds to numWeeksSubmitted.
     * @param numWords
     * @param isSubmitted
     * @return PoemResult.
     */
    public PoemResult nextPoem(double numWords, boolean isSubmitted) {
        addToList(numWords);
        if (isSubmitted == true) {
            numWeeksSubmitted++;
        }
        return this;
    }

    /**
     * Finds difference from goal.
     * @return Difference between how much written versus goal.
     */
    public double differenceFromGoal() {
        if (numWeeksSubmitted == 0) {
            return (averagePerDay() * (4 - numWeeksSubmitted)) / (31 - day + 1);
        } else {
            return ((averagePerDay() / numWeeksSubmitted) * (4 - numWeeksSubmitted)) / (31 - day + 1);
        }
    }
}
