package byt.spring.gof.strategy;

import byt.spring.gof.models.Cliente;

public interface ClienteStrategy {
	
	Iterable<Cliente> buscarTodos();

	Cliente buscarPorId(Long id);

	void inserir(Cliente cliente);

	void atualizar(Long id, Cliente cliente);

	void deletar(Long id);

}
