public class ChallengeResult {
    //Fields
    ReadingResult ReadingResultObj; //ReadingResult object
    WritingResult WritingResultObj; //WritingResult object

    //Constructor
    ChallengeResult(ReadingResult ReadingResultObj, WritingResult WritingResultObj) {
        this.ReadingResultObj = ReadingResultObj;
        this.WritingResultObj = WritingResultObj;
    }

    //Method
    //number of books per day needed to reach their reading goal (the difference) multiplied by 10,000, and then added
    // to their number of words to write per day needed to reach the writing challenge goal (the difference)
    public double howClose() {
        return (ReadingResultObj.differenceFromGoal() * 10000) + WritingResultObj.differenceFromGoal();
    }
}
