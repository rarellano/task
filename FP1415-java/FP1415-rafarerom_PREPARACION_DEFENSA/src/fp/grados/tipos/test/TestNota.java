package fp.grados.tipos.test;

import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionNotaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.TipoAsignatura;


public class TestNota {

	private static void mostrar(Nota nota) {
		
		
		
		System.out.print(nota.getAsignatura() + " ,");
		System.out.print(nota.getCalificacion() + " ,");
		System.out.print(nota.getConvocatoria() + " ,");
		System.out.print(nota.getCursoAcademico() + " ,");
		System.out.print(nota.getMencionHonor() + " ,");
		System.out.println(nota.getValor() + " ,");
		
		
		
		
	}

	private static void testConstructor1() {

		AsignaturaImpl asig1 = new AsignaturaImpl("Matematicas Discreta",
				"1643512", 12.0, TipoAsignatura.ANUAL, 1, null);

		NotaImpl nota2 = new NotaImpl(asig1, 1, Convocatoria.SEGUNDA, 9.00,
				true);
		mostrar(nota2);

	}

	private static void testConstructor1ExcepcionValor() {

		try {
			AsignaturaImpl asig1 = new AsignaturaImpl("Matematicas Discreta",
					"1643512", 12.0, TipoAsignatura.ANUAL, 1, null);

			NotaImpl nota2 = new NotaImpl(asig1, 1, Convocatoria.SEGUNDA, 19.00,
					true);
			mostrar(nota2);

		} catch (ExcepcionNotaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionNotaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}
	
	private static void testConstructor1ExcepcionMencionHonor() {

		try {
			AsignaturaImpl asig1 = new AsignaturaImpl("Matematicas Discreta",
					"1643512", 12.0, TipoAsignatura.ANUAL, 1, null);

			NotaImpl nota2 = new NotaImpl(asig1, 1, Convocatoria.SEGUNDA, 6.00,
					true);
			mostrar(nota2);

		} catch (ExcepcionNotaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionNotaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}

	private static void testConstructor2() {

		AsignaturaImpl asig1 = new AsignaturaImpl(
				"Fundamentos de programacion", "9643512", 12.0,
				TipoAsignatura.ANUAL, 1, null);

		NotaImpl nota1 = new NotaImpl(asig1, 2014, Convocatoria.SEGUNDA, 6.00);
		mostrar(nota1);
		

	}
	
	private static void testConstructor2ExcepcionValor() {

		try {
			AsignaturaImpl asig1 = new AsignaturaImpl("Matematicas Discreta",
					"1643512", 12.0, TipoAsignatura.ANUAL, 1, null);

			NotaImpl nota2 = new NotaImpl(asig1, 1, Convocatoria.SEGUNDA, 19.00);
			mostrar(nota2);

		} catch (ExcepcionNotaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionNotaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}

	public static void main(String[] args) {
//		Set<Profesor> profesores = new HashSet<Profesor>();
//
//		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
//		Departamento depart1 = new DepartamentoImpl("LSI");
//
//		
//		AsignaturaImpl asig1 = new AsignaturaImpl("Matematicas Discreta",
//				"1643512", 12.0, TipoAsignatura.ANUAL, 1, depart1);
//		
//		System.out.println(asig1);
//
//		NotaImpl nota2 = new NotaImpl(asig1, 1, Convocatoria.SEGUNDA, 9.00,
//				true);
//		System.out.println(nota2);
//
//		testConstructor1();
//		testConstructor1ExcepcionValor();
//		testConstructor1ExcepcionMencionHonor();
//		testConstructor2();
//		testConstructor2ExcepcionValor();
								   
		Nota nota01= new NotaImpl("Fundamentos de Programacion#1234567#12.0#ANUAL#1;2014   ;PRIMERA;10.0;true");
		System.out.println(nota01);
		

	}

}
