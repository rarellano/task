package fp.grados.tipos;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import fp.grados.excepciones.ExcepcionTutoriaNoValida;

public class TutoriaImpl implements Tutoria {

	private DayOfWeek dia;

	private LocalTime horaComienzo;
	private LocalTime horaFin;


	public TutoriaImpl(DayOfWeek dia, LocalTime horaComienzo, LocalTime horaFin) {
		checkDia(dia);
		this.dia = dia;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaFin;		
		checkDuracion2(horaComienzo, horaFin);

	}
	
	public TutoriaImpl(DayOfWeek dia, LocalTime horaComienzo, Integer duracion) {
		checkDia(dia);
		checkDuracion(duracion);
		this.dia = dia;
		this.horaComienzo = horaComienzo;
		this.horaFin = horaComienzo.plusMinutes(duracion);
		checkDuracion2(horaComienzo, horaFin);
	}
	
	public TutoriaImpl(String s){
		String[] attr = s.split(",");
		if(attr.length!=3){
			throw new IllegalArgumentException("TutoriaImpl.TutoriaImpl: Error en el numero de trozos.");
		}
		switch (attr[0].trim().charAt(0)){
		case 'L':
			this.dia = DayOfWeek.MONDAY;
			break;
		case 'M':
			this.dia = DayOfWeek.TUESDAY;
			break;
		case 'X':
			this.dia = DayOfWeek.WEDNESDAY;
			break;
		case 'J':
			this.dia = DayOfWeek.THURSDAY;
			break;
		case 'V':
			this.dia = DayOfWeek.FRIDAY;
			break;
		case 'S':
			this.dia = DayOfWeek.SATURDAY;
			break;
		default:
			this.dia = DayOfWeek.SUNDAY;
			
		}
		
		checkDia(dia);
		this.horaComienzo = LocalTime.parse(attr[1].trim());
		this.horaFin = LocalTime.parse(attr[2].trim());
		checkDuracion2(horaComienzo, horaFin);

	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof TutoriaImpl
				&& getDiaSemana().equals(((TutoriaImpl) o).getDiaSemana())
				&& getHoraComienzo().equals(((TutoriaImpl) o).getHoraComienzo())) {
			res = true;
		}

		return res;
	}

	public int hashCode() {
		return getDiaSemana().hashCode() + getHoraComienzo().hashCode() * 31;
	}

	public int compareTo(Tutoria o) {
		int res = getDiaSemana().compareTo(o.getDiaSemana());
		

		if (res == 0) {
			res = getHoraComienzo().compareTo(o.getHoraComienzo());
		}

		return res;

	}


	private void checkDuracion(Integer duracion) {
		if (!(duracion >= 15)) {
			throw new ExcepcionTutoriaNoValida(
					"La duración de una tutoria debe ser de al menos 15 minutos");
		}
	}

	private void checkDuracion2(LocalTime horaComienzo, LocalTime horaFin) {

		Integer duracion = horaFin.getMinute() - horaComienzo.getMinute()
				+ (horaFin.getHour() - horaComienzo.getHour()) * 60;

		if (duracion < 15) {
			
			throw new ExcepcionTutoriaNoValida(
					"La duración de una tutoria debe ser de al menos 15 minutos");
		}
	}

	private void checkDia(DayOfWeek dia) {
		if (dia == DayOfWeek.SUNDAY || dia == DayOfWeek.SATURDAY) {
			throw new ExcepcionTutoriaNoValida(
					"Los dias de tutoria son de Lunes a Viernes");
		}
	}

	public String toString() {
		return esDia() + " " + getHoraComienzo() + "-" + getHoraFin();
	}

	public DayOfWeek getDiaSemana() {

		return dia;
	}

	public LocalTime getHoraComienzo() {
		return horaComienzo;
	}

	public LocalTime getHoraFin() {

		if (horaFin == null) {
			horaFin = getHoraComienzo().plusMinutes(getDuracion());
		}

		return horaFin;
	}

	public Integer getDuracion() {

		return horaFin.getMinute() - horaComienzo.getMinute()
				+ (horaFin.getHour() - horaComienzo.getHour()) * 60;
	}

	public String esDia() {

		String diaSemana= "";
		switch (getDiaSemana()) {
		case MONDAY:
			diaSemana = "L";
			break;
		case TUESDAY:
			diaSemana = "M";
			break;
		case WEDNESDAY:
			diaSemana = "X";
			break;
		case THURSDAY:
			diaSemana = "J";
			break;
		case FRIDAY:
			diaSemana = "V";
			break;
		default:
			break;
		}

		return diaSemana;

	}

	

}
