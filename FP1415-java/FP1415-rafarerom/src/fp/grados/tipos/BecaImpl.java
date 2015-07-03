      package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionBecaNoValida;

public class BecaImpl implements Beca {

	private String codigo;
	private Double cuantiaTotal;
	private final static Double CUANTIA_MINIMA = 1500.00;
	private Integer duracion;
	private TipoBeca tipo;

	public BecaImpl(String codigo, Double cuantiaTotal, Integer duracion,
			TipoBeca tipo) {
		checkCodigo(codigo);
		this.codigo = codigo;
		checkCuantiaTotal(cuantiaTotal);
		this.cuantiaTotal = cuantiaTotal;
		checkDuracion(duracion);
		this.duracion = duracion;
		this.tipo = tipo;
	}

	public BecaImpl(String codigo, TipoBeca tipo) {
		checkCodigo(codigo);
		this.codigo = codigo;
		this.tipo = tipo;
		this.cuantiaTotal = 1500.00;
		this.duracion = 1;
	}
	
	public BecaImpl(String s){
		
		String[] attr = s.split(",");
		if(attr.length != 4)
			throw new IllegalArgumentException();
		
		checkCodigo(attr[0].trim());
		this.codigo = attr[0].trim();
		checkCuantiaTotal(Double.valueOf(attr[1].trim()));
		this.cuantiaTotal = Double.valueOf(attr[1].trim());
		checkDuracion(Integer.valueOf(attr[2].trim()));
		this.duracion = Integer.valueOf(attr[2].trim());
		this.tipo = TipoBeca.valueOf(attr[3].trim());
//		new BecaImpl(attr[0].trim(), Double.valueOf(attr[1].trim()), Integer.valueOf(attr[2].trim()), TipoBeca.valueOf(attr[3].trim()));
	}

	public int compareTo(Beca beca) {
		int res = 0;

		res = getCodigo().compareTo(beca.getCodigo());
		if (res == 0) {
			res = getTipo().compareTo(beca.getTipo());
		}
		return res;
	}

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof BecaImpl
				&& this.getCodigo() == ((BecaImpl) o).getCodigo()
				&& this.getTipo() == ((BecaImpl) o).getTipo()) {
			res = true;
		}

		return res;
	}

	public int hashCode() {
		return getCodigo().hashCode() + getTipo().hashCode() * 31;
	}

	private void checkCodigo(String codigo) {

		if (codigo.length() == 7) {

			for (int i = 0; i <= codigo.length() - 1; i++) {
				if (i <= 2) {
					if (!(Character.isAlphabetic(codigo.charAt(i)))) {
						throw new ExcepcionBecaNoValida(
								"El codigo de Beca no esta compuesto por 3 letras y 4 numeros1");
					}
				} else if (i >= 3) {
					if (!(Character.isDigit(codigo.charAt(i)))) {
						throw new ExcepcionBecaNoValida(
								"El codigo de Beca no esta compuesto por 3 letras y 4 numeros2");

					}
				}
			}
		} else {
			throw new ExcepcionBecaNoValida(
					"El codigo de Beca no esta compuesto por 3 letras y 4 numeros2");
		}
	}

	private void checkDuracion(Integer duracion) {
		if (duracion < 1) {
			throw new ExcepcionBecaNoValida("La duracion minima debe ser 1");
		}
	}

	private void checkCuantiaTotal(Double cuantiaTotal) {
		if (cuantiaTotal < CUANTIA_MINIMA) {
			throw new ExcepcionBecaNoValida("La duracion minima debe ser 1");
		}
	}

	public String toString() {
		return "[" + getCodigo() + ", " + getTipo() + "]";
	}

	public String getCodigo() {
		return codigo;
	}

	public Double getCuantiaTotal() {
		return cuantiaTotal;
	}

	public Integer getDuracion() {
		return duracion;
	}

	public TipoBeca getTipo() {
		return tipo;
	}

	public Double getCuantiaMensual() {

		double cuantiaMensual = getCuantiaTotal() / getDuracion();

		return cuantiaMensual;
	}

	public void setCuantiaTotal(Double cuantiaTotal) {
		checkCuantiaTotal(cuantiaTotal);
		this.cuantiaTotal = cuantiaTotal;
	}

	public void setDuracion(Integer duracion) {
		checkDuracion(duracion);
		this.duracion = duracion;
	}

}
