package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
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
import fp.grados.tipos.TutoriaImpl;

public class TestDepartamento {

	public static void main(String[] args) {
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
				Categoria.CATEDRATICO, depart1);

		profesores.add(profesor01);
		profesores.add(profesor02);
		profesores.add(profesor03);
		asignaturas.add(asig1);
		asignaturas.add(asig2);

		Expediente expe01 = new ExpedienteImpl();

		NotaImpl nota1 = new NotaImpl(asig2, 2013, Convocatoria.PRIMERA, 2.00,
				false);
		NotaImpl nota2 = new NotaImpl(asig1, 2013, Convocatoria.SEGUNDA, 4.00,
				false);
		NotaImpl nota3 = new NotaImpl(asig1, 2013, Convocatoria.PRIMERA, 4.00,
				false);
		
		profesor01.imparteAsignatura(asig1, 2.00);
		profesor01.imparteAsignatura(asig2, 2.00);
		profesor03.imparteAsignatura(asig1, 3.00);
		
		System.out.println(depart1);
		System.out.println(depart1.getAsignaturas());
		System.out.println(depart1.getProfesores());
		System.out.println(depart1.estanTodasAsignaturasAsignadas());
		System.out.println(depart1.existeProfesorAsignado(asig2));
		
		profesor01.nuevaTutoria(LocalTime.of(14, 50), 100, DayOfWeek.FRIDAY);
		profesor01.nuevaTutoria(LocalTime.of(14, 50), 100, DayOfWeek.MONDAY);
		profesor01.nuevaTutoria(LocalTime.of(14, 50), 100, DayOfWeek.THURSDAY);
		profesor01.nuevaTutoria(LocalTime.of(14, 50), 100, DayOfWeek.WEDNESDAY);
		profesor01.nuevaTutoria(LocalTime.of(14, 50), 100, DayOfWeek.TUESDAY);
		
		profesor03.nuevaTutoria(LocalTime.of(14, 50), 100, DayOfWeek.WEDNESDAY);
		profesor03.nuevaTutoria(LocalTime.of(14, 50), 100, DayOfWeek.TUESDAY);
		
		System.out.println(profesor01.getTutorias());
		
		System.out.println(profesor03.getTutorias());

//		depart1.borraTutorias(Categoria.AYUDANTE_DOCTOR);
		
		System.out.println(profesor01.getTutorias());
		
		System.out.println(profesor03.getTutorias());
		
		System.out.println(profesor01.getAsignaturas());
		
		System.out.println(profesor03.getAsignaturas());
		
//		depart1.eliminaAsignacionProfesorado(asig1);

		System.out.println(profesor01.getAsignaturas());
		
		System.out.println(profesor03.getAsignaturas());
		
		// Pruebas entrega 3
		
		System.out.println(depart1.getTutoriasPorProfesor());
		
		System.out.println(depart1.getProfesoresPorAsignatura());
	
		
	}

}
