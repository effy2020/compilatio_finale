package AST;

import java.util.List;

public class DoWhileLoop extends ExpressionA {
    private ExpressionA condition;
    private List<Expr_Pt_Virg> body;
    public static Integer labelJump = 0;


    public DoWhileLoop(ExpressionA condition, List<Expr_Pt_Virg> body) {
        this.condition = condition;
        this.body = body;
    }

    public String symbole() {
        return "DoWhile";
    }

    public String toString() {
        return String.format("%s(%s,%s)",
                symbole(),
                body != null ? "body(" + body.toString() + ")" : "null",
                condition != null ? "condition(" + condition.toString() + ")" : "null");
    }

    public String toAssembly() {
        Integer startLabel = labelJump++;
        Integer endLabel = labelJump++;
        StringBuilder result = new StringBuilder();
        result.append("u").append(startLabel).append(": ");
        for (Expr_Pt_Virg expr : body) {
            result.append(expr.toAssembly());
        }
        result.append(condition.toAssembly());
        if (condition instanceof Num || condition instanceof Neg ||
                condition instanceof Plus || condition instanceof Moins ||
                condition instanceof Mult || condition instanceof Div) {
            result.append("NbToBe\n");
        }
        result.append("CondJump u").append(startLabel).append("\n");
        result.append("u").append(endLabel).append(": ");
        return result.toString();
    }
}