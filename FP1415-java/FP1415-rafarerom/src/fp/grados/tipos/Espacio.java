package fp.grados.tipos;

public interface Espacio extends Comparable<Espacio> {

	public TipoEspacio getTipo();
	public String getNombre();
	public Integer getCapacidad();
	public Integer getPlanta();
	
	public void setTipo(TipoEspacio tipo);
	public void setNombre(String nombre);
	public void setCapacidad(Integer capacidad);
	
	
	
}
