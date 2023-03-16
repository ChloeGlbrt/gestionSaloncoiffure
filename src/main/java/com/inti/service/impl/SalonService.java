package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Reservation;
import com.inti.entities.Salon;
import com.inti.repositories.ReservationRepository;
import com.inti.repositories.SalonRepository;
import com.inti.service.interfaces.ISalonService;

@Service
public class SalonService implements ISalonService {

	@Autowired
	SalonRepository salonRepository;
	

	
//====Méthodes====//	

	@Override
	public List<Salon> findAll() {
		return salonRepository.findAll();
	}

	@Override
	public Salon findOne(Long id) {
		return salonRepository.findById(id).get();
	}

	@Override
	public Salon save(Salon salon) {
		return salonRepository.save(salon);
	}

	@Override
	public void delete(Long id) {
		salonRepository.deleteById(id);

	}

	@Override
	public Salon findBynomSalon(String nomSalon) {
		return salonRepository.findBynomSalon(nomSalon);
	}

	@Override
	public List<Reservation> findReservationByIdSalon(Long idSalon) {
		return salonRepository.findReservationByIdSalon(idSalon);
	}

	/*
	@Override
	public List<Salon> findByIdReservation(Long idReservation) {
		return salonRepository.findByIdReservation(idReservation);
	}

*/

	
	

	

}
