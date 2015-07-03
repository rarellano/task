package fp.java8.tipos;

public interface Viaje extends Cloneable{

	public String getOrigen();
	public String getDestino();
	public String getMedioTransporte();
	public Double getPrecio();
	public String getEmpresa();
	
	
	public void setOrigen(String origen);
	public void setDestino(String destino);
	public void setMedioTransporte(String medioTransporte);
	public void setPrecio(Double precio);
	public void	setEmpresa(String empresa);
}
