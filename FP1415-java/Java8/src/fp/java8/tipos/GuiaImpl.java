package fp.java8.tipos;

import fp.java8.tipos.TipoDeGenero;

public class GuiaImpl extends PersonaImpl implements Guia {

	private String empresa;
	private Integer puntuacion;

	public GuiaImpl() {
		super();
	}

	public GuiaImpl(String nombre, String apellidos, String dni,
			Integer telefono1, Integer telefono2, TipoDeGenero genero,
			String empresa, Integer puntuacion) {
		super(nombre, apellidos, dni, telefono1, telefono2, genero);
		this.empresa = empresa;
		this.puntuacion = puntuacion;
	}

	public boolean equals(Object o) {
		boolean res = false;

		if (this == o && o != null
				&& this.getDNI().equals(((PersonaImpl) o).getDNI())
				&& this.getEmpresa().equals(((GuiaImpl) o).getEmpresa())) {
			res = true;
		}

		return res;
	}

	public GuiaImpl clone(){
		
		GuiaImpl p = null;
		
		p=(GuiaImpl)super.clone();
		
		return p;
		
	}
	
	public String toString() {
		return getNombre() + " " + getApellidos() + " " + getEmpresa() + " "
				+ getPuntuacion();
	}

	public String getEmpresa() {
		return this.empresa;
	}

	public Integer getPuntuacion() {
		return this.puntuacion;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void setPuntuacion(Integer puntuacion) {
		this.puntuacion = puntuacion;
	}

	public String puntuacionAValor() {
		String res = null;
		if (getPuntuacion() < 3) {
			res = "Muy Malo";
		} else if (getPuntuacion() >= 3 & getPuntuacion() < 5) {
			res = "Malo";
		} else if (getPuntuacion() >= 5 & getPuntuacion() < 7) {
			res = "Bueno";
		} else if (getPuntuacion() >= 7 & getPuntuacion() < 9) {
			res = "Muy Bueno";
		} else {
			res = "Excelente";
		}
		return res;

	}
}
