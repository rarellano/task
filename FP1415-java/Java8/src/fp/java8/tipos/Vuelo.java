package fp.java8.tipos;

import java.time.LocalDate;
import java.util.List;

public interface Vuelo extends Comparable<Vuelo> {
	String getCodigo();

	String getOrigen();

	String getDestino();

	void setDestino(String destino);

	LocalDate getFechaSalida();

	void setFechaSalida(LocalDate fsal);

	LocalDate getFechaLlegada();

	void setFechaLlegada(LocalDate flleg);

	Integer getNumPlazas();

	Integer getNumPasajeros();

	List<Viajero> getViajero();
}