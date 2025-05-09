package AST;

public class Expr_Pt_Virg extends CommandA{


    private ExpressionA exp;


    public Expr_Pt_Virg(ExpressionA exp) {
        this.exp = exp;
    }

    public String toString() {
        return exp.toString() + ";";
    }
}