package com.inti.restController;

import java.util.ArrayList;
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


import com.inti.entities.Avis;
import com.inti.entities.Reservation;
import com.inti.entities.Role;
import com.inti.entities.Utilisateur;
import com.inti.service.impl.AvisService;
import com.inti.service.interfaces.IAvisService;
import com.inti.service.interfaces.IReservationService;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@CrossOrigin
public class UtilisateurController {

	@Autowired
	IUtilisateurService utilisateurService;
	


//====les Find====//

	@GetMapping("/utilisateurs")
	public List<Utilisateur> findAll() {
		return utilisateurService.findAll();
	}

	@GetMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur findOne(@PathVariable("idUtilisateur") Long id) {
		return utilisateurService.findOne(id);
	}

	@GetMapping("/utilisateurs/{username}")
	public Utilisateur findByUsername(@RequestParam("username") String username) {
		return utilisateurService.findByUsername(username);
	}

	@GetMapping("/utilisateurs/{nomUtilisateur}")
	public List<Utilisateur> findByNomUtilisateur(@RequestParam("nomUtilisateur") String nomUtilisateur) {
		return utilisateurService.findByNomUtilisateur(nomUtilisateur);
	}

	@GetMapping("/utilisateurs/{idUtilisateur}/roles")
	public List<Role> findRolesByIdUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
		return utilisateurService.findRoleByIdUtilisateur(idUtilisateur);
	}
	/*	
	@GetMapping("/utilisateurs/{idUtilisateur}/avis")
	public List<Avis> findAvisByIdUtilisateur(@PathVariable("idUtilisateur")  Long idUtilisateur) {
		return utilisateurService.findAvisByIdUtilisateur(idUtilisateur);
	}
*/
	@GetMapping("/utilisateurs/{idUtilisateur}/reservations")
	public List<Reservation> findReservationByIdUtilisateur( @PathVariable("idUtilisateur") Long idUtilisateur) {
		return utilisateurService.findReservationByIdUtilisateur(idUtilisateur);
	}
	
/*
//=====Récupération des avis ====//

	@GetMapping("utilisateurs/{idUtilisateur}/avis")
	public List<String> getDescriptionAvisByUtilisateur(@PathVariable ("idUtilisateur")Long idUtilisateur) {
		List<Avis> avisList = utilisateurService.findAvisByIdUtilisateur(idUtilisateur);
		List<String> descriptionAvisList = new ArrayList<>();
		for (Avis avis : avisList) {
			descriptionAvisList.add(avis.getDescriptionAvis());
		}
		return descriptionAvisList;
	}

//====Récupération des réservations====//
	@GetMapping("utilisateurs/{idUtilisateur}/reservations")
	public List<Date> getListReservationByUtilisateur(@PathVariable ("idUtilisateur") Long idUtilisateur){
		List <Reservation> reservationList = utilisateurService.findReservationByIdUtilisateur(idUtilisateur);
		List<Date> dateReservationsList = new ArrayList<>();
		for (Reservation reservation : reservationList) {
			dateReservationsList.add(reservation.getDateReservation());
		}
		return dateReservationsList;
	}
*/	

//====les Save====//

	@PostMapping("/utilisateurs")
	public Utilisateur saveUtilisateur(@RequestBody Utilisateur utilisateur) {
		return utilisateurService.saveUtilisateur(utilisateur);
	}

//====Les delete====//

	@DeleteMapping("/utilisateurs/{idUtilisateur}")
	public void deleteUtilisateur(@PathVariable("idUtilisateur") Long id) {
		utilisateurService.deleteUtilisateur(id);

	}

	/*
	 * @PostMapping("/utilisateurs") public String
	 * saveUtilisateur(@RequestParam("nomFront") String
	 * nom,@RequestParam("prenomFront") String prenom,
	 * 
	 * @RequestParam("usernameFront") String login,@RequestParam("passwordFront")
	 * String password,@RequestParam("dateNaissanceFront") String
	 * dateNaissance, @RequestParam("imageFront") MultipartFile image) { try {
	 * Utilisateur currentUser=new Utilisateur();
	 * currentUser.setNomUtilisateur(nom); currentUser.setPrenomUtilisateur(prenom);
	 * currentUser.setUsername(login); currentUser.setPasswordUtilisateur(password);
	 * currentUser.setDateNaissanceUtilisateur(null);
	 * currentUser.setImage(image.getBytes()); utilisateurService.save(currentUser);
	 * return "File uploaded successfully!!"; }catch(Exception ex) {
	 * ex.printStackTrace(); return
	 * "Fail ! maybe you had uploaded the file before !!"; } }
	 * 
	 */

//====les update====//
	
	@PutMapping("/utilisateurs/{idUtilisateur}")
	public Utilisateur updateUtilisateur(@PathVariable("idUtilisateur") Long id, @RequestBody Utilisateur utilisateur) { //
		Utilisateur currentUser = utilisateurService.findOne(id);
		// System.out.println(currentUser.toString());
		currentUser.setNomUtilisateur(utilisateur.getNomUtilisateur());
		currentUser.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
		currentUser.setUsername(utilisateur.getUsername());
		currentUser.setPasswordUtilisateur(utilisateur.getPasswordUtilisateur());
		currentUser.setDateNaissanceUtilisateur(utilisateur.getDateNaissanceUtilisateur());
		currentUser.setImage(utilisateur.getImage());
		currentUser.setReservations(utilisateur.getReservations());
		currentUser.setAvis(utilisateur.getAvis());
		currentUser.setRoles(utilisateur.getRoles());
		return utilisateurService.saveUtilisateur(currentUser);
	}
}
