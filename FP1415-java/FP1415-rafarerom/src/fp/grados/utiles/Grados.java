package fp.grados.utiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

import fp.grados.tipos.Alumno;
import fp.grados.tipos.AlumnoImpl;
import fp.grados.tipos.AlumnoImpl2;
import fp.grados.tipos.Asignatura;
import fp.grados.tipos.AsignaturaImpl;
import fp.grados.tipos.Beca;
import fp.grados.tipos.BecaImpl;
import fp.grados.tipos.Categoria;
import fp.grados.tipos.Centro;
import fp.grados.tipos.CentroImpl;
import fp.grados.tipos.CentroImpl2;
import fp.grados.tipos.Departamento;
import fp.grados.tipos.DepartamentoImpl;
import fp.grados.tipos.DepartamentoImpl2;
import fp.grados.tipos.Despacho;
import fp.grados.tipos.DespachoImpl;
import fp.grados.tipos.Espacio;
import fp.grados.tipos.EspacioImpl;
import fp.grados.tipos.Grado;
import fp.grados.tipos.GradoImpl;
import fp.grados.tipos.GradoImpl2;
import fp.grados.tipos.Nota;
import fp.grados.tipos.Profesor;
import fp.grados.tipos.ProfesorImpl;
import fp.grados.tipos.ProfesorImpl2;
import fp.grados.tipos.TipoAsignatura;
import fp.grados.tipos.TipoBeca;
import fp.grados.tipos.TipoEspacio;
import fp.grados.tipos.Tutoria;

public class Grados {

	public static <T> List<T> leeFichero(String nombreFichero,
			Function<String, T> funcion_deString_aT) {
		List<T> res = null;
		try {
			res = Files.lines(Paths.get(nombreFichero))
					.map(funcion_deString_aT).collect(Collectors.toList());
		} catch (IOException e) {
			System.out
					.println("Error en lectura del fichero: " + nombreFichero);
		}

		return res;
	}

	private static Set<Alumno> alumnos = new HashSet<Alumno>();
	private static Boolean usarJava8 = true;
	private static Integer[] numBecasPorTipo = { 0, 0, 0 };

	public static Integer getNumAlumnosCreados() {
		return getAlumnosCreados().size();
	}

	public static Set<Alumno> getAlumnosCreados() {
		return new HashSet<Alumno>(alumnos);
	}

	public static void setUsarJava8(Boolean b) {
		usarJava8 = b;
	}

	public static Alumno createAlumno(String dni, String nombre,
			String apellidos, LocalDate fechaNacimiento, String email) {
		Alumno res = null;
		if (usarJava8)
			res = new AlumnoImpl2(dni, nombre, apellidos, fechaNacimiento,
					email);
		else
			res = new AlumnoImpl(dni, nombre, apellidos, fechaNacimiento, email);

		// numAlumnos++;
		alumnos.add(res);
		return res;
	}

	public static Alumno createAlumno(Alumno a) {

		Alumno res = createAlumno(a.getDNI(), a.getNombre(), a.getApellidos(),
				a.getFechaNacimiento(), a.getEmail());

		for (Asignatura asig : a.getAsignaturas()) {
			res.matriculaAsignatura(asig);
		}
		for (Nota n : a.getExpediente().getNotas()) {
			res.evaluaAlumno(n.getAsignatura(), n.getCursoAcademico(),
					n.getConvocatoria(), n.getValor(), n.getMencionHonor());
		}

		// numAlumnos++;
		// alumnos.add(res);
		return res;
	}

	public static Alumno createAlumno(String s) {
		// Alumno res = null;
		// if (usarJava8)
		// res = new AlumnoImpl2(s);
		// else
		// res = new AlumnoImpl(s);
		// numAlumnos++;
		// alumnos.add(res);
		//
		Alumno res = new AlumnoImpl(s);
		alumnos.add(res);

		return res;
	}

	public static List<Alumno> createAlumnos(String file) {

		return leeFichero(file, a -> new AlumnoImpl(a));
	}

	// private static Integer numAsignaturas = 0;
	// private static Set<Asignatura> asignaturas = new HashSet<Asignatura>();
	private static Map<String, Asignatura> codigoAsignaturas = new HashMap<String, Asignatura>();

	public static Integer getNumAsignaturasCreadas() {
		return getAsignaturasCreadas().size();
	}

	public static Set<Asignatura> getAsignaturasCreadas() {
		return new HashSet<Asignatura>(codigoAsignaturas.values());
	}

	public static Set<String> getCodigosAsignaturasCreadas() {
		Set<String> res = new HashSet<>(codigoAsignaturas.keySet());
		return res;
	}

