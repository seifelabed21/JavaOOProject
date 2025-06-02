public class Etudiant {
    private String matricule;
    private String nom;
    private String prenom;

    public Etudiant(String matricule, String nom, String prenom) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void afficher_info() {
        System.out.println("Matricule: " + matricule + ", Nom: " + nom + ", Prenom: " + prenom);
    }
}
