package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Prestation;
import com.inti.entities.Reservation;

public interface IPrestationService {

	List<Prestation> findAll();

	Prestation findOne(Long id);

	Prestation save(Prestation prestation);

	void delete(Long id);

	Prestation findBynomPrestation (String nomPrestation);
	
//===Les réservations===//
	
	//List<Prestation> findByIdReservation(Long idReservation);

	List<Reservation> findReservationByIdPrestation(Long idPrestation);
}
