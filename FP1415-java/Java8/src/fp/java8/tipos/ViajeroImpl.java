package fp.java8.tipos;

public class ViajeroImpl extends PersonaImpl implements Viajero {

	private TipoDeViajero tipoViajero;

	public ViajeroImpl() {
		super();
	}

	public ViajeroImpl(String nombre, String apellidos, String dni,
			Integer telefono1, Integer telefono2, TipoDeGenero genero,
			TipoDeViajero tipoViajero) {
		super(nombre,apellidos,dni,telefono1,telefono2,genero);
		this.tipoViajero = tipoViajero;
	}
	
	public boolean equals(Object o) {
		Boolean res = false;

		if (this == o && o != null
				&& this.getDNI().equals(((PersonaImpl) o).getDNI())
				&& this.getTipoViajero().equals(((ViajeroImpl) o).getTipoViajero())) {
			res = true;
		}

		return res;
	}

	public ViajeroImpl clone(){
		
		ViajeroImpl v = null;
		
			v=(ViajeroImpl)super.clone();
		
		return v;
		
	}
	
	public String toString() {
		return getNombre() + " " + getApellidos() + " " + getTipoViajero()+ " "
				+ getGenero();
	}

	public TipoDeViajero getTipoViajero() {
		return this.tipoViajero;
	}

	public void setTipoViajero(TipoDeViajero tipoViajero) {
		this.tipoViajero = tipoViajero;
	}
	
	public String esTipoViajero(TipoDeGenero tipo){
		String res = null;
		if (getTipoViajero() == TipoDeViajero.PREFERENTE){
			res = "PREFERENTE";
		}else{
			res="TURISTA";
		}
		return res;
	}
	
	


}
