package fp.grados.tipos.test;

import fp.grados.excepciones.ExcepcionPersonaNoValida;

public class TestDni {

	public static void main(String[] args) {
		
		String dni = "47343391F";
		
		checkDni(dni);
		
		System.out.println(dni);
		
		
	}
	
	private static void checkDni(String dni) {
		String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
		Integer numeroDNI = new Integer(dni.substring(0, 8));

		if (dni.length() == 9) {

			for (int i = 0; i <= dni.length() -1; i++) {
				if (i <= 7) {
					System.out.println(Character.isDigit(dni.charAt(i)));
					if (!(Character.isDigit(dni.charAt(i)))) {
						System.out.println(dni.charAt(i));
						throw new ExcepcionPersonaNoValida(
								"El Dni de la persona debe estar compuesto por 8 digitos y una letra");
					}
				} else {
					System.out.println(Character.isDigit(dni.charAt(i)));
					if (!(Character.isLetter(dni.charAt(8)))) {
						throw new ExcepcionPersonaNoValida(
								"El Dni de la persona debe estar compuesto por 8 digitos y una letra");

					}
				}
			}

			if ((dni.charAt(8) != letras.charAt(numeroDNI % 23))) {
				throw new ExcepcionPersonaNoValida(
						"El Dni de la persona debe estar compuesto por 8 digitos y una letra");
			}

		} else {
			throw new ExcepcionPersonaNoValida(
					"El Dni de la persona debe estar compuesto por 8 digitos y una letra");

		}
	}

}
