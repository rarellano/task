package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoEspacio;

public class TestCentro {

	public static void main(String[] args) {

		Set<Espacio> espacio = new HashSet<Espacio>();

		EspacioImpl espacio01 = new EspacioImpl(TipoEspacio.OTRO, "AS.03", 10,
				0);
		EspacioImpl espacio02 = new EspacioImpl(TipoEspacio.OTRO, "AS.13", 11,
				1);
		EspacioImpl espacio03 = new EspacioImpl(TipoEspacio.OTRO, "AS.23", 8, 2);
		EspacioImpl espacio04 = new EspacioImpl(TipoEspacio.OTRO, "AS.33", 7, 3);

		Despacho desp01 = new DespachoImpl("DA.01", 10, 2);
		Despacho desp02 = new DespachoImpl("DA.02", 10, 1);

		Centro centro01 = new CentroImpl("Alixar", "Calle Ana botieso", 5, 2);

		centro01.nuevoEspacio(espacio01);
		centro01.nuevoEspacio(espacio02);
		centro01.nuevoEspacio(espacio03);
		centro01.nuevoEspacio(espacio04);
		

		System.out.println(centro01);
		System.out.println(centro01.getConteosEspacios()[4]);
		Integer[] res = { 0, 0, 0, 0, 0 };

		System.out.println(res[0]);

		centro01.nuevoEspacio(desp01);
		centro01.nuevoEspacio(desp02);

		System.out.println(centro01.getDespachos());

		System.out.println(centro01.getEspacioMayorCapacidad());

		System.out.println(centro01.getConteosEspacios()[4]);
		centro01.eliminaEspacio(espacio04);
		System.out.println(centro01.getConteosEspacios()[4]);

		Set<Profesor> profesores = new HashSet<Profesor>();

		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		Departamento depart1 = new DepartamentoImpl("LSI");

		ProfesorImpl profesor01 = new ProfesorImpl("47343391F", "Alejandro",
				"Are", LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
				Categoria.AYUDANTE_DOCTOR, depart1);
		ProfesorImpl profesor02 = new ProfesorImpl("47343391F", "Rafael",
				"Are", LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
				Categoria.AYUDANTE_DOCTOR, depart1);
		ProfesorImpl profesor03 = new ProfesorImpl("47343391F", "Luis", "Are",
				LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
				Categoria.AYUDANTE_DOCTOR, depart1);

		profesores.add(profesor01);
		profesores.add(profesor02);
		profesores.add(profesor03);
		
		desp01.setProfesores(profesores);
		
		System.out.println(centro01.getDespachos());
		
		System.out.println(centro01.getDespachos(depart1));
		
		System.out.println(centro01.getEspacioMayorCapacidad());
		
		//Prueba Entrega 3
		
		System.out.println(centro01.getDespachosPorProfesor());

	}
}
