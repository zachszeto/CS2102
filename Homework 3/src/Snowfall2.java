import java.util.LinkedList;

class Snowfall2 {
    Snowfall2() {
    }

    // checks whether a datum is a date
    boolean isDate(double anum) {
        return (int) anum >= 101;
    } // Jan 1st

    // extracts the month from an 4-digit date
    int extractMonth(double dateNum) {
        return ((int) (dateNum / 100));
    }

    //Parsing Approach
    /**
     * Takes in a list of sensor data and returns a list of maxInReports
     * @param data
     * @param month
     * @return A list of maxInReports that contain the largest reported snowfall for the given dates in the specified month
     */
    public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
        LinkedList<MaxInchReport> maxInMonth = new LinkedList<MaxInchReport>();

        for(int h = 0; h < data.size(); h++){
            if(extractMonth(data.get(h)) == month){
                double currentDate = data.get(h);
                double currentMax = 0.0;
                for(int i = h + 1; i < data.size() + 1; i++){
                    if(i >= data.size() || isDate(data.get(i))){
                        break;
                    } else if(data.get(i) >= 0 && data.get(i) <= 99 && data.get(i) > currentMax) {
                        currentMax = data.get(i);
                    }
                }
                maxInMonth.add(new MaxInchReport(currentDate, currentMax));
            }
        }
        return maxInMonth;
    }
}