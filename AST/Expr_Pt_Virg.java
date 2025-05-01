package AST;

public class Expr_Pt_Virg extends CommandA{

    public ExpressionA exp;

public Expr_Pt_Virg(ExpressionA exp) {
  this.exp = exp;
}

public String toString() {
 
  return String.format("exp(%1$s)", exp.toString() + ";");
}

 

public String toAssembly(){
    return exp.toAssembly();
}
}
 

 