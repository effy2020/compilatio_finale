package AST;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Expression_Import extends ExpressionA {
    private String bibliotheque;

    public Expression_Import(String bibliotheque) {
        this.bibliotheque = bibliotheque.replace("import ", "").trim();
    }


    public String toString() {
        return "import " + bibliotheque ;
    }

    @Override
    public String toAssembly() {
        String nomFichier = this.bibliotheque + ".jsm";
        try {
            Path filePath = Paths.get(nomFichier);
            if (!Files.exists(filePath)) {
                return "// Erreur: Fichier " + nomFichier + " introuvable\n";
            }

            String contenuFichier = Files.readString(filePath).trim();

            // Supprimer le Halt final si présent
            if (contenuFichier.endsWith("Halt")) {
                contenuFichier = contenuFichier.substring(0, contenuFichier.length() - 4).trim();
            }

            return contenuFichier + "\n";
        } catch (IOException e) {
            return "// Erreur: Impossible de lire " + nomFichier + " (" + e.getMessage() + ")\n";
        }
    }

}