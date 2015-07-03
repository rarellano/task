package fp.grados.tipos;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionGradoNoValido;
import sun.net.www.content.audio.aiff;

public class GradoImpl implements Grado {

	private String nombre;
	private Set<Asignatura> asignaturasObligatorias;
	private Set<Asignatura> asignaturasOptativas;
	private Double numeroMinimoCreditosOptativas;

	public GradoImpl(String nombre, Set<Asignatura> asignaturasObligatorias,
			Set<Asignatura> asignaturasOptativas,
			Double numeroMinimoCreditosOptativas) {
		this.nombre = nombre;
		this.asignaturasObligatorias = asignaturasObligatorias;
		checkAsigOpt(asignaturasOptativas);
		this.asignaturasOptativas = asignaturasOptativas;
		checkNumMinCreditosOpt(numeroMinimoCreditosOptativas);
		this.numeroMinimoCreditosOptativas = numeroMinimoCreditosOptativas;
	}

	private void checkNumMinCreditosOpt(Double numeroMinimoCreditosOptativas) {
		double sum = 0.00;
		for (Asignatura a : getAsignaturasOptativas()) {
			sum = sum + a.getCreditos();
		}
		if (numeroMinimoCreditosOptativas < 0
				|| numeroMinimoCreditosOptativas > sum) {
			throw new ExcepcionGradoNoValido();
		}
	}

	private void checkAsigOpt(Set<Asignatura> asignaturasOptativas) {
		for (Asignatura a : asignaturasOptativas) {
			for (Asignatura b : asignaturasOptativas) {
				if (!(a.getCreditos().equals(b.getCreditos()))) {
					throw new ExcepcionGradoNoValido();
				}
			}
		}
	}

	@Override
	public int compareTo(Grado o) {
		return getNombre().compareTo(o.getNombre());
	}

	public boolean equals(Object o) {
		Boolean res = false;

		if (o instanceof Grado && ((Grado) o).getNombre().equals(getNombre())) {
			res = true;
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

	public Set<Asignatura> getAsignaturasObligatorias() {
		return asignaturasObligatorias;
	}

	public Set<Asignatura> getAsignaturasOptativas() {
		return asignaturasOptativas;
	}

	public Double getNumeroMinimoCreditosOptativas() {
		return numeroMinimoCreditosOptativas;
	}

	public Double getNumeroTotalCreditos() {

		Double sum = 0.00;
		for (Asignatura a : getAsignaturasObligatorias()) {
			sum = sum + a.getCreditos();
		}

		return sum + getNumeroMinimoCreditosOptativas();
	}

	public Set<Departamento> getDepartamentos() {

		Set<Departamento> depart = new HashSet<Departamento>();

		for (Asignatura aobl : getAsignaturasObligatorias()) {
			depart.add(aobl.getDepartamento());
		}

		for (Asignatura aopt : getAsignaturasOptativas()) {
			depart.add(aopt.getDepartamento());
		}
		return depart;
	}

	public Set<Profesor> getProfesores() {
		Set<Profesor> prof = new HashSet<Profesor>();

		for (Departamento d : getDepartamentos()) {
			prof.addAll(d.getProfesores());
		}

		return prof;
	}

	public Set<Asignatura> getAsignaturas(Integer curso) {
		Set<Asignatura> asignaturas = new HashSet<Asignatura>();

		for (Asignatura aobl : getAsignaturasObligatorias()) {
			if (aobl.getCurso() == curso) {
				asignaturas.add(aobl);
			}
		}
		for (Asignatura aopt : getAsignaturasOptativas()) {
			if (aopt.getCurso() == curso) {
				asignaturas.add(aopt);
			}
		}

		return asignaturas;
	}

	public Asignatura getAsignatura(String codigo) {

		Asignatura asig = null;

		for (Asignatura aobl : getAsignaturasObligatorias()) {
			if (aobl.getCodigo() == codigo) {
				asig = aobl;
			}
		}
		for (Asignatura aopt : getAsignaturasOptativas()) {
			if (aopt.getCodigo() == codigo) {
				asig = aopt;
			}
		}

		return asig;
	}

	public SortedMap<Asignatura, Double> getCreditosPorAsignatura() {
		SortedMap<Asignatura, Double> res = new TreeMap<Asignatura, Double>();

		Set<Asignatura> asigTotal = new HashSet<>(getAsignaturasObligatorias());
		asigTotal.addAll(asignaturasOptativas);
		for (Asignatura asig : asigTotal) {
			res.put(asig, asig.getCreditos());
		}

		return res;

	}
	
	public SortedSet<Departamento> getDepartamentosOrdenadosPorAsignaturas() {
		Comparator<Departamento> cmpDepartamentosPorNumAsignauras=Comparator.comparing(x->x.getAsignaturas().size());
		SortedSet<Departamento> res=new TreeSet<Departamento>(cmpDepartamentosPorNumAsignauras.reversed().thenComparing(Comparator.naturalOrder()));
		res.addAll(this.getDepartamentos());
		return res;
	}

}
