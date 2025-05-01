 
package AST;

public class Plus extends ExpressionA_Binaire {

public Plus(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
public String symbole() {return "plus";}; 
 
public String toAssembly(){
    //faire le cast vers eniter 
    String resultat = "";
    //on rajoute seulement les operateurs qui peuvent nous donner un boolean en resultat
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
    resultat += "AddiNb\n";

    return resultat;
}

}

  
