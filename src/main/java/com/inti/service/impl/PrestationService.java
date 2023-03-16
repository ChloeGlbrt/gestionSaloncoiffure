package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Prestation;
import com.inti.entities.Reservation;
import com.inti.repositories.PrestationRepository;
import com.inti.repositories.ReservationRepository;
import com.inti.service.interfaces.IPrestationService;

@Service
public class PrestationService implements IPrestationService {

	@Autowired
	PrestationRepository prestationRepository;
	
	

	@Override
	public List<Prestation> findAll() {
		return prestationRepository.findAll();
	}

	@Override
	public Prestation findOne(Long id) {

		return prestationRepository.findById(id).get();
	}

	@Override
	public Prestation save(Prestation prestation) {
		return prestationRepository.save(prestation);
	}

	@Override
	public void delete(Long id) {
		prestationRepository.deleteById(id);
	}

	@Override
	public Prestation findBynomPrestation(String nomPrestation) {
		return prestationRepository.findBynomPrestation(nomPrestation);
	}

	@Override
	public List<Reservation> findReservationByIdPrestation(Long idPrestation) {
		return prestationRepository.findReservationByIdPrestation(idPrestation);
	}
 /*
	@Override
	public List<Prestation> findByIdReservation(Long idReservation) {
		return prestationRepository.findByIdReservation(idReservation);
	}

*/

	


}
