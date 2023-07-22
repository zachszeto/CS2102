import org.junit.Test;
import static org.junit.Assert.*;
import java.util.LinkedList;

public class Examples {
    // method to set up a ballot and cast votes

    VotingData vdSetup1() {

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

    public VotingData vdSetup2() {

        VotingData vd = new VotingData();

        try {

            vd.nominateCandidate("gompei");
            vd.nominateCandidate("husky");
            vd.nominateCandidate("ziggy");
            vd.nominateCandidate("zach");
            vd.nominateCandidate("anton");

        } catch(Exception e) {}

        try {

            vd.submitVote("gompei", "husky", "ziggy");
            vd.submitVote("gompei", "anton", "zach");

        } catch(Exception e) {}

        return vd;

    }

    Vote voteSetup1() {

        LinkedList<Integer> votesList = new LinkedList<Integer>();
        votesList.add(1);
        votesList.add(2);
        votesList.add(3);

        return new Vote("gompei", votesList);
    }

    LinkedList<String> candidatesList_setup1() {

        LinkedList<String> list = new LinkedList<String>();

        list.add("ziggy");
        list.add("husky");
        list.add("gompei");

        return list;

    }

    // now run a test on a specific election
    @Test
    public void testMostFirstWinner() {
        assertEquals("gompei", this.vdSetup1().pickWinnerMostFirstChoice());
    }

    @Test
    public void testMostAgreeable() {
        assertEquals("gompei", this.vdSetup2().pickWinnerMostAgreeable());
    }

    @Test(expected=CandidateChosenMoreThanOnceException.class)
    public void VotingData_submitVote_CandidateChosenMoreThanOnceException() throws Exception {
        vdSetup1().submitVote("gompei", "gompei", "husky");
    }

    @Test(expected=CandidateNotFoundException.class)
    public void VotingData_submitVote_CandidateNotFoundException() throws Exception {
        vdSetup1().submitVote("alec", "gompei", "husky");
    }

    @Test(expected=RedundantCandidateException.class)
    public void VotingData_nominateCandidate() throws RedundantCandidateException {
       vdSetup1().nominateCandidate("gompei");
    }

    @Test
    public void VotingData_candidates() {
        assertEquals(candidatesList_setup1(), vdSetup1().candidates());
    }

    @Test
    public void VotingData_containsCandidate_true() {
        assertTrue(vdSetup1().containsCandidate("gompei"));
    }

    @Test
    public void VotingData_containsCandidate_false() {
        assertFalse(vdSetup1().containsCandidate("anton"));
    }

    @Test
    public void Vote_numVotes_correctCand() {

        LinkedList<Integer> expectedVotes = new LinkedList<Integer>();
        expectedVotes.add(1);
        expectedVotes.add(2);
        expectedVotes.add(3);

        assertEquals(expectedVotes, voteSetup1().numVotes("gompei"));

    }

    @Test
    public void Vote_numVotes_incorrectCand() {
        assertNull(voteSetup1().numVotes("anton"));
    }

    @Test
    public void Vote_getVotesByIndex() {
        assertEquals(1, voteSetup1().votesByIndex("gompei", 0));
    }

    @Test
    public void Vote_maxVotes() {
        assertEquals(3, voteSetup1().maxVotes("gompei"));
    }

    @Test
    public void Vote_addVote() {

        LinkedList<Integer> expectedVoteList = new LinkedList<Integer>();
        expectedVoteList.add(2);
        expectedVoteList.add(2);
        expectedVoteList.add(3);

        Vote expectedVote = new Vote("gompei", expectedVoteList);

        assertTrue(expectedVote.equals(voteSetup1().addVote("gompei", 0)));
    }
}
