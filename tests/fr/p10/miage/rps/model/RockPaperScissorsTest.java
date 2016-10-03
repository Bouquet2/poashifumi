package fr.p10.miage.rps.model;

import org.testng.annotations.*;

import static org.testng.Assert.*;

/**
 * Created by vabouque on 03/10/2016.
 */
public class RockPaperScissorsTest {

    RockPaperScissors rps;

    @BeforeMethod
    public void setUp() throws Exception {
        rps = new RockPaperScissors();
    }

    @AfterMethod
    public void tearDown() throws Exception {
        rps = null;
    }

    /*
    @Parameters({"rock", "rock"})
    @Test
    public void testTIEPlay(String p1, String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.TIE);
    }

    @Parameters({"paper", "paper"})
    @Test
    public void testTIEPlay2(String p1, String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.TIE);
    }

    @Parameters({"scissors", "scissors"})
    @Test
    public void testTIEPlay3(String p1, String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.TIE);
    }

    @Parameters({"rock", "scissors"})
    @Test
    public void testWinPlay(String p1, String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.WIN);
    }

    @Parameters({"paper", "rock"})
    @Test
    public void testWinPlay2(String p1, String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.WIN);
    }

    @Parameters({"scissors", "paper"})
    @Test
    public void testWinPlay3(String p1, String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.WIN);
    }

    @Parameters({"rock", "paper"})
    @Test
    public void testLOSTPlay(String p1, String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.LOST);
    }

    @Parameters({"paper", "scissors"})
    @Test
    public void testLostPlay2(String p1, String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.LOST);
    }

    @Parameters({"scissors", "rock"})
    @Test
    public void testLostPlay3(String p1, String p2) throws Exception {
        assertEquals(rps.play(RPSEnum.valueOf(p1), RPSEnum.valueOf(p2)), Result.LOST);
    }
    */

    @DataProvider(name="winData")
    public Object[][] createWinData() {
        return new Object [][] {
                {RPSEnum.ROCK, RPSEnum.SCISSORS},
                {RPSEnum.SCISSORS, RPSEnum.PAPER},
                {RPSEnum.PAPER, RPSEnum.ROCK}
        };
    }

    @DataProvider(name="lostData")
    public Object[][] createLostData() {
        return new Object [][] {
                {RPSEnum.SCISSORS, RPSEnum.ROCK},
                {RPSEnum.PAPER, RPSEnum.SCISSORS},
                {RPSEnum.ROCK, RPSEnum.PAPER}
        };
    }

    @DataProvider(name="tieData")
    public Object[][] createTieData() {
        return new Object [][] {
                {RPSEnum.ROCK, RPSEnum.ROCK},
                {RPSEnum.SCISSORS, RPSEnum.SCISSORS},
                {RPSEnum.PAPER, RPSEnum.PAPER}
        };
    }

    @Test(dataProvider = "winData")
    void testWinPlayDataProvider(RPSEnum p1, RPSEnum p2) {
        assertEquals(rps.play(p1, p2), Result.WIN);
    }

    @Test(dataProvider = "lostData")
    void testLostDataProvider(RPSEnum p1, RPSEnum p2) {
        assertEquals(rps.play(p1, p2), Result.LOST);
    }

    @Test(dataProvider = "tieData")
    void testTieDataProvider(RPSEnum p1, RPSEnum p2) {
        assertEquals(rps.play(p1, p2), Result.TIE);
    }

}

