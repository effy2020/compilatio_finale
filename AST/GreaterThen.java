package AST;

public class GreaterThen extends ExpressionA_Binaire{
    public GreaterThen(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "GrStlNb";};
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
    resultat += "GrStNb\n";

    return resultat;
             
}
}
 