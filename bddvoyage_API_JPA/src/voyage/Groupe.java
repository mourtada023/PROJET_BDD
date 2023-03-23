package voyage;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Groupe {

	
	
	
	@Id
	@GeneratedValue ( strategy = GenerationType.SEQUENCE , generator ="Seq_Groupe")
	@SequenceGenerator ( name ="Seq_Groupe", sequenceName ="Seq_Groupe", allocationSize =1)
	private Integer id_groupe ;
	public Integer getId() {return this.id_groupe; }
	
	@Column 
	private float tarif;
	public void setTarif( float newtarif) { this.tarif = newtarif;}	
	public float getTarif() { return this.tarif;}
	
	@Column
	private Integer capacite;
	public void setCapacite( Integer newCapacite) { this.capacite = newCapacite;}	
	public Integer getCapacite() { return this.capacite;}
	
	@ManyToOne
	 @JoinColumn(name = "id_guide")
	 private Guide guide;
	 public void setRealisateur(Guide a) {
		 guide = a;
	 }
	 public Guide getRealisateur() {
		 return guide;
	 }
	 
	 
	 @ManyToMany()
	 @JoinTable(name="Inscription",joinColumns=@JoinColumn(name="id_groupe"),
	 inverseJoinColumns=@JoinColumn(name="id_Personne"))
	 Set<Client> clients = new HashSet<Client>();
	 public Set<Client> getClients() {
		 return clients;
	 }
	 public void addClients(Client a) {
		 clients.add(a);
	 }
	 
	 
	 
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "id_circuit")
	 private Circuit circuit;
	 public void setCircuit(Circuit a) {
		 circuit = a;
	 }
	 public Circuit getCircuit() {
		 return circuit;
	 }

	 
}
