package ceu.dam.model;

import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Descansito {
	@Id
	private String id;
	
	private String profesor;
	private Integer duracion;
	private Boolean autorizado;
	private List<Alumno> alumnos;

}
