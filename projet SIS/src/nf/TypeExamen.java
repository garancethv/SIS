package nf;

/**
 * Donne le type d'examen
 * @author Mathilde
 */
public enum TypeExamen {

    /**
     * type d'examen IRM
     */
    IRM("irm"),

    /**
     * type d'examen radiographie
     */
    RADIOGRAPHIE("radiographie"),

    /**
     *type d'examen scanner
     */
    SCANNER("scanner");

    TypeExamen(String s) {
        this.s = s;
    }
    String s;
}
