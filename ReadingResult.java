public class ReadingResult implements IChallenge {
    //Fields
    int avgBPDgoal; //average books per day to reach goal
    BooksRead fiction;
    BooksRead nonFiction;

    //Constructor
    ReadingResult(int avgBPD, BooksRead fiction, BooksRead nonFiction) {
        this.avgBPDgoal = avgBPD;
        this.fiction = fiction;
        this.nonFiction = nonFiction;
    }

    //Methods
    public double averagePerDay() {
        //amount of books total divided by the amount of days
        //return (Double.sum(fiction.numRead, nonFiction.numRead)) / 31;
        return (fiction.numRead + nonFiction.numRead) / 31;
    }

    public double differenceFromGoal() {
        //difference between the goal they set (stored in a field) and the average per day (or 0 if that difference is negative)
        if ((avgBPDgoal - averagePerDay()) > 0) {
            return (avgBPDgoal - averagePerDay());
        } else {
            return 0;
        }
    }
}


