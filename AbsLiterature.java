import java.util.LinkedList;

abstract class AbsLiterature {
    LinkedList<Double> numWordsList = new LinkedList<Double>();
    int day; //the day of August/November the last update was made (1 - 30 for Nov) (1 - 31 for Aug)


    /**
     * Calculates the number of words written so far.
     * @return Sum of words written so far divided by day they last wrote in November.
     */
    public double averagePerDay() {
        double sum = 0;
        //number of words written so far divided by the day in November they last wrote something
        for (Double thisDouble : this.numWordsList) {
            sum += thisDouble;
        }
        return sum;
    }

    /**
     * Adds num to a numWordsList.
     * @param num
     */
    public void addToList(double num){
        this.numWordsList.add(num);
    }
}
