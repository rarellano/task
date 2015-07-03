package fp.grados.tipos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionCentroNoValido;
import fp.grados.excepciones.ExcepcionCentroOperacionNoPermitida;

public class CentroImpl implements Centro {

	private String nombre, direccion;
	private Integer numeroPlantas, numeroSotanos;
	private Set<Espacio> espacios;

	public CentroImpl(String nombre, String direccion, Integer numeroPlantas,
			Integer numeroSotanos) {
		checkNumeroPlantas(numeroSotanos, numeroPlantas);
		this.nombre = nombre;
		this.direccion = direccion;
		this.numeroPlantas = numeroPlantas;
		this.numeroSotanos = numeroSotanos;
		this.espacios = new HashSet<Espacio>();

	}

	private void checkNumeroPlantas(Integer numeroSotanos, Integer numeroPlantas) {
		if (!(numeroPlantas >= 1) || !(numeroSotanos >= 0)) {
			throw new ExcepcionCentroNoValido(
					"El numero de plantas tiene que ser mayor o igual a 1 y el numero de sotanos igual o mayor que 0.");
		}
	}

	public String toString() {
		return getNombre();
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Centro) {
			res = getNombre().equals(((Centro) o).getNombre());
		}
		return res;
	}

	public int hashCode() {
		return this.getNombre().hashCode();
	}

	public int compareTo(Centro o) {
		return getNombre().compareTo(o.getNombre());
	}

	public String getNombre() {
		return nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public Integer getNumeroPlantas() {
		return numeroPlantas;
	}

	public Integer getNumeroSotanos() {
		return numeroSotanos;
	}

	public Set<Espacio> getEspacios() {
		return new HashSet<Espacio>(espacios);
	}

	public void nuevoEspacio(Espacio e) {
		int[] a = { -numeroSotanos, numeroPlantas };

		if (e.getPlanta() < a[0] || e.getPlanta() > a[1]) {
			throw new ExcepcionCentroOperacionNoPermitida(
					"El nuevo espacio debe estar comprendido entre las plantas del centro");
		}

		espacios.add(e);
	}

	public void eliminaEspacio(Espacio e) {
		if (espacios.contains(e)) {
			espacios.remove(e);
		}
	}

	public Integer[] getConteosEspacios() {
		Integer[] conteosEspacios = { 0, 0, 0, 0, 0 };

		for (Espacio esp : espacios) {
			if (esp.getTipo() == TipoEspacio.TEORIA) {
				conteosEspacios[0]++;
			} else if (esp.getTipo() == TipoEspacio.LABORATORIO) {
				conteosEspacios[1]++;
			} else if (esp.getTipo() == TipoEspacio.SEMINARIO) {
				conteosEspacios[2]++;
			} else if (esp.getTipo() == TipoEspacio.EXAMEN) {
				conteosEspacios[3]++;
			} else if (esp.getTipo() == TipoEspacio.OTRO) {
				conteosEspacios[4]++;
			}
		}

		return conteosEspacios;

	}

	public Set<Despacho> getDespachos() {
		Set<Despacho> despachos = new HashSet<Despacho>();

		for (Espacio e : espacios) {
			if (e instanceof Despacho) {
				despachos.add((Despacho) e);
			}
		}

		return despachos;
	}

	public Set<Despacho> getDespachos(Departamento d) {
		Set<Despacho> despachos = new HashSet<Despacho>();

		for (Espacio e : espacios) {
			if (e instanceof Despacho) {
				Despacho n = (Despacho) e;

				for (Profesor p : n.getProfesores()) {
					if (p.getDepartamento() == d) {
						despachos.add(n);
					}
				}

			}
		}

		return despachos;
	}

	public Set<Profesor> getProfesores() {
		Set<Profesor> profesores = new HashSet<Profesor>();

		for (Despacho d : getDespachos()) {
			profesores.addAll(d.getProfesores());
		}

		return profesores;
	}

	@Override
	public Set<Profesor> getProfesores(Departamento d) {
		Set<Profesor> profesores = new HashSet<Profesor>();

		for (Despacho desp : getDespachos()) {

			for (Profesor p : desp.getProfesores()) {

				if (p.getDepartamento() == d) {
					profesores.add(p);
				}

			}

		}

		return profesores;
	}

	@Override
	public Espacio getEspacioMayorCapacidad() {
		Espacio espacioMayorCapacidad = null;
		int i=0;
		for(Espacio e: espacios){
			if(e.getCapacidad() > i){
				i=e.getCapacidad();
				espacioMayorCapacidad=e;
			}
		}
		
		return espacioMayorCapacidad;
	}
	
	public SortedSet<Espacio> getEspaciosOrdenadosPorCapacidad(){
		SortedSet<Espacio> res = new TreeSet<>(Comparator.comparing(Espacio :: getCapacidad).reversed().thenComparing(Comparator.naturalOrder()));
		res.addAll(espacios);
		return res;
	}
	
	public SortedMap<Profesor, Despacho> getDespachosPorProfesor(){
		SortedMap<Profesor,Despacho> res = new TreeMap<Profesor,Despacho>();
		
		for(Despacho d: getDespachos()){
			for(Profesor p : d.getProfesores()){
				res.put(p, d);
			}
		}
		
		return res;
		
	}

}
