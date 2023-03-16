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

@Entity
public class Prestation implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idPrestation;
	private String nomPrestation;
	
//=====Relations====//
	
	@ManyToOne
	@JoinColumn(name="idReservation")
	private Reservation reservationFK2;
	
//=====Constructeurs====//

	public Prestation() {}

	public Prestation(String nomPrestation) {
		this.nomPrestation = nomPrestation;
	}

	public Prestation(String nomPrestation, Reservation reservationFK2) {
		this.nomPrestation = nomPrestation;
		this.reservationFK2 = reservationFK2;
	}

	public Prestation(Long idPrestation, String nomPrestation, Reservation reservationFK2) {
		this.idPrestation = idPrestation;
		this.nomPrestation = nomPrestation;
		this.reservationFK2 = reservationFK2;
	}
	
//====Getters & Setters====//

	public Long getIdPrestation() {
		return idPrestation;
	}

	public void setIdPrestation(Long idPrestation) {
		this.idPrestation = idPrestation;
	}

	public String getNomPrestation() {
		return nomPrestation;
	}

	public void setNomPrestation(String nomPrestation) {
		this.nomPrestation = nomPrestation;
	}

	public Reservation getReservationFK2() {
		return reservationFK2;
	}

	public void setReservationFK2(Reservation reservationFK2) {
		this.reservationFK2 = reservationFK2;
	}

//====toString()====//
	
	@Override
	public String toString() {
		return "Prestation [idPrestation=" + idPrestation + ", nomPrestation=" + nomPrestation + ", reservationFK2="
				+ reservationFK2 + "]";
	}
	


}
