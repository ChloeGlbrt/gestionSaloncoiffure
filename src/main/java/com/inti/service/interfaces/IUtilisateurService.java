package com.inti.service.interfaces;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.inti.entities.Avis;
import com.inti.entities.Reservation;
import com.inti.entities.Role;
import com.inti.entities.Utilisateur;

public interface IUtilisateurService {

	List<Utilisateur> findAll();

	Utilisateur findOne(Long id);

	Utilisateur saveUtilisateur(Utilisateur utilisateur);

	void deleteUtilisateur(Long id);

	Utilisateur findByUsername(String username);

	List<Utilisateur> findByNomUtilisateur(String nomUtilisateur);

	// ====Les rôles====//
	
		List<Role> findRoleByIdUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
		
		
		//===Les avis===//

		List<Avis> findAvisByIdUtilisateur(Long idUtilisateur);
		
		//===Les réservations===//

		List<Reservation> findReservationByIdUtilisateur(Long idUtilisateur);

}
