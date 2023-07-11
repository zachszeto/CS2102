//Zachary Szeto and Ian Kane

import static org.junit.Assert.*;

import org.junit.Test;

import javax.swing.*;
import java.util.LinkedList;

public class Examples {
    //averagePerDayCheckWR
    @Test
    public void averagePerDayCheckWR(){
        WritingResult SusanWR = new WritingResult(1.0,1);
        SusanWR.numWordsList.add(1.0);
        SusanWR.numWordsList.add(1.0);

        assertEquals(3, SusanWR.averagePerDay(), 0.1);
    }

    @Test
    public void averagePerDayCheckWR2(){
        WritingResult SusanWR = new WritingResult(0.0,1);
        SusanWR.numWordsList.add(0.0);
        SusanWR.numWordsList.add(0.0);

        assertEquals(0, SusanWR.averagePerDay(), 0.1);
    }

    @Test
    public void averagePerDayCheckWR3(){
        WritingResult SusanWR = new WritingResult(100,1);

        assertEquals(100, SusanWR.averagePerDay(), 0.1);
    }

    //averagePerDayCheckPR

    @Test
    public void averagePerDayCheckPR(){
        PoemResult SusanPR = new PoemResult(0.0,1, 3);
        SusanPR.numWordsList.add(0.0);
        SusanPR.numWordsList.add(0.0);

        assertEquals(0, SusanPR.averagePerDay(), 0.1);
    }

    @Test
    public void averagePerDayCheckPR2(){
        PoemResult SusanPR = new PoemResult(1.0,1, 3);
        SusanPR.numWordsList.add(1.0);
        SusanPR.numWordsList.add(1.0);

        assertEquals(3, SusanPR.averagePerDay(), 0.1);
    }

    @Test
    public void averagePerDayCheckPR3(){
        PoemResult SusanPR = new PoemResult(1.0,1, 3);
        assertEquals(1, SusanPR.averagePerDay(), 0.1);
    }


    //averagePerDayCheckRR
    @Test
    public void averagePerDayCheckRR(){
        BooksRead fiction = new BooksRead(0, "fiction", false);
        BooksRead nonfiction = new BooksRead(0, "non-fiction", false);

        ReadingResult ZachRR = new ReadingResult(1,fiction,nonfiction);

        assertEquals(0, ZachRR.averagePerDay(), 0.1);
    }

    @Test
    public void averagePerDayCheckRR2(){
        BooksRead fiction = new BooksRead(0, "fiction", false);
        BooksRead nonfiction = new BooksRead(0, "non-fiction", false);
        BooksRead HarryPotter = new BooksRead(10000, "fiction", true);
        BooksRead MagicTreeHouse = new BooksRead(10000, "fiction", true);

        ReadingResult ZachRR = new ReadingResult(1,fiction,nonfiction);
        ZachRR.BooksReadList.add(HarryPotter);
        ZachRR.BooksReadList.add(MagicTreeHouse);

        assertEquals(20000, ZachRR.averagePerDay(), 0.1);
    }

    @Test
    public void averagePerDayCheckRR3(){
        BooksRead fiction = new BooksRead(1, "fiction", false);
        BooksRead nonfiction = new BooksRead(1, "non-fiction", false);
        BooksRead HarryPotter = new BooksRead(1, "fiction", true);
        BooksRead MagicTreeHouse = new BooksRead(1, "fiction", true);

        ReadingResult ZachRR = new ReadingResult(1,fiction,nonfiction);
        ZachRR.BooksReadList.add(HarryPotter);
        ZachRR.BooksReadList.add(MagicTreeHouse);

        assertEquals(4, ZachRR.averagePerDay(), 0.1);
    }

    //bestGenreByTypeCheck
    @Test
    public void bestGenreByTypeCheck(){
        BooksRead HarryPotter = new BooksRead(100, "fiction", false);
        BooksRead MagicTreeHouse = new BooksRead(100, "fiction", false);
        BooksRead Educated = new BooksRead(50, "non-fiction", true);
        BooksRead StarWars = new BooksRead(90, "non-fiction", true);
        BooksRead badBook = new BooksRead(0, "non-fiction", true);

        BooksRead fiction = new BooksRead(0, "fiction", false);
        BooksRead nonfiction = new BooksRead(0, "non-fiction", false);

        ReadingResult aRR = new ReadingResult(10,fiction, nonfiction);

        aRR.BooksReadList.add(HarryPotter);
        aRR.BooksReadList.add(MagicTreeHouse);
        aRR.BooksReadList.add(Educated);
        aRR.BooksReadList.add(StarWars);
        aRR.BooksReadList.add(badBook);


        assertTrue(aRR.bestGenreByType(true).equals("fiction"));
    }

