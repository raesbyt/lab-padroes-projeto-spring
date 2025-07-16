package byt.spring.gof.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import byt.spring.gof.models.Cliente;
import byt.spring.gof.strategy.ClienteStrategy;

@RestController
@RequestMapping(value = "/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteStrategy clienteStrategy;
	
	@GetMapping
	public ResponseEntity<Iterable<Cliente>> findAll() {
		return ResponseEntity.ok(clienteStrategy.buscarTodos());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> insert(@RequestBody Cliente cliente) {
		clienteStrategy.inserir(cliente);
		return ResponseEntity.ok(cliente);
	}

}
