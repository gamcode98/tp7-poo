package ar.edu.unju.fi.poo.tp7.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nro_cuenta")
	private String nroCuenta;
	
	@Column(name = "fecha_ingreso")
	private LocalDate fechaIngreso;
	
	@Column(name = "saldo_actual")
	private Double saldoActual;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "limite_extraccion")
	private Double limiteExtraccion;
	
	
	
}
