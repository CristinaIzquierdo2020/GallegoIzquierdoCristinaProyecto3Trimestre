package gallegoIzquierdoCristinaProyecto3Trimestre;

import java.util.ArrayList;

public class Temporada
{	
	public ArrayList<Capitulo> losCapitulos;
	private float notaTemporada; 
	private String nombreT;
	
		
	public Temporada(float notaTemporada, String nombreT) {
		losCapitulos = new ArrayList<Capitulo>();
		this.nombreT = nombreT;
		this.notaTemporada = notaTemporada;
	}

	public Temporada() {
	}

	public ArrayList<Capitulo> getLosCapitulos() {
		return losCapitulos;
	}
	
	
	public void setLosCapitulos(ArrayList<Capitulo> losCapitulos) {
		this.losCapitulos = losCapitulos;
	}
		
	
	public float getNotaTemporada() { 
		return notaTemporada;
	}
	
		
	public void setNotaTemporada(float notaTemporada) {
		this.notaTemporada = notaTemporada;
	}
	
	
	public String getNombre() {
		return nombreT;
	}


	public void setNombre(String nombreT) {
		this.nombreT = nombreT;
	}

		
	public void anyadirCapitulo(Capitulo numero) 
	{
		losCapitulos.add(numero);
	}
	
	public int numCapitulos() 
	{
		return losCapitulos.size();	
	}
	
	public boolean quitarCapitulo(Capitulo numero) 
	{
		return losCapitulos.remove(numero);
	}
	
	
	public String textoAImprimir() 
	{
		String textoAImprimir = "---------------- \n" +
				"NOMBRE DE LA TEMPORADA: " +nombreT + "\n"+
				"NOTA DE LA TEMPORADA: " +notaTemporada +"\n"
				+ losCapitulos.toString();
		return textoAImprimir;
	}
	
	@Override
	public String toString() {	
		return textoAImprimir();
					
	}
}
