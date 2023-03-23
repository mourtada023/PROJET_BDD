package universite.data;

import javax.persistence.*;
import universite.jpa.EntitySingleton;

public class ManagerEnseignant {

    private EntityManager persistance;

    public ManagerEnseignant() {
        persistance = EntitySingleton.getManager();
    }

    public Enseignant ajouterEnseignant(String nom, String prenom, String email, String grade, String batiment, String bureau) throws AppliException {
        Enseignant en = new Enseignant();
        en.setNom(nom);
        en.setPrenom(prenom);
        en.setEmail(email);
        en.setGrade(grade);
        en.setBatiment(batiment);
        en.setBureau(bureau);
        try {
            persistance.persist(en);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return en;
    }

}
