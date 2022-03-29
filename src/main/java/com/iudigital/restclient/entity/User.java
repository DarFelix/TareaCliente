package com.iudigital.restclient.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_user")
	private int idUser;
	@Column(unique = true)
	private String cedula;
	private String nombre;
	private String apellido;
	private int age;
	private String telefono;
	private String direccion;
	private String barrio;
	private String ciudad;
	private String foto;
	@Column(nullable = false, columnDefinition = "TINYINT(1)")
	private boolean reporte;
	
	
	public User(String cedula, String nombre, String apellido, int age, String telefono, String direccion, String barrio, String ciudad, String foto, boolean reporte) {
		
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
		this.age = age;
		this.telefono = telefono;
		this.direccion = direccion;
		this.barrio = barrio;
		this.ciudad = ciudad;
		this.foto = foto;
		this.reporte = reporte;
		
	}
	
	public User() {
		
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	public boolean isReporte() {
		return reporte;
	}

	public void setReporte(boolean reporte) {
		this.reporte = reporte;
	}

	@Override
	public String toString() {
		return "User [idUser=" + idUser + ", cedula=" + cedula + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", age=" + age + ", telefono=" + telefono + ", direccion=" + direccion + ", barrio=" + barrio
				+ ", ciudad=" + ciudad + ", foto=" + foto + ", reporte=" + reporte + "]";
	}
	
	

}