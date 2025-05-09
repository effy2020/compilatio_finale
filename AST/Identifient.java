package AST;

public class Identifient extends ExpressionA {
    public String iden;

    public Identifient(String iden) {
        this.iden =iden;
    }

    public String toString() {
        return iden;
    }
    public String symbol() {return "iden"; };

    public String toAssembly(){
        return "GetVar "+iden +"\n";
    }

}