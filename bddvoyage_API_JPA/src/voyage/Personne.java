package voyage;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Personne {
	
	//private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue ( strategy = GenerationType.SEQUENCE , generator =" Seq_Personne")
	@SequenceGenerator ( name =" Seq_Personne ", sequenceName =" Seq_Personne ", allocationSize =1)
	@Column(name = "id_Personne")
	private Integer idPersonne;
	public Integer getId() {return this.idPersonne;}
	
	@Column
	private String nom;
	public String getNom() {return nom;}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Column
	private String prenom;
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	@Column
	private String mail;
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	@Column
	private String portable;
	public String getPortable() {
		return portable;
	}
	public void setPortable(String portable) {
		this.portable = portable;
	}
	
	public Personne() {};
	
	
	
	

}
