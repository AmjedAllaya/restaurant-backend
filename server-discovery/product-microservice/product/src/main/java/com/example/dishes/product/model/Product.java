package com.example.dishes.product.model;


import javax.persistence.*;

@javax.persistence.Entity
public class Product {
	@javax.persistence.Id
	@javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
	private java.lang.Long Id;
	private java.lang.String nom;
	private java.lang.Double prix;
	
	
	public Product(java.lang.Long id, java.lang.String nom, java.lang.Double prix) {
		super();
		Id = id;
		this.nom = nom;
		this.prix = prix;
	}

	public Product() {

	}

	public java.lang.Long getId() {
		return Id;
	}
	public void setId(java.lang.Long id) {
		Id = id;
	}
	public java.lang.String getNom() {
		return nom;
	}
	public void setNom(java.lang.String nom) {
		this.nom = nom;
	}
	public java.lang.Double getPrix() {
		return prix;
	}
	public void setPrix(java.lang.Double prix) {
		this.prix = prix;
	}
	
	

}
