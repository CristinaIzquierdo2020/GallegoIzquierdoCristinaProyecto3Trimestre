package gallegoIzquierdoCristinaProyecto3Trimestre;

import java.util.ArrayList;
import java.util.Scanner;
//comienzo del MAIN
public class Main {

	public static void main(String[] args) {
		
		//Se crea una arrayList de Serie con el constructor vacio
		ArrayList<Serie> todasSeries = new ArrayList<Serie>();
	
		boolean salir = false;
		while(!salir) 
		{
			int opcion = menu(); // menu en otro método abajo
			switch (opcion)
			{
			
			case 1: todasSeries.add(insertarElementos()); 
				break;
				
			case 2: buscador(todasSeries); 
				break;
			
			case 3: mostrarDatos(todasSeries); 
				break;
			
			 case 4: borrarSerie(todasSeries);
				break; 
				
			case 5: modificarDatos(todasSeries);
			 	break;
			 			
			case 0: salir=true;
				break;
			}
		}
	
	} // fin del MAIN
	
	//comienza el MENU
	public static int menu() 
	{
						
		System.out.println("*************************************");
		System.out.println("Elige una opción: ");
		System.out.println("1 - Insertar elementos");
		System.out.println("2 - Buscador");
		System.out.println("3 - Mostrar datos");
		System.out.println("4 - Borrar serie"); 
		System.out.println("5 - Modificar datos");
		System.out.println("0 - Salir ");
		int opcion = Leer.pedirEnteroValidar();
		return opcion;
		
	} // fin del MENU
	
	//comienza INSERTAR_ELEMENTOS
	public static Serie insertarElementos() 
	{
		System.out.println("---------------- Crear una *SERIE* ----------------");
		
		System.out.println("Nombre de la serie (string)" );
		String nombre = Leer.pedirCadena();
		
		System.out.println("En que anyo se estreno (int)" );
		int anyoEstreno = Leer.pedirEnteroValidar();
		
		System.out.println("Cuantas temporadas tiene la serie: (int)");
		int numero = Leer.pedirEnteroValidar();
		
		Serie unaSerie = new Serie(nombre, anyoEstreno); //se crea unaSerie
				
		for(int x = 0; x < numero; x++) 
		{
			System.out.println("---------------- Crear una *TEMPORADA* ----------------");
			
			System.out.println("Que nota le dan las criticas (double)" );
			float notaTemporada = Leer.pedirFloat();
			
			System.out.println("Nombre de la temporada (String)" );
			String nombreT = Leer.pedirCadena();
			
			System.out.println("Cuantos capitulos meter en la temporada");
			int numero2 = Leer.pedirEnteroValidar();
			
			Temporada unaTemporada = new Temporada(notaTemporada, nombreT); //se crea unaTemporada
			
			
			for(int i = 0; i < numero2; i++) 
			{
				System.out.println("---------------- Crear un *CAPITULO* ----------------");
				
				System.out.println("Cuanto es la duracion en minutos (int)");
				int minutosDuracion = Leer.pedirEnteroValidar();
				
				System.out.println("En cuantos lenguajes esta disponible (int)");
				int cantidadLenguajes = Leer.pedirEnteroValidar();
				
				Capitulo unCapitulo = new Capitulo(minutosDuracion, cantidadLenguajes); //se crea unCapitulo
				unaTemporada.anyadirCapitulo(unCapitulo); //se utiliza anyadirCapitulo de la clase Temporada con unCapitulo
				
			}
				unaSerie.anyadirTemporada(unaTemporada); // se utiliza anyadirTemporada de la clase Serie con unaTemporada
		}	
		return unaSerie;
	}// termina INSERTAR_ELEMENTOS

	//comienza MOSTRAR_DATOS
	public static void mostrarDatos(ArrayList<Serie>laSerie) 
	{
		System.out.println(laSerie.toString()); //llama al toString de Serie (que a su vez imprime Temporada y Serie)
	}// termina MOSTRAR_DATOS
	
