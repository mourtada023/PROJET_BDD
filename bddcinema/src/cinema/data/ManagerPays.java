package cinema.data;

import javax.persistence.*;
import cinema.jpa.EntitySingleton;
import java.util.List;

public class ManagerPays {

	private EntityManager persistance;

	public ManagerPays() {
		this.persistance=EntitySingleton.getManager();
	}

	public Pays ajouterPays(String code, String nom, String langue) throws AppliException {
		Pays p = new Pays();
		p.setCode(code);
		p.setNom(nom);
		p.setLangue(langue);
		try {
			persistance.persist(p);
		}catch(Exception e) {
			throw new AppliException(e);
		}
		return p;
	}

}
