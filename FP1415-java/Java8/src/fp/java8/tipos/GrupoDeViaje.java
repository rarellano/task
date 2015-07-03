package fp.java8.tipos;

import java.util.List;



public interface GrupoDeViaje {

	public Guia getGuia();
	public Viaje getViaje();
	public List<Viajero> getLista();
	
	public void setGuia(Guia guia);
	public void setLista(List<Viajero> viajeros);
	
	public Boolean addViajero(Viajero viajero);
	public Boolean removeViajero(Viajero viajero);
	
	public List<Viajero> addPersonas(List<Persona> listP);
	
}
