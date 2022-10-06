package ar.edu.unju.fi.poo.tp7.entity;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "adherentes")	
	private List<Cliente> adherentes;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer dni, String nombre, String email, String domicilio, String estado,
			List<Cliente> adherentes) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.domicilio = domicilio;
		this.estado = estado;
		this.adherentes = adherentes;
	}	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Cliente> getAdherentes() {
		return adherentes;
	}

	public void setAdherentes(List<Cliente> adherentes) {
		this.adherentes = adherentes;
	}

	@Override
	public String toString() {
		return "Cliente [dni=" + dni + ", nombre=" + nombre + ", email=" + email + ", domicilio=" + domicilio
				+ ", estado=" + estado + ", adherentes=" + adherentes + "]";
	}
	

}
