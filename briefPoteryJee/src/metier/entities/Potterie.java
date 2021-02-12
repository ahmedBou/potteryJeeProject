package metier.entities;

public class Potterie {
	private long id;
	private String nom;
	private int quantite;
	private double prix;
	private int votes;
	
	
	public Potterie(long id, String nom, int quantite, double prix, int votes) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
		this.votes = votes;
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public int getQuantite() {
		return quantite;
	}


	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}


	public double getPrix() {
		return prix;
	}


	public void setPrix(double prix) {
		this.prix = prix;
	}


	public int getVotes() {
		return votes;
	}


	public void setVotes(int votes) {
		this.votes = votes;
	}


	@Override
	public String toString() {
		return "Potterie [id=" + id + ", nom=" + nom + ", quantite=" + quantite + ", prix=" + prix + ", votes=" + votes
				+ "]";
	}




	
	

}
