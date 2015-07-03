package fp.grados.tipos.test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.Grado;
import fp.grados.tipos.GradoImpl;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.TipoAsignatura;

public class TestGrado {

	public static void main(String[] args) {

		Set<Profesor> profesores = new HashSet<Profesor>();

		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		Departamento depart1 = new DepartamentoImpl("LSI");
		
		Departamento depart2 = new DepartamentoImpl("DTE");

		AsignaturaImpl asig01 = new AsignaturaImpl("Matematicas Discreta",
				"1000000", 12.0, TipoAsignatura.ANUAL, 1, depart1);

		AsignaturaImpl asig02 = new AsignaturaImpl("Calculo", "1000001", 12.0,
				TipoAsignatura.ANUAL, 1, depart2);

		AsignaturaImpl asig03 = new AsignaturaImpl("efrgfaeserf", "1000002",
				12.0, TipoAsignatura.ANUAL, 1, depart2);

		AsignaturaImpl asig04 = new AsignaturaImpl("sergrhtrth", "1000003",
				12.0, TipoAsignatura.ANUAL, 1, depart1);

		AsignaturaImpl asig05 = new AsignaturaImpl("wetrewrt Discreta",
				"1000004", 12.0, TipoAsignatura.ANUAL, 1, depart1);

		AsignaturaImpl asig06 = new AsignaturaImpl("iouluiuk", "1000005", 12.0,
				TipoAsignatura.ANUAL, 2, depart1);

		AsignaturaImpl asig07 = new AsignaturaImpl("213142 Discreta",
				"1000006", 12.0, TipoAsignatura.ANUAL, 2, depart2);

		AsignaturaImpl asig08 = new AsignaturaImpl("poiukmhj", "1000007", 12.0,
				TipoAsignatura.ANUAL, 2, depart2);

		AsignaturaImpl asig09 = new AsignaturaImpl("sgdxbf Discreta",
				"1000008", 12.0, TipoAsignatura.ANUAL, 2, depart1);

		AsignaturaImpl asig10 = new AsignaturaImpl("iouytf", "1000009", 12.0,
				TipoAsignatura.ANUAL, 2, depart1);

		AsignaturaImpl asig11 = new AsignaturaImpl("Matematicas waersrgdxf",
				"1000010", 12.0, TipoAsignatura.ANUAL, 3, depart1);

		AsignaturaImpl asig12 = new AsignaturaImpl("qwetrwety", "1000011",
				12.0, TipoAsignatura.ANUAL, 3, depart2);

		AsignaturaImpl asig13 = new AsignaturaImpl("sthgbfxgb dzfbdf",
				"1000012", 12.0, TipoAsignatura.ANUAL, 3, depart1);

		AsignaturaImpl asig14 = new AsignaturaImpl("zsdvzsdv", "1000013", 12.0,
				TipoAsignatura.ANUAL, 3, depart1);

		AsignaturaImpl asig15 = new AsignaturaImpl("cvnbcvbvcnb Discreta",
				"1000014", 12.0, TipoAsignatura.ANUAL, 3, depart1);

		AsignaturaImpl asig21 = new AsignaturaImpl("Trabajo de Fin de Grado",
				"1000020", 30.0, TipoAsignatura.ANUAL, 1, depart1);

		// OPTATIVAS

		AsignaturaImpl asig16 = new AsignaturaImpl("hlhjkfgh", "1000015", 6.0,
				TipoAsignatura.ANUAL, 4, depart1);

		AsignaturaImpl asig17 = new AsignaturaImpl("srdgfcnv", "1000016", 6.0,
				TipoAsignatura.ANUAL, 4, depart1);

		AsignaturaImpl asig18 = new AsignaturaImpl("gfjmgnfbc", "1000017", 6.0,
				TipoAsignatura.ANUAL, 4, depart1);

		AsignaturaImpl asig19 = new AsignaturaImpl("yterfdvc ", "1000018", 6.0,
				TipoAsignatura.ANUAL, 4, depart1);

		AsignaturaImpl asig20 = new AsignaturaImpl("yterfdvc ", "1000019", 6.0,
				TipoAsignatura.ANUAL, 4, depart1);

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
		asignaturas.add(asig01);
		asignaturas.add(asig02);

		Set<Asignatura> asignaturasObligatorias = new HashSet<Asignatura>();
		Set<Asignatura> asignaturasOptativas = new HashSet<Asignatura>();

		asignaturasObligatorias.add(asig01);
		asignaturasObligatorias.add(asig02);
		asignaturasObligatorias.add(asig03);
		asignaturasObligatorias.add(asig04);
		asignaturasObligatorias.add(asig05);
		asignaturasObligatorias.add(asig06);
		asignaturasObligatorias.add(asig07);
		asignaturasObligatorias.add(asig08);
		asignaturasObligatorias.add(asig09);
		asignaturasObligatorias.add(asig10);
		asignaturasObligatorias.add(asig11);
		asignaturasObligatorias.add(asig12);
		asignaturasObligatorias.add(asig13);
		asignaturasObligatorias.add(asig14);
		asignaturasObligatorias.add(asig15);
		asignaturasObligatorias.add(asig21);

		asignaturasOptativas.add(asig16);
		asignaturasOptativas.add(asig17);
		asignaturasOptativas.add(asig18);
		asignaturasOptativas.add(asig19);
		asignaturasOptativas.add(asig20);


		Grado grado01 = new GradoImpl(
				"Ingeniera Informatica - Tecnologias Informaticas",
				asignaturasObligatorias, asignaturasOptativas, 30.00);
		Grado grado02 = new GradoImpl(
				"Ingeniera Informatica - Tecnologias Informaticas",
				asignaturasObligatorias, asignaturasOptativas, 30.00);

		System.out.println(grado01);

		System.out.println(grado01.getAsignatura("1000000"));

		System.out.println(grado01.getAsignaturas(1));
		System.out.println(grado01.getAsignaturas(2));
		System.out.println(grado01.getAsignaturas(3));
		System.out.println(grado01.getAsignaturas(4));
		
		System.out.println(grado01.getAsignaturasObligatorias());
		
		System.out.println(grado01.getAsignaturasOptativas());
		
		System.out.println(grado01.getDepartamentos());
		
		System.out.println(grado01.getNumeroMinimoCreditosOptativas());
		
		System.out.println(grado01.getNumeroTotalCreditos());
		
		System.out.println(grado01.getProfesores());
		
		System.out.println(grado01.compareTo(grado02));
		
		System.out.println(grado01.equals(grado02));
		
		
		// Prueba entrega 3
		
		System.out.println(grado01.getCreditosPorAsignatura());

	}

}
