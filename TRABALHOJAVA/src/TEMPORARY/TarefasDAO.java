package TEMPORARY;

import jdbc.BasicoDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TarefasDAO  extends BasicoDAO {
	public void insert(Tarefas tarefas) {

		String sql = " insert into tarefas(codigousuario, descricao, datalimite) values(?,?,?)";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setInt(1, tarefas.getCodigousuario());
			statement.setString(2, tarefas.getDescricao());
			statement.setDate(3, new java.sql.Date(tarefas.getDatalimite().getTime()));
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
	public void delete(Tarefas tarefas) {
		
		String sql = " delete from tarefas where codigotarefa = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, tarefas.getCodigotarefa());
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void update(Tarefas tarefas) {
		String sql = " update tarefas set codigotarefa = ?, tarefa = ? where codigotarefa = ?";
		
		try (Connection conn = getConnection();
			 PreparedStatement statement = conn.prepareStatement(sql)){
			statement.setInt(1, tarefas.getCodigotarefa());
			statement.setString(2, tarefas.getDescricao());
			statement.setDate(3, new java.sql.Date(tarefas.getDatalimite().getTime()));
			statement.execute();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Tarefas getByCodigotarefa(int codigotarefa) {
		Tarefas tarefas = null;
		String sql = " select codigotarefa, codigousuario, descricao, datalimite from tarefas where codigotarefa = ?";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			statement.setInt(1, codigotarefa);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				tarefas = new Tarefas();
				tarefas.setCodigotarefa(resultSet.getInt(1));
				tarefas.setCodigousuario(resultSet.getInt(2));
				tarefas.setDescricao(resultSet.getString(3));
				tarefas.setDatalimite(resultSet.getDate(4));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tarefas;
	}
	
	public List<Tarefas> getAll(){
		List<Tarefas> list = new ArrayList<>();
		String sql = " select codigotarefa, codigousuario, descricao, datalimite from tarefas order by codigotarefa";
		
		try(Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				Tarefas tarefas = new Tarefas();
				tarefas.setCodigotarefa(resultSet.getInt(1));
				tarefas.setCodigousuario(resultSet.getInt(2));
				tarefas.setDescricao(resultSet.getString(3));
				tarefas.setDatalimite(resultSet.getDate(4));
				
				
				list.add(tarefas);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}	


}
