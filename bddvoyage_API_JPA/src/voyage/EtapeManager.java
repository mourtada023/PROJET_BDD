package voyage;

import javax.persistence.EntityManager;

public class EtapeManager {
	
	
	private EntityManager persistance;

	public EtapeManager() {
		this.persistance=EntitySingleton.getManager();
	}

	
	public Etape ajouterEtape(Integer ordre, Circuit circuit) throws AppliException {
		Etape a = new Etape();
		a.setCircuit(circuit);
		EtapeId p = new EtapeId();
		p.setNumOrdre(ordre);
		p.setIdCircuit(circuit.getId_circuit());
		a.setPk(p);
		
		try {
			persistance.persist(a);
		}catch(Exception e) {
			throw new AppliException(e);
		}
		return a;
	}

}
