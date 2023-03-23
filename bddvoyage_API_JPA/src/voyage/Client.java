package voyage;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "id_Personne")
public class Client extends Personne{
	
	
	
	@Column
	private Integer anneDeNaissance;

	public Integer getAnneDeNaissance() {
		return anneDeNaissance;
	}

	public void setAnneDeNaissance(Integer anneDeNaissance) {
		this.anneDeNaissance = anneDeNaissance;
	}
	
	
	@ManyToMany(mappedBy="clients")
	Set<Groupe> groupesClients = new HashSet<Groupe>();
	public Set<Groupe> getGroupes() {
		return groupesClients;
	}
	public void addGroupes(Groupe a) {
		groupesClients.add(a);
	}

	
	
	
	
	

}
