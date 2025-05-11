package AST;

import java.util.List;

public class Condition extends ExpressionA {
    private ExpressionA condition;
    private List<Expr_Pt_Virg> thenBranch;
    private List<Expr_Pt_Virg> elseBranch;

    public Condition(ExpressionA condition, List<Expr_Pt_Virg> thenBranch, List<Expr_Pt_Virg> elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public String symbole() {
        return "IfThenElse";
    }

    public String toString() {
        return String.format("%s(%s,%s,%s)",
                symbole(),
                condition != null ? "condition(" + condition.toString() + ")" : "null",
                thenBranch != null ? "then(" + thenBranch.toString()  + ")": "null",
                elseBranch != null ?  "else(" + elseBranch.toString()  + ")" : "null");


    }


}