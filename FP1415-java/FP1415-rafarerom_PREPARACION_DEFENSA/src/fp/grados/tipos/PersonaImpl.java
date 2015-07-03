package fp.grados.tipos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import fp.grados.excepciones.ExcepcionPersonaNoValida;

public class PersonaImpl implements Persona {

	private String dni, nombre, apellidos, email;
	private LocalDate fechaNacimiento;

	public PersonaImpl(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento, String email) {
		checkDni(dni);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		checkEmail(email);
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}

	public PersonaImpl(String s){
		
		if(s == null || s == ""){
			throw new IllegalArgumentException("La cadena es nula o esta vacia");
		}
		
		String[] attr = s.split(",");
		
		if(attr.length != 5)
			throw new IllegalArgumentException();
		checkDni(attr[0].trim());
		this.dni=attr[0].trim();
		this.nombre=attr[1].trim();
		this.apellidos=attr[2].trim();
		String[] f= attr[3].split("/");
		this.fechaNacimiento=LocalDate.of(Integer.parseInt(f[2].trim()),Integer.parseInt(f[1].trim()),Integer.parseInt(f[0].trim()));
		checkEmail(attr[4].trim());
		this.email=attr[4].trim();
		
		
	}
	
	private void checkEmail(String email) {
		if (!email.contains("@") && !(email.isEmpty())) {
			throw new ExcepcionPersonaNoValida(
					"El Dni de la persona debe estar compuesto por 8 digitos y una letra");
		}

	}

	public PersonaImpl(String dni, String nombre, String apellidos,
			LocalDate fechaNacimiento) {
		checkDni(dni);
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.email = "";
		this.fechaNacimiento = fechaNacimiento;
	}

	public int compareTo(Persona o) {
		int res = 0;

		res = getApellidos().compareTo(o.getApellidos());
		if (res == 0) {
			res = getNombre().compareTo(o.getNombre());
		}
		if (res == 0) {
			res = getDNI().compareTo(o.getDNI());
		}
		return res;
	}

	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof PersonaImpl
				&& this.getDNI().equals(((PersonaImpl) o).getDNI())
				&& this.getNombre().equals(((PersonaImpl) o).getNombre())
				&& this.getApellidos().equals(((PersonaImpl) o).getApellidos())) {
			res = true;
		}

		return res;
	}

	public int hashCode() {
		return getDNI().hashCode() * 31 + getNombre().hashCode() * 31
				+ getApellidos().hashCode() * 31;
	}

	private void checkDni(String dni) {

		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";

		if (dni.length() == 9) {

			for (int i = 0; i <= dni.length() - 1; i++) {
				if (i <= 7) {

					if (!(Character.isDigit(dni.charAt(i)))) {
						System.out.println(dni.charAt(i));
						throw new ExcepcionPersonaNoValida(
								"El Dni de la persona debe estar compuesto por 8 digitos y una letra");
					}
				} else {
					if (!(Character.isLetter(dni.charAt(8)))) {
						throw new ExcepcionPersonaNoValida(
								"El Dni de la persona debe estar compuesto por 8 digitos y una letra");

					}
				}
			}

			Integer numeroDNI = new Integer(dni.substring(0, 8));

			if ((dni.charAt(8) != letras.charAt(numeroDNI % 23))) {
				throw new ExcepcionPersonaNoValida(
						"El Dni de la persona debe estar compuesto por 8 digitos y una letra");
			}

		} else {
			throw new ExcepcionPersonaNoValida(
					"El Dni de la persona debe estar compuesto por 8 digitos y una letra");
		}

	}

	public String toString() {
		return getDNI()
				+ " - "
				+ getApellidos()
				+ ", "
				+ getNombre()
				+ " - "
				+ getFechaNacimiento().format(
						DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String getDNI() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public String getEmail() {
		return email;
	}

	public Integer getEdad() {
		return (int) getFechaNacimiento().until(LocalDate.now(), ChronoUnit.YEARS);

	}

	public void setDNI(String dni) {
		checkDni(dni);
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public void setEmail(String email) {
		checkEmail(email);
		this.email = email;
	}

}
