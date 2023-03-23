package cinema.data;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@PrimaryKeyJoinColumn(name="id_video")
@NamedQuery(name="lesfilms",query="select f from Film f left join fetch f.realisateur a left join fetch f.acteurs b ")
public class Film  extends Video {

    @Column
    String genre;
    public String getGenre() {
        return genre;
    }
    public void setGenre(String g) {
        genre = g;
    }
  
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn(name = "id_realisateur")
    private Artiste realisateur;
    public void setRealisateur(Artiste a) {
        realisateur = a;
    }
    public Artiste getRealisateur() {
        return realisateur;
    }

    
    @ManyToMany()
    @JoinTable(name="Role",joinColumns=@JoinColumn(name="id_film"),
               inverseJoinColumns=@JoinColumn(name="id_acteur"))
    Set<Artiste> acteurs = new HashSet<Artiste>();
    public Set<Artiste> getActeurs() {
        return acteurs;
    }
    public void addActeurs(Artiste a) {
        acteurs.add(a);
    }

    
    @ManyToOne (fetch=FetchType.LAZY)
    @JoinColumn (name="code_pays")
    Pays pays;
    public void setPays(Pays p) {pays = p;}
    public Pays getPays() {return pays;}

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Film : " + getTitre() + " " + getAnnee() + " " + getGenre();
    }

}
