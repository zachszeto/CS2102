import java.util.LinkedList;

public class ReadingResult implements IChallenge {
    //Fields
    int avgBPDgoal; //average books per day to reach goal
    LinkedList<BooksRead> BooksReadList = new LinkedList<BooksRead>();
    BooksRead fiction = new BooksRead(0, "fiction", false);
    BooksRead nonfiction = new BooksRead(0, "non-fiction", false);

    //Constructor
    ReadingResult(int avgBPD, BooksRead fiction, BooksRead nonfiction) {
        this.avgBPDgoal = avgBPD;
        this.BooksReadList.add(fiction);
        this.BooksReadList.add(nonfiction);
    }

    //Methods
    /**
     * Calculates sum of list
     * @return returns a double that represents the sum of a list
     */
    public double averagePerDay() {
        double sum = 0;

        for (BooksRead thisBooksRead : this.BooksReadList) {
            sum += thisBooksRead.numRead;
        }
        return sum;
    }


    public double differenceFromGoal() {
        //difference between the goal they set (stored in a field) and the average per day (or 0 if that difference is negative)
        if ((avgBPDgoal - averagePerDay()) > 0) {
            return (avgBPDgoal - averagePerDay());
        } else {
            return 0;
        }
    }


    public ReadingResult readSomeBooks(BooksRead aBook) {
        this.BooksReadList.add(aBook);
        return this;
    }

    /**
     * Takes in a boolean and returns the genre of the most read genre.
     * @param cantBeSkimmed
     * @return null
     */
    public String bestGenreByType(boolean cantBeSkimmed) {
        LinkedList<String> genres = new LinkedList<String>();
        LinkedList<Integer> numApperences = new LinkedList<Integer>();
        LinkedList<BooksRead> filteredList = new LinkedList<BooksRead>();

        for (BooksRead thisBooksRead : this.BooksReadList) {
            if (cantBeSkimmed == true && thisBooksRead.isSkimmed == false) {
                filteredList.add(thisBooksRead);
            } else if(thisBooksRead.isSkimmed == true){
                filteredList.add(thisBooksRead);
            }
        }
        System.out.print(filteredList);
        for (BooksRead thisBookRead : filteredList) {
            if (genres.contains(thisBookRead.genre) == false) {
                genres.add(thisBookRead.genre);
                numApperences.add(1);
            } else if (genres.contains(thisBookRead.genre)) {
                numApperences.set(genres.indexOf(thisBookRead.genre), (numApperences.get(genres.indexOf(thisBookRead.genre))) + 1);
            }
        }
        int mostApperences = -1;
        for (Integer num : numApperences) {
            int count = -1;
            if (num > mostApperences) {
                if(count + num > 0){
                    mostApperences = count + num;
                } else{
                    mostApperences = num;
                }

            }
        }
        if (filteredList.isEmpty() == false) {
            //System.out.print(numApperences.indexOf(mostApperences));
            return genres.get(numApperences.indexOf(mostApperences));
        } else {
            return null;
        }
    }
}
