

package nf;

/**
 *
 * @author Mathilde
 */
public class PH extends Personnel{
    
    private int isChef;
    
    public PH(String nom, String prenom,int id, String mdp, int isChef) {
        super(nom,prenom,id,mdp);
        this.isChef = isChef;
    }
    
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