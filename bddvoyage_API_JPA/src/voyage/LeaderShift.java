package voyage;

import javax.persistence.*;

public class LeaderShift {
	
	private EntityManager persistance;
	private GuideManager gm;
	private ClientManager cm;
	private GroupeManager mg;
	private CircuitManager crm;
	private EtapeManager ep;
	
	
	public LeaderShift() {
		this.persistance = EntitySingleton.getManager();
		this.gm = new GuideManager();
		this.cm = new ClientManager();
		this.mg = new GroupeManager();
		this.crm =new CircuitManager();
		this.setEp(new EtapeManager());
		
		
		
		
	}
	
	public void debuter() {
        this.persistance.getTransaction().begin();
    }

	public GuideManager getGm() {
		return gm;
	}

	public void setGm(GuideManager gm) {
		this.gm = gm;
	}

	public ClientManager getCm() {
		return cm;
	}

	public void setCm(ClientManager cm) {
		this.cm = cm;
	}
	
	
	public void valider() {
        this.persistance.getTransaction().commit();

    }

	public GroupeManager getMg() {
		return mg;
	}

	public void setMg(GroupeManager mg) {
		this.mg = mg;
	}

	public CircuitManager getCrm() {
		return crm;
	}

	public void setCrm(CircuitManager crm) {
		this.crm = crm;
	}

	public EtapeManager getEp() {
		return ep;
	}

	public void setEp(EtapeManager ep) {
		this.ep = ep;
	}
	
	
	
	

}
