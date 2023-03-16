package com.inti.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Avis;
import com.inti.entities.Utilisateur;
import com.inti.repositories.AvisRepository;
import com.inti.service.interfaces.IAvisService;

@Service
public class AvisService implements IAvisService {

	@Autowired
	AvisRepository avisRepository;

	@Override
	public List<Avis> findAll() {
		return avisRepository.findAll();
	}

	@Override
	public Avis findOne(Long id) {
		return avisRepository.findById(id).get();
	}

	@Override
	public Avis save(Avis avis) {
		return avisRepository.save(avis);
	}

	@Override
	public void delete(Long id) {
		avisRepository.deleteById(id);
	}

	@Override
	public Avis findByTitreAvis(String titreAvis) {
		return avisRepository.findByTitreAvis(titreAvis);
	}

	@Override
	public List<Avis> findByUtilisateurFK2_IdUtilisateur(Long idUtilisateur) {
		return avisRepository.findByUtilisateurFK2_IdUtilisateur(idUtilisateur);
	}

	
}
