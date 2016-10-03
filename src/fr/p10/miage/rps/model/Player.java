package fr.p10.miage.rps.model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by vabouque on 03/10/2016.
 */
public class Player {

    private String              nom;
    private Integer             score;
    private ArrayList<RPSEnum>  mouvements;
    private Integer             prochainMouv;
    static Integer              maxRand = 20;

    public Player(String nom) {
        Integer rand = (int) Math.random() * maxRand;
        this.prochainMouv = 0;
        this.mouvements = new ArrayList<RPSEnum>(rand);
        for(RPSEnum mouvement : mouvements) {
            mouvement = RPSEnum.getRandom();
        }
        this.nom = nom;
    }

    public Player(String nom, ArrayList<RPSEnum> mouvements) {
        this.nom = nom;
        this.mouvements = mouvements;
        this.prochainMouv = 0;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getNom() {
        return nom;
    }

    public Integer getScore() {
        return score;
    }

    public Integer getNbMouvements() {
        return this.mouvements.size();
    }

    public RPSEnum getNextMove() {
        prochainMouv++;
        if(prochainMouv == mouvements.size()) {
            return null;
        }
        return mouvements.get(prochainMouv-1);
    }


}
