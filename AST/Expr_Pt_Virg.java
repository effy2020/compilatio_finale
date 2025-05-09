package AST;

public class Expr_Pt_Virg extends CommandA{


    private ExpressionA exp;
    private String importCmd;

    public Expr_Pt_Virg(ExpressionA exp) {
        this.exp = exp;
        this.importCmd = null;
    }

    public Expr_Pt_Virg(String importCmd) {
        this.exp = new Expression_Import(importCmd);
        this.importCmd = importCmd;
    }

    public String toString() {
        return importCmd != null ? importCmd + ";"
                : exp != null ? exp.toString() + ";"
                : "";
    }
}