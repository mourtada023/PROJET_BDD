package universite.data;

import javax.persistence.*;
import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;

public class Formation implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_Formation")
	@SequenceGenerator(name="Seq_Formation", sequenceName="Seq_Formation", allocationSize=1)
	@Column(name = "id_formation")
	private Long id;
	public Long getId() { return this.id; }

	String niveau;
	public String getNiveau() {
		return niveau;
	}
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Column
	String mention;
	public String getMention() {
		return mention;
	}
	public void setMention(String mention) {
		this.mention = mention;
	}

	@Column
	String parcours;
	public String getParcours() {
		return parcours;
	}
	public void setParcours(String parcours) {
		this.parcours = parcours;
	}


	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	
	@OneToMany(mappedBy="formation")
    private Set<Matiere> matiereEnseignes = new HashSet<Matiere>();
    public void addMatiere(Matiere f) { matiereEnseignes.add(f) ;}
    public Set<Matiere> getMatiere() {return matiereEnseignes;}
    public void removeMatiere(Matiere f) { matiereEnseignes.remove(f) ;}


    
    @ManyToMany()
    @JoinTable(name="Inscrit",joinColumns=@JoinColumn(name="id_formation"),
               inverseJoinColumns=@JoinColumn(name="id_personne"))
    Set<Etudiant> etudiants = new HashSet<Etudiant>();
    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }
    public void addEtudiants(Etudiant a) {
    	etudiants.add(a);
    }
    
    
	
	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Formation)) {
			return false;
		}
		Formation other = (Formation) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Formation : " + getNiveau() + " " + getMention() + " " + (getParcours()!=null?getParcours():"");
	}

}
