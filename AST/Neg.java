 
package AST;

public class Neg extends ExpressionA {

public ExpressionA arg;

public Neg(ExpressionA arg) {
  this.arg = arg;
}

public String toString() {
  return String.format("neg(%1$s)", arg.toString());
}
 

        public String toAssembly(){
          String resultat="";
          resultat+=arg.toAssembly();
          if(arg instanceof Bool){
            resultat+="BoToNb\n";
          }
          resultat+="NegaNb\n" ;
          return resultat;
      }
      

}	

  