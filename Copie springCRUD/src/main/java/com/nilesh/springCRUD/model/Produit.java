package com.nilesh.springCRUD.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Produit implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProd;
    private String nomProd;
    private Double prixProd;

    @ManyToOne()
    private Category categorie;

    public Long getIdProd() {
        return idProd;
    }

    public void setIdProd(Long idProd) {
        this.idProd = idProd;
    }

    public String getNomProd() {
        return nomProd;
    }
	@FindBy(css="")
	private WebElement webElement;
	@FindBy(css="")
	private WebElement webElement;

    public void setNomProd(String nomProd) {
        this.nomProd = nomProd;
    }

    public Double getPrixProd() {
        return prixProd;
    }

    public void setPrixProd(Double prixProd) {
        this.prixProd = prixProd;
    }

    public Category getCategorie() {
        return categorie;
    }

    public void setCategorie(Category categorie) {
        this.categorie = categorie;
    }

    public Produit(Long idProd, String nomProd, Double prixProd) {
        this.idProd = idProd;
        this.nomProd = nomProd;
        this.prixProd = prixProd;
    }

    public Produit(String nomProd, Double prixProd) {
        this.nomProd = nomProd;
        this.prixProd = prixProd;
    }

    public Produit() {
    }
}
