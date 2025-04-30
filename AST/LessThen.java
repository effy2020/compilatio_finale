
package AST;

public class LessThen extends ExpressionA_Binaire{
    public LessThen(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "LoStlNb";};
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
    resultat += "LoStNb\n";

    return resultat;
             
        }   
}
 