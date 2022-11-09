//Zachary Szeto and Christopher Smith

import static org.junit.Assert.*;

import org.junit.Test;

public class Examples {

    @Test
    public void ReadingResultAvgPerDay() {
        //Reading Result Average Per Day for Bob
        BooksRead fiction1 = new BooksRead(20);
        BooksRead nonFiction1 = new BooksRead(11.0);
        ReadingResult RRBob = new ReadingResult(1, fiction1, nonFiction1);
        assertEquals(1.0, RRBob.averagePerDay(), 0.0000001);
    }

    @Test
    public void ReadingResultDifferenceFromGoal() {
        //Reading Result Difference From Goal for John
        BooksRead fiction1 = new BooksRead(20.0);
        BooksRead nonFiction1 = new BooksRead(11.0);
        ReadingResult RRJohn = new ReadingResult(1, fiction1, nonFiction1);
        assertEquals(0, RRJohn.differenceFromGoal(), 0.0000001);
    }

    @Test
    public void WritingResultAvgPerDay() {
        //Writing Result Average Per Day for Susan
        WritingResult WRSusan = new WritingResult(10000.0, 5);
        assertEquals(2000, WRSusan.averagePerDay(), 0.0000001);
    }

    @Test
    public void WritingResultDifferenceFromGoal() {
        WritingResult WRMary = new WritingResult(33333.0, 21);
        assertEquals(1666.7, WRMary.differenceFromGoal(), 0.0000001);
    }

    @Test
    public void ChallengeResultHowClose() {
        //Challenge Result for David
        BooksRead fiction2 = new BooksRead(2.25);
        BooksRead nonFiction2 = new BooksRead(5.5);
        ReadingResult RRDavid = new ReadingResult(1, fiction2, nonFiction2);
        WritingResult WRDavid = new WritingResult(33333.0, 21);
        ChallengeResult David = new ChallengeResult(RRDavid, WRDavid);

        assertEquals(9166.7, David.howClose(), 0.0000001);
    }

    @Test
    public void LiterarianBetterBookWorm() {
        //Literarian Katie Builder
        BooksRead fiction3 = new BooksRead(2.25);
        BooksRead nonFiction3 = new BooksRead(5.5);
        ReadingResult RRKatie = new ReadingResult(1, fiction3, nonFiction3);
        WritingResult WRKatie = new WritingResult(33333.0, 21);
        ChallengeResult CRKatie = new ChallengeResult(RRKatie, WRKatie);
        Literarian Katie = new Literarian(CRKatie);

        //Literarian Kyle Builder
        BooksRead fiction4 = new BooksRead(11.0);
        BooksRead nonFiction4 = new BooksRead(20.0);
        ReadingResult RRKyle = new ReadingResult(1, fiction4, nonFiction4);
        WritingResult WRKyle = new WritingResult(33333.0, 21);
        ChallengeResult CRKyle = new ChallengeResult(RRKyle, WRKyle);
        Literarian Kyle = new Literarian(CRKyle);

        assertTrue(Kyle.betterBookworm(Katie));
    }

    @Test
    public void LiterarianWittierWordSmith () {
        //Literarian Katie Builder
        BooksRead fiction3 = new BooksRead(2.25);
        BooksRead nonFiction3 = new BooksRead(5.5);
        ReadingResult RRKatie = new ReadingResult(1, fiction3, nonFiction3);
        WritingResult WRKatie = new WritingResult(10000.0, 20); //Tested Data: 10000/20 = 500
        ChallengeResult CRKatie = new ChallengeResult(RRKatie, WRKatie);
        Literarian Katie = new Literarian(CRKatie);

        //Literarian Kyle Builder
        BooksRead fiction4 = new BooksRead(11.0);
        BooksRead nonFiction4 = new BooksRead(20.0);
        ReadingResult RRKyle = new ReadingResult(1, fiction4, nonFiction4);
        WritingResult WRKyle = new WritingResult(5000.0, 20); //Tested Data: 5000/20 = 250
        ChallengeResult CRKyle = new ChallengeResult(RRKyle, WRKyle);
        Literarian Kyle = new Literarian(CRKyle);

        //500>250 so true
        assertTrue(Katie.wittierWordsmith(Kyle));
    }

    @Test
    public void LiterarianSuccessfulScholarTrue  () {
        //Literarian Katie Builder
        BooksRead fiction3 = new BooksRead(2.25);
        BooksRead nonFiction3 = new BooksRead(5.5);
        ReadingResult RRKatie = new ReadingResult(1, fiction3, nonFiction3);
        WritingResult WRKatie = new WritingResult(10000.0, 20); //Tested Data: 10000/20 = 500
        ChallengeResult CRKatie = new ChallengeResult(RRKatie, WRKatie);
        Literarian Katie = new Literarian(CRKatie);

        //Literarian Kyle Builder
        BooksRead fiction4 = new BooksRead(11.0);
        BooksRead nonFiction4 = new BooksRead(20.0);
        ReadingResult RRKyle = new ReadingResult(1, fiction4, nonFiction4);
        WritingResult WRKyle = new WritingResult(50000.0, 20); //Tested Data: 5000/20 = 2500
        ChallengeResult CRKyle = new ChallengeResult(RRKyle, WRKyle);
        Literarian Kyle = new Literarian(CRKyle);

        //2500>500 so true
        assertTrue(Kyle.successfulScholar(Katie));
    }

    @Test
    public void LiterarianSuccessfulScholarFalse  () {
        //Literarian Katie Builder
        BooksRead fiction3 = new BooksRead(2.25);
        BooksRead nonFiction3 = new BooksRead(5.5);
        ReadingResult RRKatie = new ReadingResult(1, fiction3, nonFiction3);
        WritingResult WRKatie = new WritingResult(10000.0, 20); //Tested Data: 10000/20 = 500
        ChallengeResult CRKatie = new ChallengeResult(RRKatie, WRKatie);
        Literarian Katie = new Literarian(CRKatie);

        //Literarian Kyle Builder
        BooksRead fiction4 = new BooksRead(11.0);
        BooksRead nonFiction4 = new BooksRead(20.0);
        ReadingResult RRKyle = new ReadingResult(1, fiction4, nonFiction4);
        WritingResult WRKyle = new WritingResult(50000.0, 20); //Tested Data: 5000/20 = 2500
        ChallengeResult CRKyle = new ChallengeResult(RRKyle, WRKyle);
        Literarian Kyle = new Literarian(CRKyle);

        //2500>500 so true
        assertFalse(Katie.successfulScholar(Kyle));
    }
}
