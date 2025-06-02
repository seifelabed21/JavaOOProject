public class Unite {
    private String nomUnite;
    private int coefficient;
    private Matiere[] matieres;
    private int nbMatieres;

    public Unite(String nomUnite, int coefficient, int taille) {
        this.nomUnite = nomUnite;
        this.coefficient = coefficient;
        this.matieres = new Matiere[taille];
        this.nbMatieres = 0;
    }

    // --- Getters ---
    public String getNomUnite() {
        return nomUnite;
    }

    public int getCoefficient() {
        return coefficient;
    }

    public Matiere[] getMatieres() {
        return matieres;
    }

    public int getNbMatieres() {
        return nbMatieres;
    }

    // --- Setters ---
    public void setNomUnite(String nomUnite) {
        this.nomUnite = nomUnite;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    // --- Autres méthodes ---
    public void ajouter_matiere(Matiere m) {
        if (nbMatieres < matieres.length) {
            matieres[nbMatieres++] = m;
        } else {
            System.out.println("Pas assez d'espace pour ajouter une matière !");
        }
    }

    public double calculer_moyenne_unite() {
        double somme = 0;
        int totalCoeff = 0;
        for (int i = 0; i < nbMatieres; i++) {
            somme += matieres[i].calculer_moyenne_matiere() * matieres[i].getCoefficient();
            totalCoeff += matieres[i].getCoefficient();
        }
        return (totalCoeff != 0) ? somme / totalCoeff : 0;
    }

    public void afficher_unite() {
        System.out.println("Unité: " + nomUnite + " (Coeff: " + coefficient + ")");
        for (int i = 0; i < nbMatieres; i++) {
            matieres[i].afficher_matiere();
        }
    }
}
