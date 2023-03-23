package cinema;

import java.util.List;

import cinema.data.Cinematheque;
import cinema.data.ManagerFilm;
import cinema.data.ManagerPays;
import cinema.data.ManagerArtiste;
import cinema.data.Film;
import cinema.data.Pays;
import cinema.data.Artiste;

public class ApplicationCreation {

    public static void main(String[] args) throws Exception {
		
        Cinematheque ci = new Cinematheque();
        ManagerFilm mf = ci.getManagerFilm();
        ManagerPays mp = ci.getManagerPays();
        ManagerArtiste ma = ci.getManagerArtiste();

        ci.debuter();

        // création de pays
        Pays is = mp.ajouterPays("is","Islande","islandais");
        Pays fr = mp.ajouterPays("fr","France","français");
        Pays apays[] = new Pays[10];
        for(int i=0; i<10; i++) {
            apays[i] = mp.ajouterPays("p"+i,"Pays"+i,"Pays"+i+"ais");
        }
        
        // création d'artistes
        Artiste carne = ma.ajouterArtiste("Carné","Marcel",1906);
        Artiste arletty = ma.ajouterArtiste("Arletty",null,1898);
        Artiste barrault = ma.ajouterArtiste("Barrault","Jean-Louis",1910);
        Artiste  brasseur = ma.ajouterArtiste("Brasseur","Pierre",1905);
        Artiste aartiste[] = new Artiste[1000];
        for(int i=0;i<1000;i++)
            aartiste[i] = ma.ajouterArtiste("ArN"+i,"ArtP"+i,i);
        
        // création d'un film
        Film paradis = mf.ajouterFilm("Les enfants du paradis",1945,"Drame");
        Film afilm[] = new Film[100];
        for(int i=0; i<100; i++) {
            afilm[i] = mf.ajouterFilm("Fi"+i,i,"Genre" + i);
            apays[i/10].addFilmsDuPays(afilm[i]);
            afilm[i].setPays(apays[i/10]);
            afilm[i].setRealisateur(aartiste[i*10]);
            aartiste[i*10].addFilmsRealises(afilm[i]);
            for(int j=i*10; j<i*10+10; j++) {
                afilm[i].addActeurs(aartiste[j]);
                aartiste[j].addFilmsJoues(afilm[i]);
            }
        }
        
        fr.addFilmsDuPays(paradis);
        paradis.setPays(fr);
        
        paradis.setRealisateur(carne);
        carne.addFilmsRealises(paradis);

        paradis.addActeurs(arletty);
        arletty.addFilmsJoues(paradis);
        paradis.addActeurs(barrault);
        barrault.addFilmsJoues(paradis);
        paradis.addActeurs(brasseur);
        brasseur.addFilmsJoues(paradis);
        
        ci.valider();
     }
}

