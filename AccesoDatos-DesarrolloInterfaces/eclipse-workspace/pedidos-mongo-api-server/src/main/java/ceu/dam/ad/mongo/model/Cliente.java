package ceu.dam.ad.mongo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Document
public class Cliente {

	@Id
	private String id;
	@NotBlank
	private String dni;
	@NotBlank
	private String nombre;
	@NotBlank
	private String direccion;
	
	
}
