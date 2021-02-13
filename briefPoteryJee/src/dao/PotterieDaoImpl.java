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
		// String SQL_SELECT = "Select * ";

		try {
			PreparedStatement ps = connection.prepareStatement(
					"" + "INSERT INTO products(nom,quantite, prix,images,description)VALUES(?,?,?,?,?)");
			ps.setString(1, p.getNom());
			ps.setInt(2, p.getQuantite());
			ps.setDouble(3, p.getPrix());
			ps.setBytes(4, p.getImages());
			ps.setString(5, p.getDescription());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("" + "SELECT MAX(id) as MAX_ID FROM plantes");
			ResultSet rs = ps2.executeQuery();

			if (rs.next()) {
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
//		Potterie pr = new Potterie(0, nm, 1, 2, 0);
//		pList.add(pr);

		return pList;
	}

	@Override
	public Potterie getPotterie(Potterie id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Potterie> getPotterie() {
		ArrayList<Potterie> pottery = new ArrayList<Potterie>();
		Connection connection = null;
		PreparedStatement sp = null;
		ResultSet rs = null;
		try {
			connection = SingletonConnection.getConnection();
			String query = "SELECT * FROM products";
			sp = connection.prepareStatement(query);
			rs = sp.executeQuery();
			while (rs.next()) {
				int id = rs.getInt(1);
				String nom = rs.getString(2);
				int quant = rs.getInt(3);
				double prix = rs.getDouble(4);
				byte[] images = rs.getBytes(5);
				String desc = rs.getString(6);
				Potterie p = new Potterie(id, nom, quant, prix, images, desc);
				pottery.add(p);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pottery;

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
