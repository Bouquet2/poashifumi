package fr.p10.miage.rps.model;

import org.testng.annotations.*;
import org.testng.internal.junit.ArrayAsserts;

import java.util.ArrayList;

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

    @DataProvider(name="winData")
    public Object[][] createWinData() {
        return new Object [][] {
                {RPSEnum.ROCK, RPSEnum.SCISSORS},
                {RPSEnum.SCISSORS, RPSEnum.PAPER},
                {RPSEnum.PAPER, RPSEnum.ROCK}
        };
    }

    @Test(dataProvider = "winData")
    void testWinPlayDataProvider(RPSEnum p1, RPSEnum p2) {
        assertEquals(rps.play(p1, p2), Result.WIN);
    }

    @DataProvider(name="lostData")
    public Object[][] createLostData() {
        return new Object [][] {
                {RPSEnum.SCISSORS, RPSEnum.ROCK},
                {RPSEnum.PAPER, RPSEnum.SCISSORS},
                {RPSEnum.ROCK, RPSEnum.PAPER}
        };
    }

    @Test(dataProvider = "lostData")
    void testLostDataProvider(RPSEnum p1, RPSEnum p2) {
        assertEquals(rps.play(p1, p2), Result.LOST);
    }

    @DataProvider(name="tieData")
    public Object[][] createTieData() {
        return new Object [][] {
                {RPSEnum.ROCK, RPSEnum.ROCK},
                {RPSEnum.SCISSORS, RPSEnum.SCISSORS},
                {RPSEnum.PAPER, RPSEnum.PAPER}
        };
    }

    @Test(dataProvider = "tieData")
    void testTieDataProvider(RPSEnum p1, RPSEnum p2) {
        assertEquals(rps.play(p1, p2), Result.TIE);
    }

    @DataProvider(name="playerWin")
    public Object[][] createWinGame() {
        return new Object [][]{
                {new Player("Jean", new ArrayList<RPSEnum>() {{
                    add(RPSEnum.PAPER);
                    add(RPSEnum.ROCK);
                    add(RPSEnum.SCISSORS);
                }}),
                        new Player("Jean", new ArrayList<RPSEnum>() {{
                            add(RPSEnum.PAPER);
                            add(RPSEnum.SCISSORS);
                            add(RPSEnum.PAPER);
                        }})
                }
        };
    }

    @Test(dataProvider = "playerWin")
    void testWinGame(Player p1, Player p2) throws Exception{
        assertEquals(rps.play(p1, p2), Result.WIN);
    }

    @DataProvider(name="playerLost")
    public Object[][] createLostGame() {
        return new Object [][]{
                {new Player("Jean", new ArrayList<RPSEnum>() {{
                    add(RPSEnum.SCISSORS);
                    add(RPSEnum.PAPER);
                    add(RPSEnum.SCISSORS);
                }}),
                        new Player("Jean", new ArrayList<RPSEnum>() {{
                            add(RPSEnum.ROCK);
                            add(RPSEnum.PAPER);
                            add(RPSEnum.ROCK);
                        }})
                }
        };
    }

    @Test(dataProvider = "playerLost")
    void testLostGame(Player p1, Player p2) throws Exception{
        assertEquals(rps.play(p1, p2), Result.LOST);
    }

    @DataProvider(name="playerTie")
    public Object[][] createTieGame() {
        return new Object [][]{
                {new Player("Jean", new ArrayList<RPSEnum>() {{
                    add(RPSEnum.PAPER);
                    add(RPSEnum.ROCK);
                    add(RPSEnum.ROCK);
                }}),
                        new Player("Jean", new ArrayList<RPSEnum>() {{
                            add(RPSEnum.SCISSORS);
                            add(RPSEnum.ROCK);
                            add(RPSEnum.SCISSORS);
                        }})
                }
        };
    }

    @Test(dataProvider = "playerTie")
    void testTieGame(Player p1, Player p2) throws Exception{
        assertEquals(rps.play(p1, p2), Result.TIE);
    }
    /*
    void testLostPlay(Player p1, Player p2) throws Exception{
        assertEquals(rps.play(p1, p2), Result.LOST);
    }

    void testTiePlay(Player p1, Player p2) throws Exception{
        assertEquals(rps.play(p1, p2), Result.TIE);
    }
    */

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

}

