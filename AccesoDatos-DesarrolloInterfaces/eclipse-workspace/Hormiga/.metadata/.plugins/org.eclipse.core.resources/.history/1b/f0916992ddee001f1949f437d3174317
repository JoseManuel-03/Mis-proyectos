package ceu.dam.examen.services;

import java.time.LocalDate;
import java.util.List;

import ceu.dam.examen.model.Alumno;
import ceu.dam.examen.model.Ciclo;

public interface MatriculasService {

	/** Este método debe consultar los datos del alumno a partir de su DNI en BBDD y devolverlo. 
	 * Vendrá con todos sus datos, incluyendo el ciclo con sus asignaturas y su tutor. 
	 * NOTA: un tutor sólo puede tutorizar un ciclo.
	 * 
	 * Si no existe el alumno, se lanzará NoExisteExcepcion.
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /alumno con GET. 
	 * El DNI se enviará por URL a continuación de /alumno/. Ejemplo: /alumno/22222222B
	 * Si se lanza NoExisteException tendrá que devolver un 404 NOT FOUND con mensaje explicativo en el body
	 * 
	 * @param dni
	 * @return
	 * @throws NoExisteException
	 */
	public Alumno consultarAlumno(String dni) throws NoExisteException;
	
	
	/** Este método debe consultar los datos del ciclo a partir de su código en BBDD y devolverlo. 
	 * Vendrá con todos sus datos, incluyendo sus asignaturas y su tutor. 
	 * NOTA: un tutor sólo puede tutorizar un ciclo.
	 * 
	 * Si no existe el ciclo, se lanzará NoExisteExcepcion.
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /ciclo con GET. 
	 * El código se enviará por URL a continuación de /ciclo/. Ejemplo /ciclo/DAM
	 * Si se lanza NoExisteException tendrá que devolver un 404 NOT FOUND con mensaje explicativo en el body
	 * 
	 * @param codigo
	 * @return
	 * @throws NoExisteException
	 */
	public Ciclo consultarCiclo(String codigo) throws NoExisteException;
	
	
	
	
	/** Este método debe crear un ciclo en BBDD. Se creará el ciclo y todas sus entidades asociadas. 
	 * NOTA: un tutor sólo puede tutorizar un ciclo.
	 * Si ya existe un ciclo con el mismo código, se lanzará RepetidosException.
	 * Si ya existe un tutor con el mismo email, se lanzará RepetidosException.
	 * El ciclo y sus entidades asociadas tienen que ser válidos de acuerdo a los comentarios indicados en el modelo.
	 * Si ocurre algún error, no se guardará nada en BBDD. Es decir, o se guarda el ciclo completo, o no se guarda nada
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /ciclo con POST. 
	 * El ciclo se enviará en el body de la petición. 
	 * Se debe validar que ciclo recibido en la petición cumpla todas las restricciones de validación.
	 * Si no es válido, tendrá que devolver 400 BAD REQUEST con un mensaje indicando qué atributo no es válido y por qué.
	 * 
	 * Si se lanza RepetidosException tendrá que devolver un 400 BAD REQUEST con mensaje explicativo en el body
	 * 
	 * @param ciclo
	 * @return
	 * @throws RepetidosException
	 */
	public void crearCiclo(Ciclo ciclo) throws RepetidosException;
	
	
	
	
	/** Este método debe crear un alumno en BBDD que esté matriculado en el ciclo del código recibido. Como fecha de matriculación
	 * se pondrá la fecha actual.
	 * Si ya existe un alumno matriculado con ese DNI en la BBDD (aunque sea para otro ciclo), se lanzará RepetidosException.
	 * Si NO existe un ciclo con el código indicado, se lanzará NoExisteException.
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /matricula con POST. 
	 * Todos los datos se enviarán como parámetros de la petición. Ejemplo: /matricula?dni=12345678Y&nombre=Lopez&codCiclo=DAM
	 * 
	 * Si se lanza RepetidosException tendrá que devolver un 400 BAD REQUEST con mensaje explicativo en el body
	 * Si se lanza NoExisteException tendrá que devolver un 404 NOT FOUND con mensaje explicativo en el body
	 * 
	 * @param dni, nombre, codCiclo
	 * @return
	 * @throws RepetidosException, NoExisteException
	 */
	public Alumno matricularAlumno(String dni, String nombre, String codCiclo) throws NoExisteException, RepetidosException;
	
	
	
	
	/** Este método consultará todos los alumnos matriculados en el curso con el código indicado y cuya
	 * fecha de matrícula este entre las dos fechas enviadas. 
	 * Si NO existe un ciclo con el código indicado, se lanzará NoExisteException.
	 * 
	 * Este método tendrá que estar también publicado en un API en la URL /matriculas con GET. 
	 * El código de ciclo se enviará en la URL a continuación de /matriculas/. El resto de datos (las fechas) se 
	 * enviarán como parámetros de la petición con formato dd-MM-yyyy. Ejemplo: /matriculas/DAM?fechaDesde=01-02-2025&fechaHasta=01-03-2025
	 * 
	 * Si se lanza NoExisteException tendrá que devolver un 404 NOT FOUND con mensaje explicativo en el body
	 * 
	 * @param codCiclo, fechaDesde, fechaHasta
	 * @return
	 * @throws  NoExisteException
	 */
	public List<Alumno> consultarAlumnosMatriculados(String codCiclo, LocalDate fechaDesde, LocalDate fechaHasta) throws NoExisteException;
	
}
