 
package AST;

public class Mult extends ExpressionA_Binaire {

public Mult(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

public String symbole() {return "fois";}; 

 
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
    resultat += "MultNb\n";

    return resultat;
}
          
        }



 