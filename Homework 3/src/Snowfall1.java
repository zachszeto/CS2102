import java.util.LinkedList;

class Snowfall1 {
  Snowfall1() {
  }

  // checks whether a datum is a date
  boolean isDate(double anum) {
    return (int) anum >= 101;
  } // Jan 1st

  // extracts the month from an 4-digit date
  int extractMonth(double dateNum) {
    return ((int) (dateNum / 100));
  }

  /**
   * Takes in a list of sensor data and returns a list of maxInReports
   * @param data
   * @param month
   * @return A list of maxInReports that contain the largest reported snowfall for the given dates in the specified month
   */
  //Cleaning Approach
  public LinkedList<MaxInchReport> dailyMaxForMonth(LinkedList<Double> data, int month) {
    LinkedList<MaxInchReport> maxInMonth = new LinkedList<MaxInchReport>();
    LinkedList<Double> noNegatives = new LinkedList<Double>();
    LinkedList<Double> aMonthaSnowFall = new LinkedList<Double>();

    for (int i = 0; i < data.size(); i++) {
      if (data.get(i) < 0) {
        noNegatives.add(0.0);
      } else {
        noNegatives.add(data.get(i));
      }
    }

    double currentMostSnowFall = 0;
    for (int i = 0; i < noNegatives.size(); i++) {
      if (isDate(noNegatives.get(i))) {
        if (currentMostSnowFall > 0){
          aMonthaSnowFall.add(currentMostSnowFall);
        }
        aMonthaSnowFall.add(noNegatives.get(i));
        currentMostSnowFall = 0;
      } else if (noNegatives.get(i) <= 99 && noNegatives.get(i) > currentMostSnowFall) {
        currentMostSnowFall = noNegatives.get(i);
      }
    }
    aMonthaSnowFall.add(currentMostSnowFall);

    for (int i = 0; i < aMonthaSnowFall.size(); i++) {
      if (isDate(aMonthaSnowFall.get(i)) && extractMonth(aMonthaSnowFall.get(i)) >= month && extractMonth(aMonthaSnowFall.get(i)) < month + 1) {
        maxInMonth.add(new MaxInchReport(aMonthaSnowFall.get(i), aMonthaSnowFall.get(i + 1)));
      }
    }
    return maxInMonth;
  }
}
