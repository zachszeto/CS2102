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

    /**
     * Calculates how close someone is to their writing goal.
     * @return Sum representing how close they are.
     */

    public double howClose() {
        return (ReadingResultObj.differenceFromGoal() * 10000) + WritingResultObj.differenceFromGoal();
    }
}
