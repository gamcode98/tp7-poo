package ar.edu.unju.fi.poo.tp7;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import ar.edu.unju.fi.poo.tp7.entity.Cliente;
import ar.edu.unju.fi.poo.tp7.entity.Cuenta;
import ar.edu.unju.fi.poo.tp7.repository.ClienteRepository;
import ar.edu.unju.fi.poo.tp7.repository.CuentaRepository;
import ar.edu.unju.fi.poo.tp7.util.Estado;

@SpringBootTest
class Tp7ApplicationTests {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Autowired
	CuentaRepository cuentaRepository;	
	
	static Cliente cliente1; 
	
	static Cliente cliente2;
	
	static Cliente cliente3;
	
	static Cliente adherente1;
	
	static Cliente adherente2;
	
	static Cliente adherente3;
	
	static Cuenta cuenta1;
	
	static Cuenta cuenta2;
	
	@BeforeEach
	void setUp() throws Exception {
		adherente1 = new Cliente(99123123, "zzzzz", "zzzzz@gmail.com", "Av. Sinza 999", null, null);
		adherente2 = new Cliente(88123123, "ppppp", "ppppp@gmail.com", "Av. Sinza 888", null, null);
		adherente3 = new Cliente(77123123, "ooooo", "ooooo@gmail.com", "Av. Sinza 777", null, null);
		List<Cliente> adherentes = new ArrayList<Cliente>(Arrays.asList(adherente1, adherente2, adherente3));
		cliente1 = new Cliente(12123123, "aaaaa", "aaaaa@gmail.com", "Av. Siempre viva 123", Estado.HABILITADO, null);
		cliente2 = new Cliente(22123123, "bbbbb", "bbbbb@gmail.com", "Av. Callao 222", Estado.INHABILITADO, null);
		cliente3= new Cliente(33123123, "ccccc", "ccccc@gmail.com", "Av. Colina 333", Estado.HABILITADO, adherentes);
		
		cuenta1 = new Cuenta(11111,LocalDate.parse("2021-12-20"), 150000.00, Estado.HABILITADO, 30000.00, cliente1);
	}
	
	@AfterEach
	void tearDown() throws Exception {
		adherente1 = null;
		adherente2 = null;
		adherente3 = null;
		cliente1 = null;
		cliente2 = null;
		cliente3 = null;
		
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception { }

	@AfterAll
	static void tearDownAfterClass() throws Exception { }
	
	@Test
	@DisplayName("Registrar cliente")
	void registrarCliente() {
		clienteRepository.save(cliente1);
		assertEquals(12123123, clienteRepository.findByDni(12123123).getDni());
		Long id = clienteRepository.findByDni(12123123).getId();			
		clienteRepository.deleteById(id);
		assertNull(clienteRepository.findByDni(12123123));
	}
	
	@Test
	@DisplayName("Actualizar cliente - cambia el estado de inhabilitado a habilitado")
	void actualizarCliente() {
		clienteRepository.save(cliente2);
		assertEquals("inhabilitado", clienteRepository.findByDni(22123123).getEstado());
		Cliente clienteEncontrado = clienteRepository.findByDni(22123123);
		clienteEncontrado.setEstado(Estado.HABILITADO);
		clienteRepository.save(clienteEncontrado);
		assertEquals("habilitado", clienteRepository.findByDni(22123123).getEstado());
		Long id = clienteRepository.findByDni(22123123).getId();			
		clienteRepository.deleteById(id);
		assertNull(clienteRepository.findByDni(22123123));
	}
	
	@Test	
	@DisplayName("Eliminar cliente por id")
	void eliminarCliente() {
		clienteRepository.save(cliente1);
		assertEquals(12123123, clienteRepository.findByDni(12123123).getDni());
		Long id = clienteRepository.findByDni(12123123).getId();			
		clienteRepository.deleteById(id);
		assertNull(clienteRepository.findByDni(12123123));
	}
	
	@Test
	@DisplayName("Registrar cuenta bancaria")
	void registrarCuenta() {
		cuentaRepository.save(cuenta1);
		assertEquals(11111, cuentaRepository.findByNroCuenta(11111).getNroCuenta());
		Long id = cuentaRepository.findByNroCuenta(11111).getId();
		cuentaRepository.deleteById(id);
		assertNull(cuentaRepository.findByNroCuenta(11111));		
	}
	
	@Test
	@DisplayName("Actualizar cuenta - cambia el limite de extraccion")
	void actualizarCuenta() {
		cuentaRepository.save(cuenta1);
		assertEquals(30000.00, cuentaRepository.findByNroCuenta(11111).getLimiteExtraccion());
		Cuenta cuentaEncontrada = cuentaRepository.findByNroCuenta(11111);
		cuentaEncontrada.setLimiteExtraccion(50000.00);
		cuentaRepository.save(cuentaEncontrada);
		assertEquals(50000.00, cuentaRepository.findByNroCuenta(11111).getLimiteExtraccion());
		Long id = cuentaRepository.findByNroCuenta(11111).getId();
		cuentaRepository.deleteById(id);
		assertNull(cuentaRepository.findByNroCuenta(11111));	
	}
	
	@Test
	@DisplayName("Eliminar cuenta por id")
	void eliminarCuenta() {
		cuentaRepository.save(cuenta1);
		assertEquals(11111, cuentaRepository.findByNroCuenta(11111).getNroCuenta());
		Long id = cuentaRepository.findByNroCuenta(11111).getId();
		cuentaRepository.deleteById(id);
		assertNull(cuentaRepository.findByNroCuenta(11111));
	}
}
