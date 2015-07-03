package fp.java8.tipos;
public interface Viajero extends Persona,Cloneable {

	public TipoDeViajero getTipoViajero();

	public void setTipoViajero(TipoDeViajero tipoViajero);
	
	public String esTipoViajero(TipoDeGenero tipo);

	
}
