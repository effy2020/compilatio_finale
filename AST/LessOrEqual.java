
package AST;

public class LessOrEqual extends ExpressionA_Binaire{
    public LessOrEqual(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "LoEqlNb";};
      public String toAssembly(){
           String resultat = "";
    resultat += gauche.toAssembly();
    if (gauche instanceof Equals || gauche instanceof NotEquals ||
        gauche instanceof LessThen || gauche instanceof GreaterThen ||
        gauche instanceof LessOrEqual || gauche instanceof GreaterOrEqual ||
        gauche instanceof Not || gauche instanceof Bool) {
        resultat += "BoToNb\n";
    }

    resultat += droite.toAssembly();
    if (droite instanceof Equals ||droite instanceof NotEquals ||
    droite instanceof LessThen ||droite instanceof GreaterThen ||
    droite instanceof LessOrEqual ||droite instanceof GreaterOrEqual ||
    droite instanceof Not || droite instanceof Bool) {
        resultat += "BoToNb\n";
    }
    resultat += "LoEqNb\n";

    return resultat;
        
        }  
}
 