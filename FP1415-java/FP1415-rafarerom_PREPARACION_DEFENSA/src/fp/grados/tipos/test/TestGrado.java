package fp.grados.tipos.test;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import jdk.nashorn.internal.runtime.ListAdapter;

import com.google.common.base.Predicate;

import fp.grados.tipos.*;

public class TestGrado {

	public static void main(String[] args) {

		Set<Profesor> profesores = new HashSet<Profesor>();

		Set<Asignatura> asignaturas = new HashSet<Asignatura>();
		Departamento depart1 = new DepartamentoImpl("LSI");

		Departamento depart2 = new DepartamentoImpl("DTE");

		AsignaturaImpl asig01 = new AsignaturaImpl(
				"Introduccion Matematicas Discreta", "1000000", 12.0,
				TipoAsignatura.ANUAL, 1, depart1);

		AsignaturaImpl asig02 = new AsignaturaImpl("Calculo", "1000001", 12.0,
				TipoAsignatura.PRIMER_CUATRIMESTRE, 1, depart2);

		AsignaturaImpl asig03 = new AsignaturaImpl("Algebra", "1000002", 10.0,
				TipoAsignatura.ANUAL, 1, depart2);

		AsignaturaImpl asig04 = new AsignaturaImpl("Circuitos", "1000003",
				10.0, TipoAsignatura.SEGUNDO_CUATRIMESTRE, 1, depart1);

		AsignaturaImpl asig05 = new AsignaturaImpl("Estructura", "1000004",
				12.0, TipoAsignatura.ANUAL, 1, depart1);

		AsignaturaImpl asig06 = new AsignaturaImpl("Sistemas Operativos",
				"1000005", 12.0, TipoAsignatura.PRIMER_CUATRIMESTRE, 2, depart1);

		AsignaturaImpl asig07 = new AsignaturaImpl(
				"Analisis y Diseño de Algoritmos", "1000006", 10.0,
				TipoAsignatura.ANUAL, 2, depart2);

		AsignaturaImpl asig08 = new AsignaturaImpl("Redes de Computadores",
				"1000007", 10.0, TipoAsignatura.ANUAL, 2, depart2);

		AsignaturaImpl asig09 = new AsignaturaImpl("Lógica Informática",
				"1000008", 10.0, TipoAsignatura.ANUAL, 2, depart1);

		AsignaturaImpl asig11 = new AsignaturaImpl("Inteligencia Artificial",
				"1000010", 10.0, TipoAsignatura.ANUAL, 3, depart1);

		AsignaturaImpl asig12 = new AsignaturaImpl("Seguridad Informatica",
				"1000011", 10.0, TipoAsignatura.ANUAL, 3, depart2);

		AsignaturaImpl asig13 = new AsignaturaImpl("Criptografia", "1000012",
				12.0, TipoAsignatura.ANUAL, 3, depart1);

		AsignaturaImpl asig14 = new AsignaturaImpl("zsdvzsdv", "1000013", 12.0,
				TipoAsignatura.ANUAL, 3, depart1);

		AsignaturaImpl asig15 = new AsignaturaImpl("cvnbcvbvcnb Discreta",
				"1000014", 12.0, TipoAsignatura.ANUAL, 3, depart1);

		AsignaturaImpl asig21 = new AsignaturaImpl("Trabajo de Fin de Grado",
				"1000020", 30.0, TipoAsignatura.ANUAL, 4, depart1);

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
				Categoria.CATEDRATICO, depart1);
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
		// asignaturasObligatorias.add(asig10);
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

