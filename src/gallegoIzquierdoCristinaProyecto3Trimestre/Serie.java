package gallegoIzquierdoCristinaProyecto3Trimestre;

import java.util.ArrayList;

public class Serie
{			
	public ArrayList<Temporada> todasTemporadas;
	private String nombre;
	private int anyoEstreno;
	
	
	public Serie(String nombre, int anyoEstreno) {
		todasTemporadas = new ArrayList<Temporada>();
		this.nombre = nombre;
		this.anyoEstreno = anyoEstreno;
	}

	public Serie() {
	
	}
	

	public ArrayList<Temporada> getTodasTemporadas() {
		return todasTemporadas;
	}


	public void setTodasTemporadas(ArrayList<Temporada> todasTemporadas) {
		this.todasTemporadas = todasTemporadas;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getAnyoEstreno() {
		return anyoEstreno;
	}


	public void setAnyoEstreno(int anyoEstreno) {
		this.anyoEstreno = anyoEstreno;
	}
	
	public void anyadirTemporada(Temporada numero) 
	{
		todasTemporadas.add(numero);
	}
	
	public boolean quitarTemporada(String numero) 
	{
		return todasTemporadas.remove(numero);
	}
	
	public int numeroTemporadas() 
	{
		return todasTemporadas.size();
	}
	
	public String textoAImprimir() 
	{
		
		String textoImprimir = "***************** VISUALIZACIÓN DE DATOS *****************\n" + 
				"NOMBRE DE LA SERIE: " +nombre + "\n" + 
				"AÑO DE ESTRENO: " +anyoEstreno + "\n" + 
				todasTemporadas.toString();
		
		return textoImprimir;
	}
	
	
	@Override
	public String toString() {
		return textoAImprimir();
	}
	
}
