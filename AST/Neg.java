 
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
          if(arg instanceof Equals || arg instanceof NotEquals ||
        arg instanceof LessThen || arg instanceof GreaterThen ||
        arg instanceof LessOrEqual || arg instanceof GreaterOrEqual ||
        arg instanceof Not || arg instanceof Bool) {
      
            resultat+="BoToNb\n";
          }
          else if(arg instanceof Identifient) {
            //ici on va rajouter la logique de type of
            resultat+="TypeOf \nCase 1\nBoToNb\n";

          }
          resultat+="NegaNb\n" ;
          return resultat;
      }


}	

  