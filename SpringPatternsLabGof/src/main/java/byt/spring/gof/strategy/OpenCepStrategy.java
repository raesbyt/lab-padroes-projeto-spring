package byt.spring.gof.strategy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import byt.spring.gof.models.Endereco;

@FeignClient(name = "opencep", url = "https://opencep.com/v1")
public interface OpenCepStrategy {
	
	@GetMapping("/{cep}")
	Endereco buscarEnderecoPorCep(@PathVariable("cep") String cep);

}
