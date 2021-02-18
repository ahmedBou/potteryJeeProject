package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class VoteForProductsImpl implements VoteDao {
	
	@Override
	public void makeVote(int idUser, int idPrd) {
		// TODO Auto-generated method stub
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO public.vote(\r\n"
					+ "	personid, idproducts)\r\n"
					+ "	VALUES (?, ?)");
			
			
			ps.setInt(1, idUser);
			ps.setInt(2, idPrd);
			ps.executeQuery();
			System.out.println(ps);
			// fermer l'objet preparedStatement
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
