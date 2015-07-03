package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;

import fp.grados.excepciones.ExcepcionBecaNoValida;
import fp.grados.excepciones.ExcepcionDespachoNoValido;

public class DespachoImpl extends EspacioImpl implements Despacho {

	private Set<Profesor> profesores;
	private static final TipoEspacio TIPO = TipoEspacio.OTRO;

	public DespachoImpl(String nombre, Integer capacidad, Integer planta,
			Set<Profesor> profesores) {
		super(TIPO, nombre, capacidad, planta);
		this.profesores = new HashSet<Profesor>();
		this.profesores.addAll(profesores);
		checkCapacidad(profesores);

	}

	public DespachoImpl(String nombre, Integer capacidad, Integer planta,
			Profesor profesor) {
		super(TIPO, nombre, capacidad, planta);
		this.profesores = new HashSet<Profesor>();
		this.profesores.add(profesor);
		checkCapacidad(profesores);

	}

	public DespachoImpl(String nombre, Integer capacidad, Integer planta) {
		super(TIPO, nombre, capacidad, planta);
		this.profesores = new HashSet<Profesor>();
		checkCapacidad(profesores);

	}
	
	public DespachoImpl(String s){
		super(s + ",OTRO");
		this.profesores = new HashSet<Profesor>();	
	}

	public void checkCapacidad(Set<Profesor> prof) {
		if (getCapacidad() < prof.size()) {
			throw new ExcepcionDespachoNoValido(
					"El Despacho debe tener una capacidad mayor a la del numero de profesores.");
		}
	}

	public String toString() {

		return super.toString() + getProfesores();

	}

	public Set<Profesor> getProfesores() {
		return profesores;
	}

	public void setTipo(TipoEspacio tipo) {
		throw new UnsupportedOperationException(
				"No se puede modificar el tipo de espacio");
	}

	public void setProfesores(Set<Profesor> profesores) {
		checkCapacidad(profesores);
		this.profesores = profesores;
	}

}
