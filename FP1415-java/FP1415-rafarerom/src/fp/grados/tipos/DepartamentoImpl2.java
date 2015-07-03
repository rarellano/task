package fp.grados.tipos;

import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DepartamentoImpl2 extends DepartamentoImpl {

	public DepartamentoImpl2(String nombre) {
		super(nombre);
	}
	
	public void borraTutorias(){
		getProfesores().stream().forEach(p->p.borraTutorias());
	}
	
	public void borraTutorias(Categoria categoria){
		getProfesores().stream().filter(p->p.getCategoria().equals(categoria)).forEach(p->p.borraTutorias());
	}
	
	public Boolean existeProfesorAsignado(Asignatura a){
		return getProfesores().stream().anyMatch(p->p.dedicacionAsignatura(a)>0);
	}

	public Boolean estanTodasAsignaturasAsignadas(){
		return getAsignaturas().stream().allMatch(a -> existeProfesorAsignado(a));
	}
	
	public void eliminaAsignacionProfesorado(Asignatura a){
		getProfesores().stream().filter(p-> p.dedicacionAsignatura(a) > 0).forEach(p -> p.eliminaAsignatura(a));	 
	}
	
	public SortedMap<Profesor,SortedSet<Tutoria>> getTutoriasPorProfesor(){
		Map<Profesor, SortedSet<Tutoria>> mapa = getProfesores().stream().collect(Collectors.toMap(Function.identity(), p -> p.getTutorias()));
		return new TreeMap<>(mapa);
		
	}
}
