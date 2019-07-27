package com.ti.ele.machineRest.dao;

import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;


import com.ti.ele.machineRest.entity.Machine;
import com.ti.ele.machineRest.entity.Usuario;

import oracle.jdbc.internal.OracleTypes;


@Repository
public class MachineDaoImpl implements machineDao{

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Usuario> getAllUsers() {
		// TODO Auto-generated method stub
		List<Usuario> listUsuarios = jdbcTemplate.query("select usuario_id,usuario_alias,usuario_dni,usuario_email,usuario_names,usuario_password from cdevaws.usuario",
				(result,rowNum)->new Usuario(result.getLong("usuario_id"),result.getString("usuario_alias"),result.getString("usuario_dni"),result.getString("usuario_email"),
						result.getString("usuario_names")
						,result.getString("usuario_password")));
		return listUsuarios;
	}

	
	//select usuario_id,usuario_alias,usuario_dni,usuario_email,usuario_password from cdevaws.usuario
	
	@Override
	public Usuario getUser(Long id) {
		// TODO Auto-generated method stub
		String query = "SELECT * FROM cdevaws.usuario where usuario_id = ?";
		Usuario usuario = jdbcTemplate.queryForObject(query, new Object[] {id}, new BeanPropertyRowMapper<>(Usuario.class));
		return usuario;
	}


	@Override
	public int addUser(Long usuario_id, String usuario_alias, String usuario_dni, String usuario_email,
			String usuario_names, String usuario_password) {
		// TODO Auto-generated method stub
		String query="INSERT INTO CDEVAWS.USUARIO VALUES(?,?,?,?,?,?)";
		
		return jdbcTemplate.update(query,usuario_id,usuario_alias,usuario_dni,usuario_email,usuario_names,usuario_password);
	}


	@Override
	public int deleteUser(Long id) {
		// TODO Auto-generated method stub
		String query = "DELETE FROM CDEVAWS.USUARIO  WHERE usuario_id = ? ";
		return jdbcTemplate.update(query,id);
	}


	@Override
	public int addUserEntity(Usuario user) {
		// TODO Auto-generated method stub
		String query="INSERT INTO CDEVAWS.USUARIO VALUES(?,?,?,?,?,?)";
		
		return jdbcTemplate.update(query,user.getUsuarioId(),user.getUsuarioAlias(),user.getUsuarioDni(),
				user.getUsuarioEmail(),user.getUsuarioNames(),user.getUsuarioPassword());
		
	}


	@Override
	public Long totalusuario() {
		// TODO Auto-generated method stub
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("NP_MANAGEMENT_USER_PKG"). withProcedureName("SP_GET_TOTAL_USERS");
		
		Map<String, Object> inParamMap = new HashMap<String, Object>();
		//inParamMap.put("firstName", "FirstNameValue");
		//inParamMap.put("lastName", "LastNameValue");
		SqlParameterSource in = new MapSqlParameterSource(inParamMap);
		Map<String, Object> simpleJdbcCallResult = simpleJdbcCall.execute(in);
		System.out.println(simpleJdbcCallResult.get("AN_TOTAL"));
		return Long.parseLong(simpleJdbcCallResult.get("AN_TOTAL").toString());
	}


	@Override
	public List<Usuario> listUsersCursor(String alias) {
		// TODO Auto-generated method stub
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withCatalogName("NP_MANAGEMENT_USER_PKG").withProcedureName("SP_GET_LIST_USERS")
				.declareParameters(new SqlParameter("username",Types.VARCHAR),
						new SqlOutParameter("AC_USERS",OracleTypes.CURSOR));
		simpleJdbcCall.compile();
		SqlParameterSource param = new MapSqlParameterSource().addValue("username", alias);
		Map map = simpleJdbcCall.execute(param);
		
		return (List <Usuario>) map.get("AC_USERS");
		
	}

	
	List<Machine> machinesActives(){
		
		List<Machine> listMachines = new ArrayList<Machine>();
		Machine machine1 = new Machine();
		Machine machine2 = new Machine();
		machine1.setId(1);
		machine1.setMarca("HP");
		machine1.setModelo("LUNATY");
		machine1.setSerial("23451689");
		machine2.setId(2);
		machine2.setMarca("IBM");
		machine2.setModelo("PHOTON");
		machine2.setSerial("45341489");
		listMachines.add(machine1);
		listMachines.add(machine2);
		return listMachines;
		
	}
	
	Machine oneMachine() {
		Machine machine1 = new Machine();
		
		machine1.setId(1);
		machine1.setMarca("HP");
		machine1.setModelo("LUNATY");
		machine1.setSerial("23451689");
		
		return machine1;
	}
	
}
