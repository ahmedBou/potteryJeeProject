package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.entities.Potterie;

public class PotterieDaoImpl implements PotterieDao {

	@Override
	public Potterie save(Potterie p) {
		Connection connection = SingletonConnection.getConnection();
		//String SQL_SELECT = "Select * ";
		
		try {
			PreparedStatement ps = connection.prepareStatement(""
					+ "INSERT INTO products(nom,quantite, prix, vote)VALUES(?,?,?,?)");
			ps.setString(1, p.getNom());
			ps.setInt(2, p.getQuantite());
			ps.setDouble(3, p.getPrix());
			ps.setDouble(4, p.getVotes());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement(""
					+ "SELECT MAX(id) as MAX_ID FROM plantes");
			ResultSet rs = ps2.executeQuery();
			
			if(rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			
			// fermer l'objet preparedStatement
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public List<Potterie> nmPotterie(String nm) {
		List<Potterie> pList = new ArrayList<Potterie>();
		Potterie pr = new Potterie(0, nm, 1, 2, 0);
		pList.add(pr);
		
		return pList;
	}

	@Override
	public Potterie getPotterie(Potterie id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Potterie> getPotterie() {
		ArrayList<Potterie> plantes = new ArrayList<Potterie>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement sp = connection.prepareStatement("select * from products");
			ResultSet rs = sp.executeQuery();
			while(rs.next()) {
				long a = rs.getInt(1);
				String d = rs.getString(2);
				int c = rs.getInt(3);
				double b = rs.getDouble(4);
				int v = rs.getInt(5);
				Potterie  p = new Potterie(a, d, c, b, v);
				plantes.add(p);	
			}
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return plantes;
	
	}

	@Override
	public void updatePotterie(Potterie p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub
		
	}

}