		System.out
				.println("<-----------------    PROBANDO JAVA 8    ------------------->");
		System.out.println(grado01.getAsignaturasObligatorias());
		List<Asignatura> listaAsig = new ArrayList<Asignatura>(
				grado01.getAsignaturasObligatorias());
		System.out.println("ORDENADAS POR CURSO JAVA8");
		Collections.sort(listaAsig, Comparator.comparing(Asignatura::getCurso));
		System.out.println(listaAsig);
		System.out.println("ORDENADAS POR CODIGO JAVA8");
		Collections.sort(listaAsig, Comparator.comparing(x -> x.getCodigo()));
		System.out.println(listaAsig);
		System.out.println("ORDENADAS POR TIPO JAVA8");
		Collections.sort(listaAsig, (x, y) -> x.getTipo()
				.compareTo(y.getTipo()));
		System.out.println(listaAsig);

		Comparator<Asignatura> cmp1 = Comparator
				.comparing(Asignatura::getCodigo);
		Comparator<Asignatura> cmp2 = Comparator
				.comparing(Asignatura::getCreditos);

		Collections.sort(listaAsig, cmp1.thenComparing(cmp2));

		System.out.println(listaAsig);

		Long numAsig2Cuatrimestre = listaAsig.stream()
				.filter(x -> x.getTipo().equals(TipoAsignatura.ANUAL)).count();

		System.out.println("Asignaturas del segundo cuatrimestre: "
				+ numAsig2Cuatrimestre);

		Collections.sort(listaAsig, Comparator.comparing(x -> x.getCreditos()));

		listaAsig.stream()
				.sorted(Comparator.comparing(Asignatura::getCreditos));

		System.out.println(getAsigMaxCredTipo(grado01, TipoAsignatura.ANUAL));

		Map<Integer, Double> mapaG1 = new TreeMap<>(getNumCredPorCurso(grado01));

		System.out.println(mapaG1);

		profesor01.nuevaTutoria(LocalTime.of(14, 50), 20, DayOfWeek.MONDAY);
		profesor01.nuevaTutoria(LocalTime.of(13, 50), 20, DayOfWeek.THURSDAY);
		profesor01.nuevaTutoria(LocalTime.of(12, 50), 20, DayOfWeek.FRIDAY);
		profesor01.nuevaTutoria(LocalTime.of(11, 50), 20, DayOfWeek.WEDNESDAY);
		profesor01.nuevaTutoria(LocalTime.of(10, 50), 20, DayOfWeek.MONDAY);
		profesor01.nuevaTutoria(LocalTime.of(19, 50), 20, DayOfWeek.MONDAY);
		profesor01.nuevaTutoria(LocalTime.of(18, 50), 20, DayOfWeek.MONDAY);

		profesor02.nuevaTutoria(LocalTime.of(14, 30), 20, DayOfWeek.MONDAY);
		profesor02.nuevaTutoria(LocalTime.of(13, 30), 20, DayOfWeek.THURSDAY);

		profesor02.nuevaTutoria(LocalTime.of(10, 30), 20, DayOfWeek.MONDAY);
		profesor02.nuevaTutoria(LocalTime.of(19, 30), 20, DayOfWeek.MONDAY);
		profesor02.nuevaTutoria(LocalTime.of(18, 30), 20, DayOfWeek.MONDAY);

		profesor03.nuevaTutoria(LocalTime.of(14, 50), 30, DayOfWeek.MONDAY);
		profesor03.nuevaTutoria(LocalTime.of(13, 50), 30, DayOfWeek.THURSDAY);
		profesor03.nuevaTutoria(LocalTime.of(12, 50), 30, DayOfWeek.FRIDAY);

		System.out.println(getNumTutoriasPorProfesor(profesores));
		System.out.println(getTutoriasPorProfesor(profesores));
		System.out.println(getTutoriasPorProfesor2(profesores));
		System.out.println(agruparProfPorCategoria(profesores));

		System.out.println(ordenaAsignaturaPorTipo(listaAsig));

