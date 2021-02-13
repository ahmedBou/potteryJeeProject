package metier.entities;

import java.util.Arrays;

public class Potterie {
	private long id;
	private String nom;
	private int quantite;
	private double prix;
	byte[] images;
	String description;
	public Potterie(long id, String nom, int quantite, double prix, byte[] images, String description) {
		super();
		this.id = id;
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
		this.images = images;
		this.description = description;
	}
	
	
	public Potterie(String nom, int quantite, double prix, byte[] images, String description) {
		super();
		this.nom = nom;
		this.quantite = quantite;
		this.prix = prix;
		this.images = images;
		this.description = description;
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
	public byte[] getImages() {
		return images;
	}
	public void setImages(byte[] images) {
		this.images = images;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Potterie [id=" + id + ", nom=" + nom + ", quantite=" + quantite + ", prix=" + prix + ", images="
				+ Arrays.toString(images) + ", description=" + description + "]";
	}
	
	

	
	



	
	

}
