package fp.grados.tipos;

import com.google.common.base.CaseFormat;

import fp.grados.excepciones.ExcepcionAsignaturaNoValida;

public class AsignaturaImpl implements Asignatura {

	private String nombre;
	private String codigo;
	private Departamento departamento;
	private Double creditos;
	private Integer curso;
	private TipoAsignatura tipo;

	public AsignaturaImpl(String nombre, String codigo, Double creditos,
			TipoAsignatura tipo, Integer curso, Departamento departamento) {

		checkCodigo(codigo);
		checkCreditos(creditos);
		checkCurso(curso);

		this.nombre = nombre;
		this.codigo = codigo;
//		 this.departamento = departamento;
		this.creditos = creditos;
		this.curso = curso;
		this.tipo = tipo;
		setDepartamento(departamento);
	}

	public AsignaturaImpl(String s) {

		String attr[] = s.split("#");

		if (attr.length != 5)
			throw new IllegalArgumentException();

		this.nombre = attr[0].trim();

		checkCodigo(attr[1].trim());
		this.codigo = attr[1].trim();

		checkCreditos(Double.valueOf(attr[2].trim()));
		this.creditos = Double.valueOf(attr[2].trim());
		this.tipo = TipoAsignatura.valueOf(attr[3].trim());

		checkCurso(Integer.valueOf(attr[4].trim()));
		this.curso = Integer.valueOf(attr[4].trim());

	}

	private void checkCurso(Integer curso) {
		if (curso < 1 || curso > 4) {
			throw new ExcepcionAsignaturaNoValida(
					"La asignatura debe pertenecer a un curso mayor que 0 y menor que 4");
		}

	}

	public int compareTo(Asignatura asig) {

		return getCodigo().compareTo(asig.getCodigo());
	}

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof AsignaturaImpl
				&& this.getCodigo().equals(((AsignaturaImpl) o).getCodigo())) {
			res = true;
		}

		return res;
	}

	public int hashCode() {
		return getCodigo().hashCode();
	}

	private void checkCreditos(Double creditos) {
		if (creditos <= 0.00) {
			throw new ExcepcionAsignaturaNoValida(
					"La asignatura debe tener mas de 0 créditos");
		}

	}

	private void checkCodigo(String codigo) {
		if (codigo.length() != 7) {
			throw new ExcepcionAsignaturaNoValida(
					"La asignatura tiene un codigo distinto de 7 digitos");
		}

		for (int i = 0; i != 7; i++) {
			if (!(Character.isDigit(codigo.charAt(i)))) {
				throw new ExcepcionAsignaturaNoValida(
						"La asignatura tiene un codigo distinto de 7 digitos");
			}
		}

	}

	public String toString() {
		return "(" + getCodigo() + ") " + getNombre();

	}

	public String getNombre() {
		return nombre;
	}

	public String getAcronimo() {
		String acronimo = "";
		for (int i = 0; i < nombre.length(); i++) {
			if (Character.isUpperCase(nombre.charAt(i)))
				acronimo = acronimo + nombre.charAt(i);
		}
		return acronimo;
	}

	public String getCodigo() {
		return codigo;
	}

	public Double getCreditos() {
		return creditos;
	}

	public TipoAsignatura getTipo() {
		return tipo;
	}

	public Integer getCurso() {
		return curso;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento nuevoDepartamento) {
		if (nuevoDepartamento != this.departamento) {
			Departamento antiguoDepartamento = this.departamento;
			this.departamento = nuevoDepartamento;
			if (antiguoDepartamento != null) {
				antiguoDepartamento.eliminaAsignatura(this);
			}
			if (nuevoDepartamento != null) {
				nuevoDepartamento.nuevaAsignatura(this);
			}
		}
	}

}
