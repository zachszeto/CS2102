import java.util.LinkedList;

public class Vote {

    private String candidate;

    private LinkedList<Integer> votes = new LinkedList<Integer>();

    public Vote() {}

    public Vote(String candidate) {

        this.candidate = candidate;

        votes.add(0);
        votes.add(0);
        votes.add(0);

    }

    public boolean equals(Object e) {

        Vote voteToCompare = (Vote) e;

        return this.candidate.equals(voteToCompare.candidate)
                && this.votes.equals(voteToCompare.votes);

    }

    public Vote(String candidate, LinkedList<Integer> votes) {
        this.candidate = candidate;
        this.votes = votes;
    }

    /**
     * Finds the number of votes for a candidate
     * @param forCand a candidate's name
     * @return a linked list of integers
     */
    public LinkedList<Integer> numVotes(String forCand) {
        if(this.candidate.equals(forCand)) return this.votes;
        else return null;
    }

    /**
     * Finds the number of a specific kind of vote (1st, 2nd, or 3rd)
     * @param forCand candidates name
     * @param index integer from (0 - 2)
     * @return the number of votes of a specific kind
     */
    public int votesByIndex(String forCand, int index){
        return this.numVotes(forCand).get(index);
    }

    /**
     * Finds the maximum number of a specific kind of vote a candidate has
     * @param forCand candidates name
     * @return the largest number of votes in a specific place
     */
    public int maxVotes(String forCand) {
        LinkedList candVotes = this.numVotes(forCand);
        return Integer.max(Integer.max((int) candVotes.get(0), (int) candVotes.get(1)), (int) candVotes.get(2));
    }

    /**
     * Adds a vote to a candidate
     * @param forCand candidates name
     * @param index integer (0 - 2)
     * @return the updated vote object or null
     */
    public Vote addVote(String forCand, int index) {
        if(this.candidate.equals(forCand)) { votes.set(index, votes.get(index) + 1); return this; }
        else return null;
    }
}