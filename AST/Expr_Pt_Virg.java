package AST;

public class Expr_Pt_Virg extends CommandA{

    public ExpressionA exp;

public Expr_Pt_Virg(ExpressionA exp) {
  this.exp = exp;
}

public String toString() {
 
  return String.format("exp(%1$s)", exp.toString() + ";");
}
//genere drop a la fin de chaque instruction (une seule)
  // Version avec paramètre booléen
  public String toAssembly(boolean isLastCommand) {
    String asm = exp.toAssembly() + "Drop\n";
    if (isLastCommand) {
        asm += "Halt\n";
    }
    return asm;
}

// Version sans paramètre (optionnelle)
public String toAssembly() {
    return toAssembly(false); // Par défaut sans Halt
}
}
 

 