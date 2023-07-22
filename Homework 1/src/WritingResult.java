public class    WritingResult implements IChallenge {
    //Fields
    double numWords; //the number of words written
    int dayNov; //the day of November the last update was made (1 through 30)

    //Constructor
    WritingResult(double numWords, int dayNov) {
        this.numWords = numWords;
        this.dayNov = dayNov;
    }

    //Methods
    public double averagePerDay() {
        //number of words written so far divided by the day in November they last wrote something
        return (numWords / dayNov);
    }

    public double differenceFromGoal() {
        //difference between 50,000 and the number of words they have written divided by the number
        // of days left in November since they had last written something including that day
        return (50000 - numWords) / (30 - dayNov + 1);
    }
}
