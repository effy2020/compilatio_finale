package AST;

public class Affectation extends ExpressionA_Unaire {

    public Affectation(String identifient, ExpressionA exp) {
        super( identifient,exp);
    }

    public String symbole() {
        return "Affect";
    }
    public String toAssembly(){

        String resultat="";
        resultat+=exp.toAssembly();

        resultat += "SetVar " + identifient + "\n";
        if(exp instanceof Plus || exp instanceof Moins || exp instanceof Mult || exp instanceof Div
                || exp instanceof GreaterThen || exp instanceof GreaterOrEqual || exp instanceof LessThen
        || exp instanceof LessOrEqual || exp instanceof NotEquals || exp instanceof Not
        || exp instanceof Equals || exp instanceof Neg || exp instanceof AndExpression
                || exp instanceof Affectation) {
            resultat += "GetVar " + identifient + "\n";
        }



        return resultat;
    }

}
