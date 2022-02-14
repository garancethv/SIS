package nf;

/**
 *
 * @author Mathilde
 */
public enum TypeExamen {
    IRM("irm"),
    RADIO("radiographie"),
    SCANNER("scanner");

    TypeExamen(String s) {
        this.s = s;
    }
    String s;
}
