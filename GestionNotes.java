import java.util.Scanner;

public class GestionNotes {
    private releve_de_note[] releves;
    private int nbReleves;

    public GestionNotes() {
        this.releves = new releve_de_note[50];
        this.nbReleves = 0;
    }

    public void ajouterEtudiant() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Matricule: ");
        String matricule = sc.nextLine();
        System.out.print("Nom: ");
        String nom = sc.nextLine();
        System.out.print("Prenom: ");
        String prenom = sc.nextLine();

        Etudiant e = new Etudiant(matricule, nom, prenom);
        releves[nbReleves] = new releve_de_note(e);
        nbReleves++;
        System.out.println("Etudiant ajouté !");
    }

    public void supprimerEtudiant() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Matricule à supprimer: ");
        String mat = sc.nextLine();

        for (int i = 0; i < nbReleves; i++) {
            if (releves[i].getEtudiant().getMatricule().equals(mat)) {
                // Décaler le tableau vers la gauche
                for (int j = i; j < nbReleves - 1; j++) {
                    releves[j] = releves[j+1];
                }
                releves[nbReleves-1] = null;
                nbReleves--;
                System.out.println("Etudiant supprimé !");
                return;
            }
        }
        System.out.println("Etudiant non trouvé !");
        sc.close();
    }

    public void modifierNote() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Matricule de l'étudiant: ");
        String mat = sc.nextLine();
        releve_de_note r = chercherReleve(mat);

        if (r == null) {
            System.out.println("Etudiant introuvable !");
            return;
        }

        // Simple exemple : changer la note d'une matière
        System.out.print("Nom de l'UE: ");
        String nomUE = sc.nextLine();
        System.out.print("Nom de la matière: ");
        String nomMatiere = sc.nextLine();

        for (int i = 0; i < r.getNb_unites(); i++) {
            Unite ue = r.getUnite()[i];
            if (ue.getNomUnite().equals(nomUE)) {
                for (int j = 0; j < ue.getNbMatieres(); j++) {
                    Matiere m = ue.getMatieres()[j];
                    if (m.getNomMatiere().equals(nomMatiere)) {
                        System.out.print("Nouvelle note DS: ");
                        m.setNoteDS(sc.nextFloat());
                        System.out.print("Nouvelle note Examen: ");
                        m.setNoteExamen(sc.nextFloat());
                        System.out.println("Note modifiée !");
                        return;
                    }
                }
            }
        }
        System.out.println("Matière ou UE non trouvée !");
        sc.close();
    }

    public releve_de_note chercherReleve(String matricule) {
        for (int i = 0; i < nbReleves; i++) {
            if (releves[i].getEtudiant().getMatricule().equals(matricule)) {
                return releves[i];
            }
        }
        return null;
    }

    public void afficherTousLesReleves() {
        for (int i = 0; i < nbReleves; i++) {
            releves[i].afficherReleve();
            System.out.println("-------------------------");
        }
    }

    public void afficherStatistiques() {
        if (nbReleves == 0) {
            System.out.println("Aucun étudiant");
            return;
        }

        float somme = 0;
        float maxMoyenne = 0;
        releve_de_note meilleur = null;

        for (int i = 0; i < nbReleves; i++) {
            float moyenne = releves[i].calculerMoyenneGenerale();
            somme += moyenne;
            if (moyenne > maxMoyenne) {
                maxMoyenne = moyenne;
                meilleur = releves[i];
            }
        }

        System.out.println("Moyenne générale de la classe : " + (somme / nbReleves));
        if (meilleur != null) {
            System.out.print("Meilleur étudiant : ");
            meilleur.getEtudiant().afficher_info();
            System.out.println("Avec une moyenne de : " + maxMoyenne);
        }
    }

    public void ajouterUEetMatieres() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Matricule de l'étudiant : ");
        String matricule = scanner.nextLine();
        releve_de_note releve = chercherReleve(matricule);

        if (releve == null) {
            System.out.println("Étudiant non trouvé.");
            return;
        }
    
        System.out.print("Nom de l'UE : ");
        String nomUE = scanner.nextLine();
        System.out.print("Coefficient de l'UE : ");
        int coefUE = Integer.parseInt(scanner.nextLine());
        System.out.print("Taille de l'UE : ");
        int tailleUe = Integer.parseInt(scanner.nextLine());
        Unite ue = new Unite(nomUE, coefUE, tailleUe);
    
        System.out.print("Nombre de matières dans cette UE : ");
        int nbMatieres = Integer.parseInt(scanner.nextLine());
    
        for (int i = 0; i < nbMatieres; i++) {
            System.out.println("Matière " + (i + 1) + ":");
            System.out.print("Nom : ");
            String nomMatiere = scanner.nextLine();
            System.out.print("Coefficient : ");
            int coefMatiere = Integer.parseInt(scanner.nextLine());
            System.out.print("Note DS : ");
            double noteDS = Float.parseFloat(scanner.nextLine());
            System.out.print("Note Examen : ");
            double noteExamen = Float.parseFloat(scanner.nextLine());
    
            Matiere matiere = new Matiere(nomMatiere, noteDS, noteExamen, coefMatiere);
            ue.ajouter_matiere(matiere);
        }
    
        releve.ajouter_unité(ue);
        System.out.println("UE et matières ajoutées avec succès !");
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            System.out.println("1. Ajouter un étudiant");
            System.out.println("2. Supprimer un étudiant");
            System.out.println("3. Modifier une note");
            System.out.println("4. Rechercher un étudiant");
            System.out.println("5. Afficher tous les relevés");
            System.out.println("6. Afficher statistiques");
            System.out.println("7. Ajouter une UE et ses matières à un étudiant");
            System.out.println("0. Quitter");
            System.out.print("Votre choix: ");
            choix = sc.nextInt();
            sc.nextLine(); // nettoyage buffer

            switch (choix) {
                case 1: ajouterEtudiant(); break;
                case 2: supprimerEtudiant(); break;
                case 3: modifierNote(); break;
                case 4:
                    System.out.print("Matricule à chercher: ");
                    String mat = sc.nextLine();
                    releve_de_note r = chercherReleve(mat);
                    if (r != null) r.afficherReleve();
                    else System.out.println("Etudiant non trouvé !");
                    break;
                case 5: afficherTousLesReleves(); break;
                case 6: afficherStatistiques(); break;
                case 7: ajouterUEetMatieres();break;
                case 0: System.out.println("Au revoir !"); break;
                default: System.out.println("Choix invalide !");
            }

        } while (choix != 0);
        sc.close();
    }

    public static void main(String[] args) {
        GestionNotes app = new GestionNotes();
        app.menu();
    }
}