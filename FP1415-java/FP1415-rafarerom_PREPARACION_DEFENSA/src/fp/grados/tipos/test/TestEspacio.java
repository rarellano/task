package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionEspacioNoValido;
import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.TipoEspacio;



public class TestEspacio {

	private static void mostrar(Espacio espacio) {
		System.out.print(espacio.getNombre() +" ,");
		System.out.print(espacio.getCapacidad()+" ,");
		System.out.print(espacio.getPlanta()+" ,");
		System.out.println(espacio.getTipo());
	}

	private static void testConstructor1(){
	
		EspacioImpl espacio01 = new EspacioImpl(TipoEspacio.OTRO, "AS.43", 10, 0);
		mostrar(espacio01);
		
	}
	
	private static void testConstructor1ExcepcionCapacidad(){
		
		try {
			EspacioImpl espacio01 = new EspacioImpl(TipoEspacio.OTRO, "AS.43",
					-10, 0);
			mostrar(espacio01);

		} catch (ExcepcionEspacioNoValido e) {
			System.out
					.println("******************** Se ha capturado la excepción ExcepcionEspacioNoValido");
		} catch (Exception e) {
			System.out
					.println("******************** Se ha capturado una excepción inesperada.");
		}
	}
	
	
	
	private static void testComparador(){
		
		System.out.println("Utilizando compareTo");
		
		EspacioImpl espacio01 = new EspacioImpl(TipoEspacio.OTRO, "AS.43", 10, 0);
		EspacioImpl espacio02 = new EspacioImpl(TipoEspacio.OTRO, "AS.43", 10, 0);

		System.out.println(espacio01.compareTo(espacio02));
	}
	
	private static void testIgualdad(){
		
		System.out.println("Utilizando equals");
		
		EspacioImpl espacio01 = new EspacioImpl(TipoEspacio.OTRO, "AS.43", 10, 0);
		EspacioImpl espacio02 = new EspacioImpl(TipoEspacio.OTRO, "AS.23", 10, 0);

		System.out.println(espacio01.equals(espacio02));
		

	}
	
	public static void main(String[] args) {
		testConstructor1();
		testConstructor1ExcepcionCapacidad();
		testComparador();
		testIgualdad();
		

		Espacio esp01 = new EspacioImpl("A3.10,3,210,EXAMEN");
		System.out.println(esp01);
		Espacio esp02 = new EspacioImpl("A3.11,3,170,EXAMEN");
		System.out.println(esp02);
		Espacio esp03 = new EspacioImpl("A1.16,1,186,TEORIA");
		System.out.println(esp03);
		Espacio esp04 = new EspacioImpl("F1.30,1,49,LABORATORIO");
		System.out.println(esp04);
		Espacio esp05 = new EspacioImpl("A2.16,2,186,TEORIA");
		System.out.println(esp05);
		Espacio esp06 = new EspacioImpl("F1.32,1,49,LABORATORIO");
		System.out.println(esp06);
		Espacio esp07 = new EspacioImpl("F1.84,1,30,SEMINARIO");
		System.out.println(esp07);
		Espacio esp08 = new EspacioImpl("A0.11,0,138,TEORIA");
		System.out.println(esp08);
		Espacio esp09 = new EspacioImpl("A0.12,0,135,TEORIA");
		System.out.println(esp09);
		Espacio esp10 = new EspacioImpl("F1.31,1,49,LABORATORIO");
		System.out.println(esp10);
		Espacio esp11 = new EspacioImpl("F1.33,1,49,LABORATORIO");
		System.out.println(esp11);
		Espacio esp12 = new EspacioImpl("A4.30,4,53,LABORATORIO");
		System.out.println(esp12);
		Espacio esp13 = new EspacioImpl("A4.32,4,33,LABORATORIO");
		System.out.println(esp13);

	
	}

}
