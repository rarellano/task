package fp.grados.tipos;

public interface Nota extends Comparable<Nota> {

	public Asignatura getAsignatura();
	public Integer getCursoAcademico();
	public Convocatoria getConvocatoria();
	public Double getValor();
	public Boolean getMencionHonor();
	public Calificacion getCalificacion();
		

}
