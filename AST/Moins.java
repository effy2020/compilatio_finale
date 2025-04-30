 
package AST;

public class Moins extends ExpressionA_Binaire {

public Moins(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

public String symbole() {return "moins";}; 
 
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
    resultat += "SubiNb\n";

    return resultat;
}
          
}


 