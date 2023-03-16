package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idRole;
	private String libelleRole;
	
	//=====Relations====//



	//=====Constructeurs====//
	
	public Role() {}


	public Role(String libelleRole) {
		this.libelleRole = libelleRole;
	}

	//=====Setters & Getters====//
	
	public Long getIdRole() {
		return idRole;
	}

	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}

	public String getLibelleRole() {
		return libelleRole;
	}

	public void setLibelleRole(String libelleRole) {
		this.libelleRole = libelleRole;
	}
	
	

	//=====toString()====//
	@Override
	public String toString() {
		return "Role [idRole=" + idRole + ", libelleRole=" + libelleRole + "]";
	}

	

	
}