    @Test
    public void bestGenreByTypeCheck2(){
        BooksRead HarryPotter = new BooksRead(100, "fiction", true);
        BooksRead MagicTreeHouse = new BooksRead(100, "fiction", true);
        BooksRead Educated = new BooksRead(50, "non-fiction", true);
        BooksRead StarWars = new BooksRead(90, "non-fiction", false);
        BooksRead badBook = new BooksRead(0, "non-fiction", false);

        BooksRead fiction = new BooksRead(0, "fiction", false);
        BooksRead nonfiction = new BooksRead(0, "non-fiction", false);

        ReadingResult aRR = new ReadingResult(10,fiction, nonfiction);

        aRR.BooksReadList.add(HarryPotter);
        aRR.BooksReadList.add(MagicTreeHouse);
        aRR.BooksReadList.add(Educated);
        aRR.BooksReadList.add(StarWars);
        aRR.BooksReadList.add(badBook);


        assertTrue(aRR.bestGenreByType(false).equals("non-fiction"));

    }

    @Test
    public void bestGenreByTypeCheck3() {
        BooksRead HarryPotter = new BooksRead(100, "fiction", false);
        BooksRead MagicTreeHouse = new BooksRead(100, "fiction", false);
        BooksRead Educated = new BooksRead(50, "non-fiction", true);
        BooksRead StarWars = new BooksRead(90, "non-fiction", true);
        BooksRead badBook = new BooksRead(0, "non-fiction", true);

        BooksRead fiction = new BooksRead(0, "fiction", false);
        BooksRead nonfiction = new BooksRead(0, "non-fiction", false);

        ReadingResult aRR = new ReadingResult(10,fiction, nonfiction);



        assertTrue(aRR.bestGenreByType(true).equals("fiction"));

    }


    //readingDNFCheck
    @Test
    public void readingDNFTest1() {
        //Literarian Katie Builder
        BooksRead fiction1 = new BooksRead(15000.0, "fiction", true);
        BooksRead nonFiction1 = new BooksRead(15000.0, "non-fiction", false);
        ReadingResult RRKatie = new ReadingResult(100, fiction1, nonFiction1);
        WritingResult WRKatie = new WritingResult(33333.0, 10);
        ChallengeResult CRKatie = new ChallengeResult(RRKatie, WRKatie);
        Literarian Katie = new Literarian("CRKatie", CRKatie);

        //Literarian Kyle Builder
        BooksRead fiction2 = new BooksRead(15000.0, "fiction", true);
        BooksRead nonFiction2 = new BooksRead(15000.0, "non-fiction", false);
        ReadingResult RRKyle = new ReadingResult(100, fiction2, nonFiction2);
        WritingResult WRKyle = new WritingResult(33333.0, 10);
        ChallengeResult CRKyle = new ChallengeResult(RRKyle, WRKyle);
        Literarian Kyle = new Literarian("CRKyle", CRKyle);


        LinkedList<Literarian> test = new LinkedList<>();


        LitJam LitJam1 = new LitJam(5,test);

        LitJam1.LiterarianList.add(Katie);
        LitJam1.LiterarianList.add(Kyle);


        //assertTrue(penNameList.contains(Katie) && DNFTest1.contains(Kyle));
        assertTrue(LitJam1.readingDNF().contains("CRKyle") && LitJam1.readingDNF().contains("CRKatie"));
    }

    @Test
    public void readingDNFTest2() {
        //Literarian Katie Builder
        BooksRead fiction1 = new BooksRead(0.0, "fiction", true);
        BooksRead nonFiction1 = new BooksRead(0.0, "non-fiction", false);
        ReadingResult RRKatie = new ReadingResult(100, fiction1, nonFiction1);
        WritingResult WRKatie = new WritingResult(0.0, 1);
        ChallengeResult CRKatie = new ChallengeResult(RRKatie, WRKatie);
        Literarian Katie = new Literarian("CRKatie", CRKatie);

        //Literarian Kyle Builder
        BooksRead fiction2 = new BooksRead(0.0, "fiction", true);
        BooksRead nonFiction2 = new BooksRead(0.0, "non-fiction", false);
        ReadingResult RRKyle = new ReadingResult(100, fiction2, nonFiction2);
        WritingResult WRKyle = new WritingResult(0.0, 1);
        ChallengeResult CRKyle = new ChallengeResult(RRKyle, WRKyle);
        Literarian Kyle = new Literarian("CRKyle", CRKyle);

        LinkedList<Literarian> DNFTest1 = new LinkedList<Literarian>();


        LitJam LitJam2 = new LitJam(1,DNFTest1);
        LitJam2.LiterarianList.add(Katie);
        LitJam2.LiterarianList.add(Kyle);



        //assertTrue(penNameList.contains(Katie) && DNFTest1.contains(Kyle));
        assertFalse(LitJam2.readingDNF().contains("CRKyle") && LitJam2.readingDNF().contains("CRKatie"));
    }

