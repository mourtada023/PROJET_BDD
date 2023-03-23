package voyage;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class EtapeId {
	
	@Column(name ="ordre", nullable = false )
	private Integer numOrdre ;
	@Column ( name =" id_circuit ", nullable = false )
	private Long idCircuit ;
	
	
	public Integer getNumOrdre() {
		return numOrdre;
	}
	public void setNumOrdre(Integer numOrdre) {
		this.numOrdre = numOrdre;
	}
	public Long getIdCircuit() {
		return idCircuit;
	}
	public void setIdCircuit(Long idCircuit) {
		this.idCircuit = idCircuit;
	}

	
	
}
