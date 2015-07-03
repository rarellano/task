package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.SortedSet;

public interface Profesor extends Persona {

	public Categoria getCategoria();

	public SortedSet<Tutoria> getTutorias();

	public void setCategoria(Categoria categoria);

	public void nuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos,
			DayOfWeek dia);

	public void borraTutoria(LocalTime horaComienzo, DayOfWeek dia);

	public void borraTutorias();

	public Departamento getDepartamento();

	public void setDepartamento(Departamento departamento);

	public List<Asignatura> getAsignaturas();
	
	public List<Double> getCreditos();
	
	public Double getDedicacionTotal();
	
	public void imparteAsignatura(Asignatura asig, Double dedicacion);
	
	public Double dedicacionAsignatura(Asignatura asig);
	
	public void eliminaAsignatura(Asignatura asig);
}
