/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nf;

/**
 * Genre d'un patient
 * @author Mathilde
 */
public enum Genre {

    /**
     * Genre Masculin
     */
    H("masculin"),

    /**
     * genre féminin
     */
    F("feminin"),

    /**
     * autre genre
     */
    Autre("autre");

    Genre(String s) {
        this.s=s;
    }
    String s;
}
