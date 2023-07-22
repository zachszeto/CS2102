public class RedundantCandidateException extends Exception{
    private String name;
    RedundantCandidateException(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}