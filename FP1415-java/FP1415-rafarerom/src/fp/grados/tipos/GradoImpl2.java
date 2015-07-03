package fp.grados.tipos;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GradoImpl2 extends GradoImpl implements Grado {

	public GradoImpl2(String nombre, Set<Asignatura> asignaturasObligatorias,
			Set<Asignatura> asignaturasOptativas,
			Double numeroMinimoCreditosOptativas) {
		super(nombre, asignaturasObligatorias, asignaturasOptativas,
				numeroMinimoCreditosOptativas);
	}

	public Double getNumeroTotalCreditos() {
		return this.getNumeroMinimoCreditosOptativas()
				+ this.getAsignaturasObligatorias().stream()
						.mapToDouble(Asignatura::getCreditos).sum();
	}

	public Set<Asignatura> getAsignaturas(Integer curso) {
		return Stream
				.concat(this.getAsignaturasObligatorias().stream(),
						this.getAsignaturasOptativas().stream())
				.filter(a -> a.getCurso().equals(curso))
				.collect(Collectors.toSet());
	}

	public Asignatura getAsignatura(String codigo) {
		Asignatura res = (Asignatura) Stream
				.concat(this.getAsignaturasObligatorias().stream(),
						this.getAsignaturasOptativas().stream())
				.filter(x -> x.getCodigo().equals(codigo))
				.collect(Collectors.toSet());
		return res;
	}

	public Set<Departamento> getDepartamentos() {
		Set<Departamento> res = Stream
				.concat(getAsignaturasObligatorias().stream(),
						getAsignaturasOptativas().stream())
				.map(x -> x.getDepartamento()).collect(Collectors.toSet());

		return res;

	}

	public Set<Profesor> getProfesores() {
		Set<Profesor> res = new HashSet<Profesor>();

		for (Departamento d : getDepartamentos())
			res.addAll(d.getProfesores());
		return res;
	}

	public SortedMap<Asignatura, Double> getCreditosPorAsignatura() {
		return Stream.concat(getAsignaturasObligatorias().stream(),
				getAsignaturasOptativas().stream()).collect(
				Collectors.toMap(a -> a, a -> ((Asignatura) a).getCreditos(), (
						a1, a2) -> a1, TreeMap::new));
	}
}
