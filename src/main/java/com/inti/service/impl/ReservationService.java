package com.inti.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Prestation;
import com.inti.entities.Reservation;
import com.inti.entities.Salon;
import com.inti.entities.Utilisateur;
import com.inti.repositories.PrestationRepository;
import com.inti.repositories.ReservationRepository;
import com.inti.repositories.SalonRepository;
import com.inti.repositories.UtilisateurRepository;
import com.inti.service.interfaces.IReservationService;

@Service
public class ReservationService implements IReservationService {

	@Autowired
	ReservationRepository reservationRepository;
	
	
	
//====Méthodes====//

	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation findOne(Long id) {
		return reservationRepository.findById(id).get();
	}

	@Override
	public Reservation save(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public void delete(Long id) {
		reservationRepository.deleteById(id);

	}

	@Override
	public Reservation findByDateReservation(Date dateReservation) {
		return reservationRepository.findByDateReservation(dateReservation);
	}

	
	@Override
	public List<Prestation> findPrestationByIdReservation(Long idReservation) {
		return reservationRepository.findPrestationByIdReservation(idReservation);
	}

	
	@Override
	public List<Utilisateur> findUtilisateurByIdReservation(Long idReservation) {
		return reservationRepository.findUtilisateurByIdReservation(idReservation);
	}

	
	@Override
	public List<Salon> findSalonByIdReservation(Long idReservation) {
		return reservationRepository.findSalonByIdReservation(idReservation);
	}

	/*
	@Override
	public List<Reservation> findByIdPrestation(Long idPrestation) {
		return reservationRepository.findByIdPrestation(idPrestation);
	}

	@Override
	public List<Reservation> findByIdUtilisateur(Long idUtilisateur) {
		return reservationRepository.findByIdUtilisateur(idUtilisateur);
	}

	@Override
	public List<Reservation> findByIdSalon(Long idSalon) {
		return reservationRepository.findByIdSalon(idSalon);
	}

	*/


}
