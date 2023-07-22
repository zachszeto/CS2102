public class CandidateChosenMoreThanOnceException extends Exception {
    private String name;
    CandidateChosenMoreThanOnceException(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}