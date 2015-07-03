package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import fp.grados.excepciones.ExcepcionEspacioNoValido;
import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Persona;
import fp.grados.tipos.PersonaImpl;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.TipoEspacio;
import fp.grados.tipos.TutoriaImpl;

public class TestProfesor {

	
	
	

	private static void mostrar(Profesor profesor) {
		System.out.print(profesor.getNombre()+" ,");
		System.out.print(profesor.getApellidos()+" ,");
		System.out.print(profesor.getDNI()+" ,");
		System.out.print(profesor.getEmail()+" ,");
		System.out.print(profesor.getEdad()+" ,");
		System.out.print(profesor.getFechaNacimiento()+" ,");
		System.out.println(profesor.getCategoria()+" ,");

	}

	private static void testConstructor1(){
		
		try {
			ProfesorImpl profesor01 = new ProfesorImpl("47343391F", "Rafael",
					"Arellano Romero",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",  Categoria.AYUDANTE_DOCTOR, null);
			
			mostrar(profesor01);
			
		} catch (ExcepcionProfesorNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionProfesorNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testConstructor1ConEdadMal(){
		
		try {
			ProfesorImpl profesor01 = new ProfesorImpl("47343391F", "Rafael",
					"Arellano Romero",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",  Categoria.AYUDANTE_DOCTOR, null);
			
			mostrar(profesor01);
			
		} catch (ExcepcionProfesorNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionProfesorNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testGetTutorias(){
		
		try {
			
			
			
			ProfesorImpl profesor01 = new ProfesorImpl("47343391F", "Rafael",
					"Arellano Romero",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",  Categoria.AYUDANTE_DOCTOR, null);
			
			profesor01.getTutorias();
			profesor01.nuevaTutoria(LocalTime.of(16, 30), 40, DayOfWeek.MONDAY);
			profesor01.nuevaTutoria(LocalTime.of(16, 30), 50, DayOfWeek.FRIDAY);
			profesor01.nuevaTutoria(LocalTime.of(16, 20), 20, DayOfWeek.FRIDAY);
			profesor01.nuevaTutoria(LocalTime.of(14, 30), 40, DayOfWeek.WEDNESDAY);
			
			System.out.println(profesor01.getTutorias());
			
		} catch (ExcepcionProfesorNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionProfesorNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}
	
	private static void testBorraTutorias(){
		
		try {
			
			
			
			ProfesorImpl profesor01 = new ProfesorImpl("47343391F", "Rafael",
					"Arellano Romero",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",  Categoria.AYUDANTE_DOCTOR, null);
			
			profesor01.getTutorias();
			profesor01.nuevaTutoria(LocalTime.of(16, 30), 40, DayOfWeek.MONDAY);
			profesor01.nuevaTutoria(LocalTime.of(16, 30), 50, DayOfWeek.FRIDAY);
			profesor01.nuevaTutoria(LocalTime.of(16, 20), 20, DayOfWeek.FRIDAY);
			profesor01.nuevaTutoria(LocalTime.of(14, 30), 40, DayOfWeek.WEDNESDAY);
			
			System.out.println("Actualmente tienes estas asignaturas: " +profesor01.getTutorias());
			
			profesor01.borraTutorias();
			
			System.out.println("Actualmente no tienes asignaturas: " +profesor01.getTutorias());
			
		} catch (ExcepcionProfesorNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionProfesorNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}
		
	public static void main(String[] args) {

		testConstructor1();
		testGetTutorias();
		testConstructor1ConEdadMal();
		testBorraTutorias();
		
		List<Double> creditos = new LinkedList<Double>();
		creditos.add(1.00);
		creditos.add(2.00);
		creditos.add(3.00);
		creditos.add(4.00);
		creditos.remove(0);
		creditos.add(0, 5.00);
		
		
		
		System.out.println(creditos);
		System.out.println(creditos.indexOf(5.00));
		System.out.println(creditos.get(3));
		
		System.out.println("A MAMAHLAAAA");
		Set<Profesor> profesores = new HashSet<Profesor>();

		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		
		Departamento depart1 = new DepartamentoImpl("LSI");
		Departamento depart2 = new DepartamentoImpl("DTE");

		
		ProfesorImpl profesor01 = new ProfesorImpl("47343391F", "Alejandro",
				"Are",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",  Categoria.AYUDANTE_DOCTOR, depart1);
		ProfesorImpl profesor02 = new ProfesorImpl("47343391F", "Rafael",
				"Are",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",  Categoria.AYUDANTE_DOCTOR, depart1);
		ProfesorImpl profesor03 = new ProfesorImpl("47343391F", "Luis",
				"Are",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",  Categoria.AYUDANTE_DOCTOR, depart1);
		
//		Asignatura asig;
//		depart.nuevaAsignatura(asig);
		
		depart1.nuevoProfesor(profesor01);
		depart1.nuevoProfesor(profesor02);
		depart1.nuevoProfesor(profesor03);
		
		System.out.println(depart1.getProfesores());
		
		Asignatura asig01 = new AsignaturaImpl("Fundamentos de Programacion","2050001",12.0, TipoAsignatura.ANUAL, 1, depart1);
		Asignatura asig02 = new AsignaturaImpl("Analisis y diseño de Algoritmos","2050002",12.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2, depart1);

		Asignatura asig03 = new AsignaturaImpl("Circuitos Electronicos Digitales","2050003",12.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 1, depart2);
		Asignatura asig04 = new AsignaturaImpl("Estructura de Computadores","2050004",6.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2, depart2);
		
		depart1.nuevaAsignatura(asig01);
		depart1.nuevaAsignatura(asig02);
		
		System.out.println(depart1.getAsignaturas());
		
		profesor01.imparteAsignatura(asig01, 12.00);
		profesor01.imparteAsignatura(asig02, 12.00);	
//		profesor01.imparteAsignatura(asig03, 1.50);	
		profesor02.imparteAsignatura(asig01, 3.00);
		
		System.out.println(profesor01.dedicacionAsignatura(asig01));
		
//		profesor01.imparteAsignatura(asig04, 1.0);
	
		System.out.println(profesor01.getAsignaturas());
		
		profesor01.eliminaAsignatura(asig01);
		
		System.out.println(profesor01.getAsignaturas());
		
		System.out.println(profesor01.getDedicacionTotal());

	}

}
