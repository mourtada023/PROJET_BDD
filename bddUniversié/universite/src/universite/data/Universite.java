package universite.data;

import javax.persistence.EntityManager;
import universite.jpa.EntitySingleton;

public class Universite {

    private EntityManager persistance;
    private ManagerEtudiant met;
    private ManagerFormation mf;
    private ManagerEnseignant men;
    private ManagerMatiere ma;

    public Universite() {
        this.persistance=EntitySingleton.getManager();
        this.met = new ManagerEtudiant();
        this.mf = new ManagerFormation();
        this.men = new ManagerEnseignant();
        this.ma = new ManagerMatiere();
    }

    public void debuter() {
        this.persistance.getTransaction().begin();
    }

    public ManagerEtudiant getManagerEtudiant() {
		return met;
	}

	public ManagerFormation getManagerFormation() {
		return mf;
	}

	public ManagerEnseignant getManagerEnseignant() {
		return men;
	}

	public ManagerMatiere getManagerMatiere() {
		return ma;
	}

	public void valider() {
        this.persistance.getTransaction().commit();

    }
}
