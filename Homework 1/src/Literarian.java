public class Literarian {
    //Fields
    ChallengeResult ChallengeResultObj;

    //Constructor
    Literarian(ChallengeResult ChallengeResultObj) {
        this.ChallengeResultObj = ChallengeResultObj;
    }

    //Methods
    public boolean betterBookworm(Literarian candidate1) {
        if (this.ChallengeResultObj.ReadingResultObj.differenceFromGoal() < candidate1.ChallengeResultObj.ReadingResultObj.differenceFromGoal()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean wittierWordsmith(Literarian candidate1) {
        if (this.ChallengeResultObj.WritingResultObj.averagePerDay() > candidate1.ChallengeResultObj.WritingResultObj.averagePerDay()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean successfulScholar(Literarian candidate1) {
        if (this.betterBookworm(candidate1) || this.wittierWordsmith(candidate1)) {
            return true;
        } else {
            return false;
        }
    }
}

