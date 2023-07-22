import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;

public class VotingData {
    private HashMap<String, Vote> ballot = new HashMap<String, Vote>();
    private double numFirstVotes = 0.0;

    public VotingData() {}

    /**
     * Takes in a new vote and adds it to the hash map
     * @param firstChoice name of voter's favorite candidate
     * @param secondChoice name of voter's second favorite candidate
     * @param thirdChoice name of voter's third favorite candidate
     * @throws CandidateNotFoundException happens when voter votes for a non-existent candidate
     * @throws CandidateChosenMoreThanOnceException happens when voter votes for a candidate more than once
     */
    public void submitVote(String firstChoice, String secondChoice, String thirdChoice) throws CandidateNotFoundException, CandidateChosenMoreThanOnceException {

        //Checks to see if all the votes are valid candidates
        if (!ballot.containsKey(firstChoice)) {
            throw new CandidateNotFoundException(firstChoice);
        } else if (!ballot.containsKey(secondChoice)) {
            throw new CandidateNotFoundException(secondChoice);
        } else if (!ballot.containsKey(thirdChoice)) {
            throw new CandidateNotFoundException(thirdChoice);
        }

        //Checks to see if there are no duplicate votes for a single candidate
        if (firstChoice.equals(secondChoice)) {
            throw new CandidateChosenMoreThanOnceException(secondChoice);
        } else if (secondChoice.equals(thirdChoice)) {
            throw new CandidateChosenMoreThanOnceException(thirdChoice);
        } else if (thirdChoice.equals(firstChoice)) {
            throw new CandidateChosenMoreThanOnceException(thirdChoice);
        }

        //Adds new candidate if they do not exist
        if(!ballot.containsKey(firstChoice))
            this.ballot.put(firstChoice, new Vote(firstChoice));
        if(!ballot.containsKey(secondChoice))
            this.ballot.put(secondChoice, new Vote(secondChoice));
        if(!ballot.containsKey(thirdChoice))
            this.ballot.put(thirdChoice, new Vote(thirdChoice));

        //Adds vote to Linked List
        ballot.put(firstChoice, ballot.get(firstChoice).addVote(firstChoice, 0));
        ballot.put(secondChoice, ballot.get(secondChoice).addVote(secondChoice, 1));
        ballot.put(thirdChoice, ballot.get(thirdChoice).addVote(thirdChoice, 2));

        //Counts how many sets of 3 votes have been cast
        numFirstVotes += 1.0;
    }

    /**
     * Adds a new candidate to the hashmap
     * @param aCandidate name of the candidate
     * @throws RedundantCandidateException happens when voter tries to add an already existing candidate
     */
    public void nominateCandidate(String aCandidate) throws RedundantCandidateException {
        if (!ballot.containsKey(aCandidate)) {
            this.ballot.put(aCandidate, new Vote(aCandidate));
        } else {
            throw new RedundantCandidateException(aCandidate);
        }
    }

    /**
     * Finds candidate with most first place votes
     * @return returns the name of the candidate with more than 50% of the first place votes (if they exist)
     */
    public String pickWinnerMostFirstChoice() { // return person who has more than 50% of the first place votes

        String winner = "";
        boolean noMajority = true;

        for (Map.Entry<String, Vote> entry : ballot.entrySet()) {
            String key = entry.getKey();

            if (((ballot.get(key).votesByIndex(key, 0)) / (numFirstVotes) >= 0.5) && ((ballot.get(key).votesByIndex(key, 0)) * 2 != numFirstVotes)) {
                noMajority = false;
                winner = key;
            } else noMajority = true;
        }

        if (noMajority == true) return "*Requires Runoff Poll*";
        else return winner;
    }

    /**
     * Finds candidate with most votes (1st, 2nd, or 3rd)
     * @return returns the name of the candidate with the most votes
     */
    public String pickWinnerMostAgreeable() { // return person who has greater max( #ofFirst , #ofSecond , #ofThird )
        String winner = "";
        int greatestNumVotes = 0;

        for (Map.Entry<String, Vote> entry : ballot.entrySet()) {
            if (entry.getValue().maxVotes(entry.getKey()) > greatestNumVotes)
                winner = entry.getKey();
        }
        return winner;
    }

    /**
     * Adds all the candidates in the hashmap to a linked list
     * @return a linked list of candidates (strings)
     */
    public LinkedList<String> candidates() {
        LinkedList<String> candidatesLL = new LinkedList<>();
        for (Map.Entry<String, Vote> entry : ballot.entrySet()) {
            String key = entry.getKey();
            candidatesLL.add(key);
        }
        return candidatesLL;
    }

    /**
     * Checks if a candidate exists
     * @param cand name of a candidate
     * @return true if candidate exists in the hashmap otherwise false
     */
    public boolean containsCandidate(String cand) {
        return this.ballot.containsKey(cand);
    }
}