import java.util.LinkedList;
import java.util.GregorianCalendar;

public class RadioStation {
    private GregorianCalendar date;
    private IRatings ratings;

    RadioStation(GregorianCalendar aDate, IRatings aRatings){
        this.date = aDate;
        this.ratings = aRatings;
    }

    public int bestRankThisMonth() {
        int min = Integer.MAX_VALUE;
        for (TodaysRatings r : ratings) {
            if (this.date.get(GregorianCalendar.MONTH) == r.getDate().get(GregorianCalendar.MONTH) && r.findMinRank() < min)
                min = r.findMinRank();
        }
        return min;
    }

    public int totalSongDownloads(int month, int year) {

        int count = 0;

        for(TodaysRatings r : this.ratings) {
            if(r.sameMonthYear(month, year))
                for(int d : r.getSurveyDownloads()) {
                    count += d;
                }
        }
        return count;
    }

    public void addTodaysSurveys(LinkedList<Survey> surveys) {

        LinkedList<Integer> someSurveyRankings = new LinkedList<Integer>();
        LinkedList<Integer> someSurveyDownloads = new LinkedList<Integer>();

        for(Survey s : surveys) {
            someSurveyRankings.add(s.getRanking());
            someSurveyDownloads.add(s.getDownloads());

        }

        this.ratings.add(new TodaysRatings(this.date, someSurveyRankings, someSurveyDownloads));
        this.date.add(GregorianCalendar.DAY_OF_YEAR, 1);

    }

}
