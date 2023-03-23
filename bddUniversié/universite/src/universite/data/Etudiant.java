package universite.data;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;
@Entity
@PrimaryKeyJoinColumn(name="id_personne")
public class Etudiant  extends Personne {

    private static final long serialVersionUID = 1L;
	
    @Column
    String nationalite;
    public String getNationalite() {
        return nationalite;
    }
    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    @Column
    String baccalaureat;
	
    public String getBaccalaureat() {
        return baccalaureat;
    }
    public void setBaccalaureat(String baccalaureat) {
        this.baccalaureat = baccalaureat;
    }

    @Column
    Integer annee;
    public Integer getAnnee() {
        return annee;
    }
    public void setAnnee(Integer annee) {
        this.annee = annee;
    }
    
    @ManyToMany(mappedBy = "etudiants")
    Set<Formation> formationEtudiants = new HashSet<Formation>();
    public Set<Formation> getFormation() {
        return formationEtudiants;
    }
    public void addFormation(Formation f) {
    	formationEtudiants.add(f);
    }


    
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
        Etudiant other = (Etudiant) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Etudiant : " + getNom() + " " + getPrenom();
    }

    public Etudiant() {
    	super();
    }
}