	public static Asignatura getAsignaturaCreada(String codigo) {
		return codigoAsignaturas.get(codigo);

	}

	public static Asignatura createAsignatura(String nombre, String codigo,
			Double creditos, TipoAsignatura tipo, Integer curso,
			Departamento departamento) {
		Asignatura res = new AsignaturaImpl(nombre, codigo, creditos, tipo,
				curso, departamento);
		// numAsignaturas++;
		codigoAsignaturas.put(codigo, res);
		return res;
	}

	public static Asignatura createAsignatura(String s) {
		Asignatura res = new AsignaturaImpl(s);
		// numAsignaturas++;
		codigoAsignaturas.put(res.getCodigo(), res);
		return res;
	}

	public static List<Asignatura> createAsignaturas(String file) {
		return leeFichero(file, a -> new AsignaturaImpl(a));
		// return leeFichero(file, a -> createAsignatura(a));
	}

	private static Set<Beca> becas = new HashSet<Beca>();

	public static Integer getNumBecasCreadas() {
		return getBecasCreadas().size();
	}

	public static Set<Beca> getBecasCreadas() {
		return new HashSet<Beca>(becas);
	}

	private static void actualizaNumBecasPorTipo(Beca beca) {
		switch (beca.getTipo()) {
		case ORDINARIA:
			numBecasPorTipo[0]++;
			break;
		case MOVILIDAD:
			numBecasPorTipo[1]++;
			break;
		case EMPRESA:
			numBecasPorTipo[2]++;
			break;
		}
	}

	public static Integer getNumBecasTipo(TipoBeca tipo) {
		Integer res = 0;
		switch (tipo) {
		case ORDINARIA:
			res = numBecasPorTipo[0];
			break;
		case MOVILIDAD:
			res = numBecasPorTipo[1];
			break;
		case EMPRESA:
			res = numBecasPorTipo[2];
			break;
		}
		return res;
	}

	public static Beca createBeca(String codigo, Double cuantiaTotal,
			Integer duracion, TipoBeca tipo) {
		Beca res = new BecaImpl(codigo, cuantiaTotal, duracion, tipo);
		becas.add(res);
		actualizaNumBecasPorTipo(res);
		return res;
	}

	public static Beca createBeca(String codigo, TipoBeca tipo) {
		Beca res = new BecaImpl(codigo, tipo);
		becas.add(res);
		actualizaNumBecasPorTipo(res);
		return res;
	}

	public static Beca createBeca(Beca b) {

		Beca res = createBeca(b.getCodigo(), b.getCuantiaTotal(),
				b.getDuracion(), b.getTipo());

		return res;
	}

	public static Beca createBeca(String s) {
		Beca res = new BecaImpl(s);
		becas.add(res);
		actualizaNumBecasPorTipo(res);
		return res;
	}

	public static List<Beca> createBecas(String file) {
		List<Beca> res = leeFichero(file, b -> createBeca(b));
		return res;
	}

	// private static Integer numCentros = 0;
	private static Set<Centro> centros = new TreeSet<Centro>();
	private static Integer maxPlantas = 0;
	private static Integer maxSotanos = 0;
	private static Integer sumaPlantas = 0;
	private static Integer sumaSotanos = 0;

	public static Centro createCentro(String nombre, String direccion,
			Integer numeroPlantas, Integer numeroSotanos) {
		Centro res = null;
		if (usarJava8) {
			res = new CentroImpl2(nombre, direccion, numeroPlantas,
					numeroSotanos);
			centros.add(res);
		} else {
			res = new CentroImpl(nombre, direccion, numeroPlantas,
					numeroSotanos);
			centros.add(res);
		}
		actulizarCentros(res);
		return res;
	}

	public static Centro createCentro(Centro c) {
		Centro res = createCentro(c.getNombre(), c.getDireccion(),
				c.getNumeroPlantas(), c.getNumeroSotanos());
		for (Espacio e : c.getEspacios())
			res.nuevoEspacio(e);
		return res;
	}

	public static Integer getNumCentrosCreados() {
		return getCentrosCreados().size();
	}

	public static Set<Centro> getCentrosCreados() {
		return new HashSet<Centro>(centros);
	}

	public static void actulizarCentros(Centro c) {
		if (c.getNumeroPlantas() > maxPlantas)
			maxPlantas = c.getNumeroPlantas();

		if (c.getNumeroSotanos() > maxSotanos)
			maxSotanos = c.getNumeroSotanos();

		sumaPlantas = sumaPlantas + c.getNumeroPlantas();
		sumaSotanos = sumaSotanos + c.getNumeroSotanos();
	}

