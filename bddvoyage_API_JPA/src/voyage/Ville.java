package voyage;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

public class Ville {

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_Circuit")
    @SequenceGenerator(name="Seq_Circuit", sequenceName="Seq_Circuit", allocationSize=1)
	Long idVille;

	public Long getIdVille() {
		return idVille;
	}
	
	private String nom;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	private String pays;

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
}
