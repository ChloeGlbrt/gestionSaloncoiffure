package com.inti.restController;

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

import com.inti.entities.Role;
import com.inti.service.interfaces.IRoleService;

@RestController
@CrossOrigin
public class RoleController {

	@Autowired
	IRoleService roleService;

//====les Find====//

	@GetMapping("/roles")
	public List<Role> findAll() {
		return roleService.findAll();
	}

	@GetMapping("/roles/{idRole}")
	public Role findOne(@PathVariable("idRole") Long id) {
		return roleService.findOne(id);
	}
	
	@GetMapping("/roles/{libelleRole}")
	public Role findRoleByLibelleRole(@RequestParam("libelleRole")  String libelleRole) {
		return roleService.findRoleByLibelleRole(libelleRole);
	}

//====les Save====//

	@PostMapping("/roles")
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}

//====Les delete====//

	@DeleteMapping("/roles/{idRole}")
	public void deleteRole(@PathVariable("idRole") Long id) {
		roleService.deleteRole(id);
	}

//====les update====//

	@PutMapping("/roles/{idRole}")
	public Role updateRole(@PathVariable("idRole") Long id, @RequestBody Role role) {
		Role currentRole = roleService.findOne(id);
		currentRole.setLibelleRole(role.getLibelleRole());
		return roleService.saveRole(currentRole);
	}
}
