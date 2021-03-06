package fp.grados.tipos;

import fp.grados.excepciones.ExcepcionNotaNoValida;

public final class NotaInmutableImpl implements Nota {

	private final Asignatura asignatura;
	private final Integer cursoAcademico;
	private final Double valor;
	private final Convocatoria convocatoria;
	private final Boolean mencionHonor;

	public NotaInmutableImpl(Asignatura asignatura, Integer cursoAcademico,
			Convocatoria convocatoria, Double valor, Boolean mencionHonor) {

		this.asignatura = new AsignaturaImpl(asignatura.getNombre(),
				asignatura.getCodigo(), asignatura.getCreditos(),
				asignatura.getTipo(), asignatura.getCurso(),
				asignatura.getDepartamento());
		this.cursoAcademico = cursoAcademico;
		checkValor(valor);
		this.valor = valor;
		this.convocatoria = convocatoria;
		checkMencionHonor(mencionHonor);
		this.mencionHonor = mencionHonor;

	}

	public NotaInmutableImpl(Asignatura asignatura, Integer cursoAcademico,
			Convocatoria convocatoria, Double valor) {

		this.asignatura = new AsignaturaImpl(asignatura.getNombre(),
				asignatura.getCodigo(), asignatura.getCreditos(),
				asignatura.getTipo(), asignatura.getCurso(),
				asignatura.getDepartamento());
		this.cursoAcademico = cursoAcademico;
		checkValor(valor);
		this.valor = valor;
		this.convocatoria = convocatoria;
		this.mencionHonor = false;

	}

	public NotaInmutableImpl(String s) {

		String[] attr = s.split(";");

		if (attr.length != 5)
			throw new IllegalArgumentException();

		this.asignatura = new AsignaturaImpl(attr[0]);

		this.cursoAcademico = Integer.parseInt(attr[1].trim());
		this.convocatoria = Convocatoria.valueOf(attr[2].trim());
		checkValor(Double.valueOf(attr[3].trim()));
		this.valor = Double.valueOf(attr[3].trim());
		checkMencionHonor(Boolean.valueOf(attr[4].trim()));
		this.mencionHonor = Boolean.valueOf(attr[4].trim());
	}

	public int compareTo(Nota o) {
		int res = getCursoAcademico().compareTo(o.getCursoAcademico());
		if (res == 0) {
			res = asignatura.compareTo(o.getAsignatura());
		}
		if (res == 0) {
			res = getConvocatoria().compareTo(o.getConvocatoria());
		}
		return res;
	}

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Nota
				&& this.getCursoAcademico().equals(
						((NotaInmutableImpl) o).getCursoAcademico())
				&& this.getAsignatura().equals(
						((NotaInmutableImpl) o).getAsignatura())
				&& this.getConvocatoria().equals(
						((NotaInmutableImpl) o).getConvocatoria())) {
			res = true;
		}

		return res;
	}

	public int hashCode() {
		return getCursoAcademico().hashCode() + getAsignatura().hashCode() * 31
				+ getConvocatoria().hashCode() * 31;
	}

	private void checkMencionHonor(Boolean mencionHonor) {
		if ((valor < 9 && mencionHonor == true)) {
			throw new ExcepcionNotaNoValida(
					"Para obtener una mencion de honor se necesita tener una nota mayor o igual a 9");
		}
	}

	private void checkValor(Double valor) {
		if (!(valor >= 0.00) || !(valor <= 10.00)) {
			throw new ExcepcionNotaNoValida(
					"El valor numérico de la nota debe estar comprendido entre 0 y 10 ambos inclusibe");
		}
	}

	public String toString() {

		String num = Integer.toString(getCursoAcademico() + 1);
		String cursoAc = num.toString().substring(2, 4);
		// int cursoAc = getCursoAcademico() % 1000 +1;
		return getAsignatura() + ", " + getCursoAcademico() + "-" + cursoAc
				+ ", " + getConvocatoria() + ", " + getValor() + ", "
				+ getCalificacion();

		// String abrev = Integer.toString(getCursoAcademico()+1);
		// String fin = abrev.substring(abrev.length() -2, abrev.length());
		// String fin2 = getCursoAcademico() + "-" + fin;
		// String s = getAsignatura() + ","
		// +fin2+","+getConvocatoria()+","+getValor()+","+getCalificacion();
		//
		// return s;

	}

	public Asignatura getAsignatura() {
		return new AsignaturaImpl(this.asignatura.getNombre(),
				this.asignatura.getCodigo(), this.asignatura.getCreditos(),
				this.asignatura.getTipo(), this.asignatura.getCurso(),
				this.asignatura.getDepartamento());
	}

	public Integer getCursoAcademico() {
		return cursoAcademico;
	}

	public Convocatoria getConvocatoria() {
		return convocatoria;
	}

	public Double getValor() {
		return valor;
	}

	public Boolean getMencionHonor() {
		return mencionHonor;
	}

	public Calificacion getCalificacion() {

		Calificacion calificacion = null;
		if (getValor() < 5) {
			calificacion = Calificacion.SUSPENSO;
		} else if (getValor() >= 5 && getValor() < 6) {
			calificacion = Calificacion.APROBADO;
		} else if (getValor() >= 6 && getValor() < 7) {
			calificacion = Calificacion.BIEN;
		} else if (getValor() >= 7 && getValor() < 9) {
			calificacion = Calificacion.NOTABLE;
		} else if (getValor() >= 9 && getMencionHonor() == false) {
			calificacion = Calificacion.SOBRESALIENTE;
		} else if (getValor() >= 9 && getMencionHonor() == true) {
			calificacion = Calificacion.MATRICULA_DE_HONOR;
		}
		return calificacion;
	}

}
