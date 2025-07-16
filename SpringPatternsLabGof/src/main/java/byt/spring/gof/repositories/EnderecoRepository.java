package byt.spring.gof.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import byt.spring.gof.models.Endereco;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
