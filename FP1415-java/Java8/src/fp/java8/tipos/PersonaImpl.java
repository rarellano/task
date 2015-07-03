package fp.java8.tipos;


public class PersonaImpl implements Persona  {
	private String nombre, apellidos, dni;
	private TipoDeGenero genero;
	private Integer telefono1, telefono2;
//	private Set<Persona> personas;
	
	public PersonaImpl() {
		super();
	}
	
	public PersonaImpl(String nombre, String apellidos, String dni,
			Integer telefono1, Integer telefono2, TipoDeGenero genero) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.dni = dni;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.genero = genero;
		
	}
	
	public boolean equals(Object o){
		Boolean res = false;
		
		if(this == o && o != null && this.getDNI() == ((PersonaImpl) o).getDNI()){
			res = true;
		}
		
		return res;
	}
	
	public int hashCode(){
		return this.getTelefono1()*this.getTelefono2()*31;
	}
	
	public int compareTo(Object o){
		int res = getDNI().compareTo(((PersonaImpl) o).getDNI());
		return res;
	}
	
	public PersonaImpl clone(){
		
		PersonaImpl p = null;
		
		try{
			p=(PersonaImpl)super.clone();
		}catch(CloneNotSupportedException c){
			System.out.println(c.getMessage());
		}
		
		
		return p;
		
	}
	
	public String toString(){
		return this.getDNI() + " " + this.getNombre() + " " + this.getApellidos();
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getApellidos(){
		return this.apellidos;
	}

	public String getDNI(){
		return this.dni;
	}

	public TipoDeGenero getGenero(){
		return this.genero;
	}
	
	public Integer getTelefono1(){
		return this.telefono1;
	}
	
	public Integer getTelefono2(){
		return this.telefono2;
	}
	
	public void setNombre(String nombre){
		this.nombre = nombre;
	}
	
	public void setApellidos(String apellidos){
		this.apellidos = apellidos;
	}
	
	public void setDNI(String dni){
		this.dni = dni;
	}
	
	public void setGenero(TipoDeGenero genero){
		this.genero=genero;
	}

	public void setTelefono1(Integer telefono1) {
		this.telefono1=telefono1;
	}

	public void setTelefono2(Integer telefono2) {
		this.telefono2=telefono2;
	}
}