	public static Integer getMaxPlantas() {
		Integer res = null;

		if (!centros.isEmpty())
			res = maxPlantas;
		return res;
	}

	public static Integer getMaxSotanos() {
		Integer res = null;
		if (!centros.isEmpty())
			res = maxSotanos;

		return res;
	}

	public static Double getMediaPlantas() {
		Double res = null;

		if (!centros.isEmpty())
			res = getCentrosCreados().stream()
					.mapToDouble(Centro::getNumeroPlantas).average()
					.getAsDouble();

		return res;
	}

	public static Double getMediaSotanos() {
		Double res = null;

		if (!centros.isEmpty())
			res = getCentrosCreados().stream()
					.mapToDouble(Centro::getNumeroSotanos).average()
					.getAsDouble();

		return res;
	}

	// private static Integer numDepartamentos = 0;
	private static Set<Departamento> departamentos = new HashSet<Departamento>();

	public static Integer getNumDepartamentosCreados() {
		return getDepartamentosCreados().size();
	}

	public static Set<Departamento> getDepartamentosCreados() {
		return new HashSet<Departamento>(departamentos);
	}

	public static Departamento createDepartamento(String nombre) {
		Departamento res = null;
		if (usarJava8) {
			res = new DepartamentoImpl2(nombre);
		} else
			res = new DepartamentoImpl(nombre);
		departamentos.add(res);
		return res;
	}

	private static Set<Despacho> despachos = new TreeSet<Despacho>();

	public static Despacho createDespacho(String nombre, Integer capacidad,
			Integer planta) {
		Despacho res = new DespachoImpl(nombre, capacidad, planta);
		despachos.add(res);
		return res;
	}

	public static Despacho createDespacho(Despacho d) {
		Despacho res = new DespachoImpl(d.getNombre(), d.getCapacidad(),
				d.getPlanta());

		return res;
	}

	public static Despacho createDespacho(String s) {
		Despacho res = new DespachoImpl(s);
		despachos.add(res);
		return res;
	}

	public static List<Despacho> createDespachos(String file) {
		List<Despacho> res = leeFichero(file, d -> new DespachoImpl(d));
		return res;
	}

	// private static Integer numEspacios = 0;
	private static Set<Espacio> espacios = new HashSet<Espacio>();

	public static Integer getNumEspaciosCreados() {
		return getEspaciosCreados().size();
	}

	public static SortedSet<Espacio> getEspaciosCreados() {
		return new TreeSet<Espacio>(espacios);
	}

	public static Integer getPlantaMayorEspacio() {
		Integer res = null;

		if (!getEspaciosCreados().isEmpty())
			res = getEspaciosCreados().stream()
					.max(Comparator.comparing(Espacio::getPlanta)).get()
					.getPlanta();
		return res;
	}

	public static Integer getPlantaMenorEspacio() {
		Integer res = null;

		if (!getEspaciosCreados().isEmpty())
			res = getEspaciosCreados().stream()
					.min(Comparator.comparing(Espacio::getPlanta)).get()
					.getPlanta();
		return res;
	}

	public static Espacio createEspacio(TipoEspacio tipo, String nombre,
			Integer capacidad, Integer planta) {
		Espacio res = new EspacioImpl(tipo, nombre, capacidad, planta);
		espacios.add(res);
		return res;
	}

	public static Espacio createEspacio(Espacio e) {
		Espacio res = createEspacio(e.getTipo(), e.getNombre(),
				e.getCapacidad(), e.getPlanta());
		return res;
	}

	public static Espacio createEspacio(String s) {
		Espacio res = new EspacioImpl(s);
		espacios.add(res);
		return res;
	}

	public static List<Espacio> createEspacios(String file) {
		List<Espacio> res = leeFichero(file, e -> new EspacioImpl(e));
		return res;
	}

