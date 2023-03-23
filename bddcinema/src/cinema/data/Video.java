package cinema.data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Video implements Serializable {

  @Id
  @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="Seq_Video")
  @SequenceGenerator(name="Seq_Video", sequenceName="Seq_Video", allocationSize=1)
  @Column(name = "id_video")
  private Long id;
  public Long getId() { return this.id; }

  @Column
  private String titre;
  public void setTitre(String t) { titre = t; }
  public String getTitre() { return titre; }

  @Column
  private Integer annee;
  public void setAnnee(Integer a) { annee = a; }
  public Integer getAnnee() { return annee; }

  public Video() {  }
}
