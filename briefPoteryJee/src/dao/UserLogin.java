package dao;
import java.sql.SQLException;

import metier.entities.*;


public interface UserLogin {
	public User userLogin(String username, String password) throws ClassNotFoundException, SQLException;
        

}
