package gallegoIzquierdoCristinaProyecto3Trimestre;


public class Capitulo {
	private int minutosDuracion;
	private int cantidadLenguajes;
	
	
	public Capitulo(int minutosDuracion, int cantidadLenguajes) {
		this.minutosDuracion = minutosDuracion;
		this.cantidadLenguajes = cantidadLenguajes;
	}

	public int getMinutosDuracion() {
		return minutosDuracion;
	}

	public void setMinutosDuracion(int minutosDuracion) {
		this.minutosDuracion = minutosDuracion;
	}

	public int getCantidadLenguajes() {
		return cantidadLenguajes;
	}

	public void setCantidadLenguajes(int cantidadLenguajes) {
		this.cantidadLenguajes = cantidadLenguajes;
	}
	
	public String textoAImprimir() 
	{
		String textoAImprimir = "MINUTOS DURACIÓN DEL CAPÍTULO: " +minutosDuracion + "\n"
				+ "CANTIDAD DE LENGUAJES DISPONIBLES: " +cantidadLenguajes;
		return textoAImprimir;
	}

	@Override
	public String toString() {
		return textoAImprimir();
	}
	
	

}
