package br.edu.ifpb.todo.services;

import br.edu.ifpb.todo.domain.Todo;
import br.edu.ifpb.todo.repositories.TodoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    //@Autowired
    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public Todo salvar (Todo todo) {
        return todoRepository.save(todo);
    }

    public List<Todo> listar(){
        return todoRepository.findAll();
    }

    public Optional<Todo> buscarPorId(Integer id) {
        return todoRepository.findById(id);
    }

    public long total() {
        return todoRepository.count();
    }

    public void apagar(Todo todo) {
        todoRepository.delete(todo);
    }
}
