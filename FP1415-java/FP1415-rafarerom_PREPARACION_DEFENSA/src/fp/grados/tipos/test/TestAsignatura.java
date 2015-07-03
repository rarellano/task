package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.TipoAsignatura;

// Este código se les da como material adjunto al boletín T3
public class TestAsignatura {

	public static void main(String[] args) {
		
//		Asignatura b = new AsignaturaImpl("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 3, null);
//		System.out.println(b.getAcronimo());
		
		testConstructorNormal();
		testConstructorExcepcion1();
		testConstructorExcepcion2();
		testConstructorExcepcion3();
		testConstructorExcepcion4();
		testConstructorExcepcion5();
		testConstructorExcepcion6();
		testConstructorExcepcion7();	
		
		
		Asignatura asig01 = new AsignaturaImpl("Fundamentos de Programacion #2050001 # 12.0# ANUAL# 1");
		System.out.println(asig01);
		Asignatura asig02 = new AsignaturaImpl("Calculo Infinitesimal y Numerico# 2050002# 6.0# PRIMER_CUATRIMESTRE# 1");
		System.out.println(asig02);
		Asignatura asig03 = new AsignaturaImpl("Circuitos Electronicos Digitales# 2050003# 6.0# PRIMER_CUATRIMESTRE# 1");
		System.out.println(asig03);
		Asignatura asig04 = new AsignaturaImpl("Fundamentos Fisicos de la Informatica#2050004#6.0# PRIMER_CUATRIMESTRE# 1");
		System.out.println(asig04);
		Asignatura asig05 = new AsignaturaImpl("Introduccion a la Matematica Discreta#2050005#6.0# PRIMER_CUATRIMESTRE# 1");
		System.out.println(asig05);
		Asignatura asig06 = new AsignaturaImpl("Administracion de Empresas# 2050006# 6.0# SEGUNDO_CUATRIMESTRE# 1");
		System.out.println(asig06);
		Asignatura asig07 = new AsignaturaImpl("Algebra Lineal y Numerica# 2050007# 6.0# SEGUNDO_CUATRIMESTRE# 1");
		System.out.println(asig07);
		Asignatura asig08 = new AsignaturaImpl("Estadistica# 2050008# 6.0# SEGUNDO_CUATRIMESTRE# 1");
		System.out.println(asig08);
		Asignatura asig09 = new AsignaturaImpl("Estructura de Computadores# 2050009# 6.0# SEGUNDO_CUATRIMESTRE# 1");
		System.out.println(asig09);
		Asignatura asig10 = new AsignaturaImpl("Analisis y Dis de Datos y Algoritmos# 2050010# 12.0# ANUAL# 2");
		System.out.println(asig10);
		Asignatura asig11 = new AsignaturaImpl("Introduccion a la Ingenieria del Software# 2050011# 12.0# ANUAL# 2");
		System.out.println(asig11);
		Asignatura asig12 = new AsignaturaImpl("Logica Informatica# 2050012# 6.0# PRIMER_CUATRIMESTRE# 2");
		System.out.println(asig12);
		Asignatura asig13 = new AsignaturaImpl("Redes de Computadores# 2050013# 6.0# PRIMER_CUATRIMESTRE# 2");
		System.out.println(asig13);
		Asignatura asig14 = new AsignaturaImpl("Sistemas Operativos# 2050014# 6.0# PRIMER_CUATRIMESTRE# 2");
		System.out.println(asig14);
		Asignatura asig15 = new AsignaturaImpl("Arquitectura de Computadores# 2050015# 6.0# SEGUNDO_CUATRIMESTRE# 2");
		System.out.println(asig15);
		Asignatura asig16 = new AsignaturaImpl("Arquitectura e Integracion de Sistemas#2050016#6.0#SEGUNDO_CUATRIMESTRE#2");
		System.out.println(asig16);
		Asignatura asig17 = new AsignaturaImpl("Matematica Discreta# 2050017# 6.0# SEGUNDO_CUATRIMESTRE# 2");
		System.out.println(asig17);
	}
	
	
	/******************************** CASOS DE PRUEBA **************************/

	private static void testConstructorNormal() {
		System.out
				.println("==================================Probando el constructor");
		testConstructor("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 1);
	}

	private static void testConstructorExcepcion1() {
		System.out
		.println("==================================Probando el constructor, código de asignatura más largo");
		testConstructor("Fundamentos de Programación","20500010",12.0, TipoAsignatura.ANUAL, 1);
	}
	
	private static void testConstructorExcepcion2() {
		System.out
		.println("==================================Probando el constructor, código de asignatura más corto");
		testConstructor("Fundamentos de Programación","205000",12.0, TipoAsignatura.ANUAL, 1);
	}
	
	private static void testConstructorExcepcion3() {
		System.out
				.println("==================================Probando el constructor, código de asignatura no numérico");
		testConstructor("Fundamentos de Programación","2A50001",12.0, TipoAsignatura.ANUAL, 1);
	}
	
	private static void testConstructorExcepcion4() {
		System.out
				.println("==================================Probando el constructor, créditos incorrectos (0.0)");
		testConstructor("Fundamentos de Programación","2050001",0.0, TipoAsignatura.ANUAL, 1);
	}
		
	private static void testConstructorExcepcion5() {
		System.out
				.println("==================================Probando el constructor, créditos incorrectos (-1.0)");
		testConstructor("Fundamentos de Programación","2050001",-1.0, TipoAsignatura.ANUAL, 1);
	}
	
	
	private static void testConstructorExcepcion6() {
		System.out
				.println("==================================Probando el constructor, curso menor de 1");
		testConstructor("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, -2);
	}
	
	private static void testConstructorExcepcion7() {
		System.out
				.println("==================================Probando el constructor, curso mayor de 4");
		testConstructor("Fundamentos de Programación","2050001",12.0, TipoAsignatura.ANUAL, 5);
	}
	
	/******************************** METODOS AUXILIARES **************************/
	
	private static void testConstructor(String nombre, String codigo, Double creditos,
			TipoAsignatura tipo, Integer curso) {
		try {
			Asignatura a = new AsignaturaImpl(nombre, codigo, creditos, tipo, curso, null);
			mostrarAsignatura(a);
		} catch (ExcepcionAsignaturaNoValida e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionAsignaturaNoValida");
		} catch (Exception e) {
			System.out
					.println("******************** ¡¡¡Se ha capturado una EXCEPCIÓN INESPERADA!!!");
		}
	}


	private static void mostrarAsignatura(Asignatura a) {		
		System.out.println("Assignatura --> <" + a + ">");
		System.out.println("\tNombre: <" + a.getNombre() + ">");
		System.out.println("\tCódigo: <" + a.getCodigo() + ">");
		System.out.println("\tCréditos: <" + a.getCreditos() + ">");
		System.out.println("\tTipo: <" + a.getTipo() + ">");
		System.out.println("\tCurso: <" + a.getCurso() + ">");
	}

}