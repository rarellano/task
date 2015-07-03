package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import fp.grados.excepciones.ExcepcionProfesorNoValido;
import fp.grados.excepciones.ExcepcionProfesorOperacionNoPermitida;

public class ProfesorImpl2 extends PersonaImpl implements Profesor {

	private Categoria categoria;
	private SortedSet<Tutoria> tutorias;
	private Departamento departamento;
	private Map<Asignatura, Double> creditosAsignatura;
	private final static Double CREDITOS_MAXIMO = 24.00;
	public ProfesorImpl2(String dni, String nombre, String apellidos,
			 LocalDate fechaNacimiento,String email, Categoria categoria,
			Departamento departamento) {

		super(dni, nombre, apellidos, fechaNacimiento, email);

		checkFechaNacimiento(fechaNacimiento);
		this.categoria = categoria;
		this.tutorias = new TreeSet<Tutoria>();
		setDepartamento(departamento);
		//		this.departamento = departamento;
		this.creditosAsignatura=new HashMap<Asignatura,Double>();

	}

	private void checkFechaNacimiento(LocalDate fechaNacimiento) {
		
		if (fechaNacimiento.compareTo(LocalDate.now().minusYears(18)) > 0) {
			throw new ExcepcionProfesorNoValido(
					"La edad del profesor debe ser mayor que 18");
		}
	}

	
	
	public String toString() {
		return super.toString() + " (" + getCategoria() + ")";
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public SortedSet<Tutoria> getTutorias() {
		return new TreeSet<Tutoria>(tutorias);
	}

	public void setCategoria(Categoria categoria) {

		this.categoria = categoria;
	}
	
	public void setFechaNacimiento(LocalDate fechaNacimiento){
		checkFechaNacimiento(fechaNacimiento);
		super.setFechaNacimiento(fechaNacimiento);
	}

	public void nuevaTutoria(LocalTime horaComienzo, Integer duracionMinutos,
			DayOfWeek dia) {

		TutoriaImpl t = new TutoriaImpl(dia, horaComienzo, duracionMinutos);
		tutorias.add(t);
	}

	public void borraTutoria(LocalTime horaComienzo, DayOfWeek dia) {

		for (Tutoria t : tutorias) {

			if (t.getHoraComienzo().equals(horaComienzo)
					&& t.getDiaSemana().equals(dia)) {
				this.tutorias.remove(t);
			}
		}
	}
	
	public Departamento getDepartamento(){
		return departamento;
	}
	
	public void setDepartamento(Departamento departamento){
		
		if(departamento != this.departamento){
		
			Departamento AntiguoDepartamento = getDepartamento();
			this.departamento=departamento;
			
			if(AntiguoDepartamento != null)
				AntiguoDepartamento.eliminaProfesor(this);
			
			if(departamento != null)
				departamento.nuevoProfesor(this);
		}
	}

	public void borraTutorias() {
		tutorias.clear();
	}

	public List<Asignatura> getAsignaturas() {
		return new LinkedList<Asignatura>(creditosAsignatura.keySet());
	}

	public List<Double> getCreditos() {
		return new LinkedList<Double>(creditosAsignatura.values());
	}

	public Double getDedicacionTotal() {
		
		Double res = 0.00;
		//MIRAR
		for (Double c: getCreditos()){
			res = res + c;
		}
		return res;
	}

//	public void imparteAsignatura(Asignatura asig, Double dedicacion) {
////		checkCreditos(dedicacion);
////		checkAsignatura(asig);
//		checkImparte(dedicacion, asig);
//		
//		if(this.asignaturas.contains(asig)){
//			this.creditos.add(this.asignaturas.indexOf(asig), dedicacion);
//		}else{
//			this.asignaturas.add(asig);
//			this.creditos.add(this.asignaturas.indexOf(asig), dedicacion);
//		}
//	}
	
	public void imparteAsignatura(Asignatura asig, Double dedicacion) {
		checkDedicacion(asig.getCreditos(), dedicacion);
		checkDepartamento(asig.getDepartamento());
		checkDedicacionTotal(getDedicacionTotal());
		this.creditosAsignatura.put(asig, dedicacion);
	}
		
	private void checkDepartamento(Departamento dptoProfe) {
		if(dptoProfe!=null  && !dptoProfe.equals(this.getDepartamento()))
			throw new ExcepcionProfesorOperacionNoPermitida();
	}

	private void checkDedicacion(Double creditos, Double dedicacion) {
		if(dedicacion>creditos)
			throw new ExcepcionProfesorOperacionNoPermitida();
	}

	private void checkDedicacionTotal (Double dedicacion){
		if(((this.getDedicacionTotal()+dedicacion)>CREDITOS_MAXIMO))
			throw new ExcepcionProfesorOperacionNoPermitida();
	}


//	private void checkImparte(Double dedicacion, Asignatura asig) {
//		if(dedicacion <= 0 && dedicacion <= asig.getCreditos()){
//			throw new ExcepcionProfesorOperacionNoPermitida("La dedicación debe ser mayor que 0 y menor que el numero de creditos de la asignatura");
//		}
//		if(this.getDepartamento() != asig.getDepartamento()){
//			throw new ExcepcionProfesorOperacionNoPermitida("El profesor pertenece a un departamento que no imparte esa asignatura");
//		}
//		if(getDedicacionTotal() + dedicacion > CREDITOS_MAXIMO){
//			throw new ExcepcionProfesorOperacionNoPermitida("Un profesor no puede tener mas de 24 Creditos");
//		}
//	}
//	
//	private void checkCreditos(Double dedicacion) {
//		if(dedicacion <= 0 && dedicacion <= asig.getCreditos()){
//			throw new ExcepcionProfesorOperacionNoPermitida("La dedicación debe ser mayor que 0 y menor que el numero de creditos de la asignatura");
//		}
//	}



//	private void checkAsignatura(Asignatura asig) {
//		if(this.getDepartamento() != asig.getDepartamento()){
//			throw new ExcepcionProfesorOperacionNoPermitida("El profesor pertenece a un departamento que no imparte esa asignatura");
//		}
//	}

	public Double dedicacionAsignatura(Asignatura asig) {
		Double res = 0.00;
		
		if(creditosAsignatura.containsKey(asig)){
					res = creditosAsignatura.get(asig);
		}		
		
		return res;
	}

	public void eliminaAsignatura(Asignatura asig) {
		if(creditosAsignatura.containsKey(asig))
			creditosAsignatura.remove(asig);
	}
}
