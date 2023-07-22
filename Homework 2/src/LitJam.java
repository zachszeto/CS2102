import java.util.LinkedList;

public class LitJam {
    //Fields
    int numGenres;
    LinkedList<Literarian> LiterarianList;

    //Constructor
    LitJam(int numGenres, LinkedList<Literarian> LiterarianList) {
        this.numGenres = numGenres;
        this.LiterarianList = LiterarianList;
    }

    /**
     * Adds literarian to list if they didn't meet their goal for LitJam.
     * @params readingDNF
     * @params penNamesList
     * @return penNamesList (with added literarians)
     */

    public LinkedList<String> readingDNF() {
        LinkedList<String> penNamesList = new LinkedList<String>();

        for (Literarian thisLiterarian : LiterarianList) {
            if (thisLiterarian.ChallengeResultObj.ReadingResultObj.BooksReadList.size() < numGenres) {
                penNamesList.add(thisLiterarian.penName);
            }
        }
        return penNamesList;
    }

    /**
     * Calculates final score for a literarian.
     * @param literarianName
     * @return Final score for a literarian.
     */

    public int finalScoreForLiterarian(String literarianName) {
        int finalScore = 0;
        for (Literarian thisLiterarian : this.LiterarianList) {
            if (thisLiterarian.penName.equals(literarianName)) {
                //11b
                if (thisLiterarian.ChallengeResultObj.ReadingResultObj.BooksReadList.size() >= numGenres) {
                    finalScore += 25;
                    //System.out.print("Meets/Exceeds Goal: +25 ");
                }

                //11c
                for (BooksRead thisBooksRead : thisLiterarian.ChallengeResultObj.ReadingResultObj.BooksReadList) {
                    if (thisBooksRead.isSkimmed == false) {
                        finalScore += 5;
                        //System.out.print("non-skimmed Book read: +5 ");

                    }
                }

                //11d
                if ( thisLiterarian.ChallengeResultObj.ReadingResultObj.BooksReadList.size() >= thisLiterarian.ChallengeResultObj.ReadingResultObj.avgBPDgoal) {
                    finalScore += 5;
                    //System.out.print("Met their own goal Score: +5 ");
                }

                //11e and 11f
                if (thisLiterarian.ChallengeResultObj.WritingResultObj.averagePerDay() >= 50000) {
                    finalScore += 25;
                    //System.out.print("Wrote more than 50,000 Score: +25 ");
                    finalScore += ((30 - thisLiterarian.ChallengeResultObj.WritingResultObj.day) * 5);
                    //System.out.print(((30 - thisLiterarian.ChallengeResultObj.WritingResultObj.day) * 5));
                }
            }
        }
        return finalScore;
    }

    /**
     * Determines whether a literarian improved between LitJams.
     * @param LitJam2
     * @return Boolean for whether a literarian improved their final score.
     */

    public boolean anyImprovement(LitJam LitJam2) {
        boolean anyImprovement = false;
        for (Literarian thisLiterarian : this.LiterarianList) {
            if (this.finalScoreForLiterarian(thisLiterarian.penName) > LitJam2.finalScoreForLiterarian(thisLiterarian.penName)) {
                anyImprovement = true;
            }
        }
        return anyImprovement;
    }
}

/*
Questions:
In hindsight, do you see any helper methods that you should have written that could have been shared over those two problems,
or are you happy with how you organized the code?

Answer:
Looking back I probably should have created a helper function that represents the booklist field of a Literarian instead
of going from Literarian to challenge result to reading result to finally whatever I wanted to do. I am glad that I
made a helper function to add an item to a list instead of having to write a new one for everyone time I wanted to add
an item to a list for a specific class.

 */