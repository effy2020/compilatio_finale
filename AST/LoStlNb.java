
package AST;

public class LoStlNb extends ExpressionA_Binaire{
    public LoStlNb(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "LoStlNb";}; 
}
 