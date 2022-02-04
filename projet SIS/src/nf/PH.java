/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fc;

/**
 *
 * @author Mathilde
 */
public class PH extends Personnel{
    private String nom;
    private String prenom;
    private int id;
    private String mdp;
    private boolean isChef;

    public PH(String nom, String prenom,int id, String mdp, boolean isChef) {
        super(nom,prenom,id,mdp);
        this.isChef = isChef;
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
    
    public boolean isChef(){
        return isChef;
    }
    
    
    ////////////////////////CODE EN PLUS
    
    
    public String toString() {
        return "Dr " + prenom + " " + nom;
    }

    //Verification que l’objet passe en parametre est bien une instance de Medecin avant de comparer avec le medecin courant
    public boolean equals(Object o) {
        if (o instanceof PH) {
            PH ph = (PH) o;
            return nom.equals(ph.nom) && prenom.equals(ph.prenom);
        } else {
            return false;
        }
    }
}