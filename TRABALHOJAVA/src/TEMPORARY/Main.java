package TEMPORARY;

import java.util.Date;

public class Main {
public static void main(String[] args) {
		
		TarefasDAO tarefadao = new TarefasDAO();
		
		UsuariosDAO usuariodao = new UsuariosDAO();
		
		Tarefas t1 = new Tarefas();
		t1.setDescricao("Teste");
		t1.setDatalimite(new Date(21,12,2019));
		t1.setCodigousuario(1);
		
		Usuarios u1 = new Usuarios();
		u1.setUsuario("Fulano");
		
		usuariodao.insert(u1);
		tarefadao.insert(t1);
		
		System.out.println(tarefadao.getByCodigotarefa(4));
		
		System.out.println(usuariodao.getByCodigousuario(1));
		
		for(Usuarios usuario : usuariodao.getAll()) {
			System.out.println(usuario);
		}
		
		for(Tarefas tarefa : tarefadao.getAll()) {
			System.out.println(tarefa);
		}
		
	}


}
