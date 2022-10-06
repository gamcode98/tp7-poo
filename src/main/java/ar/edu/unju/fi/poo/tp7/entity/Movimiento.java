package ar.edu.unju.fi.poo.tp7.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movimientos")
public class Movimiento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "fecha_movimiento")
	private LocalDate fechaMovimiento;
	
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	
	@Column(name = "importe")
	private Double importe;
	
	@ManyToOne
	private Cuenta cuenta;

	public Movimiento(LocalDate fechaMovimiento, String tipoMovimiento, Double importe, Cuenta cuenta) {
		super();
		this.fechaMovimiento = fechaMovimiento;
		this.tipoMovimiento = tipoMovimiento;
		this.importe = importe;
		this.cuenta = cuenta;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaMovimiento() {
		return fechaMovimiento;
	}

	public void setFechaMovimiento(LocalDate fechaMovimiento) {
		this.fechaMovimiento = fechaMovimiento;
	}

	public String getTipoMovimiento() {
		return tipoMovimiento;
	}

	public void setTipoMovimiento(String tipoMovimiento) {
		this.tipoMovimiento = tipoMovimiento;
	}

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public Cuenta getCuenta() {
		return cuenta;
	}

	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	

	@Override
	public String toString() {
		return "Movimiento [id=" + id + ", fechaMovimiento=" + fechaMovimiento + ", tipoMovimiento=" + tipoMovimiento
				+ ", importe=" + importe + ", cuenta=" + cuenta + "]";
	}
	
}
