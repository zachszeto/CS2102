import java.util.Scanner;

public class PollingDevice {

    //Fields
    private VotingData sampleVoting = new VotingData();

    private Scanner keyboard = new Scanner(System.in);

    public PollingDevice() {}

    //Methods
    public void printBallot() {
        System.out.println("The candidates are ");
        for (int i = 0; i < sampleVoting.candidates().size(); i++) {
            System.out.println(sampleVoting.candidates().get(i));
        }
    }

    public void displayResults() {

    }

    public void screen() {

        try {

            this.printBallot();

            System.out.print("Submit your first choice: ");
            String firstChoice = keyboard.next();
            if (!sampleVoting.containsCandidate(firstChoice))
                throw new CandidateNotFoundException(firstChoice);

            System.out.print("Submit your second choice: ");
            String secondChoice = keyboard.next();
            if(!sampleVoting.containsCandidate(secondChoice))
                throw new CandidateNotFoundException(secondChoice);

            System.out.print("Submit your third choice: ");
            String thirdChoice = keyboard.next();
            if(!sampleVoting.containsCandidate(thirdChoice))
                throw new CandidateNotFoundException(thirdChoice);

            sampleVoting.submitVote(firstChoice, secondChoice, thirdChoice);


        } catch(CandidateNotFoundException e) {
            System.out.print(e.getName() + " does not exist. Would you like to write them in? (y/n) ");
            this.addWriteIn(e.getName());
            this.screen();
        } catch(CandidateChosenMoreThanOnceException e){
            System.out.println("Cannot vote for same candidate twice");
            this.screen();
        }

    }

    public void addWriteIn(String cand) {
        String confirmation = keyboard.next();
        try{
            if(confirmation.toLowerCase().equals("y")) {
                sampleVoting.nominateCandidate(cand);
                this.screen();
            } else this.screen();

        } catch(RedundantCandidateException e){
            System.out.println("Candidate already exists");
        }
        System.out.println("Candidate was added successfully");
    }
}