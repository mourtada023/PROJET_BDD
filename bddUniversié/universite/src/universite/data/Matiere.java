package universite.data;

import javax.persistence.*;

@Entity
public class Matiere  {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_Matiere")
	@SequenceGenerator(name="Seq_Matiere", sequenceName="Seq_Matiere", allocationSize=1)
	@Column(name = "id_matiere")
	Long id;
	public void setId(Long i) {id = i;}
	public Long getId() {return id ;}

	@Column
	String nom;
	public void setNom(String n) {nom = n;}
	public String getNom() {return nom;}

	@Column
	Integer ects;
	public void setEcts(Integer ects) {this.ects = ects;}
	public Integer getEcts() {return ects;}


	@ManyToOne
	@JoinColumn (name="id_formation")
	private Formation formation;    
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	@ManyToOne
	@JoinColumn (name="id_personne")
	private Enseignant responsable;
	public Enseignant getResponsable() {
		return responsable;
	}
	public void setResponsable(Enseignant responsable) {
		this.responsable = responsable;
	}
	
	
	
    
    
	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Matiere)) {
			return false;
		}
		Matiere other = (Matiere) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Matiere " + getNom() + " " + getEcts() + " ects ";
	}

}
