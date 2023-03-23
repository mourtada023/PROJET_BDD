package voyage;



public class Main {

	public static void main(String[] args) throws AppliException {
		
	
		LeaderShift  ls = new LeaderShift();
		GuideManager g = new GuideManager();
		ClientManager c = new ClientManager();
		GroupeManager mg = new GroupeManager();
		CircuitManager cm = new CircuitManager();
		EtapeManager et = new EtapeManager();
		
		ls.debuter();
		
		// Creation des personne
		Personne g1 = g.ajouterGuide("Rabah" ,"Mamadou", "mmd.@gmail.com", "00", 2000.20);
		Personne  c1 = c.ajouterClient("Lune" ,"Ciel", "cml.@gmail.com", "00", 2023);
		Groupe gp = mg.ajouterGroupe(20.5f,200);
		
		// Creation du circuit
		Circuit  cir = cm.ajouterCircuit("Paris _ Dakar", 1);
		
		// Creation d'une Etapes
		Etape etp = et.ajouterEtape(1,cir);
		
		
		
		
		ls.valider();
		
	}

}
