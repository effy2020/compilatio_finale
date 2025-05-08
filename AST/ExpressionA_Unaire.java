
package AST;

 abstract class ExpressionA_Unaire extends ExpressionA {
    ExpressionA exp;
    String identifient;

    public ExpressionA_Unaire(String identifient, ExpressionA exp) {
        this.exp = exp;
        this.identifient = identifient;
    }

    abstract String symbole();

    public String toString() {
        return String.format("%1$s(%2$s,%3$s)", this.symbole(), this.identifient, this.exp.toString());
    }
}
