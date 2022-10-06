package ar.edu.unju.fi.poo.tp7.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.poo.tp7.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long>{
	
	Cliente findByDni(Integer dni);

}
