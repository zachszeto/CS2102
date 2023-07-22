import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {
    // method to set up a ballot and cast votes

    VotingData setup1() {

        VotingData vd = new VotingData();

        // put candidates on the ballot
        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("husky");
            vd.nominateCandidate("ziggy");

        } catch (Exception e) {}

        // cast votes

        try {

            vd.submitVote("gompei", "husky", "ziggy");
            vd.submitVote("gompei", "ziggy", "husky");
            vd.submitVote("husky", "gompei", "ziggy");

        } catch (Exception e) {}

        return(vd);

    }

    // now run a test on a specific election
    @Test
    public void testMostFirstWinner () {
        assertEquals ("gompei", this.setup1().pickWinnerMostFirstChoice());
    }
}