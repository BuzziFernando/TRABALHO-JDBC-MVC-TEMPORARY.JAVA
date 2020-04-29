package TEMPORARY;

import java.util.Date;

public class Tarefas {

	private int codigotarefa;
	private int codigousuario;
	private String descricao;
	private Date datalimite;
	
	
	public int getCodigotarefa() {
		return codigotarefa;
	}
	public void setCodigotarefa(int codigotarefa) {
		this.codigotarefa = codigotarefa;
	}
	public int getCodigousuario() {
		return codigousuario;
	}
	public void setCodigousuario(int codigousuario) {
		this.codigousuario = codigousuario;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Date getDatalimite() {
		return datalimite;
	}
	public void setDatalimite(Date datalimite) {
		this.datalimite = datalimite;
	}
	@Override
	public String toString() {
		return "Tarefas [codigotarefa=" + codigotarefa + ", codigousuario=" + codigousuario + ", descricao=" + descricao
				+ ", datalimite=" + datalimite + "]";
	}	
	
	
	

}
