package fp.grados.tipos.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;
import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Expediente;
import fp.grados.tipos.ExpedienteImpl;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestAlumno {

	public static void main(String[] args) {

		testConstructorNormal();
		testConstructorExcepcion();

		testSetEmailNormal();
		testSetEmailExcepcion();

		testMatriculaAsignatura();
		testMatriculaAsignaturaExcepcion();

		testEliminaAsignatura();
		testEliminaAsignaturaExcepcion();
		
		Alumno alum = new AlumnoImpl("47343391F", "Rafa", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");	


		
		Set<Profesor> profesores = new HashSet<Profesor>();

		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		Departamento depart1 = new DepartamentoImpl("LSI");

		AsignaturaImpl asig1 = new AsignaturaImpl("Matematicas Discreta","1643512", 12.0, TipoAsignatura.ANUAL, 1, depart1);

		AsignaturaImpl asig2 = new AsignaturaImpl("Calculo", "1642222", 12.0,TipoAsignatura.ANUAL, 1, depart1);
		
		AsignaturaImpl asig3 = new AsignaturaImpl("Sistemas Oooperativos", "1642244", 6.0,TipoAsignatura.PRIMER_CUATRIMESTRE, 2, depart1);

		ProfesorImpl profesor01 = new ProfesorImpl("47343391F", "Alejandro","Are", LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
				Categoria.AYUDANTE_DOCTOR, depart1);
		ProfesorImpl profesor02 = new ProfesorImpl("47343391F", "Rafael","Are", LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
				Categoria.AYUDANTE_DOCTOR, depart1);
		ProfesorImpl profesor03 = new ProfesorImpl("47343391F", "Luis", "Are",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
				Categoria.AYUDANTE_DOCTOR, depart1);

		profesores.add(profesor01);
		profesores.add(profesor02);
		profesores.add(profesor03);
		asignaturas.add(asig3);
		asignaturas.add(asig1);
		asignaturas.add(asig2);
		
		alum.matriculaAsignatura(asig3);
		alum.matriculaAsignatura(asig1);
		alum.matriculaAsignatura(asig2);

		Expediente expe01 = new ExpedienteImpl();
		Expediente expe02 = expe01;
		Expediente expe03 = new ExpedienteImpl();


//		NotaImpl nota2 = new NotaImpl(asig2, 2013, Convocatoria.PRIMERA, 2.00,
//				false);
//		NotaImpl nota1 = new NotaImpl(asig1, 2013, Convocatoria.SEGUNDA, 4.00,
//				false);
//		NotaImpl nota3 = new NotaImpl(asig3, 2013, Convocatoria.PRIMERA, 4.00,
//				false);
//		System.out.println(nota1);
//		System.out.println(nota2);
//
//		System.out.println(nota3);
//
//		expe01.nuevaNota(nota2);
//		expe01.nuevaNota(nota1);
//		expe01.nuevaNota(nota3);
		System.out.println(expe01.getNotaMedia());

		System.out.println(expe01);
		System.out.println(expe01.equals(expe02));	
		System.out.println(expe02.equals(expe03));
		
		System.out.println(alum.getCurso());
		
		System.out.println(alum);
		
		// Prueba 
		
//		alum.evaluaAlumno(asig2, 2, Convocatoria.PRIMERA, 5.00);
//		alum.evaluaAlumno(asig1, 2, Convocatoria.PRIMERA, 8.00);
//		
//		System.out.println(alum.getCalificaionPorAsignatura());
		
		Alumno alum01 = new AlumnoImpl("12345678Z,Juan,Lopez Garcia,20/7/1998,juan@alum.us.es");
		System.out.println(alum01);
		Alumno alum02 = new AlumnoImpl("12345678Z,Antonio,Lopez Lopez,3/11/1997,antonio@alum.us.es");
		System.out.println(alum01);
		Alumno alum03 = new AlumnoImpl("12345678Z,Sonia Estefania,Amor Gena,10/12/1988,sonia@alum.us.es");
		System.out.println(alum01);
		Alumno alum04 = new AlumnoImpl("12345678Z,Maria,Lora Santa,26/7/2002,maria@alum.us.es");
		System.out.println(alum01);
		
//		Map<String, Integer> cabesa = new HashMap<String, Integer>();
//		
//		cabesa.put("ORDINARIA", 0);
//		cabesa.put("TRANSPORTE",0);
//		cabesa.put("ERASMUS", 0);
//		
//		System.out.println(cabesa.get("ORDINARIA"));
//		System.out.println(cabesa);
		
	}

	private static void testConstructorNormal() {
		System.out
				.println("\n==================================Probando el primer constructor");
		testConstructor("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
	}

	private static void testConstructorExcepcion() {
		System.out
				.println("\n==================================Probando el primer constructor, email incorrecto");
		testConstructor("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@gmail.com");
	}

	private static void testSetEmailNormal() {
		System.out
				.println("\n==================================Probando setEmail");

		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		testSetEmail(a, "juan@alum.us.es");
	}

	private static void testSetEmailExcepcion() {
		System.out
				.println("\n==================================Probando setEmail, email incorrecto");

		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		testSetEmail(a, "juan@gmail.com");
	}

	private static void testMatriculaAsignatura() {
		System.out
				.println("\n==================================Probando matriculaAsignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1, null);
		testMatriculaAsignatura(a, asig);
	}

	private static void testMatriculaAsignaturaExcepcion() {
		System.out
				.println("\n==================================Probando matriculaAsignatura, matricula doble en una asignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1, null);
		a.matriculaAsignatura(asig);
		testMatriculaAsignatura(a, asig);
	}

	private static void testEliminaAsignatura() {
		System.out
				.println("\n==================================Probando eliminaAsignatura");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1, null);
		a.matriculaAsignatura(asig);
		testEliminaAsignatura(a, asig);
	}

	private static void testEliminaAsignaturaExcepcion() {
		System.out
				.println("\n==================================Probando eliminaAsignatura, asignatura no matriculada");
		Alumno a = new AlumnoImpl("12345678Z", "Juan", "Nadie Nadie",
				LocalDate.of(1950, 3, 15), "juan.nadie@alum.us.es");
		Asignatura asig = new AsignaturaImpl("Fundamentos de Programación",
				"2050001", 12.0, TipoAsignatura.ANUAL, 1, null);
		testEliminaAsignatura(a, asig);
	}

	private static void testConstructor(String dni, String nombre,
			String apellidos, LocalDate fechaNacimiento, String email) {

		try {
			Alumno a = new AlumnoImpl(dni, nombre, apellidos, fechaNacimiento,
					email);
			mostrarAlumno(a);
		} catch (ExcepcionAlumnoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}

	private static void testSetEmail(Alumno a, String nuevoEmail) {

		try {
			System.out.println("El email antes de la operación es: "
					+ a.getEmail());
			System.out.println("El nuevo email es: " + nuevoEmail);
			a.setEmail(nuevoEmail);
			System.out.println("El email después de la operación es: "
					+ a.getEmail());
		} catch (ExcepcionAlumnoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	private static void testMatriculaAsignatura(Alumno a, Asignatura asig) {

		try {
			System.out.println("Las asignaturas antes de la operación son: "
					+ a.getAsignaturas());
			System.out.println("Nueva asignatura a matricular: " + asig);
			a.matriculaAsignatura(asig);
			System.out.println("Las asignaturas después de la operación son: "
					+ a.getAsignaturas());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoOperacionNoPermitida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	private static void testEliminaAsignatura(Alumno a, Asignatura asig) {

		try {
			System.out.println("Las asignaturas antes de la operación son: "
					+ a.getAsignaturas());
			System.out.println("Asignatura a eliminar: " + asig);
			a.eliminaAsignatura(asig);
			System.out.println("Las asignaturas después de la operación son: "
					+ a.getAsignaturas());
		} catch (ExcepcionAlumnoOperacionNoPermitida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAlumnoOperacionNoPermitida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	private static void mostrarAlumno(Alumno a) {
		System.out.println("Alumno --> <" + a + ">");
		System.out.println("\tDNI: <" + a.getDNI() + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tApellidos: <" + a.getApellidos() + ">");
		System.out.println("\tFecha Nacimiento: <"
				+ a.getFechaNacimiento().format(
						DateTimeFormatter.ofPattern("dd/MM/yyyy")) + ">");
		System.out.println("\tEdad: <" + a.getEdad() + ">");
		System.out.println("\tEmail:  <" + a.getEmail() + ">");
		System.out.println("\tAsignaturas:  <" + a.getAsignaturas() + ">");
	}
}