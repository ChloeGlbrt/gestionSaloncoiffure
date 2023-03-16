package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Reservation;
import com.inti.entities.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {

	Salon findBynomSalon(String nomSalon);

	List<Reservation> findReservationByIdSalon(Long idSalon);

	// List<Salon> findByIdReservation (Long idReservation);

}
