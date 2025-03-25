package AST;

public class Eql extends ExpressionA_Binaire{
    public Eql(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "Eq";}; 
}
 