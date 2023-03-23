package universite;

import java.util.List;
import java.util.Set;

import universite.data.*;


public class Application {

    public static void main(String[] args) throws Exception {
		
        Universite univ = new Universite();
        ManagerEtudiant met = univ.getManagerEtudiant();
        ManagerFormation mf = univ.getManagerFormation();
        ManagerEnseignant men = univ.getManagerEnseignant();
        ManagerMatiere ma = univ.getManagerMatiere();

        univ.debuter();

        // création de formations
        Formation l2 = mf.ajouterFormation("L2", "informatique", null);
        Formation l3i = mf.ajouterFormation("L3", "informatiqe", "informatique");
        Formation l3m = mf.ajouterFormation("L3", "informatiqe", "miage");

        // création de matieres
        Matiere bdd = ma.ajouterMatiere("Base de données", 6);
        Matiere bdd1 = ma.ajouterMatiere("Base de données 1", 3);
        Matiere logique = ma.ajouterMatiere("Logique", 3);
        Matiere afsi = ma.ajouterMatiere("Analyse Fonctionnelle des Systèmes d'Information 1", 6);

        // création des enseignants
        Enseignant en1 = men.ajouterEnseignant("Roos", "Jean-François", "jean-francois.roos@univ-lille.fr", "mdc", "M3 ext", "218");
        Enseignant en2 = men.ajouterEnseignant("Bogaert", "Bruno", "bruno.bogaert@univ-lille.fr", "mdc", "M3 ext", "208");
        Enseignant en3 = men.ajouterEnseignant("Salvati", "Sylvain", "sylvai.salvati@univ-lille.fr", "prof", "M3 ext", "210");
        Enseignant en4 = men.ajouterEnseignant("Décallonne", "Marc", "marc.decallonne@univ-lille.fr", "past", "M3", "14");
 
        // création des étudiants
        Etudiant et1 = met.ajouterEtudiant("Salengro", "Roger", "roger.salengro.etu@univ-lille.fr", "française", "Lettres", 1907);
        Etudiant et2 = met.ajouterEtudiant("Rouve", "Jean-Paul", "jean-paul.rouve.etu@univ-lille.fr", "française", "A3", 1985);
        Etudiant et3 = met.ajouterEtudiant("Mittenaere", "Iris", "iris.mittrnaere.etu@univ-lille.fr", "française", "S", 2011);
     
        // associer formations et matières   
        mf.contenirMatiere(l3m, afsi);
        mf.contenirMatiere(l3m, bdd);
        mf.contenirMatiere(l2, bdd1);
        mf.contenirMatiere(l2, logique);
 
        // associer formations et étudiants
        mf.inscrireEtudiant(l3m, et3);
        mf.inscrireEtudiant(l3m, et2);
        mf.inscrireEtudiant(l2, et1);
        mf.inscrireEtudiant(l3i, et1);
        
        // associer matieres et enseignants
        ma.responsableMatiere(afsi, en4);
        ma.responsableMatiere(logique, en3);
        ma.responsableMatiere(bdd1, en2);
        ma.responsableMatiere(bdd, en1);
        
      univ.valider();
      
      univ.debuter();
      
      List<Formation> lf = mf.lesFormations();
      for(Formation f : lf) {
    	  System.out.println(f);
          
    	  System.out.println("\tMatières :");
          // afficher les différentes matières de la formation
    	  Set<Matiere> matieres = f.getMatiere();
    	    for (Matiere m : matieres) {
    	        System.out.println("\t\t" + m);
    	    }
    	  System.out.println("\tInscrits :");
          // afficher les différents étudiants inscrits à la formation
    	  Set<Etudiant> etudiants = f.getEtudiants();
    	    for (Etudiant e : etudiants) {
    	        System.out.println("\t\t" + e);
    	    }
      }

      univ.valider();
      
     }
}

