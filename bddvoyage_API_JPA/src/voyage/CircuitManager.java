package voyage;

import javax.persistence.EntityManager;

public class CircuitManager {
	
	private EntityManager persistance;

	public CircuitManager() {
		this.persistance=EntitySingleton.getManager();
	}

	public Circuit ajouterCircuit(String titre, Integer duree) throws AppliException {
		Circuit a = new Circuit();
		a.setTitre(titre);
		a.setDuree(duree);
		try {
			persistance.persist(a);
		}catch(Exception e) {
			throw new AppliException(e);
		}
		return a;
	}

}
