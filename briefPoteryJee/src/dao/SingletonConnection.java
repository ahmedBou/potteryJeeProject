package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
	

		private static Connection connection;
		
		// quand une class est charg�e au m�moire, c'est le bloc static qui s'execute le premier
		static {
			//pr creer la connection, j'ai besoin de charger le pilote jdbc
			try { 

				connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/potteryDb", "postgres", "admin");
			} catch (Exception e) { // si le pilote n'existe pas
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		// methode qui retourner l'objet connection qui deja creer au moment de chargment de la class au memoire
		public static Connection getConnection() {
			return connection;
		}
 
		
	

	
}


//conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/potteryDb", "postgres", "admin");