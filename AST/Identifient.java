package AST;

public class Identifient extends ExpressionA {
    public String iden;

    public Identifient(String iden) {
        this.iden =iden;
    }

    public String toString() {
        return iden;
    }



}