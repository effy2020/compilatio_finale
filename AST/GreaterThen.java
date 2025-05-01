package AST;

public class GreaterThen extends ExpressionA_Binaire{
    public GreaterThen(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "GrStlNb";};
    public String toAssembly(){
        //faire le cast vers eniter 
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
    resultat += "GrStNb\n";

    return resultat;
             
}
}
 