package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Prestation;
import com.inti.entities.Reservation;

@Repository
public interface PrestationRepository extends JpaRepository<Prestation, Long> {

	Prestation findBynomPrestation(String nomPrestation);

	//List<Prestation> findByIdReservation(Long idReservation);

	List<Reservation> findReservationByIdPrestation(Long idPrestation);
}
