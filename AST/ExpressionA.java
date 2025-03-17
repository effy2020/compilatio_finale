package AST;

public abstract class ExpressionA extends AST {
    // un jour il y aura d'autres choses ici

    abstract Double eval();
    public abstract String toAssembly();
}
