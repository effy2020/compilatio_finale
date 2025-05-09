 
package AST;

public class Moins extends ExpressionA_Binaire {

public Moins(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

public String symbole() {return "moins";}; 
 
        public String toAssembly(){
              String resultat = "";
    resultat += gauche.toAssembly();
    if (gauche instanceof Bool || gauche instanceof Equals || gauche instanceof NotEquals ||
        gauche instanceof LessThen || gauche instanceof GreaterThen ||
        gauche instanceof LessOrEqual || gauche instanceof GreaterOrEqual ||
        gauche instanceof Not ) {
        resultat += "BoToNb\n";
    }else if(gauche instanceof Identifient) {
        //ici on va rajouter la logique de type of
        resultat+="TypeOf \nCase 1\nBoToNb\n";

    }

    resultat += droite.toAssembly();
    if (droite instanceof Bool || droite instanceof Equals ||droite instanceof NotEquals ||
    droite instanceof LessThen ||droite instanceof GreaterThen ||
    droite instanceof LessOrEqual ||droite instanceof GreaterOrEqual ||
    droite instanceof Not  ) {
        resultat += "BoToNb\n";
    }else if(droite instanceof Identifient) {
        //ici on va rajouter la logique de type of
        resultat+="TypeOf \nCase 1\nBoToNb\n";

    }
    resultat += "SubiNb\n";

    return resultat;
}

}


 