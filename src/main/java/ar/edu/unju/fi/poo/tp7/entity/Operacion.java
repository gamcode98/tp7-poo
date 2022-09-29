package ar.edu.unju.fi.poo.tp7.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Operacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "fecha_movimiento")
	private LocalDate fechaMovimiento;
	
	@Column(name = "tipo_movimiento")
	private String tipoMovimiento;
	
	@Column(name = "importe")
	private Double importe;

	public Operacion(LocalDate fechaMovimiento, String tipoMovimiento, Double importe) {
		super();
		this.fechaMovimiento = fechaMovimiento;
		this.tipoMovimiento = tipoMovimiento;
		this.importe = importe;
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

	@Override
	public String toString() {
		return "Operacion [fechaMovimiento=" + fechaMovimiento + ", tipoMovimiento=" + tipoMovimiento + ", importe="
				+ importe + "]";
	}
	
	
	
}
