package com.ti.ele.machineRest.entity;

import java.io.Serializable;

public class Usuario implements Serializable
{

	 	
	    public Long getUsuarioId() {
			return usuarioId;
		}
		public void setUsuarioId(Long usuarioId) {
			this.usuarioId = usuarioId;
		}
		public String getUsuarioAlias() {
			return usuarioAlias;
		}
		public void setUsuarioAlias(String usuarioAlias) {
			this.usuarioAlias = usuarioAlias;
		}
		public String getUsuarioDni() {
			return usuarioDni;
		}
		public void setUsuarioDni(String usuarioDni) {
			this.usuarioDni = usuarioDni;
		}
		public String getUsuarioEmail() {
			return usuarioEmail;
		}
		public void setUsuarioEmail(String usuarioEmail) {
			this.usuarioEmail = usuarioEmail;
		}
		public String getUsuarioNames() {
			return usuarioNames;
		}
		public void setUsuarioNames(String usuarioNames) {
			this.usuarioNames = usuarioNames;
		}
		public String getUsuarioPassword() {
			return usuarioPassword;
		}
		public void setUsuarioPassword(String usuarioPassword) {
			this.usuarioPassword = usuarioPassword;
		}
	
		
		
	    public Usuario() {
			super();
			// TODO Auto-generated constructor stub
		}
	    
		public Usuario(Long usuarioId, String usuarioAlias, String usuarioDni, String usuarioEmail, String usuarioNames,
				String usuarioPassword) {
			//super();
			this.usuarioId = usuarioId;
			this.usuarioAlias = usuarioAlias;
			this.usuarioDni = usuarioDni;
			this.usuarioEmail = usuarioEmail;
			this.usuarioNames = usuarioNames;
			this.usuarioPassword = usuarioPassword;
		}
	    
	    private Long usuarioId;
		private String usuarioAlias;
		private String usuarioDni;
	    private String usuarioEmail;
	    private String usuarioNames;
	    private String usuarioPassword;
	    
	    
}
