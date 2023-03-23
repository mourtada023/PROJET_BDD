package cinema.data;

import javax.persistence.*;
import cinema.jpa.EntitySingleton;
import java.util.List;

public class ManagerFilm {

    private EntityManager persistance;
    private Query listerFilms;
    
    public ManagerFilm() {
        this.persistance=EntitySingleton.getManager();
        listerFilms = persistance.createNamedQuery("lesfilms");
    }

    public Film ajouterFilm(String titre, int annee,String genre) throws AppliException {
        Film f = new Film();
        f.setTitre(titre);
        f.setAnnee(annee);
        f.setGenre(genre);
        try {
            persistance.persist(f);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return f;
    }

    public List<Film> listerFilms() {
	return (List<Film>)listerFilms.getResultList();
    }
}
