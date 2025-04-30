
package AST;

public class LessOrEqual extends ExpressionA_Binaire{
    public LessOrEqual(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "LoEqlNb";};
      public String toAssembly(){
           String resultat = "";
    resultat += gauche.toAssembly();
    if (gauche instanceof Bool) {
        resultat += "BoToNb\n";
    }

    resultat += droite.toAssembly();
    if (droite instanceof Bool) {
        resultat += "BoToNb\n";
    }
    resultat += "LoEqNb\n";

    return resultat;
        
        }  
}
 