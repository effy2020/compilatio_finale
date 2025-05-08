package AST;

public class Affectation extends ExpressionA {
    public String identifient;
    public ExpressionA droite;

    public Affectation(String identifient, ExpressionA droite) {
        this.identifient = identifient;
        this.droite = droite;
    }

    public String symbole() {
        return "Affect";
    }

    public String toString() {
        return String.format("%s(%s,%s)", symbole(), identifient, droite);
    }
}
