package nf;

/**
 *
 * @author Mathilde
 */
public class Personnel {

    private String nom;
    private String prenom;
    private int id;
    private String mdp;

    public Personnel(String nom, String prenom, int id, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.mdp = mdp;
    }

    /*public String getMetier() {
        if (this instanceof Medecin) {
            return "MEDECIN";
        } else if (this instanceof SecretaireAdministration) {
            return "SECRETAIRE ADMINISTRATIVE";
        } else {
            return "SECRETAIRE MEDICALE";
        }
    }*/

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getMdp() {
        return mdp;
    }

    public int getId() {
        return id;
    }
}
