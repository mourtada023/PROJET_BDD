package voyage;

import javax.persistence.EntityManager;

public class GuideManager {

	
	
	private EntityManager persistance;
	 
    
	 public GuideManager() {
	      this.persistance=EntitySingleton.getManager();
	     
	    }

	    public Guide ajouterGuide(String nom ,String prenom, String email, String portable, double salaire) throws AppliException {
	    	Guide g = new Guide();
	        
	        g.setNom(nom);
	        g.setPrenom(prenom);
	        g.setMail(email);
	        g.setPortable(portable);
	        g.setSalaire(salaire);
	        try {
	            persistance.persist(g);
	        }catch(Exception e) {
	            throw new AppliException(e);
	        }
	        return g;
	    }
}
