package cinema.data;

import javax.persistence.EntityManager;
import cinema.jpa.EntitySingleton;

public class Cinematheque {

    private EntityManager persistance;
    private ManagerFilm mf;
    private ManagerPays mp;
    private ManagerArtiste ma;

    public Cinematheque() {
        this.persistance=EntitySingleton.getManager();
        this.mf = new ManagerFilm();
        this.mp = new ManagerPays();
        this.ma = new ManagerArtiste();
    }

    public void debuter() {
        this.persistance.getTransaction().begin();
    }

    public ManagerFilm getManagerFilm() {
    	return mf;
    }
    
    public ManagerPays getManagerPays() {
    	return mp;
    }
    

    public ManagerArtiste getManagerArtiste() {
    	return ma;
    }
    

    public void valider() {
        this.persistance.getTransaction().commit();

    }
}
