package universite.data;

import javax.persistence.*;
import universite.jpa.EntitySingleton;

public class ManagerEtudiant {

    private EntityManager persistance;

    public ManagerEtudiant() {
        this.persistance=EntitySingleton.getManager();
    }

    public Etudiant ajouterEtudiant(String nom, String prenom, String email, String nationalite, String baccalaureat, int anneeBac) throws AppliException {
        Etudiant et = new Etudiant();
        et.setNom(nom);
        et.setPrenom(prenom);
        et.setEmail(email);
        et.setNationalite(nationalite);
        et.setBaccalaureat(baccalaureat);
        et.setAnnee(anneeBac);
        try {
            persistance.persist(et);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return et;
    }
}
