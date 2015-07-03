package fp.grados.tipos;

import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public interface Centro extends Comparable<Centro>{

	public String getNombre();
	public String getDireccion();
	public Integer getNumeroPlantas();
	public Integer getNumeroSotanos();
	public Set<Espacio> getEspacios();
	public void nuevoEspacio(Espacio e);
	public void eliminaEspacio(Espacio e);
	public Integer[] getConteosEspacios();
	public Set<Despacho> getDespachos();
	public Set<Despacho> getDespachos(Departamento d);
	public Set<Profesor> getProfesores();
	public Set<Profesor> getProfesores(Departamento d);
	public Espacio getEspacioMayorCapacidad();
	public SortedMap<Profesor, Despacho> getDespachosPorProfesor();
	public SortedSet<Espacio> getEspaciosOrdenadosPorCapacidad();
	
}
