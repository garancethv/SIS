
package nf;

/**
 * Créer une instance de secrétaire
 * @author Mathilde
 */
public class Secretaire extends Personnel{
    
    /**
     * Contructeur de la classe Secrétaire et initialisation avec la classe Personnel
     * @param nom
     * @param prenom
     * @param id
     * @param mdp
     */
    public Secretaire(String nom, String prenom,int id, String mdp) {
        super(nom,prenom,id,mdp);
    }   
}