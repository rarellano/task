package fp.java8.tipos;

public interface Persona extends Cloneable {

	public String getNombre();
	public String getApellidos();
	public String getDNI();
	public Integer getTelefono1();
	public Integer getTelefono2();
	public TipoDeGenero getGenero();

	public void setNombre(String nombre);
	public void setApellidos(String apellidos);
	public void setDNI(String dni);
	public void setTelefono1(Integer telefono1);
	public void setTelefono2(Integer telefono2);
	public void setGenero(TipoDeGenero genero);
	
	
}
