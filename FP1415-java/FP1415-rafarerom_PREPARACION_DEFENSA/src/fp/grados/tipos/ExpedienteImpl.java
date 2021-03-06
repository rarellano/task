package fp.grados.tipos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Stream;

import fp.grados.excepciones.ExcepcionExpedienteOperacionNoPermitida;

public class ExpedienteImpl implements Expediente {

	private List<Nota> notas;

	public ExpedienteImpl() {
		this.notas = new ArrayList<Nota>();
	}

	public String toString() {
		return getNotas().toString();

	}

	public boolean equals(Object o) {

		boolean res = false;
		Expediente exp = (Expediente) o;
		if (o instanceof Expediente && getNotas().equals(exp.getNotas())) {
			res = true;
		}

		return res;

	}

	public int hashCode() {

		return getNotas().hashCode();
	}

	public List<Nota> getNotas() {
		return new ArrayList<Nota>(notas);
	}

	public Double getNotaMedia() {

		Double sum = 0.0;
		if (getNotas().isEmpty())
			return sum;
		else
			for (Nota n : getNotas())
				if (n.getValor() >= 5.0)
					sum += n.getValor();

		if ((getNotas().size() - 1) > 1)
			sum = sum / (getNotas().size() - 1);

		return sum;
	}

	private void checkExpediente(Nota nota) {

		int i = 0;
		for (Nota n : getNotas()) {
			if ((n.getAsignatura().equals(nota.getAsignatura()))
					&& (n.getCursoAcademico().equals(nota.getCursoAcademico())))
				i++;
			if (i >= 2)
				throw new ExcepcionExpedienteOperacionNoPermitida(
						"No pueden existir dos notas iguales en el expediente");
		}
	}

	public void nuevaNota(Nota n) {
		if (notas.contains(n)) {
			notas.remove(n);
		}

		checkExpediente(n);
		notas.add(n);

	}

	public Nota getMejorNota() {
		return getNotas()
				.stream()
				.max(Comparator
						.comparing(Nota::getMencionHonor)
						.thenComparing(Nota::getValor)
						.thenComparing(
								Comparator.comparing(Nota::getConvocatoria)
										.thenComparing(Nota::getCursoAcademico)
										.reversed())).get();
	}

	public List<Nota> getNotasOrdenadasPorAsignatura() {
		List<Nota> res = new ArrayList<Nota>(getNotas());
		Collections.sort(res, Comparator.comparing(Nota::getAsignatura)
				.thenComparing(Comparator.naturalOrder()));

		return res;
	}
}
