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

		try {
			PreparedStatement ps = connection.prepareStatement("INSERT INTO products(nom,quantite, prix,images,\"desc\")VALUES(?,?,?,?,?)");
			
			System.out.println(ps);
			ps.setString(1, p.getNom());
			ps.setInt(2, p.getQuantite());
			ps.setDouble(3, p.getPrix());
			ps.setBytes(4, p.getImages());
			ps.setString(5, p.getDescription());
			ps.executeUpdate();
			PreparedStatement ps2 = connection.prepareStatement("" +
			                             "SELECT MAX(idproducts) as MAX_ID FROM products");
			
			ResultSet rs = ps2.executeQuery();
			System.out.println(p.getNom());
			System.out.println(p.getQuantite());
			System.out.println(p.getImages());
			System.out.println(p.getDescription());

			if (rs.next()) {
				p.setId(rs.getLong("MAX_ID"));
			}
			System.out.println(ps);

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
		List <Potterie> potterie = new ArrayList<Potterie>();
		Connection connection = SingletonConnection.getConnection();
		try {
			PreparedStatement ps = connection.prepareStatement(""
					+ "SELECT * FROM products WHERE nom LIKE ?");
			
			ps.setString(1, nm);
			System.out.println(ps);
			// execute la requette
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Potterie p = new Potterie();
				p.setId(rs.getLong("idproducts"));
				p.setNom(rs.getString("nom"));
				p.setQuantite(rs.getInt("quantite"));
				p.setPrix(rs.getDouble("prix"));
				p.setImages(rs.getBytes("images"));
				potterie.add(p);
			}
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// apres la creation du plantes et le stockage je retourne la liste des plantes
		return potterie;

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
			System.out.println(sp);
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
	public Potterie updatePotterie(Potterie p) {
		Connection connection = SingletonConnection.getConnection();

		try {                                         
			PreparedStatement ps = connection.prepareStatement("UPDATE public.products SET nom=?, quantite=?, prix=?, images=?, \"desc\"=?\r\n"
					+ "	WHERE idproducts=?");
			
			System.out.println(ps);
			
			ps.setString(1, p.getNom());
			ps.setInt(2, p.getQuantite());
			ps.setDouble(3, p.getPrix());
			ps.setBytes(4, p.getImages());
			ps.setString(5, p.getDescription());
			ps.setLong(6, p.getId());
			ps.executeUpdate();

			// fermer l'objet preparedStatement
			ps.close();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return p;

	}

	@Override
	public void delete(long id) {
		Connection connection = SingletonConnection.getConnection();

		try {
			PreparedStatement ps = connection.prepareStatement("delete from products where idproducts=?");
		
			
			
			ps.setLong(1, id);
			System.out.println(id);
			System.out.println(ps);
	
	
			ps.executeUpdate();
			// fermer l'objet preparedStatement
			ps.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public Potterie getPotterie(Long id) {

			Potterie prd = null;
			Connection connection = SingletonConnection.getConnection();
			try {
				PreparedStatement ps = connection.prepareStatement(""
						+ "select * FROM products WHERE idproducts=?");
				
				ps.setLong(1, id); 
				// execute la requette
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					prd = new Potterie();
					prd.setId(rs.getLong("idproducts"));
					prd.setNom(rs.getString("nom"));
					prd.setQuantite(rs.getInt("quantite"));
					prd.setPrix(rs.getDouble("prix"));
					prd.setImages(rs.getBytes("images"));
				
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// apres la creation du plantes et le stockage je retourne la liste des plantes
			return prd ;
		}

	@Override
	public int getVotePrd(long id) {
		Connection connection;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        int count = 0;
        try {
        	connection = SingletonConnection.getConnection();
            String query_Count = "SELECT count (personid)\r\n"
            		+ "	FROM public.vote where idproducts= ?";
            statement = connection.prepareStatement(query_Count);
            statement.setLong(1, id);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                count = resultSet.getInt(1);
                
            }
            System.out.println(count);
        } catch (SQLException e) {
        	e.printStackTrace();
        }
		return count;
	}


}
