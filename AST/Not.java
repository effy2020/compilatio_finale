package AST;

public class Not extends ExpressionA {

public ExpressionA arg;

public Not(ExpressionA arg) {
  this.arg = arg;
}

public String toString() {
  return String.format("not(%1$s)", arg.toString());
}
   public String toAssembly(){
    String resultat="";
    resultat+=arg.toAssembly();
    if(arg instanceof Num || arg instanceof Neg || arg instanceof Plus || arg instanceof Moins
    || arg instanceof Mult || arg instanceof Div){
      resultat+="NbToBe \n";
    }
    resultat+="Not\n";
    return resultat;
      } 
}	