package AST;

public class GreaterThen extends ExpressionA_Binaire{
    public GreaterThen(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "GrStlNb";}; 
}
 