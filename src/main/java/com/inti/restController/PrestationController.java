package com.inti.restController;

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
import com.inti.service.interfaces.IPrestationService;
import com.inti.service.interfaces.IReservationService;

@RestController
@CrossOrigin
public class PrestationController {
	
	@Autowired
	IPrestationService prestationService;
	
	
//====les Find====//
	
	@GetMapping("/prestations")
	public List<Prestation> findAll() {
		return prestationService.findAll();
	}

	@GetMapping("/prestations/{idPrestation}")
	public Prestation findOne(@PathVariable("idPrestation") Long id) {
		return prestationService.findOne(id);
	}
	
	@GetMapping("/prestations/{nomPrestation}")
	public Prestation findBynomPrestation(@RequestParam("nomPrestation")  String nomPrestation) {
		return prestationService.findBynomPrestation(nomPrestation);
	}

//===Les réservations===//	
	
	@GetMapping("/prestations/{idPrestation}/reservations")
	public List<Reservation> findReservationByIdPrestation (@PathVariable("idPrestation")  Long idPrestation) {
		return prestationService.findReservationByIdPrestation(idPrestation);
	}

	
//====les Save====//

	@PostMapping("/prestations")
	public Prestation save(@RequestBody Prestation prestation) {
		return prestationService.save(prestation);
	}

//====Les delete====//


	@DeleteMapping("/prestations/{idPrestation}")
	public void delete(@PathVariable("idPrestation") Long id) {
		prestationService.delete(id);
	}

//====les update====//
		
	@PutMapping("/prestations/{idPrestation}")
	public Prestation updatePrestationWithPut(@PathVariable("idPrestation") Long id, @RequestBody Prestation prestation) {
		Prestation currentPrestation = prestationService.findOne(id);
		currentPrestation.setNomPrestation(prestation.getNomPrestation());
		return prestationService.save(currentPrestation);
	}

}
