package AST;

// non disponible hors du package (non publique).
// Permet uniquement de factoriser le code des noeuds binaires.
abstract class ExpressionA_Binaire extends ExpressionA {
  ExpressionA gauche;
  ExpressionA droite;

  ExpressionA_Binaire (ExpressionA gauche,ExpressionA droite) {
    this.gauche = gauche;
    this.droite = droite;
  }

  abstract Double eval();
  abstract String symbole(); 
  public abstract String toAssembly();

  public String toString() {
    return String.format("%1$s(%2$s,%3$s)", symbole(), gauche.toString(), droite.toString());
  }
}
