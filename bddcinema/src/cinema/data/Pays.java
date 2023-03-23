package cinema.data;

import javax.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Pays  {
	@Id
	String code;
	public void setCode(String c) {code = c;}
	public String getCode() {return code ;}

	@Column
	String nom;
	public void setNom(String n) {nom = n;}
	public String getNom() {return nom;}

	@Column
	String langue;
	public void setLangue(String l) {langue = l;}
	public String getLangue() {return langue;}


	@OneToMany(mappedBy="pays")
	private Set<Film> filmsDuPays = new HashSet<Film>();

	public void addFilmsDuPays(Film f) { filmsDuPays.add(f) ;}
	public Set<Film> getFilmsDuPays() {return filmsDuPays;}
	public void removeFilmsDuPays(Film f) { filmsDuPays.remove(f) ;}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (code != null ? code.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Pays)) {
			return false;
		}
		Pays other = (Pays) object;
		if ((this.code == null && other.code != null) || (this.code != null && !this.code.equals(other.code))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return getNom() + " " + getLangue();
	}

}
