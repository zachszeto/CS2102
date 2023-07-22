public class BooksRead {
    //Fields
    double numRead; //the number of books that have been read (including partial books)
    String genre;
    boolean isSkimmed;

    //Constructor
    BooksRead(double numRead, String genre, boolean isSkimmed) {
        this.numRead = numRead;
        this.genre = genre;
        this.isSkimmed = isSkimmed;
    }
}
