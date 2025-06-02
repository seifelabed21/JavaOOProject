public class releve_de_note {
    private Etudiant etudiant;
    private Unite[] unites;
    private int nb_unites;
    
    // Constructeur

    public releve_de_note(Etudiant etudiant)
    {
        this.etudiant = etudiant;
        this.unites = new Unite[10]; 
        this.nb_unites = 0;
    }

    // Getters

    public Etudiant getEtudiant()
    {
        return etudiant;
    }
    public Unite[] getUnite()
    {
        return unites;
    }
    public int getNb_unites()
    {
        return nb_unites;
    }

    // Setters

    public void setEtudiant(Etudiant e)
    {
        this.etudiant = e;
    }
    public void setEtudiant(Unite[] u)
    {
        this.unites = u;
    }
    public void setEtudiant(int n)
    {
        this.nb_unites = n;
    }

    // ajouter_unité()

    public void ajouter_unité(Unite unite)
    {
        if (nb_unites < unites.length) 
        {
            unites[nb_unites] = unite;
            nb_unites++;
        } 
        else 
        {
            System.out.println("Limite d'UE atteinte pour cet étudiant");
        }
    }

    // calculer_moyenne_generale()
    public float calculerMoyenneGenerale() 
    {
    float somme = 0;
    float somme_coef = 0;
    for (int i = 0; i < nb_unites; i++) {
        somme += unites[i].calculer_moyenne_unite() * unites[i].getCoefficient();
        somme_coef += unites[i].getCoefficient();
    }
    if (somme_coef == 0) 
        return 0;
    return (somme / somme_coef);
    }

    // afficher_relevé()

    public void afficherReleve() {
        etudiant.afficher_info();
        for (int i = 0; i < nb_unites; i++) {
            unites[i].afficher_unite();
        }
        System.out.println("Moyenne Générale: " + calculerMoyenneGenerale());
    }
}
