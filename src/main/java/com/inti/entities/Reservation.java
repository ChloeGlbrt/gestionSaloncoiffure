package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Reservation implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idReservation;
	@Temporal(TemporalType.DATE)
	private Date dateReservation;

	// =====Relations====//

	@OneToMany(mappedBy = "reservationFK2", cascade = { CascadeType.ALL })
	@Transient
	private List<Prestation> prestations = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "idSalon")
	private Salon salonFK;

	@ManyToOne
	@JoinColumn(name = "idUtilisateur")
	private Utilisateur utilisateurFK;

//=====Constructeurs====//
	public Reservation() {
	}

	public Reservation(Long idReservation, Date dateReservation) {
		this.idReservation = idReservation;
		this.dateReservation = dateReservation;
	}

	public Reservation(Date dateReservation, List<Prestation> prestations, Salon salonFK, Utilisateur utilisateurFK) {
		this.dateReservation = dateReservation;
		this.prestations = prestations;
		this.salonFK = salonFK;
		this.utilisateurFK = utilisateurFK;
	}

	public Reservation(Long idReservation, Date dateReservation, List<Prestation> prestations, Salon salonFK,
			Utilisateur utilisateurFK) {
		this.idReservation = idReservation;
		this.dateReservation = dateReservation;
		this.prestations = prestations;
		this.salonFK = salonFK;
		this.utilisateurFK = utilisateurFK;
	}

//====Getters & Setters====//

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}

	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}

	public List<Prestation> getPrestations() {
		return prestations;
	}

	public void setPrestations(List<Prestation> prestations) {
		this.prestations = prestations;
	}


	public Salon getSalonFK() {
		return salonFK;
	}

	public void setSalonFK(Salon salonFK) {
		this.salonFK = salonFK;
	}

	public Utilisateur getUtilisateurFK() {
		return utilisateurFK;
	}

	public void setUtilisateurFK(Utilisateur utilisateurFK) {
		this.utilisateurFK = utilisateurFK;
	}

//====toString()====//
	
	@Override
	public String toString() {
		return "Reservation [idReservation=" + idReservation + ", dateReservation=" + dateReservation + ", prestations="
				+ prestations + ", salonFK=" + salonFK + ", utilisateurFK=" + utilisateurFK + "]";
	}


	

}
