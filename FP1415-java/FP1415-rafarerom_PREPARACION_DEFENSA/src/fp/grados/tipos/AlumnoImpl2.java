package fp.grados.tipos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;

public class AlumnoImpl2 extends AlumnoImpl{

	public AlumnoImpl2(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento, String email) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		// TODO Auto-generated constructor stub
	}

	public AlumnoImpl2(String s){
		super(s);
	}
	
	public Integer getCurso(){
		if(getAsignaturas().isEmpty())
			return 0;
		else
			return getAsignaturas().stream().max(Comparator.comparing(Asignatura::getCurso)).orElseThrow(ExcepcionAlumnoOperacionNoPermitida::new).getCurso();
	}

	public SortedMap<Asignatura,Calificacion> getCalificacionPorAsignatura(){
		Map<Asignatura, Calificacion> ca = getAsignaturas().stream().collect(Collectors.toMap(n -> n, n-> mayorCalificacion(n)));
		return new TreeMap<>(ca);
	}

	private Calificacion mayorCalificacion(Object o) {
		Asignatura a = (Asignatura) o;
		return getExpediente().getNotas().stream().filter(n1 -> n1.getAsignatura().equals(a)).max(Comparator.comparing(Nota::getCalificacion)).get().getCalificacion();
		
	}
}
