package ar.edu.unju.fi.poo.tp7.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "dni")
	private Integer dni;
	
	@Column(name = "nombre")
	private String nombre;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "domicilio")
	private String domicilio;
	
	@Column(name = "estado")
	private String estado;
	
	@ManyToOne
	@JoinColumn(name = "adherentes")
	private Cliente adherentes;

	public Cliente(Integer dni, String nombre, String email, String domicilio, String estado,
			Cliente adherentes) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.domicilio = domicilio;
		this.estado = estado;
		this.adherentes = adherentes;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Cliente getAdherentes() {
		return adherentes;
	}

	public void setAdherentes(Cliente adherentes) {
		this.adherentes = adherentes;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", email=" + email + ", domicilio=" + domicilio
				+ ", estado=" + estado + ", adherentes=" + adherentes + "]";
	}
	
	

}
