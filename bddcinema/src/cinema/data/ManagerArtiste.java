package cinema.data;

import javax.persistence.*;
import cinema.jpa.EntitySingleton;
import java.util.List;

public class ManagerArtiste {

    private EntityManager persistance;

    public ManagerArtiste() {
        this.persistance=EntitySingleton.getManager();
    }

    public Artiste ajouterArtiste(String nom, String prenom, int naissance) throws AppliException {
        Artiste a = new Artiste();
        a.setNom(nom);
        a.setPrenom(prenom);
        a.setAnneeNaissance(naissance);
        try {
            persistance.persist(a);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return a;
    }

}
