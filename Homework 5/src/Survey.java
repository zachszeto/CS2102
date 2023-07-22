public class Survey {

    private int ranking;
    private int downloads;

    public Survey(int ranking, int downloads) {
        this.ranking = ranking;
        this.downloads = downloads;
    }

    public int getDownloads() {
        return this.downloads;
    }

    //remove later
    public int getRanking(){
        return this.ranking;
    }

}