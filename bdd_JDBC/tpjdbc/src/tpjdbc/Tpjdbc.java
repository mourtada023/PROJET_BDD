package tpjdbc;

import java.sql.*;
import java.io.*;
import oracle.jdbc.pool.OracleDataSource; // pour OracleDataSource
import javax.sql.DataSource;



public class Tpjdbc {


		
		private static OracleDataSource ods ; // variable de classe donc partagée par les instances
		private java.sql.Connection connect;
		private java.sql.Statement stmt;
		private java.sql.PreparedStatement contrat;
		private java.sql.CallableStatement newligne;	

		/* 
		 * Constructeur - se connecte à la base Oracle et initialise les statements variables d'instance
		 * @param login  nom d'utilisateur Oracle
		 * @param passwd mot de passe correspondant
		 */
		public Tpjdbc(String login, String passwd) {
			// on se connecte
			this.seConnecter(login, passwd);
			// on continue.
			// Si la connexion ne s'est pas faite, on a affiché le message d'erreur "erreur connexion ..."
			// La première instruction qui suit déclenchera java.lang.NullPointerException
			try {
				this.stmt = this.connect.createStatement();
				this.contrat = this.connect.prepareStatement("select * from JFROOS.TABLE_TEST where texte LIKE ?");
				this.newligne = this.connect.prepareCall("{? =call JFROOS.inserer_ligne(?)}");
				
				    
			} catch (SQLException e) {
				System.err.println("pb de creation du Statement : " + e.getErrorCode() + " " + e.getMessage());
			}
		}

		/*
		 * Connexion à Oracle
		 * @param login  nom d'utilisateur Oracle
		 * @param passwd mot de passe correspondant
		 */
		public void seConnecter(String login, String passwd) {
			try {
				// 1ère solution sans utiliser de DataSource  :
				//---------------------------------------------
				// this.connect =
				//   DriverManager.getConnection("jdbc:oracle:thin:@oracle.fil.univ-lille1.fr:1521:filora",login, passwd);
	 
				// 2ème solution avec DataSource :
				//--------------------------------
				if (Tpjdbc.ods == null) {
					Tpjdbc.ods = new OracleDataSource(); // gère les connexions pour tous les objets Rapido
				}
				ods.setURL("jdbc:oracle:thin:@oracle.fil.univ-lille.fr:1521:filora");
				ods.setUser(login);
				ods.setPassword(passwd);
				this.connect = ods.getConnection();
			} catch (SQLException e) {
				System.err.println("erreur connexion " + e.getErrorCode() + " " + e.getMessage());
			}
		}

		/*
		 * Déconnexion
		 * En se déconnectant, on ferme toutes les ressources encore ouvertes liées à la connexion : ResultSet, statements
		 */
		public void seDeconnecter() {
			try {
				this.connect.close();
				this.stmt.close();
				
			} catch (SQLException e) {
				System.err.println("erreur déconnexion " + e.getErrorCode() + " " + e.getMessage());
			}
		}
		
		
		
		public void lireTableTest() {
			try {
				ResultSet rs = this.stmt.executeQuery("SELECT * FROM JFROOS.TABLE_TEST");
				while(rs.next()) {
					System.out.println(rs.getInt("id") + " : " + rs.getString("texte") );
				}
				// on ferme le ResultSet
				rs.close();
			}
			
			catch(SQLException e){
				System.err.println("erreur dans lireTable" + e.getErrorCode() + " " + e.getMessage());
			}
		}
		
		
		public void lireTableTestAmeliore(String s) {
			try {
				
				// on fixe la valeur du paramètre de la requête
				this.contrat.setString(1, "%" + s + "%");
				// on exécute la requête select et on récupère le résultat dans une variable de type ResultSet
				ResultSet rs = this.contrat.executeQuery();
				// on traite le résultat
				while (rs.next()) { 
					 System.out.println(rs.getInt("id") + " : " + rs.getString("texte"));
					 } 
				// on ferme le ResultSet 
				rs.close();
			} catch (SQLException e) {
				 System.out.println("erreur dans lireTableTestAmeliore" + e.getErrorCode() + " " + e.getMessage());
			}
		}
		
		
		public int insererLigne(String s) {
			
			try {
				// On fixe les valeurs des parametres
				this.newligne.setString(2,s);
				// on précise le type du résultat
				this.newligne.registerOutParameter(1, java.sql.Types.INTEGER);
				
				// On execute la procedure
				this.newligne.execute();
				
				// On recupere le resultat
				return this.newligne.getInt(1);
			}
		 catch (SQLException e) {
			 System.out.println("erreur dans insererLigne" + e.getErrorCode() + " " + e.getMessage());
			 return 0;
		}
			
		}

	public static void main(String[] args) {
		
		// lecture d'un nom d'utilisateur et d'un mot de passe
				Console console = System.console();
				String name = console.readLine("[Identifiant BDD]: ");
				char[] pdt = console.readPassword("[Mot de passe]: ");
				String passdata = new String(pdt);

				// on teste les méthodes
				// on crée deux objets Rapido, i.e. deux connexions à la base avec le même utilisateur
				Tpjdbc obj = new Tpjdbc(name, passdata); // connexion via le constructeur
				System.out.println("ok ouverture connexion obj\n");
				
				System.out.println("Lecture de la table /");
				obj.lireTableTest();
				
				System.out.println("Lecture de la colonne contenant LA");
				obj.lireTableTestAmeliore("la");
			
				
				//System.out.println("Insertion dans la table et retour de l'idantifiant :" + obj.insererLigne("Plata o Plomo"));
				
		
				
				// on se déconnecte
				obj.seDeconnecter();
				System.out.println("ok fermeture connexion obj");
		
	}

}
