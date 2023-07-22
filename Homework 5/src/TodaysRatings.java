import java.util.GregorianCalendar;
import java.util.LinkedList;

public class TodaysRatings {

   //Fields
    private GregorianCalendar date;
    private LinkedList<Integer> rankingLL;
    private LinkedList<Integer> downloadLL;

    //Constructor
    TodaysRatings(GregorianCalendar aDate, LinkedList<Integer> aRankingLL, LinkedList<Integer> aDownloadLL){
        this.date = aDate;
        this.rankingLL = aRankingLL;
        this.downloadLL = aDownloadLL;
    }

    public int rankingLLSize(){
        return rankingLL.size();
    }

    public boolean sameMonth(GregorianCalendar aDate){
        return this.date.MONTH == aDate.MONTH;
    }

    public GregorianCalendar getDate(){
        return this.date;
    }

}

