 
package AST;

public class Mult extends ExpressionA_Binaire {

public Mult(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

public String symbole() {return "fois";}; 

 
        public String toAssembly(){
                        String resultat = "";
    resultat += gauche.toAssembly();
    if (gauche instanceof Bool || gauche instanceof Equals || gauche instanceof NotEquals ||
        gauche instanceof LessThen || gauche instanceof GreaterThen ||
        gauche instanceof LessOrEqual || gauche instanceof GreaterOrEqual ||
        gauche instanceof Not ) {
        resultat += "BoToNb\n";
    }

    resultat += droite.toAssembly();
    if (droite instanceof Bool || droite instanceof Equals ||droite instanceof NotEquals ||
    droite instanceof LessThen ||droite instanceof GreaterThen ||
    droite instanceof LessOrEqual ||droite instanceof GreaterOrEqual ||
    droite instanceof Not  ) {
        resultat += "BoToNb\n";
    }
    resultat += "MultNb\n";

    return resultat;
}
          
        }



 