package fp.grados.tipos;

import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public interface Grado extends Comparable<Grado> {
	public String getNombre();

	public Set<Asignatura> getAsignaturasObligatorias();

	public Set<Asignatura> getAsignaturasOptativas();

	public Double getNumeroMinimoCreditosOptativas();

	public Double getNumeroTotalCreditos();

	public Set<Departamento> getDepartamentos();

	public Set<Profesor> getProfesores();

	public Set<Asignatura> getAsignaturas(Integer curso);

	public Asignatura getAsignatura(String codigo);
	
	//
	
	public SortedMap<Asignatura, Double> getCreditosPorAsignatura();

	public SortedSet<Departamento> getDepartamentosOrdenadosPorAsignaturas();
}
