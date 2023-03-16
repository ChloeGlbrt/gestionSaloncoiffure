package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Salon implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idSalon;
	private String nomSalon;
	private String adresseSalon;

//=====Relations====//

	@OneToMany(mappedBy = "salonFK", cascade = { CascadeType.ALL })
	@Transient
	private List<Reservation> reservation = new ArrayList<>();

//=====Constructeurs====//

	public Salon() {
	}

	public Salon(String nomSalon, String adresseSalon) {
		this.nomSalon = nomSalon;
		this.adresseSalon = adresseSalon;
	}

	public Salon(String nomSalon, String adresseSalon, List<Reservation> reservation) {
		this.nomSalon = nomSalon;
		this.adresseSalon = adresseSalon;
		this.reservation = reservation;
	}

	public Salon(Long idSalon, String nomSalon, String adresseSalon, List<Reservation> reservation) {
		this.idSalon = idSalon;
		this.nomSalon = nomSalon;
		this.adresseSalon = adresseSalon;
		this.reservation = reservation;
	}

//=====Setters & Getters====//

	public Long getIdSalon() {
		return idSalon;
	}

	public void setIdSalon(Long idSalon) {
		this.idSalon = idSalon;
	}

	public String getNomSalon() {
		return nomSalon;
	}

	public void setNomSalon(String nomSalon) {
		this.nomSalon = nomSalon;
	}

	public String getAdresseSalon() {
		return adresseSalon;
	}

	public void setAdresseSalon(String adresseSalon) {
		this.adresseSalon = adresseSalon;
	}

	public List<Reservation> getReservations() {
		return reservation;
	}

	public void setReservations(List<Reservation> reservation) {
		this.reservation = reservation;
	}
//=====toString()====//

	@Override
	public String toString() {
		return "Salon [idSalon=" + idSalon + ", nomSalon=" + nomSalon + ", adresseSalon=" + adresseSalon
				+ ", reservation=" + reservation + "]";
	}
	
	
}
