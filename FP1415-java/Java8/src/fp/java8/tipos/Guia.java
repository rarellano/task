package fp.java8.tipos;

public interface Guia extends Cloneable {
	public String getEmpresa();

	public Integer getPuntuacion();
	
	public void setEmpresa(String empresa);
	public void setPuntuacion(Integer puntuacion);
	public String puntuacionAValor();

}
