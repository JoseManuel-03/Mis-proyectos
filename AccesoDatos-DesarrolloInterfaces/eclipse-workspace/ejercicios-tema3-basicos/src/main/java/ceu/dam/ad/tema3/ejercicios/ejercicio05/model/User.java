package ceu.dam.ad.tema3.ejercicios.ejercicio05.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuarios")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUser")
	private Long id;
	private String username;
	private String email;
	private String password;
	@Column(name = "fechaAlta")
	private LocalDate createdDate;
	@Column(name = "fechaUltLogin")
	private LocalDate lastLoginDate;
	
	
	

}
