package com.ti.ele.machineRest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ti.ele.machineRest.entity.Machine;
import com.ti.ele.machineRest.entity.Usuario;
import com.ti.ele.machineRest.service.MachineServiceImpl;

@RestController
@RequestMapping("uri")
public class MachineController {

	
	@Autowired
	MachineServiceImpl machineServiceImpl;
	
	@GetMapping(value="/machineuser/{id}",produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Usuario> getMachine(@PathVariable ("id") long id ){
		
		
		Usuario machineUser = machineServiceImpl.getUser(id);
		
		return new ResponseEntity<Usuario>(machineUser,HttpStatus.OK);
		
	}
		
	
	@RequestMapping(value = "/machineuserxml/{id}",
	       
			produces = { MediaType.APPLICATION_XML_VALUE })
	public Usuario getMachineXml(@PathVariable ("id") long id ){
		
		
		Usuario machineUser = machineServiceImpl.getUser(id);
		
		return machineUser;
		
	}
	
}
