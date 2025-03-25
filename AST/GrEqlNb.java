package AST;

public class GrEqlNb extends ExpressionA_Binaire{
    public GrEqlNb(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "GrEqlNb";}; 
}
 