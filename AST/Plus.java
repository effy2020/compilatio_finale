 
package AST;

public class Plus extends ExpressionA_Binaire {

public Plus(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
public String symbole() {return "plus";}; 
 
public String toAssembly(){
    //faire le cast vers eniter 
    String resultat = "";
    resultat += gauche.toAssembly();
    if (gauche instanceof Bool) {
        resultat += "BoToNb\n";
    }

    resultat += droite.toAssembly();
    if (droite instanceof Bool) {
        resultat += "BoToNb\n";
    }
    resultat += "AddiNb\n";

    return resultat;
}

}

 
