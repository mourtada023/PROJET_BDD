package cinema;

import java.util.List;

import cinema.data.Pays;
import cinema.data.Artiste;
import cinema.data.Cinematheque;
import cinema.data.Film;
import cinema.data.ManagerFilm;
import cinema.jpa.EntitySingleton;

import javax.persistence.*;

public class ApplicationSelection {

    public static void main(String[] args) throws Exception {
		

         EntityManager em = EntitySingleton.getManager();
         Cinematheque ci = new Cinematheque();
         ManagerFilm mf = ci.getManagerFilm();

         em.getTransaction().begin();

         // placez votre code ici, entre le begin et le commit
         
        //récupération des films
         List<Film> lf = mf.listerFilms();

         // affichage des films
         for(Film f : lf) {
             System.out.println("titre " + f.getTitre());
             System.out.println("Réalisateur : " + f.getRealisateur());
             System.out.println("Acteurs : ");
             for(Artiste a : f.getActeurs()) {
                 System.out.println(a.getNom());
             }
         }
         
         
      
         em.getTransaction().commit();
     }
}

