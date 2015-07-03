import java.util.function.Function;
import java.util.function.Predicate;


public class main {

	public static void main(String[] args) {
		Predicate<Libro> libro = libro -> libro.getPrcio().compareTo(9.90)>0; 
		Predicate<Libro> prepB = libro -> libro.getNumeroPaginas().compareTo(100)>=0;
		String nombreDado = "John";
		Predicate<Libro> predC = libro -> libro.getAutor().startsWith(nombreDado);
		Predicate<Libro> predD = libro -> conjLibroDado.contains(libro);
		
		
	}

}
