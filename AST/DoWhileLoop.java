package AST;

import java.util.List;

public class DoWhileLoop extends ExpressionA {
    private ExpressionA condition;
    private List<Expr_Pt_Virg> body;


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

   
}