	// // private static Integer numGrados = 0;
	// private static Integer numAsignaturasObligatorias = 0;
	// private static Integer numAsignaturasOptativas = 0;
	// private static Integer numAsignaturasTotal = 0;
	// private static Set<Grado> grados = new HashSet<Grado>();
	//
	// public static Integer getNumGradosCreados() {
	// return getGradosCreados().size();
	// }
	//
	// public static Set<Grado> getGradosCreados() {
	// return new HashSet<Grado>(grados);
	// }
	//
	// public static Double getMediaAsignaturasGrados() {
	// Double res = null;
	// if (!grados.isEmpty())
	// res = (double) (numAsignaturasTotal / getNumGradosCreados());
	// return res;
	// }
	//
	// public static Double getMediaAsignaturasObligatoriasGrados() {
	// Double res = null;
	// if (!grados.isEmpty())
	// res = (double) (numAsignaturasObligatorias / getNumGradosCreados());
	// return res;
	// }
	//
	// public static Double getMediaAsignaturasOptativasGrados() {
	// Double res = null;
	// if (!grados.isEmpty())
	// res = (double) (numAsignaturasOptativas / getNumGradosCreados());
	// return res;
	// }
	//
	// public static Grado createGrado(String nombre,
	// Set<Asignatura> asignaturasObligatorias,
	// Set<Asignatura> asignaturasOptativas,
	// Double numeroMinimoCreditosOptativas) {
	// Grado res;
	// if (usarJava8) {
	// res = new GradoImpl2(nombre, asignaturasObligatorias,
	// asignaturasOptativas, numeroMinimoCreditosOptativas);
	// } else {
	// res = new GradoImpl(nombre, asignaturasObligatorias,
	// asignaturasOptativas, numeroMinimoCreditosOptativas);
	// }
	//
	// numAsignaturasObligatorias = numAsignaturasObligatorias
	// + res.getAsignaturasObligatorias().size();
	// numAsignaturasOptativas = numAsignaturasOptativas
	// + res.getAsignaturasOptativas().size();
	// numAsignaturasTotal = numAsignaturasTotal
	// + res.getAsignaturasObligatorias().size()
	// + res.getAsignaturasOptativas().size();
	//
	// return res;
	// }
	private static Set<Grado> grados = new HashSet<Grado>();

	public static Grado createGrado(String nombre,
			Set<Asignatura> asignaturasObligatorias,
			Set<Asignatura> asignaturasOptativas,
			Double numeroMinimoCreditosOptativas) {
		Grado res;
		if (usarJava8) {
			res = new GradoImpl2(nombre, asignaturasObligatorias,
					asignaturasOptativas, numeroMinimoCreditosOptativas);
		} else {
			res = new GradoImpl(nombre, asignaturasObligatorias,
					asignaturasOptativas, numeroMinimoCreditosOptativas);
		}

		grados.add(res);
		return res;
	}

	 public static Integer getNumGradosCreados() {
	 return getGradosCreados().size();
	 }
	
	 public static Set<Grado> getGradosCreados() {
	 return new HashSet<Grado>(grados);
	 }

	public static Double getMediaAsignaturasObligatoriasGrados() {
		Double res = 0.00;
		for (Grado g : getGradosCreados()) 
			res = res + g.getAsignaturasObligatorias().size();

		return res / getGradosCreados().size();
	}

	public static Double getMediaAsignaturasOptativasGrados() {
		Double res = 0.;

		for (Grado g : getGradosCreados()) 
			res = res + g.getAsignaturasOptativas().size();

		return res / getGradosCreados().size();
	}

	public static Double getMediaAsignaturasGrados() {
		Double res = 0.;

		for (Grado g : getGradosCreados()) {
			res = res + g.getAsignaturasOptativas().size()
					+ g.getAsignaturasObligatorias().size();
		}
		return res / getGradosCreados().size();
	}

	private static Set<Profesor> profesores = new HashSet<Profesor>();

	private static Boolean usarProfesorImpl2 = false;

	public static void setUsarImplementacionMapProfesor(Boolean b) {
		usarProfesorImpl2 = b;
	}

	public static Integer getNumProfesoresCreados() {
		return getProfesoresCreados().size();
	}

	public static Set<Profesor> getProfesoresCreados() {
		return new HashSet<Profesor>(profesores);
	}

	public static Profesor createProfesor(String dni, String nombre,
			String apellidos, LocalDate fechaNacimiento, String email,
			Categoria categoria, Departamento departamento) {
		Profesor res;
		if (usarProfesorImpl2) {
			res = new ProfesorImpl2(dni, nombre, apellidos, fechaNacimiento,
					email, categoria, departamento);
		} else {
			res = new ProfesorImpl(dni, nombre, apellidos, fechaNacimiento,
					email, categoria, departamento);
		}
		profesores.add(res);

		return res;
	}

	public static Profesor createProfesor(Profesor p) {
		Profesor res = createProfesor(p.getDNI(), p.getNombre(),
				p.getApellidos(), p.getFechaNacimiento(), p.getEmail(),
				p.getCategoria(), p.getDepartamento());
		for (Asignatura a : p.getAsignaturas()) {
			res.imparteAsignatura(a, p.dedicacionAsignatura(a));
		}
		for (Tutoria t : p.getTutorias())
			res.nuevaTutoria(t.getHoraComienzo(), t.getDuracion(),
					t.getDiaSemana());
		return res;
	}

}
