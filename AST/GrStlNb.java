package AST;

public class GrStlNb extends ExpressionA_Binaire{
    public GrStlNb(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "GrStlNb";}; 
}
 