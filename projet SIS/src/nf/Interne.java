/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nf;

/**
 * Créer une instance d'Interne
 * @author Mathilde
 */
public class Interne extends Personnel {

    /**
     * Contructeur de la classe Interne et initialisation avec la classe Personnel
     * @param nom
     * @param prenom
     * @param id
     * @param mdp
     */
    public Interne(String nom, String prenom,int id, String mdp) {
        super(nom,prenom,id,mdp);
    }   
}