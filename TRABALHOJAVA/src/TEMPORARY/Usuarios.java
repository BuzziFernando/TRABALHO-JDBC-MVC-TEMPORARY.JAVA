package TEMPORARY;

public class Usuarios {
	private int codigousuario;
	private String usuario;
	
	
	public int getCodigousuario() {
		return codigousuario;
	}
	public void setCodigousuario(int codigousuario) {
		this.codigousuario = codigousuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	@Override
	public String toString() {
		return "Usuarios [codigousuario=" + codigousuario + ", usuario=" + usuario + "]";
	}
	

}
