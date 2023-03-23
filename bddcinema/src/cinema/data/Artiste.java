package cinema.data;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Artiste  {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_Artiste")
    @SequenceGenerator(name="Seq_Artiste", sequenceName="Seq_Artiste", allocationSize=1)
    Long id;
    public void setId(Long i) {id = i;}
    public Long getId() {return id ;}

    @Column
    String nom;
    public void setNom(String n) {nom = n;}
    public String getNom() {return nom;}

    @Column
    String prenom;
    public void setPrenom(String n) {prenom = n;}
    public String getPrenom() {return prenom;}

    @Column(name="anne_naissance")
    Integer anneeNaissance;
    public void setAnneeNaissance(Integer a) {anneeNaissance = a;}
    public Integer getAnneeNaissance() {return anneeNaissance;}


    @OneToMany(mappedBy="realisateur")
    private Set<Film> filmsRealises = new HashSet<Film>();
    public void addFilmsRealises(Film f) { filmsRealises.add(f) ;}
    public Set<Film> getFilmsRealises() {return filmsRealises;}
    public void removeFilmsDuPays(Film f) { filmsRealises.remove(f) ;}


    @ManyToMany(mappedBy = "acteurs")
    Set<Film> filmsJoues = new HashSet<Film>();
    public Set<Film> getFilmsJoues() {
        return filmsJoues;
    }
    public void addFilmsJoues(Film f) {
        filmsJoues.add(f);
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
        if (!(object instanceof Artiste)) {
            return false;
        }
        Artiste other = (Artiste) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getNom() + " " + getPrenom() + " " + getAnneeNaissance();
    }

}
