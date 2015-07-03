package fp.java8.tipos;

import java.util.ArrayList;
import java.util.List;

public class GrupoDeViajeImpl implements GrupoDeViaje {

	
	private Guia guia;
	private Viaje viaje;
	private List<Viajero> viajerosLista;
	
	public GrupoDeViajeImpl(){
		super();
		this.viajerosLista=new ArrayList<Viajero>();
	}
	
	public GrupoDeViajeImpl(Guia guia, Viaje viaje, List<Viajero> viajeros) {
		super();
		this.guia = guia;
		this.viaje = viaje;
		this.viajerosLista=viajeros;
	}
	
	public boolean equals(Object o){
		boolean res = false;
		
		if (this == o && o != null
				&& this.getGuia() == ((GrupoDeViajeImpl) o).getGuia()
				&& this.getViaje() == ((GrupoDeViajeImpl) o).getViaje()){
			res = true;
		}
		
		return res;
	}
	
	public String toString(){
		return getGuia().toString() + " " + getViaje().toString();
	}
	
	@Override
	public Guia getGuia() {
		return guia;
	}

	@Override
	public Viaje getViaje() {
		return viaje;
	}

	@Override
	public void setGuia(Guia guia) {
		this.guia = guia;
	}

	@Override
	public List<Viajero> getLista() {
		// TODO Auto-generated method stub
		return viajerosLista;
	}

	@Override
	public void setLista(List<Viajero> viajeros) {
		this.viajerosLista=viajeros;
	}
	public Boolean addViajero(Viajero viajero){
		
		Boolean res = false;
		
		if(viajero!=null){
			viajerosLista.add(viajero);
		}
		
		
		return res;
	}

	public Boolean removeViajero(Viajero viajero){
		
		Boolean res = false;
		
		if(viajero!=null){
			viajerosLista.remove(viajero);
		}
		
		
		return res;
	}
	
	public List<Viajero> addPersonas(List<Persona> listP){
		
		
		for(Persona a: listP){
			if(a != null){
				ViajeroImpl viajero = new ViajeroImpl(a.getNombre(), a.getApellidos(), a.getDNI(), a.getTelefono1(), a.getTelefono2(), a.getGenero(), TipoDeViajero.TURISTA);
				addViajero( viajero);
			}
		}
		System.out.println(getLista());
		
		return getLista();
	}
	
	public List<Viajero> removeViajeros(List<Viajero> listV){
		
		for(Viajero a: listV){
			if(getLista().contains(a)){
				System.out.println("He entrado");
				getLista().remove(a);
			}
//			for(Viajero g: viajerosLista){
//				if(a.equals(g)){
//					removeViajero(a);
//				}
//			}
		}
		
		return getLista();
	}
	
}