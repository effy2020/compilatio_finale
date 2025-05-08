package AST;

public class Affectation extends ExpressionA_Binaire{
    public String identifient;
    public Affectation(String identifient,ExpressionA droite) {
        super(null, droite);
        this.identifient=identifient;}

    public String symbole() {return "Affect";};
    public String toString() {
        return String.format("%1$s(%2$s,%3$s)", symbole(), identifient, droite.toString());
    }
}
