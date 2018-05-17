package br.edu.ifpb.todo.repositories;

import br.edu.ifpb.todo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

}
