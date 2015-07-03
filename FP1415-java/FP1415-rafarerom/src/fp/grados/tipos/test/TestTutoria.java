package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import com.sun.org.apache.xerces.internal.impl.dv.xs.DayDV;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.excepciones.ExcepcionTutoriaNoValida;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Convocatoria;
import fp.grados.tipos.Nota;
import fp.grados.tipos.NotaImpl;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Tutoria;
import fp.grados.tipos.TutoriaImpl;

public class TestTutoria {

	private static void mostrar(Tutoria tutoria) {
		System.out.print(tutoria.getDiaSemana() + " ,");
		System.out.print(tutoria.getDuracion() + " ,");
		System.out.print(tutoria.getHoraComienzo() + " ,");
		System.out.println(tutoria.getHoraFin());

	}

	private static void testConstructor1() {

		try {
			TutoriaImpl tutoria01 = new TutoriaImpl(DayOfWeek.FRIDAY,
					LocalTime.of(14, 50), 100);

			mostrar(tutoria01);

		} catch (ExcepcionTutoriaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionTutoriaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}

	private static void testConstructor1ConDiaMal() {

		try {
			TutoriaImpl tutoria01 = new TutoriaImpl(DayOfWeek.SATURDAY,
					LocalTime.of(14, 50), 100);

			mostrar(tutoria01);

		} catch (ExcepcionTutoriaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionTutoriaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}

	private static void testConstructor1ConDuracionMal() {

		try {
			TutoriaImpl tutoria01 = new TutoriaImpl(DayOfWeek.SATURDAY,
					LocalTime.of(14, 50), 10);

			mostrar(tutoria01);

		} catch (ExcepcionTutoriaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionTutoriaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}

	}

	private static void testConstructor2() {

		try {
			TutoriaImpl tutoria01 = new TutoriaImpl(DayOfWeek.MONDAY,
					LocalTime.of(17, 50), LocalTime.of(18, 50));
			mostrar(tutoria01);

		} catch (ExcepcionTutoriaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionTutoriaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	private static void testConstructor2ConDiaMal() {

		try {
			TutoriaImpl tutoria01 = new TutoriaImpl(DayOfWeek.SUNDAY,
					LocalTime.of(17, 50), LocalTime.of(18, 50));
			mostrar(tutoria01);

		} catch (ExcepcionTutoriaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionTutoriaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	private static void testConstructor2ConDuracionMal() {

		try {
			TutoriaImpl tutoria01 = new TutoriaImpl(DayOfWeek.MONDAY,
					LocalTime.of(17, 50), LocalTime.of(18, 00));
			mostrar(tutoria01);

		} catch (ExcepcionTutoriaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionTutoriaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}

	public static String muestra(Double[] a) {
		String res = "---> ";
		for (int i = 0; i <= a.length -1; i++) {
			res = res + a[i] + " ";
		}
		return res;
	}

	public static void main(String[] args) {
		testConstructor1();
		testConstructor1ConDiaMal();
		testConstructor1ConDuracionMal();
		testConstructor2();
		testConstructor2ConDiaMal();
		testConstructor2ConDuracionMal();

		Double [] array = {1.0, 2.0, 3.0, 4.0, 5.0};
		System.out.println(muestra(array));
		
		Tutoria t01 = new TutoriaImpl("L,15:30,17:30");
		
	}

}
