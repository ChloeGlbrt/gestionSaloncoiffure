package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.inti.repositories.AvisRepository;

@Entity
public class Avis implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAvis;
	private String titreAvis;
	private String descriptionAvis;
	
	
	

// =====Relations====//

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateurFK2;

// =====Constructeurs====//

	public Avis() {
	}

	public Avis(String titreAvis, String descriptionAvis) {
		this.titreAvis = titreAvis;
		this.descriptionAvis = descriptionAvis;
	}

	public Avis(String titreAvis, String descriptionAvis, Utilisateur utilisateurFK2) {
		this.titreAvis = titreAvis;
		this.descriptionAvis = descriptionAvis;
		this.utilisateurFK2 = utilisateurFK2;
	}

	public Avis(Long idAvis, String titreAvis, String descriptionAvis, Utilisateur utilisateurFK2) {
		this.idAvis = idAvis;
		this.titreAvis = titreAvis;
		this.descriptionAvis = descriptionAvis;
		this.utilisateurFK2 = utilisateurFK2;
	}

// =====Setters & Getters====//

	public Long getIdAvis() {
		return idAvis;
	}

	public void setIdAvis(Long idAvis) {
		this.idAvis = idAvis;
	}

	public String getTitreAvis() {
		return titreAvis;
	}

	public void setTitreAvis(String titreAvis) {
		this.titreAvis = titreAvis;
	}

	public String getDescriptionAvis() {
		return descriptionAvis;
	}

	public void setDescriptionAvis(String descriptionAvis) {
		this.descriptionAvis = descriptionAvis;
	}

	public Utilisateur getUtilisateurFK2() {
		return utilisateurFK2;
	}

	public void setUtilisateurFK2(Utilisateur utilisateurFK2) {
		this.utilisateurFK2 = utilisateurFK2;
	}

// =====toString()====//

	@Override
	public String toString() {
		return "Avis [idAvis=" + idAvis + ", titreAvis=" + titreAvis + ", descriptionAvis=" + descriptionAvis
				+ ", utilisateurFK2=" + utilisateurFK2 + "]";
	}

}
