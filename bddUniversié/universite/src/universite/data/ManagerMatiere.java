package universite.data;

import javax.persistence.*;
import universite.jpa.EntitySingleton;

public class ManagerMatiere {

    private EntityManager persistance;

    public ManagerMatiere() {
        this.persistance=EntitySingleton.getManager();
    }

    public Matiere ajouterMatiere(String nom, int ects) throws AppliException {
        Matiere m = new Matiere();
        m.setNom(nom);
        m.setEcts(ects);
        try {
            persistance.persist(m);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return m;
    }
		
    public void responsableMatiere(Matiere m, Enseignant e) {
        e.addMatiere(m);
        m.setResponsable(e);
    }

}
