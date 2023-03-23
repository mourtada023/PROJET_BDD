package voyage;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
@Entity
@PrimaryKeyJoinColumn(name = "id_Personne")
public class Guide extends Personne {
	
	@Column
	private double salaire;

	public double getSalaire() {
		return salaire;
	}

	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	

	@OneToMany(mappedBy="guide")
	private Set<Groupe> groupeGuide = new HashSet<Groupe>();
	public void addGuideGroupe(Groupe f) { groupeGuide.add(f) ;}
	public Set<Groupe> getGuideGroupe() {return groupeGuide;}
	public void removeguideGroupe(Groupe f) { groupeGuide.remove(f) ;}

}
