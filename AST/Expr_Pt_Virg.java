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
return importCmd != null ? importCmd + ";" : String.format("exp(%1$s)", exp.toString() + ";") ;
}
//genere drop a la fin de chaque instruction (une seule)
  // Version avec paramètre booléen
  public String toAssembly(boolean isLastCommand) {
    String asm;
    if(this.importCmd!=null){
      asm="import malib\n";
    }
    else{
      asm = exp.toAssembly() + "Drop\n";
      if (isLastCommand) {
          asm += "Halt\n";
      }
    }
   
    return asm;
 
}

// Version sans paramètre (optionnelle)
public String toAssembly() {
    return toAssembly(false); // Par défaut sans Halt
}
}
 

 