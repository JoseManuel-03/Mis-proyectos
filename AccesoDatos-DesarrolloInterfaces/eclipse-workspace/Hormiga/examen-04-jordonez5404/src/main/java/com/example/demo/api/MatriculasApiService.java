package com.example.demo.api;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Alumno;
import com.example.demo.model.Ciclo;
import com.example.demo.services.MatriculasServiceImpl;
import com.example.demo.services.NoExisteException;
import com.example.demo.services.RepetidosException;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;

@RestController
public class MatriculasApiService {
	@Autowired
	private MatriculasServiceImpl matriculasServiceImpl;

	@GetMapping("/alumno/dni")
	public Alumno consultarAlumno(@RequestParam String dni) throws NoExisteException {
		return matriculasServiceImpl.consultarAlumno(dni);
	}

	@GetMapping("/ciclo/codigo")
	public Ciclo consultarCiclo(@RequestParam String codigo) throws NoExisteException {
		return matriculasServiceImpl.consultarCiclo(codigo);

	}
	@PostMapping("/ciclo")
	public void crearCiclo(@Valid @RequestBody Ciclo ciclo) throws RepetidosException {
		matriculasServiceImpl.crearCiclo(ciclo);

	}
	@PostMapping("/matricula")
	@Operation(description = "Matricula un alumno a partir de su dni, nombre y el codigo del ciclo al que pertenecerá")
	public Alumno matricularAlumno(@RequestParam String dni,@RequestParam String nombre, @RequestParam String codCiclo)
			throws NoExisteException, RepetidosException {
		return matriculasServiceImpl.matricularAlumno(dni, nombre, codCiclo);
	}

	@GetMapping("/matricula/codciclo")
	@Operation(description = "Consulta alumnos a partir del codigo del ciclo al que pertenece, la fecha de matriculacion, que debe estar entre las dos fechas pasadas por parámetros")
	public List<Alumno> consultarAlumnosMatriculados(@RequestParam String codCiclo, @RequestParam LocalDate fechaDesde, @RequestParam LocalDate fechaHasta)
			throws NoExisteException {
		return matriculasServiceImpl.consultarAlumnosMatriculados(codCiclo, fechaDesde, fechaHasta); 

	}

}
