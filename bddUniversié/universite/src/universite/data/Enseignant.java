package universite.data;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_personne")
public class Enseignant extends Personne {

	private static final long serialVersionUID = 1L;
	@Column
	String grade;
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	@Column
	String batiment;
	public String getBatiment() {
		return batiment;
	}
	public void setBatiment(String batiment) {
		this.batiment = batiment;
	}

	@Column
	String bureau;
	public String getBureau() {
		return bureau;
	}
	public void setBureau(String bureau) {
		this.bureau = bureau;
	}
	
	
	@OneToMany(mappedBy="responsable")
    private Set<Matiere> matiereEnseignes = new HashSet<Matiere>();
    public void addMatiere(Matiere f) { matiereEnseignes.add(f) ;}
    public Set<Matiere> getMatiere() {return matiereEnseignes;}
    public void removeMatiere(Matiere f) { matiereEnseignes.remove(f) ;}
	
	

	

	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etudiant)) {
            return false;
        }
        Enseignant other = (Enseignant) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Enseignant : " + getNom() + " " + getPrenom() + " " + getGrade();
    }
	public Enseignant() {
		super();
	}
}
