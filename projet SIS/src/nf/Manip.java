
package nf;

/**
 *
 * @author Mathilde
 */
public class Manip extends Personnel{
    private String nom;
    private String prenom;
    private int id;
    private String mdp;

    public Manip(String nom, String prenom,int id, String mdp) {
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