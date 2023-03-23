package voyage;

import javax.persistence.EntityManager;

public class ClientManager {
	
	
	 private EntityManager persistance;
	 
	    
	 public ClientManager() {
	      this.persistance=EntitySingleton.getManager();
	     
	    }

	    public Client ajouterClient(String nom ,String prenom, String email, String portable, int annee) throws AppliException {
	    	Client f = new Client();
	        
	        f.setNom(nom);
	        f.setPrenom(prenom);
	        f.setMail(email);
	        f.setPortable(portable);
	        f.setAnneDeNaissance(annee);
	        try {
	            persistance.persist(f);
	        }catch(Exception e) {
	            throw new AppliException(e);
	        }
	        return f;
	    }

}
