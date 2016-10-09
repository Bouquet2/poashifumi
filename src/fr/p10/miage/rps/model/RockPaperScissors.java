package fr.p10.miage.rps.model;

import com.sun.org.apache.regexp.internal.RE;
import fr.p10.miage.rps.model.Result;

/**
 * Created by vabouque on 03/10/2016.
 */
public class RockPaperScissors {

    public RockPaperScissors() {
    }

    public Result play(RPSEnum p1, RPSEnum p2) {
        if(p1.equals(p2)) return Result.TIE;
        if(p1.equals(RPSEnum.PAPER)) {
            if(p2.equals(RPSEnum.ROCK)) return Result.WIN;
        }
        if(p1.equals(RPSEnum.SCISSORS)) {
            if(p2.equals(RPSEnum.PAPER)) return Result.WIN;
        }
        if(p1.equals(RPSEnum.ROCK)) {
            if(p2.equals(RPSEnum.SCISSORS)) return Result.WIN;
        }
        return Result.LOST;
    }

    public Result play(Player p1, Player p2) throws Exception{
        if(p1.getNbMouvements() != p2.getNbMouvements()) {
            throw new Exception(); //TODO Class exception
        }
        int tour = 0;
        while( tour < p1.getNbMouvements() ) {
            RPSEnum mouvP1 = p1.getNextMove();
            RPSEnum mouvP2 = p2.getNextMove();
            if(play(mouvP1, mouvP2).equals(Result.WIN)) {
                p1.setScore(p1.getScore() + 1);
            }
            if(play(mouvP1, mouvP2).equals(Result.LOST)) {
                p2.setScore(p2.getScore() + 1);
            }
            if(play(mouvP1, mouvP2).equals(Result.TIE)) {
                p1.setScore(p1.getScore() + 1);
                p2.setScore(p2.getScore() + 1);
            }
            tour++;
        }
        if(p1.getScore() > p2.getScore()) {
            return Result.WIN;
        }
        if(p1.getScore() < p2.getScore()) {
            return Result.LOST;
        }
        return Result.TIE;
    }
}
