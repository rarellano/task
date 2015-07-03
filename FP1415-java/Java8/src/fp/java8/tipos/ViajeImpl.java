package fp.java8.tipos;

public class ViajeImpl implements Viaje {
	private String origen, destino, medioTransporte, empresa;
	private Double precio;

	public ViajeImpl() {
		super();
	}

	public ViajeImpl(String origen, String destino, String medioTransporte,
			String empresa, Double precio) {
		super();
		this.origen=origen;
		this.destino=destino;
		this.medioTransporte=medioTransporte;
		this.empresa=empresa;
		this.precio=precio;
	}
	
	public Viaje clone(){
		
		Viaje v = null;
		
		try{
			v=(Viaje)super.clone();
		}catch(CloneNotSupportedException c){
			System.out.println(c.getMessage());
		}
		
		
		return v;
		
	}
	
	public String getOrigen(){
		return this.origen;
	}

	public String getDestino(){
		return this.destino;
		
	}
	
	public String getMedioTransporte(){
		return this.medioTransporte;
	}
	
	public Double getPrecio(){
		return this.precio;
	}

	public String getEmpresa(){
		return this.empresa;
	}
	
	public void setOrigen(String origen){
		this.origen=origen;
	}
	
	public void setDestino(String destino){
		this.destino=destino;
	}
	
	public void setMedioTransporte(String medioTransporte){
		this.medioTransporte=medioTransporte;
	}
	
	public void setPrecio(Double precio){
		this.precio=precio;
	}
	
	public void setEmpresa(String empresa){
		this.empresa=empresa;
	}


}