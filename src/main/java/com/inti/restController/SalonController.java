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

import com.inti.entities.Reservation;
import com.inti.entities.Salon;
import com.inti.service.interfaces.IReservationService;
import com.inti.service.interfaces.ISalonService;

@RestController
@CrossOrigin
public class SalonController {

	@Autowired
	ISalonService salonService;
	
	

//=====les Find====//

	@GetMapping("/salons")
	public List<Salon> findAll() {
		return salonService.findAll();
	}

	@GetMapping("/salons/{idSalon}")
	public Salon findOne(@PathVariable("idSalon") Long id) {
		return salonService.findOne(id);
	}

	@GetMapping("/salons/{nomSalon}")
	public Salon findBynomSalon(@RequestParam("nomSalon")  String nomSalon) {
		return salonService.findBynomSalon(nomSalon);
	}
	
	@GetMapping("salons/ {idSalon}/reservations")
	public List<Reservation> findReservationByIdSalon(@PathVariable("idSalon")  Long idSalon) {
		return salonService.findReservationByIdSalon(idSalon);
	}
	
//=====les save====//

	@PostMapping("/salons")
	public Salon save(@RequestBody Salon salon) {
		return salonService.save(salon);
	}

// =====les delete====//

	@DeleteMapping("/salons/{idSalon}")
	public void delete(@PathVariable("idSalon") Long id) {
		salonService.delete(id);
	}

// =====les update====//

	@PutMapping("/salons/{idSalon}")
	public Salon updateSalonWithPut(@PathVariable("idSalon") Long id, @RequestBody Salon salon) {
		Salon currentSalon = salonService.findOne(id);
		currentSalon.setNomSalon(salon.getNomSalon());
		currentSalon.setAdresseSalon(salon.getAdresseSalon());
		return salonService.save(currentSalon);
	}

}
