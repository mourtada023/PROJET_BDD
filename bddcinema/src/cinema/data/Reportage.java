package cinema.data;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_video")
public class Reportage extends Video {

  @Column
  String lieu;
  public String getLieu() {
    return lieu;
  }
  public void setLieu(String l) {
    lieu = l;
  }
}
