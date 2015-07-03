package fp.grados.tipos;
import java.util.List;

public interface Expediente {

	public List<Nota> getNotas();

	public Double getNotaMedia();

	public void nuevaNota(Nota n);
	
	public List<Nota> getNotasOrdenadasPorAsignatura();

	public Nota getMejorNota();
	
}
