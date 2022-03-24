
package nf;

/**
 * Créer une instance de manipulateur radio
 * @author Mathilde
 */
public class Manip extends Personnel{

    /**
     *Contructeur de la classe Manip d'un manipulateur radio et initialisation avec la classe Personnel
     * @param nom
     * @param prenom
     * @param id
     * @param mdp
     */
    public Manip(String nom, String prenom,int id, String mdp) {
        super(nom,prenom,id,mdp);
    }
}