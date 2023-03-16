package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.inti.entities.Avis;
import com.inti.entities.Reservation;
import com.inti.entities.Role;
import com.inti.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long> {

	Utilisateur findByUsername(String username);

	List<Utilisateur> findByNomUtilisateur(String nomUtilisateur);

	// ====Les rôles====//
	
	List<Role> findRoleByIdUtilisateur(@Param("idUtilisateur") Long idUtilisateur);
	
	
	//===Les avis===//

	List<Avis> findAvisByIdUtilisateur(Long idUtilisateur);
	
	//===Les réservations===//

	List<Reservation> findReservationByIdUtilisateur(Long idUtilisateur);
	
	
	
	


}
