package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Role;

public interface IRoleService {

	List<Role> findAll();

	Role findOne(Long id);

	Role saveRole(Role role);

	void deleteRole(Long id);

	Role findRoleByLibelleRole(String libelleRole);

}
