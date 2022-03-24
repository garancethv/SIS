

package nf;

/**
 * Créer une instance de Ph
 * @author Mathilde
 */
public class PH extends Personnel{
    
    private int isChef;
    
    /**
     * Contructeur de la classe PH et initialisation avec la classe Personnel
     * @param nom
     * @param prenom
     * @param id
     * @param mdp
     * @param isChef
     */
    public PH(String nom, String prenom,int id, String mdp, int isChef) {
        super(nom,prenom,id,mdp);
        this.isChef = isChef;
    }
    
    /**
     * renvoie le fait s'il est chef ou non
     * @return
     */
    public int getIsChef(){
        return isChef;
    }
    
    
    ////////////////////////CODE EN PLUS
    
    
    public String toString() {
        return "Dr " + super.getPrenom() + " " + super.getNom();
    }

    //Verification que l’objet passe en parametre est bien une instance de Medecin avant de comparer avec le medecin courant
    public boolean equals(Object o) {
        if (o instanceof PH) {
            PH ph = (PH) o;
            return super.getNom().equals(ph.getNom()) && super.getPrenom().equals(ph.getPrenom());
        } else {
            return false;
        }
    }
}