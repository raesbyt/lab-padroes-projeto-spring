package byt.spring.gof.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import byt.spring.gof.models.Cliente;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
