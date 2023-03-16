package com.inti.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.entities.Prestation;
import com.inti.entities.Reservation;
import com.inti.entities.Salon;
import com.inti.entities.Utilisateur;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {

	Reservation findByDateReservation(Date dateReservation);
	
//===Les prestations===//

	//List<Reservation> findByIdPrestation (Long idPrestation);

	List<Prestation> findPrestationByIdReservation(Long idReservation);
	
//===Les utilisateurs===//
	
//	List<Reservation> findByIdUtilisateur(Long idUtilisateur);
	
	List<Utilisateur> findUtilisateurByIdReservation(Long idReservation);

//===Les salons===//

//	List<Reservation> findByIdSalon(Long idSalon);
	
	List<Salon> findSalonByIdReservation(Long idReservation);
	

	

	
}
