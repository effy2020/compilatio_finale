package AST;

public class AndExpression extends ExpressionA_Binaire{
    public AndExpression(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

    public String symbole() {return "&&";};
    public String toString() {
            return String.format("%s(%s,%s)", symbole(), gauche, droite);
    }
}
