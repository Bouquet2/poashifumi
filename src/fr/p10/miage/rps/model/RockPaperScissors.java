package fr.p10.miage.rps.model;

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
}
