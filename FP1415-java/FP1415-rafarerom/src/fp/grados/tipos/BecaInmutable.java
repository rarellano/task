package fp.grados.tipos;

public interface BecaInmutable extends Comparable<BecaInmutable> {

	public String getCodigo();

	public Double getCuantiaTotal();

	public Integer getDuracion();

	public TipoBeca getTipo();

	public Double getCuantiaMensual();

}
