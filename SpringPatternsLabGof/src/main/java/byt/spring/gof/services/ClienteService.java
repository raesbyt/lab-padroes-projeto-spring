package byt.spring.gof.services;

import org.springframework.beans.factory.annotation.Autowired;

import byt.spring.gof.models.Cliente;
import byt.spring.gof.repositories.ClienteRepository;
import byt.spring.gof.strategy.ClienteStrategy;

public class ClienteService implements ClienteStrategy {
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void inserir(Cliente cliente) {
		clienteRepository.save(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