    //finalScoreForLiterarianCheck
    @Test
    public void finalScoreForLiterarianCheckDolly() {
        BooksRead fiction3 = new BooksRead(2.25, "fiction", false);
        BooksRead nonFiction3= new BooksRead(5.5, "non-fiction", false);
        ReadingResult RRJohn = new ReadingResult(1, fiction3, nonFiction3);
        WritingResult WRJohn = new WritingResult(1.0, 30);
        ChallengeResult CRJohn = new ChallengeResult(RRJohn, WRJohn);
        Literarian John = new Literarian("John", CRJohn);

        //Literarian Kyle Builder
        BooksRead fiction4 = new BooksRead(15000.0, "fiction", false);
        BooksRead nonFiction4 = new BooksRead(15000.0, "non-fiction", false);
        ReadingResult RRDolly = new ReadingResult(100, fiction4, nonFiction4);
        WritingResult WRDolly = new WritingResult(50333.0, 10);
        ChallengeResult CRDolly = new ChallengeResult(RRDolly, WRDolly);
        Literarian Dolly = new Literarian("Dolly", CRDolly);

        LinkedList<Literarian> finalScoreList = new LinkedList<Literarian>();


        LitJam LitJam2 = new LitJam(5,finalScoreList);
        LitJam2.LiterarianList.add(John);
        LitJam2.LiterarianList.add(Dolly);


        assertEquals(135, LitJam2.finalScoreForLiterarian("Dolly"));
    }

    @Test
    public void finalScoreForLiterarianCheckJohn() {
        BooksRead fiction2 = new BooksRead(2.25, "fiction", true);
        BooksRead nonFiction2= new BooksRead(5.5, "non-fiction", true);
        ReadingResult RRZach = new ReadingResult(1, fiction2, nonFiction2);
        WritingResult WRZach = new WritingResult(1.0, 30);
        ChallengeResult CRZach = new ChallengeResult(RRZach, WRZach);
        Literarian Zach = new Literarian("Zach", CRZach);

        //Literarian Kyle Builder
        BooksRead fiction1 = new BooksRead(15000.0, "fiction", false);
        BooksRead nonFiction1 = new BooksRead(15000.0, "non-fiction", false);
        ReadingResult RRIan = new ReadingResult(100, fiction1, nonFiction1);
        WritingResult WRIan = new WritingResult(50333.0, 10);
        ChallengeResult CRIan = new ChallengeResult(RRIan, WRIan);
        Literarian Ian = new Literarian("Ian", CRIan);

        LinkedList<Literarian> finalScoreList = new LinkedList<Literarian>();


        LitJam LitJam1 = new LitJam(1,finalScoreList);
        LitJam1.LiterarianList.add(Zach);
        LitJam1.LiterarianList.add(Ian);
        assertEquals(30, LitJam1.finalScoreForLiterarian("Zach"));
    }

