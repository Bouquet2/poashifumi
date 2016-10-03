package fr.p10.miage.rps.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

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

}

