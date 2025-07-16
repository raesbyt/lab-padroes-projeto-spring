package byt.spring.gof.services;

import org.springframework.beans.factory.annotation.Autowired;

import byt.spring.gof.models.Cliente;
import byt.spring.gof.models.Endereco;
import byt.spring.gof.repositories.ClienteRepository;
import byt.spring.gof.repositories.EnderecoRepository;
import byt.spring.gof.strategy.ClienteStrategy;
import byt.spring.gof.strategy.OpenCepStrategy;

public class ClienteService implements ClienteStrategy {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private OpenCepStrategy cepStrategy;

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
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		
	}
	
	private void salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = enderecoRepository.findById(cep)
				.orElseGet(() -> { 
					Endereco novoEndereco = cepStrategy.buscarEnderecoPorCep(cep); 
					enderecoRepository.save(novoEndereco);
					return novoEndereco;
				});
		
		cliente.setEndereco(endereco);
		
		clienteRepository.save(cliente);
	}

}
