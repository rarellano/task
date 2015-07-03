package fp.grados.tipos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.lang.model.element.NestingKind;

import fp.grados.excepciones.ExcepcionAlumnoNoValido;
import fp.grados.excepciones.ExcepcionAlumnoOperacionNoPermitida;
import fp.grados.excepciones.ExcepcionEspacioNoValido;

public class AlumnoImpl extends PersonaImpl implements Alumno {

	private Set<Asignatura> asignatura;
	private Expediente expediente;

	public AlumnoImpl(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento, String email) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		checkEmail(email);
		this.asignatura = new HashSet<Asignatura>();
		this.expediente = new ExpedienteImpl();
	}

	public AlumnoImpl(String s) {
		super(s);

		 String[] attr = s.split(",");
		 checkEmail(attr[4].trim());
//		checkEmail(super.getEmail());  ////////
		this.asignatura = new HashSet<Asignatura>();
		this.expediente = new ExpedienteImpl();

	}

	public String toString() {
		return "(" + getCurso() + "º) " + super.toString();
	}

	public void setEmail(String email) {
		checkEmail(email);
		super.setEmail(email);

	}

	private void checkEmail(String email) {
		 if (!(email.contains("@alum.us.es"))) {
		 throw new ExcepcionAlumnoNoValido(
		 "El email debe acabar en @alum.us.es");
		 }
	}
	
	public Set<Asignatura> getAsignaturas() {

		return asignatura;
	}

	public Integer getCurso() {

		Integer curso = 0;

		for (Asignatura a : asignatura) {

			if (a.getCurso() > curso) {
				curso = a.getCurso();
			}

		}

		return curso;
	}

	public void matriculaAsignatura(Asignatura asig) {

		if (!asignatura.contains(asig)) {
			asignatura.add(asig);
		} else {
			throw new ExcepcionAlumnoOperacionNoPermitida(
					"El alumno ya esta matriculado en esta asignatura");
		}
	}

	public void eliminaAsignatura(Asignatura asig) {
		if (asignatura.contains(asig)) {
			asignatura.remove(asig);
		} else {
			throw new ExcepcionAlumnoOperacionNoPermitida(
					"El alumno no esta matriculado en esta asignatura");
		}

	}

	public Boolean estaMatriculadoEn(Asignatura asig) {

		Boolean res = false;

		if (asignatura.contains(asig)) {
			res = true;
		}

		return res;
	}

	@Override
	public Expediente getExpediente() {
		return expediente;
	}

	@Override
	public void evaluaAlumno(Asignatura a, Integer curso,
			Convocatoria convocatoria, Double nota, Boolean mencionHonor) {
		if (this.estaMatriculadoEn(a)) {
			Nota n = new NotaImpl(a, curso, convocatoria, nota, mencionHonor);
			expediente.nuevaNota(n);
		} else {
			throw new ExcepcionAlumnoOperacionNoPermitida(
					"El alumno no esta matriculado en la asignaura");
		}
	}

	@Override
	public void evaluaAlumno(Asignatura a, Integer curso,
			Convocatoria convocatoria, Double nota) {
		if (this.estaMatriculadoEn(a)) {
			Nota n = new NotaImpl(a, curso, convocatoria, nota);
			expediente.nuevaNota(n);
		} else {
			throw new ExcepcionAlumnoOperacionNoPermitida(
					"El alumno no esta matriculado en la asignaura");
		}

	}

	public SortedMap<Asignatura, Calificacion> getCalificacionPorAsignatura() {
		SortedMap<Asignatura, Calificacion> res = new TreeMap<Asignatura, Calificacion>();

		for (Nota nexp : getExpediente().getNotas()) {
			if (!res.containsKey(nexp.getAsignatura())) {
				res.put(nexp.getAsignatura(), nexp.getCalificacion());
			} else {
				if (nexp.getCalificacion().compareTo(
						(res.get(nexp.getAsignatura()))) > 0) {
					res.remove(nexp.getAsignatura());
					res.put(nexp.getAsignatura(), nexp.getCalificacion());
				}
			}

		}

		return res;
	}

	public SortedSet<Asignatura> getAsignaturasOrdenadasPorCurso() {
		SortedSet<Asignatura> res = new TreeSet<Asignatura>(Comparator
				.comparing(Asignatura::getCurso).reversed()
				.thenComparing(Comparator.naturalOrder()));
		res.addAll(getAsignaturas());
		return res;
	}

}
