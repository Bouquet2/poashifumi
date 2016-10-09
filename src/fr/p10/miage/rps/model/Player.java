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

    public Player(String nom) {
        this.nom = nom;
        this.prochainMouv = 0;
        this.score = 0;

        final Integer nbMouv = 20;
        this.mouvements = new ArrayList<RPSEnum>(nbMouv);
        for(RPSEnum mouvement : mouvements) {
            mouvement = RPSEnum.getRandom();
        }
    }

    public Player(String nom, ArrayList<RPSEnum> mouvements) {
        this.nom = nom;
        this.mouvements = mouvements;
        this.prochainMouv = 0;
        this.score = 0;
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

    public RPSEnum getNextMove() throws Exception{
        if(prochainMouv == mouvements.size()) {
            throw new Exception("getNextMove error : " +
                    "Il n'y a plus de mouvement disponibles " +
                    "(Mouvement actuel : " + prochainMouv +
                    " Dernier mouvement : " + mouvements.size());
        }
        return mouvements.get(prochainMouv++);
    }


}