    //anyImprovementCheck
    @Test
    public void anyImprovementCheck() {
        BooksRead fiction2 = new BooksRead(2.25, "fiction", true);
        BooksRead nonFiction2= new BooksRead(5.5, "non-fiction", true);
        ReadingResult RRZach = new ReadingResult(1, fiction2, nonFiction2);
        WritingResult WRZach = new WritingResult(1.0, 30);
        ChallengeResult CRZach = new ChallengeResult(RRZach, WRZach);
        Literarian Zach = new Literarian("Zach", CRZach);
        //Scored 30 Points

        //Literarian Kyle Builder
        BooksRead fiction1 = new BooksRead(15000.0, "fiction", false);
        BooksRead nonFiction1 = new BooksRead(15000.0, "non-fiction", false);
        ReadingResult RRIan = new ReadingResult(100, fiction1, nonFiction1);
        WritingResult WRIan = new WritingResult(50333.0, 10);
        ChallengeResult CRIan = new ChallengeResult(RRIan, WRIan);
        Literarian Ian = new Literarian("Ian", CRIan);

        LinkedList<Literarian> finalScoreList = new LinkedList<Literarian>();
        finalScoreList.add(Zach);
        finalScoreList.add(Ian);

        LitJam LitJam1 = new LitJam(1,finalScoreList);

        BooksRead fiction3 = new BooksRead(2.25, "fiction", true);
        BooksRead nonFiction3= new BooksRead(5.5, "non-fiction", true);
        ReadingResult RRZach2 = new ReadingResult(1, fiction3, nonFiction3);
        WritingResult WRZach2 = new WritingResult(50500, 30);
        ChallengeResult CRZach2 = new ChallengeResult(RRZach2, WRZach2);
        Literarian Zach2 = new Literarian("Zach", CRZach2);
        //Scores 55 Points

        //Literarian Kyle Builder
        BooksRead fiction5 = new BooksRead(15000.0, "fiction", false);
        BooksRead nonFiction5 = new BooksRead(15000.0, "non-fiction", false);
        ReadingResult RRIan2 = new ReadingResult(100, fiction5, nonFiction5);
        WritingResult WRIan2 = new WritingResult(50333.0, 10);
        ChallengeResult CRIan2 = new ChallengeResult(RRIan2, WRIan2);
        Literarian Ian2 = new Literarian("Ian", CRIan2);

        LinkedList<Literarian> finalScoreList2 = new LinkedList<Literarian>();
        finalScoreList2.add(Zach2);
        finalScoreList2.add(Ian2);

        LitJam LitJam2 = new LitJam(1,finalScoreList2);

        assertTrue(LitJam2.anyImprovement(LitJam1));

    }

    @Test
    public void anyImprovementCheck2() {
        BooksRead fiction2 = new BooksRead(2.25, "fiction", true);
        BooksRead nonFiction2= new BooksRead(5.5, "non-fiction", true);
        ReadingResult RRZach = new ReadingResult(1, fiction2, nonFiction2);
        WritingResult WRZach = new WritingResult(1.0, 30);
        ChallengeResult CRZach = new ChallengeResult(RRZach, WRZach);
        Literarian Zach = new Literarian("Zach", CRZach);
        //Scored 30 Points

        //Literarian Kyle Builder
        BooksRead fiction1 = new BooksRead(15000.0, "fiction", false);
        BooksRead nonFiction1 = new BooksRead(15000.0, "non-fiction", false);
        ReadingResult RRIan = new ReadingResult(100, fiction1, nonFiction1);
        WritingResult WRIan = new WritingResult(50333.0, 10);
        ChallengeResult CRIan = new ChallengeResult(RRIan, WRIan);
        Literarian Ian = new Literarian("Ian", CRIan);

        LinkedList<Literarian> finalScoreList = new LinkedList<Literarian>();
        finalScoreList.add(Zach);
        finalScoreList.add(Ian);

        LitJam LitJam1 = new LitJam(1,finalScoreList);

        BooksRead fiction3 = new BooksRead(2.25, "fiction", true);
        BooksRead nonFiction3= new BooksRead(5.5, "non-fiction", true);
        ReadingResult RRZach2 = new ReadingResult(1, fiction3, nonFiction3);
        WritingResult WRZach2 = new WritingResult(50500, 30);
        ChallengeResult CRZach2 = new ChallengeResult(RRZach2, WRZach2);
        Literarian Zach2 = new Literarian("Zach", CRZach2);
        //Scores 55 Points

        //Literarian Kyle Builder
        BooksRead fiction5 = new BooksRead(15000.0, "fiction", false);
        BooksRead nonFiction5 = new BooksRead(15000.0, "non-fiction", false);
        ReadingResult RRIan2 = new ReadingResult(100, fiction5, nonFiction5);
        WritingResult WRIan2 = new WritingResult(50333.0, 10);
        ChallengeResult CRIan2 = new ChallengeResult(RRIan2, WRIan2);
        Literarian Ian2 = new Literarian("Ian", CRIan2);

        LinkedList<Literarian> finalScoreList2 = new LinkedList<Literarian>();
        finalScoreList2.add(Zach2);
        finalScoreList2.add(Ian2);

        LitJam LitJam2 = new LitJam(1,finalScoreList2);

        assertFalse(LitJam1.anyImprovement(LitJam2));

    }
}

