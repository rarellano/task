package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

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

public class TestExpediente {

	public static void main(String[] args) {

		// Set<Profesor> profesores = new HashSet<Profesor>();
		//
		// Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		//
		// Departamento depart1 = new DepartamentoImpl("LSI", profesores,
		// asignaturas);
		//
		// AsignaturaImpl asig1 = new AsignaturaImpl("Matematicas Discreta",
		// "1643512", 12.0, TipoAsignatura.ANUAL, 1, depart1);
		//
		// AsignaturaImpl asig2 = new AsignaturaImpl("Calculo",
		// "1642222", 12.0, TipoAsignatura.ANUAL, 1, depart1);
		//
		// NotaImpl nota1 = new NotaImpl(asig2, 1, Convocatoria.PRIMERA, 6.00,
		// false);
		// NotaImpl nota2 = new NotaImpl(asig1, 1, Convocatoria.SEGUNDA, 9.00,
		// true);
		//
		// Expediente expe01 = new ExpedienteImpl();
		// expe01.nuevaNota(nota2);
		// expe01.nuevaNota(nota1);
		//
		// ProfesorImpl profesor01 = new ProfesorImpl("47343391F", "Alejandro",
		// "Are",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
		// Categoria.AYUDANTE_DOCTOR, depart1);
		// ProfesorImpl profesor02 = new ProfesorImpl("47343391F", "Rafael",
		// "Are",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
		// Categoria.AYUDANTE_DOCTOR, depart1);
		// ProfesorImpl profesor03 = new ProfesorImpl("47343391F", "Luis",
		// "Are",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
		// Categoria.AYUDANTE_DOCTOR, depart1);
		//
		// depart1.nuevoProfesor(profesor01);
		// depart1.nuevoProfesor(profesor02);
		// depart1.nuevoProfesor(profesor03);
		//
		// asignaturas.add(asig1);
		// asignaturas.add(asig2);
		//
		// System.out.println(expe01.toString());
		// System.out.println("PRUEBA ----------------------------");
		// System.out.println(profesores);
		// System.out.println(asignaturas);
		// System.out.println(depart1);
		// System.out.println(asig1);
		// System.out.println(asig2);
		// System.out.println(nota1);
		// System.out.println(nota2);
		// System.out.println(expe01);

		Set<Profesor> profesores = new HashSet<Profesor>();

		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		Departamento depart1 = new DepartamentoImpl("LSI");

		AsignaturaImpl asig1 = new AsignaturaImpl("Matematicas Discreta","1643512", 12.0, TipoAsignatura.ANUAL, 1, depart1);

		AsignaturaImpl asig2 = new AsignaturaImpl("Calculo", "1642222", 12.0,TipoAsignatura.ANUAL, 1, depart1);

		ProfesorImpl profesor01 = new ProfesorImpl("47343391F", "Alejandro","Are", LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
				Categoria.AYUDANTE_DOCTOR, depart1);
		ProfesorImpl profesor02 = new ProfesorImpl("47343391F", "Rafael","Are", LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
				Categoria.AYUDANTE_DOCTOR, depart1);
		ProfesorImpl profesor03 = new ProfesorImpl("47343391F", "Luis", "Are",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",
				Categoria.AYUDANTE_DOCTOR, depart1);

		profesores.add(profesor01);
		profesores.add(profesor02);
		profesores.add(profesor03);
		asignaturas.add(asig1);
		asignaturas.add(asig2);

		Expediente expe01 = new ExpedienteImpl();
		Expediente expe02 = expe01;
		Expediente expe03 = new ExpedienteImpl();


		NotaImpl nota1 = new NotaImpl(asig2, 2013, Convocatoria.PRIMERA, 2.00,
				false);
		NotaImpl nota2 = new NotaImpl(asig1, 2013, Convocatoria.SEGUNDA, 4.00,
				false);
		NotaImpl nota3 = new NotaImpl(asig1, 2013, Convocatoria.PRIMERA, 4.00,
				false);
		System.out.println(nota1);
		System.out.println(nota2);

		System.out.println(nota3);

		expe01.nuevaNota(nota2);
		expe01.nuevaNota(nota1);
		expe01.nuevaNota(nota3);
		System.out.println(expe01.getNotaMedia());

		System.out.println(expe01);
		System.out.println(expe01.equals(expe02));	
		System.out.println(expe02.equals(expe03));
		

		
	}

}