		System.out.println(asignaturasPorCredAsig(listaAsig, asig01));

	}

	private static Asignatura getAsigMaxCredTipo(Grado g, TipoAsignatura t) {
		Set<Asignatura> asigTotal = new TreeSet<>(
				g.getAsignaturasObligatorias());
		asigTotal.addAll(g.getAsignaturasOptativas());

		return asigTotal.stream().filter(x -> x.getTipo().equals(t))
				.max(Comparator.comparing(x -> x.getCreditos())).get();
	}

	private static Map<Integer, Double> getNumCredPorCurso(Grado g) {
		Map<Integer, Double> mapa = new TreeMap<Integer, Double>();

		for (int i = 1; i <= 4; i++)
			mapa.put(
					i,
					g.getAsignaturas(i).stream()
							.mapToDouble(x -> x.getCreditos()).sum());
		return mapa;

	}

	private static Map<Profesor, Integer> getNumTutoriasPorProfesor(
			Set<Profesor> p) {
		Map<Profesor, Integer> mapa = new TreeMap<Profesor, Integer>();
		for (Profesor prof : p) {
			mapa.put(prof, (int) prof.getTutorias().stream().count());

		}
		return mapa;
	}

	private static Map<Profesor, Set<Tutoria>> getTutoriasPorProfesor(
			Set<Profesor> p) {
		return p.stream().collect(
				Collectors.toMap(x -> x, Profesor::getTutorias));
	}

	private static Map<String, Set<Tutoria>> getTutoriasPorProfesor2(
			Set<Profesor> p) {
		return p.stream().collect(
				Collectors.toMap(Profesor::getNombre, Profesor::getTutorias));
	}

	private static Map<Categoria, List<Profesor>> agruparProfPorCategoria(
			Set<Profesor> p) {
		System.out
				.println("PROFESOR POR CATEGORIAAAA ------------------------------------");
		// return p.stream()
		// .collect(Collectors.groupingBy(Profesor::getCategoria));
		return p.stream()
				.collect(Collectors.groupingBy(Profesor::getCategoria));
	}

	private static List<Asignatura> ordenaAsignaturaPorTipo(List<Asignatura> l) {
		List<Asignatura> nuevaLista = new ArrayList<Asignatura>(l);
		Collections.sort(nuevaLista, Comparator.comparing(Asignatura::getTipo));
		return nuevaLista;
	}

	private static List<Asignatura> asignaturasPorCredAsig(List<Asignatura> l,
			Asignatura a) {
		List<Asignatura> nuevaLista = new ArrayList<Asignatura>(l);

		return nuevaLista.stream()
				.filter(x -> x.getCreditos() >= a.getCreditos())
				.collect(Collectors.toList());
	}

	public static List<Asignatura> ordenadasPorCreditos(List<Asignatura> lasig) {
		Comparator<Asignatura> cmp = Comparator
				.comparing(Asignatura::getCreditos);
		List<Asignatura> res = new ArrayList<Asignatura>(lasig);
		return res.stream().sorted(cmp).collect(Collectors.toList());
	}

	public static List<String> getAsignaturasMayorCreditos(List<Asignatura> l,
			Double d) {

		return l.stream().filter(x -> x.getCreditos() >= d)
				.map(x -> x.getNombre())
				.collect(Collectors.toCollection(ArrayList::new));
	}

	public static Double consultaAsignaturasCreditoMedio(List<Asignatura> l) {
		Double res = l.stream().mapToDouble(x -> x.getCreditos()).sum();
		return res / l.stream().count();
	}

	public static Boolean sonTodasAsignaturasTipo(TipoAsignatura t,
			List<Asignatura> l) {
		Boolean res = l.stream().allMatch(
				x -> x.getTipo() == TipoAsignatura.ANUAL);
		res = l.stream().allMatch(x -> x.getCreditos() >= 6.00);

		return res;
	}

	public static void gradosPollaEnVinagre(List<Grado> g, TipoAsignatura t) {
		List<Asignatura> res = new ArrayList<>();
		g.stream().forEach(x -> res.addAll(x.getAsignaturasObligatorias()));
		g.stream().forEach(x -> res.addAll(x.getAsignaturasOptativas()));

		res.stream().filter(x -> x.getTipo() == t);

		Departamento res1 = null;
		res.stream().forEach(x -> x.setDepartamento(res1));

	}
}
