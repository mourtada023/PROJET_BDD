package universite.data;

import javax.persistence.*;
import universite.jpa.EntitySingleton;
import java.util.List;

public class ManagerFormation {

    private EntityManager persistance;

    // requête pour obtenir la liste des formations
    private TypedQuery<Formation> qlesformations; 

    public ManagerFormation() {
        this.persistance=EntitySingleton.getManager();
        // modifier la chaîne premier paramètre de la méthode createQuery en donnant la bonne requête JPQL
        this.qlesformations = this.persistance.createQuery("SELECT f FROM Formation f", Formation.class);
    }

    public Formation ajouterFormation(String niveau, String mention, String parcours) throws AppliException {
        Formation f = new Formation();
        f.setNiveau(niveau);
        f.setMention(mention);
        f.setParcours(parcours);
        try {
            persistance.persist(f);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return f;
    }
    
    public void contenirMatiere(Formation f, Matiere m) {
        f.addMatiere(m);
        m.setFormation(f);
    }

    public void inscrireEtudiant(Formation f, Etudiant e) {
        f.addEtudiants(e);
        e.addFormation(f);
    }
    
    public List<Formation> lesFormations( ) {
    	return this.qlesformations.getResultList();
    }
}
