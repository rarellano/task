package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionDespachoNoValido;
import fp.grados.excepciones.ExcepcionPersonaNoValida;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Persona;
import fp.grados.tipos.PersonaImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.TipoEspacio;



public class TestDespacho {

	private static void mostrar(Despacho despacho) {
		System.out.print(despacho.getNombre() +" ,");
		System.out.print(despacho.getCapacidad()+" ,");
		System.out.print(despacho.getPlanta()+" ,");
		System.out.print(despacho.getTipo());
		System.out.println(despacho.getProfesores());
	}

	private static void testConstructor1(){
		
		try {
			System.out.println("Contructor 1");	

			Set<Profesor> profesores = new HashSet<Profesor>();
			Profesor profesor01 = new ProfesorImpl("12345678Z", "Rafael",
					"Arellano Romero", LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es", Categoria.AYUDANTE_DOCTOR,null);
			profesores.add(profesor01);
			DespachoImpl despacho01 = new DespachoImpl("A1.11", 10, 2, profesores);
			
			mostrar(despacho01);
		} catch (ExcepcionDespachoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionDespachoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada "+e+" . El constructor no funciona correctamente");
		}
		
	
	}
	
	private static void testConstructor1excepcionCapacidad(){
		
		try {
			System.out.println("Contructor 1 - Excepcion Capacidad");	

			Set<Profesor> profesores = new HashSet<Profesor>();
			Profesor profesor01 = new ProfesorImpl("12345678Z", "Rafael",
					"Arellano Romero", LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es", Categoria.AYUDANTE_DOCTOR,null);
			profesores.add(profesor01);
			DespachoImpl despacho01 = new DespachoImpl("A1.11", 0, 2, profesores);
			
			mostrar(despacho01);
		} catch (ExcepcionDespachoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionDespachoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada "+e+" . El constructor no funciona correctamente");
		}
		
	
	}
	
	private static void testConstructor2(){
		
		try {
			System.out.println("Contructor 2");	

			Profesor profesor = new ProfesorImpl("12345678Z", "Marina",
					"Martinez", LocalDate.of(1991, 8, 28), "martinez@us.es", Categoria.CATEDRATICO,null);
			DespachoImpl despacho = new DespachoImpl("A2.22", 8, 1, profesor);
			mostrar(despacho);
		} catch (ExcepcionDespachoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionDespachoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada "+e+" . El constructor no funciona correctamente");
		}
		
	
	}
	
	private static void testConstructor3(){
		
		try {
			System.out.println("Contructor 3");	
			DespachoImpl despacho = new DespachoImpl("A1.11", 4, 2);
			
			mostrar(despacho);
		} catch (ExcepcionDespachoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionDespachoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada "+e+" . El constructor no funciona correctamente");
		}
		
	
	}
	
	
	private static void testExcepcionTipoEspacio() {
		try {
			
			System.out.println("Excepcion Set Tipo Espacio");
			
			DespachoImpl despacho = new DespachoImpl("A1.11", 4, 2);
			
			despacho.setTipo(TipoEspacio.EXAMEN);
			
		} catch (ExcepcionDespachoNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionDespachoNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada "+e+" . El constructor no funciona correctamente");
		}
		
	}
	
	public static void main(String[] args) {
		testConstructor1();
		testConstructor1excepcionCapacidad();
		testConstructor2();
		testConstructor3();
		testExcepcionTipoEspacio();
		
		Despacho desp01 = new DespachoImpl("F1.43,1,3");
		System.out.println(desp01);
	}

	

}
