package fp.grados.tipos;

import java.time.LocalDate;

import fp.grados.excepciones.ExcepcionBecarioNoValido;

public class BecarioImpl extends AlumnoImpl implements Becario {

	private Beca beca;
	private LocalDate fechaComienzo;

	public BecarioImpl(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento, String email, Beca beca, LocalDate fechaComienzo) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		this.beca = beca;
		checkFechaComienzo(fechaComienzo);
		this.fechaComienzo = fechaComienzo;
	}

	public BecarioImpl(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento, String email, String codigo, Double cuantiaTotal, 
			Integer duracion,TipoBeca tipo,LocalDate fechaComienzo) {
		
		super(dni, nombre, apellidos, fechaNacimiento, email);
		
		this.beca = new BecaImpl(codigo, cuantiaTotal, duracion,tipo);
		checkFechaComienzo(fechaComienzo);
		this.fechaComienzo = fechaComienzo;

	}

	private void checkFechaComienzo(LocalDate fechaComienzo) {
		if (LocalDate.now().isAfter(fechaComienzo) || LocalDate.now().equals(fechaComienzo)) {
			throw new ExcepcionBecarioNoValido(
					"La fecha de comienzo debe ser posterior a la fecha actual");
		}
	}

	public String toString() {
		return super.toString() + " " + beca.toString();
	}

	public Beca getBeca() {
		return beca;
	}

	public LocalDate getFechaComienzo() {
		return fechaComienzo;
	}

	public LocalDate getFechaFin() {
		return getFechaComienzo().plusMonths(beca.getDuracion());
	}

	public void setFechaComienzo(LocalDate fechaDeComienzo) {
		checkFechaComienzo(fechaDeComienzo);
		this.fechaComienzo = fechaDeComienzo;

	}

	public void setEmail(String email) {
		throw new UnsupportedOperationException(
				"La modificacion del email no esta permitida para los becarios");
	}

}
