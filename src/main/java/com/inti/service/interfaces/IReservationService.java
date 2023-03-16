package com.inti.service.interfaces;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.query.Param;

import com.inti.entities.Prestation;
import com.inti.entities.Reservation;
import com.inti.entities.Salon;
import com.inti.entities.Utilisateur;

public interface IReservationService {

	List<Reservation> findAll();

	Reservation findOne(Long id);

	Reservation save(Reservation reservation);

	void delete(Long id);

	Reservation findByDateReservation(Date dateReservation);

	//===Les prestations===//

	//	List<Reservation> findByIdPrestation (Long idPrestation);

		List<Prestation> findPrestationByIdReservation(Long idReservation);
		
	//===Les utilisateurs===//
		
	//	List<Reservation> findByIdUtilisateur(Long idUtilisateur);
		
		List<Utilisateur> findUtilisateurByIdReservation(Long idReservation);

	//===Les salons===//

	//	List<Reservation> findByIdSalon(Long idSalon);
		
		List<Salon> findSalonByIdReservation(Long idReservation);

}
