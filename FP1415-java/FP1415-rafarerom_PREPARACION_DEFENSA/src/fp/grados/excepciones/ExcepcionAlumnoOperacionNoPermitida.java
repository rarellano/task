package fp.grados.excepciones;

public class ExcepcionAlumnoOperacionNoPermitida extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExcepcionAlumnoOperacionNoPermitida (){
		super();
	}
	
	public ExcepcionAlumnoOperacionNoPermitida (String error){
		super(error);
	}
	
}
