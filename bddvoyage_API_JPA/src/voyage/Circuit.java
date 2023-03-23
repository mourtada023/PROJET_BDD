package voyage;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Circuit {
	
	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_Circuit")
    @SequenceGenerator(name="Seq_Circuit", sequenceName="Seq_Circuit", allocationSize=1)
	Long id_circuit;
	public Long getId_circuit() {
		return id_circuit;
	}
	
	String titre;
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	Integer duree;
	public Integer getDuree() {
		return duree;
	}
	public void setDuree(Integer duree) {
		this.duree = duree;
	}
	

	@OneToMany(mappedBy="circuit")
	private Set<Groupe> groupeVoyageCircuit = new HashSet<Groupe>();
	public void addFilmsRealises(Groupe f) { groupeVoyageCircuit.add(f) ;}
	public Set<Groupe> getFilmsRealises() {return groupeVoyageCircuit;}
	public void removeFilmsDuPays(Groupe f) { groupeVoyageCircuit.remove(f) ;}

	
	

}
