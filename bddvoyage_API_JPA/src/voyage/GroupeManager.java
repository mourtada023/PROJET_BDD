package voyage;

import javax.persistence.EntityManager;

public class GroupeManager {

	
	 private EntityManager persistance;
	 
	    
	 public GroupeManager() {
	      this.persistance=EntitySingleton.getManager();
	     
	    }

	    public Groupe ajouterGroupe(float tarif ,Integer capacite) throws AppliException {
	    	Groupe f = new Groupe();
	        
	        f.setTarif(tarif);
	        f.setCapacite(capacite);
	        try {
	            persistance.persist(f);
	        }catch(Exception e) {
	            throw new AppliException(e);
	        }
	        return f;
	    }
}
