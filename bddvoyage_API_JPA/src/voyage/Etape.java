package voyage;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Etape {

	// Comment gerer l'annotation mapsId
	@EmbeddedId
	private EtapeId pk;
	
	
	@MapsId ("idCircuit")
	@ManyToOne
	private Circuit circuit ;


	public EtapeId getPk() {
		return pk;
	}


	public void setPk(EtapeId pk) {
		this.pk = pk;
	}


	public Circuit getCircuit() {
		return circuit;
	}


	public void setCircuit(Circuit circuit) {
		this.circuit = circuit;
	}
	
}
