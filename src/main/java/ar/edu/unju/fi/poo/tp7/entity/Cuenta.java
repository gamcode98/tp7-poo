package ar.edu.unju.fi.poo.tp7.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cuentas")
public class Cuenta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nro_cuenta")
	private Integer nroCuenta;
	
	@Column(name = "fecha_ingreso")
	private LocalDate fechaIngreso;
	
	@Column(name = "saldo_actual")
	private Double saldoActual;
	
	@Column(name = "estado")
	private String estado;
	
	@Column(name = "limite_extraccion")
	private Double limiteExtraccion;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
	private Cliente cliente;
	
	public Cuenta() {
		// TODO Auto-generated constructor stub
	}

	public Cuenta(Integer nroCuenta, LocalDate fechaIngreso, Double saldoActual, String estado, Double limiteExtraccion,
			Cliente cliente) {
		super();
		this.nroCuenta = nroCuenta;
		this.fechaIngreso = fechaIngreso;
		this.saldoActual = saldoActual;
		this.estado = estado;
		this.limiteExtraccion = limiteExtraccion;
		this.cliente = cliente;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNroCuenta() {
		return nroCuenta;
	}

	public void setNroCuenta(Integer nroCuenta) {
		this.nroCuenta = nroCuenta;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Double getSaldoActual() {
		return saldoActual;
	}

	public void setSaldoActual(Double saldoActual) {
		this.saldoActual = saldoActual;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Double getLimiteExtraccion() {
		return limiteExtraccion;
	}

	public void setLimiteExtraccion(Double limiteExtraccion) {
		this.limiteExtraccion = limiteExtraccion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "Cuenta [id=" + id + ", nroCuenta=" + nroCuenta + ", fechaIngreso=" + fechaIngreso + ", saldoActual="
				+ saldoActual + ", estado=" + estado + ", limiteExtraccion=" + limiteExtraccion + ", cliente=" + cliente
				+ "]";
	}
	
	
}
