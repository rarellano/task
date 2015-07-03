package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionBecaNoValida;
import fp.grados.tipos.BecaInmutable;
import fp.grados.tipos.BecaInmutableImpl;

import fp.grados.tipos.TipoBeca;

//Este código se les da como material adjunto al boletín T3
public class TestBecaInmutable {

	public static void main(String[] args) {

		
		//Ausencia de funciones modificadoras.

		BecaInmutable beca01 = new BecaInmutableImpl("ORD1234,6000.0,12,ORDINARIA");
		mostrarBeca(beca01);
		BecaInmutable beca02 = new BecaInmutableImpl("EMP7010,3000.0,6,EMPRESA");
		mostrarBeca(beca02);
		BecaInmutable beca03 = new BecaInmutableImpl("ORD1255,8500.0,12,ORDINARIA");
		mostrarBeca(beca03);
		BecaInmutable beca04 = new BecaInmutableImpl("MOV2020,5000.0,10,MOVILIDAD");
		mostrarBeca(beca04);
		BecaInmutable beca05 = new BecaInmutableImpl("EMP9000,1800.0,3,EMPRESA");
		mostrarBeca(beca05);
		BecaInmutable beca06 = new BecaInmutableImpl("EMP9001,6000.0,10,EMPRESA");
		mostrarBeca(beca06);
		BecaInmutable beca07 = new BecaInmutableImpl("ORD0505,12000.0,24,ORDINARIA");
		mostrarBeca(beca07);
		BecaInmutable beca08 = new BecaInmutableImpl("ORD6007,9000.0,24,ORDINARIA");
		mostrarBeca(beca08);
		BecaInmutable beca09 = new BecaInmutableImpl("MOV0024,7500.0,18,MOVILIDAD");
		mostrarBeca(beca09);
		
		
		
	}
	
	
	private static void mostrarBeca(BecaInmutable b) {
		System.out.println("Beca --> <" + b + ">");
		System.out.println("\tCódigo: <" + b.getCodigo() + ">");
		System.out.println("\tCuantía total: <" + b.getCuantiaTotal() + ">");
		System.out.println("\tDuración: <" + b.getDuracion() + ">");
		System.out.println("\tTipo: <" + b.getTipo() + ">");
		System.out.println("\tCuantía mensual: <" + b.getCuantiaMensual() + ">");
	}

}

