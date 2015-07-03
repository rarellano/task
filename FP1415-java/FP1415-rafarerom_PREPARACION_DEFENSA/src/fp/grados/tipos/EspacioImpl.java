package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionEspacioNoValido;



public class EspacioImpl implements Espacio {

	private String nombre;
	private TipoEspacio tipo;
	private Integer capacidad, planta;

	public EspacioImpl(TipoEspacio tipo, String nombre, Integer capacidad,
			Integer planta) {
		this.nombre = nombre;
		this.tipo = tipo;
		checkCapacidad(capacidad);
		this.capacidad = capacidad;
		this.planta = planta;

	}

	public EspacioImpl(String s) {
		String[] attr = s.split(",");
		if(attr.length != 4)
			throw new IllegalArgumentException();
		this.nombre = attr[0].trim();
		this.tipo = TipoEspacio.valueOf(attr[3].trim());
		checkCapacidad(Integer.valueOf(attr[2].trim()));
		this.capacidad = Integer.valueOf(attr[2].trim());
		this.planta = Integer.valueOf(attr[1].trim());
	}

	
	public int compareTo(Espacio o) {
		int res = getPlanta().compareTo(o.getPlanta());
		
			if(res == 0){
				res=getNombre().compareTo(o.getNombre());
			}
		return res;
	}
	
	public boolean equals(Object o){
		boolean res = false;
		
		if (o instanceof EspacioImpl
				&& this.getNombre() == ((EspacioImpl) o).getNombre()
				&& this.getPlanta() == ((EspacioImpl) o).getPlanta()){		
			res = true;
		}
		
		return res;
	}
	
	public int hashCode(){
		return getNombre().hashCode() + getPlanta().hashCode()*31;
	}

	private void checkCapacidad(Integer capacidad) {
		if(capacidad <= 0){
			throw new ExcepcionEspacioNoValido("El espacio debe ser mayor que 0");
		}
	}

	public String toString() {
		return getNombre() + " (planta " + getPlanta() + ")";
	}

	public TipoEspacio getTipo() {
		return tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public Integer getPlanta() {
		return planta;
	}

	public void setTipo(TipoEspacio tipo) {
		this.tipo=tipo;
	}

	public void setNombre(String nombre) {
		this.nombre=nombre;
	}

	public void setCapacidad(Integer capacidad) {
		checkCapacidad(capacidad);
		this.capacidad=capacidad;
	}

	

}