	//comienza BUSCADOR
	public static void buscador(ArrayList<Serie>laSerie) 
	{
		
		System.out.println("Que quieres buscar");
		
		int opcion; 
	
			System.out.println("1 - Buscar por nombre de serie");
			System.out.println("2 - Buscar por nota de temporada");
			System.out.println("3 - Buscar por cantidad de lenguajes en los capitulos");
			System.out.println("0 - Volver ");
			opcion = Leer.pedirEnteroValidar();
		
		switch(opcion) 
		{
		case 1: 
			System.out.println("Introduce el nombre de la serie a buscar: ");
			String nombreSerie = Leer.pedirCadena();
		
			for(int x =0; x < laSerie.size(); x++) 
			{
				Serie unaSerie = laSerie.get(x);
				if(unaSerie.getNombre().contentEquals(nombreSerie)) 
				{
					System.out.println(unaSerie.toString());
				}
			}
			
			break;
			
		case 2: System.out.println("Introduce la nota de la temporada a buscar: ");
				float notaTemporada = Leer.pedirFloat();
				
				float notaT;
				
				for(int x =0; x < laSerie.size(); x++) 
				{ 
					Serie unaSerie = laSerie.get(x);
					for(Temporada laTemporada: unaSerie.getTodasTemporadas())  
					{
						notaT = laTemporada.getNotaTemporada(); 
						if(notaT == notaTemporada)	
						{
							System.out.println(laTemporada.toString());
						} 
						
						else System.out.println("No encontrado en más temporadas");
					}
				}
			
			break;
			
			
		case 3: System.out.println("Introduce la cantidad de lenguajes a buscar disponibles para un capítulo: ");
				int cantidadLenguajes = Leer.pedirEnteroValidar();
				
				int cantidadL;
				
				for(int x=0; x<laSerie.size(); x++) 
				{
					Serie unaSerie = laSerie.get(x);
					for(Temporada laTemporada: unaSerie.getTodasTemporadas()) 
					{
						for(Capitulo elCapitulo: laTemporada.getLosCapitulos()) 
						{
							cantidadL = elCapitulo.getCantidadLenguajes();
							if(cantidadL == cantidadLenguajes) 
							{
								System.out.println(elCapitulo.toString());
							}else System.out.println("No encontrado en mas capitulos");
						}
					}
				}
			break;
			
		} //fin del switch
		
	} //termina BUSCADOR
	
	//comienza BORRAR_SERIE
	public static void borrarSerie(ArrayList<Serie>laSerie) 
	{
		System.out.println("Nombre de la serie a borrar: ");
		String serieB =Leer.pedirCadena(); 
	
		for(int x= 0; x<laSerie.size(); x++) {
			Serie unaSerie = laSerie.get(x); //recoge la posicion de la x en el for
			if(unaSerie.getNombre().contentEquals(serieB)) { //la compara con el nombre y el nombre introducido por el usuario
				laSerie.remove(x); 
				System.out.println("Eliminado con exito. Gracias :)");
			} else System.out.println("No se ha encontrado la serie que coincida, lo sentimos.");
		}
	} //termina BORRAR_SERIE
	
	
	//comienza MODIFICAR_DATOS
	public static void modificarDatos(ArrayList<Serie>laSerie) 
	{
		System.out.println("Qué dato quieres modificar: ");
		
		System.out.println("1 - Modificar nombre de Serie ");
		System.out.println("2 - Modificar anyo de estreno de una Serie "); 
		System.out.println("3 - Modificar nota de temporada de una Temporada ");
		System.out.println("0 - Volver");
		int opcion = Leer.pedirEnteroValidar();
		
			switch(opcion) 
			{
				case 1: System.out.println("---------------- MODIFICANDO NOMBRE DE *SERIE* ----------------");
				System.out.println("Nombre de la serie a modificar: ");
				String nombre = Leer.pedirCadena();
				
				for(int x =0; x < laSerie.size(); x++) 
				{
					Serie unaSerie = laSerie.get(x);
					if(unaSerie.getNombre().contentEquals(nombre)) 
					{
						System.out.println("Nombre nuevo: ");
						String nuevoNombre = Leer.pedirCadena();
						
						unaSerie.setNombre(nuevoNombre);
						System.out.println("Nombre cambiado correctamente. ");
					}else System.out.println("El nombre no se ha podido cambiar.");
				}
				break;
				
				case 2:
					System.out.println("---------------- MODIFICANDO ANYO DE ESTRENO DE *SERIE* ----------------");
					System.out.println("Escribe la serie a modificar: ");
					String nombre1 = Leer.pedirCadena();
					
					for(int x =0; x < laSerie.size(); x++) 
					{
						Serie unaSerie = laSerie.get(x);
						if(unaSerie.getNombre().contentEquals(nombre1)) 
						{
							System.out.println("Anyo nuevo: ");
							int nuevoAnyo = Leer.pedirEnteroValidar();
							
							unaSerie.setAnyoEstreno(nuevoAnyo);
							System.out.println("Anyo cambiado correctamente. ");
						}else System.out.println("El anyo no se ha podido cambiar.");
					}
					break;
				case 3:
					System.out.println("---------------- MODIFICANDO NOTA DE *TEMPORADA* ----------------");
					System.out.println("Escribe la serie a modificar: "); 
					String nombre2 = Leer.pedirCadena();

					for(int x =0; x < laSerie.size(); x++) 
					{
						Serie unaSerie = laSerie.get(x);
						if(unaSerie.getNombre().contentEquals(nombre2)) 
						{
							System.out.println("Escribe el nombre de la temporada para modificar de la serie " +nombre2+ ":");
							String nombreT2 = Leer.pedirCadena();
							
							for(Temporada laTemporada: unaSerie.getTodasTemporadas()) 
							{
								if(laTemporada.getNombre().contentEquals(nombreT2)) 
								{
									System.out.println("Nueva nota: ");
									float notaCambio = Leer.pedirFloat();
									
									laTemporada.setNotaTemporada(notaCambio); 
									System.out.println("Nota cambiada correctamente. ");
								}else System.out.println("La nota no se ha podido cambiar.");
							}
						}
					}
			}
	} //termina MODIFICAR_DATOS
	
} //fin del MAIN




