package com.apress.todo.controller;

import com.apress.todo.domain.ToDo;
import com.apress.todo.domain.ToDoBuilder;
import com.apress.todo.repository.CommonRepository;
import com.apress.todo.validation.ToDoValidationError;
import com.apress.todo.validation.ToDoValidationErrorBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/api")
public class ToDoController {
	@Autowired
	private CommonRepository<ToDo> repository;

	//@Autowired // luego quitar el autowired
	//public ToDoController(CommonRepository<ToDo> repository) {
	//	this.repository = repository;
	//}

	// Listar
	@GetMapping("/todo") // @RequestMapping(value="/todo", method = {RequestMethod.GET})
	public ResponseEntity<Iterable<ToDo>> getToDos() {
		return ResponseEntity.ok(repository.findAll());
	}

	// Buscar por Id
	@GetMapping("/todo/{id}")
	public ResponseEntity<ToDo> getToDoById(@PathVariable String id) {
		return ResponseEntity.ok(repository.findById(id));
	}

	// Edita marca la tarea como completa
	@PatchMapping("/todo/{id}")
	public ResponseEntity<ToDo> setCompleted(@PathVariable String id) {
		ToDo result = repository.findById(id);
		result.setCompleted(true);
		repository.save(result);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().buildAndExpand(result.getId()).toUri();

		return ResponseEntity.ok().header("Location", location.toString()).build();
	}

	// CREAR
	@RequestMapping(value = "/todo", method = { RequestMethod.POST, RequestMethod.PUT })
	public ResponseEntity<?> createToDo(@Valid @RequestBody ToDo toDo, Errors errors) {
		if (errors.hasErrors()) {
			return ResponseEntity.badRequest().body(ToDoValidationErrorBuilder.fromBindingErrors(errors));
		}

		ToDo result = repository.save(toDo);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(result.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	// Borra by ID
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<ToDo> deleteToDo(@PathVariable String id) {
		repository.delete(ToDoBuilder.create().withId(id).build());
		return ResponseEntity.noContent().build();
	}

	// Borrar
	@DeleteMapping("/todo")
	public ResponseEntity<ToDo> deleteToDo(@RequestBody ToDo toDo) {
		repository.delete(toDo);
		return ResponseEntity.noContent().build();
	}

	@ExceptionHandler
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ToDoValidationError handleException(Exception exception) {
		return new ToDoValidationError(exception.getMessage() + " ERRORRRRR");
	}

}
