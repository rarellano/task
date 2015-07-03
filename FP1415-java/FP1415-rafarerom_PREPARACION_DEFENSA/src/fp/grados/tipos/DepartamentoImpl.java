package fp.grados.tipos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

import java.util.Optional;

public class DepartamentoImpl implements Departamento {

	private String nombre;
	private Set<Profesor> profesores;
	private Set<Asignatura> asignaturas;

	public DepartamentoImpl(String nombre) {

		this.nombre = nombre;
		this.profesores = new HashSet<Profesor>();
		this.asignaturas = new HashSet<Asignatura>();
	}

	public int compareTo(Departamento o) {
		return getNombre().compareTo(o.getNombre());
	}

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Departamento) {
			res = this.getNombre().equals(((Departamento) o).getNombre());
		}

		return res;
	}

	public int hashCode() {
		return getNombre().hashCode();
	}

	public String toString() {
		return getNombre();
	}

	public String getNombre() {
		return nombre;
	}

	public Set<Asignatura> getAsignaturas() {
		return new HashSet<Asignatura>(asignaturas);

	}

	public Set<Profesor> getProfesores() {
		return new HashSet<Profesor>(profesores);
	}

	public void nuevaAsignatura(Asignatura asig) {
		asignaturas.add(asig);
		asig.setDepartamento(this);

	}

	public void eliminaAsignatura(Asignatura asig) {
		asignaturas.remove(asig);
		asig.setDepartamento(null);
	}

	public void nuevoProfesor(Profesor prof) {
		profesores.add(prof);
		prof.setDepartamento(this);

	}

	public void eliminaProfesor(Profesor prof) {
		profesores.remove(prof);
		prof.setDepartamento(null);
	}

	public void borraTutorias() {
		for (Profesor p : getProfesores()) {
			p.borraTutorias();
		}
	}

	public void borraTutorias(Categoria c) {
		for (Profesor p : getProfesores()) {
			if (p.getCategoria() == c) {
				p.borraTutorias();
			}
		}
	}

	public Boolean existeProfesorAsignado(Asignatura a) {
		Boolean res = false;

		for (Profesor p : getProfesores()) {
			if (p.getAsignaturas().contains(a)) {
				res = true;
			}
		}
		return res;

	}

	public Boolean estanTodasAsignaturasAsignadas() {
		Boolean res = true;
		for (Asignatura a : getAsignaturas()) {
			if (!existeProfesorAsignado(a)) {
				res = false;
			}
		}

		return res;
	}

	public void eliminaAsignacionProfesorado(Asignatura a) {
		for (Profesor p : getProfesores()) {
			if (p.getAsignaturas().contains(a)) {
				p.eliminaAsignatura(a);
			}
		}
	}


	
	public Profesor getProfesorMaximaDedicacionMediaPorAsignatura() {
		
		
		return profesores
				.stream()
				.filter(profe -> !profe.getAsignaturas().isEmpty())
				.max(Comparator.comparing(profe -> profe.getDedicacionTotal()
						/ profe.getAsignaturas().size()))
				.orElseThrow(NoSuchElementException::new);
	}

	public SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura() {
		SortedMap<Asignatura, SortedSet<Profesor>> res = new TreeMap<Asignatura, SortedSet<Profesor>>();
		for (Profesor p : getProfesores()) {
			for (Asignatura a : p.getAsignaturas()) {
				if (res.containsKey(a)) {
					res.get(a).add(p);
				} else {
					SortedSet<Profesor> profesores = new TreeSet<Profesor>();
					profesores.add(p);
					res.put(a, profesores);
				}
			}
		}
		return res;
	}

	public SortedMap<Profesor, SortedSet<Tutoria>> getTutoriasPorProfesor() {

		SortedMap<Profesor, SortedSet<Tutoria>> res = new TreeMap<Profesor, SortedSet<Tutoria>>();

		for (Profesor prof : getProfesores())
			res.put(prof, prof.getTutorias());

		return res;
	}

}
