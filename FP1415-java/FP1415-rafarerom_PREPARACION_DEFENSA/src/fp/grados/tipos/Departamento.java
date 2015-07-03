package fp.grados.tipos;

import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public interface Departamento extends Comparable<Departamento> {
	
	public String getNombre();
	public Set<Asignatura> getAsignaturas();
	public Set<Profesor> getProfesores();
	
	public void nuevaAsignatura(Asignatura asig);
	public void eliminaAsignatura(Asignatura asig);
	public void nuevoProfesor(Profesor prof);
	public void eliminaProfesor(Profesor prof);
	
	public void borraTutorias();
	public void borraTutorias(Categoria c);
	public Boolean existeProfesorAsignado(Asignatura a);
	public Boolean estanTodasAsignaturasAsignadas();
	public void eliminaAsignacionProfesorado(Asignatura a);
	
	//
	public SortedMap<Profesor, SortedSet<Tutoria>> getTutoriasPorProfesor();
	public SortedMap<Asignatura, SortedSet<Profesor>> getProfesoresPorAsignatura();
	public Profesor getProfesorMaximaDedicacionMediaPorAsignatura();
}
