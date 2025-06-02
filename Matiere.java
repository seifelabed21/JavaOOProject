public class Matiere {
    private String nomMatiere;
    private double noteDS;
    private double noteExamen;
    private int coefficient;

    public Matiere(String nomMatiere, double noteDS, double noteExamen, int coefficient) {
        this.nomMatiere = nomMatiere;
        this.noteDS = noteDS;
        this.noteExamen = noteExamen;
        this.coefficient = coefficient;
    }

    // --- Getters ---
    public String getNomMatiere() {
        return nomMatiere;
    }

    public double getNoteDS() {
        return noteDS;
    }

    public double getNoteExamen() {
        return noteExamen;
    }

    public int getCoefficient() {
        return coefficient;
    }

    // --- Setters ---
    public void setNomMatiere(String nomMatiere) {
        this.nomMatiere = nomMatiere;
    }

    public void setNoteDS(double noteDS) {
        this.noteDS = noteDS;
    }

    public void setNoteExamen(double noteExamen) {
        this.noteExamen = noteExamen;
    }

    public void setCoefficient(int coefficient) {
        this.coefficient = coefficient;
    }

    // --- Autres méthodes ---
    public double calculer_moyenne_matiere() {
        return (noteDS * 0.4) + (noteExamen * 0.6);
    }

    public void afficher_matiere() {
        System.out.println("- " + nomMatiere + " (DS: " + noteDS + ", Examen: " + noteExamen + ", Moyenne: " + calculer_moyenne_matiere() + ")");
    }
}

