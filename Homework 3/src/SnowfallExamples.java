import static org.junit.Assert.*;
import org.junit.Test;
import java.util.LinkedList;

public class SnowfallExamples {
  Snowfall1 E1 = new Snowfall1();
  LinkedList<Double> noData = new LinkedList<Double>();
  LinkedList<Double> threeDates = new LinkedList<Double>();  
  LinkedList<MaxInchReport> DecReports = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> DecReports2 = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> DecReportsEmpty = new LinkedList<MaxInchReport>();
  LinkedList<MaxInchReport> DecReportsZero= new LinkedList<MaxInchReport>();
  
  public SnowfallExamples() {
    threeDates.add(1113.0);
    threeDates.add(10.0);
    threeDates.add(5.0);
    threeDates.add(1120.0);
    threeDates.add(4.0);
    threeDates.add(5.0);
    threeDates.add(4.5);
    threeDates.add(1201.0);
    threeDates.add(6.0);
    threeDates.add(-0.5);
    threeDates.add(200.0);
    threeDates.add(0.0);
    threeDates.add(-0.5);
    DecReports.add(new MaxInchReport(1201.0,6.0));
    DecReports2.add(new MaxInchReport(1113.0,10.0));
    DecReports2.add(new MaxInchReport(1120.0,5.0));
    DecReportsZero.add(new MaxInchReport(200.0,0.0));
  }

  @Test
  public void instructorTestEQ1a() {
    assertEquals(DecReports,
                 E1.dailyMaxForMonth(threeDates, 12));
  }
  @Test
  public void instructorTestE1b() {
    assertEquals(DecReports2,
            E1.dailyMaxForMonth(threeDates, 11));
  }
  @Test
  public void instructorTestE1c() {
    assertEquals(DecReportsEmpty,
            E1.dailyMaxForMonth(threeDates, 1));
  }
  @Test
  public void instructorTestE1d() {
    assertEquals(DecReportsZero,
            E1.dailyMaxForMonth(threeDates, 2));
  }

}
/*
Subtasks for Snowfall 1
  -Filters out all negative numbers and replaces them with 0 by creating a list
  -Filters out all the snowfall totals for a given date except for largest snowfall by creating a list
  -Filters out all the dates that are not in the given month by creating a list(contains one snowfall total per date)
  -Returns list of maxInMonth based on the list created in the prior step
 */

/*
Subtasks for Snowfall 2
  -Iterates through the list of data and if it is a date and belongs to the current month then set currentDate to that date
  -Iterates through the list of data and if it is a snowfall that is larger than the current max set currentMax to that snowfall
  -Continues to update currentMax until it reaches another date
  -Creates a new MaxInchReport with its date set as currentDate and its snowfall set as currentMax
  -Adds that MaxInchReport to maxInMonth
 */