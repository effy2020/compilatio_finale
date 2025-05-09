
package AST;

public class Expression_Import extends ExpressionA {

    String bibliotheque;

    public Expression_Import(String bibliotheque ) {
        this.bibliotheque = bibliotheque;

    }


    public String toString() {
        return "import " + bibliotheque  ;
    }
}
