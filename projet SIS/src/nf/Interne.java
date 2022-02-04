/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nf;

/**
 *
 * @author Mathilde
 */
public class Interne extends Personnel {
    private String nom;
    private String prenom;
    private int id;
    private String mdp;

    public Interne(String nom, String prenom,int id, String mdp) {
        super(nom,prenom,id,mdp);
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMdp() {
        return mdp;
    }
}