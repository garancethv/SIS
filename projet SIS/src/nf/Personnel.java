package nf;

/**
 * Créer une instance de Personnel
 * @author Mathilde
 */
public class Personnel {

    private String nom;
    private String prenom;
    private int id;
    private String mdp;

    /**
     * Constructeur de la classe Personnel
     * @param nom
     * @param prenom
     * @param id
     * @param mdp
     */
    public Personnel(String nom, String prenom, int id, String mdp) {
        this.nom = nom;
        this.prenom = prenom;
        this.id = id;
        this.mdp = mdp;
    }

    @Override
    public String toString() {
        return "Personnel {" + "nom = " + nom + ", prénom = " + prenom + ", id = " + id + '}';
    }

    

    /**
     * renvoie le nom du PH
     * @return
     */
    

    public String getNom() {
        return nom;
    }

    /**
     * Renvoie le prénom du PH
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     * Renvoie le mot de passe du PH
     * @return
     */
    public String getMdp() {
        return mdp;
    }

    /**
     * Renvoie l'identifiant du PH
     * @return
     */
    public int getId() {
        return id;
    }
}
