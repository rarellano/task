package fp.grados.tipos;

public class ExpedienteImpl2 extends ExpedienteImpl implements Expediente {

	public Double getNotaMedia() {
		Double res = 0.00;
		if (this.getNotas().stream().filter(n -> n.getValor() >= 5.0).count() != 0) {
			res = this.getNotas().stream().filter(n -> n.getValor() >= 5.0)
					.mapToDouble(Nota::getValor).average().getAsDouble();
		}
		return res;
	}

}
