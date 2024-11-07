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

}
