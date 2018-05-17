package br.edu.ifpb.todo;

import br.edu.ifpb.todo.domain.Todo;
import br.edu.ifpb.todo.services.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoApplicationTests {

	@Autowired
	private TodoService todoService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void deveCriarTodo() {
		Todo todo = new Todo();
		todo.setTitulo("Fazer primeiro exemplo de aplicação Spring");
		todoService.salvar(todo);
		assertTrue(todo.getId() != null);
	}

	@Test
	public void deveListarTodo() {
		Todo todo = new Todo();
		todo.setTitulo("Mais um todo");
		todoService.salvar(todo);
		List<Todo> resultado = todoService.listar();
		assertTrue(!resultado.isEmpty());
	}

	@Test
	public void deveApagarTodo() {
		Todo todo = new Todo();
		todo.setTitulo("Uma todo a ser apagada");
		todoService.salvar(todo);
		long todosExistentes = todoService.total();
		todoService.apagar(todo);
		long todosExistentesAposRemocao = todoService.total();
		assertTrue(todosExistentesAposRemocao == todosExistentes-1);
	}

}
