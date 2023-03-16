package com.inti.restController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Prestation;
import com.inti.entities.Reservation;
import com.inti.entities.Salon;
import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IPrestationService;
import com.inti.service.interfaces.IReservationService;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@CrossOrigin
public class ReservationController {

	@Autowired
	IReservationService reservationService;
	

//====les Find====//

	@GetMapping("/reservations")
	public List<Reservation> findAll() {
		return reservationService.findAll();
	}

	@GetMapping("/reservations/{idReservation}")
	public Reservation findOne(@PathVariable("idReservation") Long id) {
		return reservationService.findOne(id);
	}
	
	@GetMapping ("/reservations /{dateReservation}")
	public Reservation findByDateReservation(@RequestParam("dateReservation")  Date dateReservation) {
		return reservationService.findByDateReservation(dateReservation);
	}

	
//====Les salons====//	
	
	@GetMapping("/salons/{idSalon}/reservations")
	public List <Salon> findSalonByIdReservation(@PathVariable("idSalon")  Long idSalon) {
		return reservationService.findSalonByIdReservation(idSalon);
	} 
	
//===Les prestations===//
	/*
	@GetMapping("/prestations/{idPrestation}/reservations")
	public List<Prestation> findPrestationByIdReservation(@PathVariable("idPrestation")  Long idPrestation) {
		return reservationService.findPrestationByIdReservation(idPrestation);
	}
	*/
	/*
//===Les utilisateurs===//
	
	@GetMapping("/utilisateurs/{idUtilisateur}/reservations")
	public List<Utilisateur> findUtilisateurByIdReservation(@PathVariable("idUtilisateur")  Long idUtilisateur) {
		return reservationService.findUtilisateurByIdReservation(idUtilisateur);
	}

	 */
//====les Save====//

	@PostMapping("/reservations")
	public Reservation save(@RequestBody Reservation reservation) {
		return reservationService.save(reservation);
	}

//====Les delete====//

	@DeleteMapping("/reservations/{idReservation}")
	public void delete(@PathVariable("idReservation") Long id) {
		reservationService.delete(id);
	}

//====les update====//

	@PutMapping("/reservations/{idReservation}")
	public Reservation updateReservationWithPut(@PathVariable("idReservation") Long id,
			@RequestBody Reservation reservation) {
		Reservation currentReservation = reservationService.findOne(id);
		currentReservation.setDateReservation(reservation.getDateReservation());
		return reservationService.save(currentReservation);
	}
}
