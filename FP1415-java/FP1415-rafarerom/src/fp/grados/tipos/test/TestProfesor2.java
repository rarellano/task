package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import fp.grados.excepciones.ExcepcionEspacioNoValido;
import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Persona;
import fp.grados.tipos.PersonaImpl;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.ProfesorImpl2;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.TipoEspacio;
import fp.grados.tipos.TutoriaImpl;

public class TestProfesor2 {

	
	
	


		
	public static void main(String[] args) {


		

		


		
		Departamento depart1 = new DepartamentoImpl("LSI");
		Departamento depart2 = new DepartamentoImpl("DTE");

		
		ProfesorImpl2 profesor01 = new ProfesorImpl2("47343391F", "Alejandro",
				"Are",LocalDate.of(1991, 8, 28), "rafa.are.ro@us.es",  Categoria.AYUDANTE_DOCTOR, depart1);

		
//		Asignatura asig;
//		depart.nuevaAsignatura(asig);
		
		depart1.nuevoProfesor(profesor01);

		
//		System.out.println(depart1.getProfesores());
		
		Asignatura asig01 = new AsignaturaImpl("Fundamentos de Programacion","2050001",12.0, TipoAsignatura.ANUAL, 1, depart1);
		Asignatura asig02 = new AsignaturaImpl("Analisis y diseño de Algoritmos","2050002",12.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 2, depart1);
		
		depart1.nuevaAsignatura(asig01);
		depart1.nuevaAsignatura(asig02);

		
//		System.out.println(depart1.getAsignaturas());
		
		
		profesor01.imparteAsignatura(asig01, 12.00);
		profesor01.imparteAsignatura(asig02,12.00);	
	
		System.out.println(profesor01.getAsignaturas());
		
		profesor01.imparteAsignatura(asig01, 11.00);
		profesor01.imparteAsignatura(asig02,10.00);	
		
		System.out.println(profesor01.getAsignaturas());
		
		System.out.println(profesor01.getCreditos());
//		profesor01.eliminaAsignatura(asig01);
		
		System.out.println(profesor01.dedicacionAsignatura(asig01));
		


	

	}

}
