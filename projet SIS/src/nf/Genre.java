/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nf;

/**
 *
 * @author Mathilde
 */
public enum Genre {
    H("masculin"),
    F("feminin"),
    Autre("autre");

    Genre(String s) {
        this.s=s;
    }
    String s;
    
    String getS() {
        return s;
    }
}
