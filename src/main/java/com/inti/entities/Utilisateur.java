package com.inti.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
public class Utilisateur implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur;
	private String prenomUtilisateur;
	private String username;
	private String passwordUtilisateur;
	@Temporal(TemporalType.DATE)
	private Date dateNaissanceUtilisateur;
	private boolean enabled = true;
	@Lob
	private byte[] image;

// =====Relations====//

	@OneToMany(mappedBy = "utilisateurFK", cascade = {CascadeType.ALL})
	@Transient
	private List<Reservation> reservations = new ArrayList<>();

	@OneToMany(mappedBy = "utilisateurFK2", cascade = {CascadeType.ALL})
	@Transient
	private List<Avis> avis = new ArrayList<>();

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "profil	", joinColumns = @JoinColumn(name = "idUtilisateur"), inverseJoinColumns = @JoinColumn(name = "idRole"))
	private Set<Role> roles = new HashSet<>();

// =====Constructeurs====//

	public Utilisateur() {
	}

	public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String username, String passwordUtilisateur,
			Date dateNaissanceUtilisateur, boolean enabled, byte[] image) {
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.username = username;
		this.passwordUtilisateur = passwordUtilisateur;
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
		this.enabled = enabled;
		this.image = image;
	}

	public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String username, String passwordUtilisateur,
			Date dateNaissanceUtilisateur, boolean enabled, byte[] image, List<Reservation> reservation,
			List<Avis> avis, Set<Role> roles) {
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.username = username;
		this.passwordUtilisateur = passwordUtilisateur;
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
		this.enabled = enabled;
		this.image = image;
		this.reservations = reservation;
		this.avis = avis;
		this.roles = roles;
	}

	public Utilisateur(Long idUtilisateur, String nomUtilisateur, String prenomUtilisateur, String username,
			String passwordUtilisateur, Date dateNaissanceUtilisateur, boolean enabled, byte[] image,
			List<Reservation> reservation, List<Avis> avis, Set<Role> roles) {
		this.idUtilisateur = idUtilisateur;
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.username = username;
		this.passwordUtilisateur = passwordUtilisateur;
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
		this.enabled = enabled;
		this.image = image;
		this.reservations = reservation;
		this.avis = avis;
		this.roles = roles;
	}

//=====Setters & Getters=====//

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswordUtilisateur() {
		return passwordUtilisateur;
	}

	public void setPasswordUtilisateur(String passwordUtilisateur) {
		this.passwordUtilisateur = passwordUtilisateur;
	}

	public Date getDateNaissanceUtilisateur() {
		return dateNaissanceUtilisateur;
	}

	public void setDateNaissanceUtilisateur(Date dateNaissanceUtilisateur) {
		this.dateNaissanceUtilisateur = dateNaissanceUtilisateur;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservation) {
		this.reservations = reservation;
	}

	public List<Avis> getAvis() {
		return avis;
	}

	public void setAvis(List<Avis> avis) {
		this.avis = avis;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", username=" + username + ", passwordUtilisateur="
				+ passwordUtilisateur + ", dateNaissanceUtilisateur=" + dateNaissanceUtilisateur + ", enabled="
				+ enabled + ", image=" + Arrays.toString(image) + ", reservation=" + reservations + ", avis=" + avis
				+ ", roles=" + roles + "]";
	}

//=====toString()====//

	
}