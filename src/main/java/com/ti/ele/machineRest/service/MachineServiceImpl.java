package com.ti.ele.machineRest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.ti.ele.machineRest.dao.MachineDaoImpl;
import com.ti.ele.machineRest.dao.machineDao;
import com.ti.ele.machineRest.entity.Machine;
import com.ti.ele.machineRest.entity.Usuario;


@Service
public class MachineServiceImpl implements MachineService{


	@Autowired
	MachineDaoImpl UsuarioDaoImpl;
	
	
	@Override
	public List<Usuario> getAllUsers() {
		// TODO Auto-generated method stub
		return UsuarioDaoImpl.getAllUsers();
	}

	@Override
	public Usuario getUser(Long id) {
		// TODO Auto-generated method stub
		return UsuarioDaoImpl.getUser(id);
	}

	@Override
	public int addUser(Long usuario_id, String usuario_alias, String usuario_dni, String usuario_email,
			String usuario_names, String usuario_password) {
		// TODO Auto-generated method stub
		return UsuarioDaoImpl.addUser( usuario_id, usuario_alias, usuario_dni, usuario_email, usuario_names, usuario_password);
	}

	@Override
	public int deleteUser(Long id) {
		// TODO Auto-generated method stub
		return UsuarioDaoImpl.deleteUser(id);
	}

	@Override
	public int addUserEntity(Usuario user) {
		// TODO Auto-generated method stub
		return UsuarioDaoImpl.addUserEntity(user);
	}

	@Override
	public Long totalusuario() {
		// TODO Auto-generated method stub
		return UsuarioDaoImpl.totalusuario();
	}

	@Override
	public List<Usuario> listUsersCursor(String alias) {
		// TODO Auto-generated method stub
		return UsuarioDaoImpl.listUsersCursor(alias);
	}

}
