package fp.grados.tipos.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import fp.grados.tipos.Asignatura;

public class TestMapas {

	public static void main(String[] args) {
		SortedMap<Integer, String> mapa = new TreeMap<Integer, String>();
		
		ArrayList<String> cabesa = new ArrayList<>();
		
//		cabesa.add("01");
//		cabesa.add("02");
//		cabesa.add("03");
//		cabesa.add("04");
//		
//		for(int s: cabesa){
//			mapa.put(cabesa.get(s),s);
//		}

		mapa.put(1,"Alvaro");
		mapa.put(2,"Alvaro");	
		mapa.put(3,"Alvaro");

		mapa.put(4,"Rafa");	
		mapa.put(5,"Rafa");
		mapa.put(6,"Rafa");
	


		
		System.out.println(mapa.values());

	}

}
