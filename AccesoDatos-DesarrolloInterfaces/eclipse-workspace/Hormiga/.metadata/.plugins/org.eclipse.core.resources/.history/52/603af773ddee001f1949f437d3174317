package ceu.dam.examen.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ceu.dam.examen.model.Alumno;
import ceu.dam.examen.model.Asignatura;
import ceu.dam.examen.model.Ciclo;
import ceu.dam.examen.model.Tutor;
import ceu.dam.examen.services.MatriculasService;

public class TestService {

	private MatriculasService service;
	
	private Scanner sc;

	public void test() {
		sc = new Scanner(System.in);
		Ciclo ciclo = createCiclo();
		
		System.out.println("\nANTES DE COMENZAR CON LAS PRUEBAS ASEGURA QUE TIENES LA BBDD LIMPIA. BORRA LAS TABLAS CON ESTO: \n");
		
		System.out.println("DELETE FROM alumno;\r\n"
				+ "DELETE FROM asignatura;\r\n"
				+ "DELETE FROM ciclo;\r\n"
				+ "DELETE FROM tutor;");
		
		System.out.println("\n");
		if (!pregunta()) {
			return;
		}
		
		try {
			System.out.println(">>> PRUEBA 1: PROBAMOS A CREAR UN CICLO....");
			pausa();
			service.crearCiclo(ciclo);
			System.out.println(">>> PRUEBA 1 OK. Revisa la BBDD que se haya guardado todo (salvo alumnos)");
		} catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}
		try {
			System.out.println(">>> PRUEBA 2: PROBAMOS A MATRICULAR TRES ALUMNOS EN EL CICLO ANTERIOR....");
			pausa();
			service.matricularAlumno("11111111A", "ALUMNO 1 DE PRUEBA", "DAM");
			service.matricularAlumno("22222222B", "ALUMNO 2 DE PRUEBA", "DAM");
			service.matricularAlumno("33333333C", "ALUMNO 3 DE PRUEBA", "DAM");
			System.out.println(">>> PRUEBA 2 OK. Revisa en BBDD que se hayan registrado 3 alumnos");
		} 
		catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}
		try {
			System.out.println(">>> PRUEBA 3: PROBAMOS A CONSULTAR UN ALUMNO...");
			pausa();
			Alumno alumno = service.consultarAlumno("22222222B");
			System.out.println(alumno);
			System.out.println(">>> PRUEBA 3 OK. Verifica que se imprimen todos sus datos");
		} 
		catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}
		try {
			System.out.println(">>> PRUEBA 4: PROBAMOS A CONSULTAR UN CICLO...");
			pausa();
			ciclo = service.consultarCiclo("DAM");
			System.out.println(ciclo);
			System.out.println(">>> PRUEBA 4 OK. Verifica que se imprimen todos sus datos");
		} 
		catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}
		try {
			System.out.println(">>> PRUEBA 5: PROBAMOS A CONSULTAR ALUMNOS MATRICULADOS...");
			pausa();
			List<Alumno> lista = service.consultarAlumnosMatriculados("DAM", LocalDate.now().minusDays(10), LocalDate.now().plusDays(10));
			lista.forEach(System.out::println);
			System.out.println(">>> PRUEBA 5 OK. Verifica que se imprimen todos los alumnos (3)");
		} 
		catch (Exception e) {
			System.out.println("Tienes algún error");
			pausa();
			e.printStackTrace();
		}
		if (!pregunta()) {
			return;
		}

		System.out.println("FIN DE LAS PRUEBAS");
				
		
		
		sc.close();
		
		
		
	}


	private Ciclo createCiclo() {
		Tutor tutor = new Tutor();
		tutor.setNombre("Blas Poropo");
		tutor.setEmail("blas@ceu.es");
		Asignatura asignatura1 = new Asignatura();
		asignatura1.setCodigo("ACD");
		asignatura1.setNombre("Acceso a datos");
		Asignatura asignatura2 = new Asignatura();
		asignatura2.setCodigo("INT");
		asignatura2.setNombre("Desarrollo de interfaces");
		List<Asignatura> asignaturas = new ArrayList<>();
		asignaturas.add(asignatura1);
		asignaturas.add(asignatura2);
		Ciclo ciclo = new Ciclo();
		ciclo.setCodigo("DAM");
		ciclo.setDescripcion("Ciclo Formativo de DESARROLLO DE APLICACIONES MULTIPLATAFORMA");
		ciclo.setTutor(tutor);
		ciclo.setAsignaturas(asignaturas);
		return ciclo;
	}
	
	
	private void pausa() {
		System.out.println("Pulsa tecla ENTER para continuar...\n");
		sc.nextLine();
	}
	
	private Boolean pregunta() {
		System.out.println("¿Quieres continuar con las pruebas? (S/N)\n");
		return sc.nextLine().equalsIgnoreCase("S");
	}
	
}
