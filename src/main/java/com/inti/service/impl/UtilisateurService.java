package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Avis;
import com.inti.entities.Reservation;
import com.inti.entities.Role;
import com.inti.entities.Utilisateur;
import com.inti.repositories.AvisRepository;
import com.inti.repositories.ReservationRepository;
import com.inti.repositories.UtilisateurRepository;
import com.inti.service.interfaces.IUtilisateurService;

@Service
public class UtilisateurService implements IUtilisateurService {

	@Autowired
	UtilisateurRepository utilisateurRepository;


//====Méthodes====//

	@Override
	public List<Utilisateur> findAll() {
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findOne(Long id) {
		return utilisateurRepository.findById(id).get();
	}

	@Override
	public Utilisateur saveUtilisateur(Utilisateur utilisateur) {
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void deleteUtilisateur(Long id) {
		utilisateurRepository.deleteById(id);

	}

	@Override
	public Utilisateur findByUsername(String username) {
		return utilisateurRepository.findByUsername(username);
	}

	@Override
	public List<Utilisateur> findByNomUtilisateur(String nomUtilisateur) {
		return utilisateurRepository.findByNomUtilisateur(nomUtilisateur);
	}

	@Override
	public List<Role> findRoleByIdUtilisateur(Long idUtilisateur) {
		return utilisateurRepository.findRoleByIdUtilisateur(idUtilisateur);
	}

	@Override
	public List<Avis> findAvisByIdUtilisateur(Long idUtilisateur) {
		return utilisateurRepository.findAvisByIdUtilisateur(idUtilisateur);
	}

	@Override
	public List<Reservation> findReservationByIdUtilisateur(Long idUtilisateur) {
		return utilisateurRepository.findReservationByIdUtilisateur(idUtilisateur);
	}

	

	
	
	

}
