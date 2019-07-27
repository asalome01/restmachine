package com.ti.ele.machineRest.dao;

import java.util.List;


import com.ti.ele.machineRest.entity.Machine;
import com.ti.ele.machineRest.entity.Usuario;

public interface machineDao {
	public List<Usuario> getAllUsers();
	public Usuario getUser(Long id);
	public int addUser(Long usuario_id, String usuario_alias,
			String usuario_dni,String usuario_email, String usuario_names,String usuario_password);
	public int addUserEntity(Usuario user);
	public int deleteUser(Long id);
	
	public Long totalusuario();
	
	public List<Usuario> listUsersCursor(String alias);
}
