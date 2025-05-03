package AST;

public class Expr_Pt_Virg extends CommandA{

    public ExpressionA exp;
    public String importCmd;

public Expr_Pt_Virg(ExpressionA exp) {
  this.exp = exp;
  this.importCmd = null;
}
public Expr_Pt_Virg(String importCmd) {
  this.exp = null;
  this.importCmd = importCmd;
}

public String toString() {
  return importCmd != null ? importCmd + ";" 
                         : exp.toString() + ";";
}

 

 
}