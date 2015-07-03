package fp.grados.tipos;

import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class CentroImpl2 extends CentroImpl {

	public CentroImpl2(String nombre, String direccion, Integer numeroPlantas,
			Integer numeroSotanos) {
		super(nombre, direccion, numeroPlantas, numeroSotanos);
	}

	public Espacio getEspacioMayorCapacidad(){
		Optional<Espacio> res= super.getEspacios().stream().max(Comparator.comparing(Espacio::getCapacidad));
		if(!res.isPresent())
			throw new NoSuchElementException();
		return res.get();
		
	}

	public Integer[] getConteosEspacios(){
		int i = 0;
		Integer[] res = new Integer[TipoEspacio.values().length];
		for (TipoEspacio te : TipoEspacio.values())
			res[i++] = cuentaEspacios(te);
		return res;
	}

	private Integer cuentaEspacios(TipoEspacio te) {
		Integer res = (int) getEspacios().stream().filter(e -> e.getTipo().equals(te)).count();
		return res;
	}
	
	public Set<Despacho> getDespachos(){
		return getEspacios().stream().filter(e->e instanceof Despacho).map(e->(Despacho)e).collect(Collectors.toSet());
	
	}
	
	
	
	public Set<Despacho> getDespachos(Departamento dpto){
		return getDespachos().stream().filter(d -> pertenece(d,dpto)).collect(Collectors.toSet());
	}
	
	private Boolean pertenece(Despacho d, Departamento dpto){
		return d.getProfesores().stream().anyMatch(p-> p.getDepartamento().equals(dpto));
	}


	public Set<Profesor> getProfesores(){
		return getDespachos().stream().flatMap(d -> d.getProfesores().stream()).collect(Collectors.toSet());
	}
	
	
	public Set<Profesor> getProfesores(Departamento d){
		return getProfesores().stream().filter(p -> p.getDepartamento().equals(d)).collect(Collectors.toSet());
	}
	
	
	public SortedMap<Profesor,Despacho> getDespachosPorProfesor(){
			return new TreeMap<>(getDespachos().stream().flatMap(d -> d.getProfesores().stream()).collect(Collectors.toMap(p -> p , p-> encuentraDespacho((Profesor) p))));
	}

	private Despacho encuentraDespacho(Profesor p){
			return getDespachos().stream().filter(d -> d.getProfesores().contains(p)).findFirst().get();
	}
	
}