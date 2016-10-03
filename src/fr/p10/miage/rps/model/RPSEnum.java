package fr.p10.miage.rps.model;

/**
 * Created by vabouque on 03/10/2016.
 */
public enum RPSEnum {
    ROCK,
    PAPER,
    SCISSORS;

    public static RPSEnum getRandom() {
        return values()[(int) (Math.random() * values().length)];
    }
}
