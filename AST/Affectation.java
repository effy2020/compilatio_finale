package AST;

public class Affectation extends ExpressionA_Unaire {

    public Affectation(String identifient, ExpressionA exp) {
        super( identifient,exp);
    }

    public String symbole() {
        return "Affect";
    }


}
