package Ejercicio4.Modelo;

import java.time.LocalDate;
import lombok.Data;

@Data

public class Usuario {

	private Long idUser;
	private String username;
	private String password;
	private String email;
	private LocalDate fechaAlta;
	private LocalDate fechaUltLogin;

	public Long getIdUser() {
		return idUser;
	}

	public void setIdUser(Long idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(LocalDate fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public LocalDate getFechaUltLogin() {
		return fechaUltLogin;
	}

	public void setFechaUltLogin(LocalDate fechaUltLogin) {
		this.fechaUltLogin = fechaUltLogin;
	}

}
