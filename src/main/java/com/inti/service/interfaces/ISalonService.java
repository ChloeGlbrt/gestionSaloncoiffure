package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Reservation;
import com.inti.entities.Salon;

public interface ISalonService {

	List<Salon> findAll();

	Salon findOne(Long id);

	Salon save(Salon salon);

	void delete(Long id);

	Salon findBynomSalon(String nomSalon);
	
//=====Récupération de la liste des réservations====//

	List<Reservation> findReservationByIdSalon(Long idSalon);

	// List<Salon> findByIdReservation (Long idReservation);

	

}
