package AST;

public class GreaterOrEqual extends ExpressionA_Binaire{
    public GreaterOrEqual(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "GrEqlNb";}; 

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
    resultat += "GrEqNb\n";

    return resultat;
       
        }
}
 