package modelo;

public class UsuarioDTO {
	
	private int documento;
	private String nomusu;
	private String clave;
	private String rol;
	private String estado;
	

	public UsuarioDTO(int documento, String nomusu, String clave, String rol, String estado) {
		super();
		this.documento = documento;
		this.nomusu = nomusu;
		this.clave = clave;
		this.rol = rol;
		this.estado = estado;
	}



	public UsuarioDTO(int documento) {
		this.documento = documento;
	}



	public int getDocumento() {
		return documento;
	}



	public String getNomusu() {
		return nomusu;
	}



	public void setNomusu(String nomusu) {
		this.nomusu = nomusu;
	}



	public String getClave() {
		return clave;
	}



	public void setClave(String clave) {
		this.clave = clave;
	}



	public String getRol() {
		return rol;
	}



	public void setRol(String rol) {
		this.rol = rol;
	}



	public String getEstado() {
		return estado;
	}



	public void setEstado(String estado) {
		this.estado = estado;
	}



	public void setDocumento(int documento) {
		this.documento = documento;
	}


	

}
