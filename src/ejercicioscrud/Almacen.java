package ejercicioscrud;

import java.util.Scanner;

/**
 * Clase que define una simulación de un almacen de Articulos
 * 
 * @author Eileen
 */
public class Almacen {

	/* Atributos */
	/**
	 *  Opciones GESTISIMAL
	 */
	final String[] OPCIONES_ALMACEN = new String[] {
			"Listado",
			"Alta",
			"Baja",
			"Modificación",
			"Entrada de Mercancía",
			"Salida de Mercancía",
			"Salir"};
	
	/**
	 * Menú del almacen
	 */
	public Menu menuAlmacen = new Menu(this.OPCIONES_ALMACEN);
	
	/**
	 * Cantidad máxima de articulos en el almacen
	 */
	public static final int MAX_ARTICULOS = 20;
	
	/**
	 * Listado de Articulos
	 */
	private Articulo[] listadoDeArticulos = new Articulo[MAX_ARTICULOS];
	
	
	/* Constructor */
	/* Usamos el constructor sin parametros por defecto */
	
	/* Métodos */
	/**
	 * Metodo toString adaptado. Devuelve una string de la información del listado de Articulos
	 * 
	 * @return almacenToString Cadena con la información del listado
	 */
	public String toString() {
		
		/* PCC: declaración de string a devolver */
		String almacenToString = "Lista de Articulos:\n\n";
		
		/* Concatenación */
		//Recorremos el listado de articulos con un FOR-EACH
		for(Articulo article: listadoDeArticulos) {
			
			//Si el articulo no es nulo se añade a la String
			if(article != null) {almacenToString += "-->" + article + "\n";}
			
		}//Fin FOR-EACH Recorremos Listado
		
		/* Return */
		return almacenToString;
		
	}//Fin toString()
	
	/**
	 * Método para dar de alta un articulo en el listado
	 * 
	 * @param codigoID Código identificador del nuevo articulo
	 * @param descripcionArticulo Descripción breve del nuevo articulo
	 * @param precioDeCompra Valor monetario de compra del nuevo articulo
	 * @param precioDeVenta Valor monetario de venta del nuevo articulo
	 * @param articleStock Cantidad de articulos de este nuevo tipo en el almacen
	 * @return hasSucceded Si la operación ha tenido éxito o no
	 */
	public boolean darDeAlta(String codigoID, String descripcionArticulo, double precioDeCompra, double precioDeVenta, int articleStock) {
		
		/* Declaraciones */
			/* PCC: Booleano a devolver */
		boolean hasSucceded = false;
		
			/* Contador de Posiciones */
		int posicion = 0;
		
		/* Operaciones */
		while(!hasSucceded && posicion < this.listadoDeArticulos.length) {
			
			//Comprobamos si la posicion en la que estamos esta vacia
			if(this.listadoDeArticulos[posicion] != null) {
				
				//Asignamos el nuevo articulo a la posicion vacia
				this.listadoDeArticulos[posicion] = new Articulo(codigoID, descripcionArticulo, precioDeCompra, precioDeVenta, articleStock);
				
				//Hemos tenido exito
				hasSucceded = true;
				
			}//Fin IF --> Comprobación Posicion Vacía
			
			//Control de Iteraciones
			posicion += 1;
			
		}//Fin WHILE --> Recorrer Listado
		
		/* Return */
		return hasSucceded;
		
	}//Fin darDeAlta()
	
	/**
	 * Función para dar de baja un artículo
	 * 
	 * @param codigoID Codigo identificador del articulo
	 * @return hasSucceded Si la operación ha tenido éxito o no.
	 */
	public boolean darDeBaja(String codigoID) {
		
		/* Declaraciones */
			/* PCC: booleano a devolver */
		boolean hasSucceded = false;
		
			/* Contador de posicions */
		int posicion = 0;
		
		/* Operaciones */
		//Recorremos el listado para buscar el articulo
		while(!hasSucceded && posicion < this.listadoDeArticulos.length) {
			
			//Comprobamos que en la posición no hay nulos, y además si el codigo coincide con el articulo en la posicion
			if(this.listadoDeArticulos[posicion] != null && 
					codigoID.equals(this.listadoDeArticulos[posicion].getCodigoID())) {
				
				//Asignamos a esa posicion un nulo
				this.listadoDeArticulos[posicion] = null;
				
				//Hemos tenido exito
				hasSucceded = true;
				
			}//Fin IF --> Comprobador
			
		}//Fin WHILE --> Recorrer listado
		
		/* Return */
		return hasSucceded;
		
	}//Fin darDeBaja
	
	/**
	 * Metodo para modificar la informacion de un articulo
	 * 
	 * @param codigoID Código identificador del articulo
	 * @param descripcionArticulo Nueva descripción breve del nuevo articulo
	 * @param precioDeCompra Nuevo valor monetario de compra del nuevo articulo
	 * @param precioDeVenta Nuevo valor monetario de venta del nuevo articulo
	 * @param articleStock Nueva cantidad de articulos de este nuevo tipo en el almacen
	 * @return hasSucceded Si la operación ha tenido éxito o no
	 */
	public boolean modifyArticle(String codigoID, String descripcionArticulo, double precioDeCompra, double precioDeVenta, int articleStock) {
		
		/* Declaraciones */
			/* PCC: boolean a devolver */
		boolean hasSucceded = false;
		
			/* Contador de posiciones */
		int posicion = 0;
		
		/* Operaciones */
		//Recorremos el listado para buscar el articulo con el codigo ID en concreto
		while(!hasSucceded && posicion < this.listadoDeArticulos.length) {
			
			//Comprobación de similitud entre codigos ID
			if(codigoID.equals(this.listadoDeArticulos[posicion].getCodigoID())) {
				
				//Modificaciones
				this.listadoDeArticulos[posicion].setDescripcionArticulo(descripcionArticulo);
				this.listadoDeArticulos[posicion].setPrecioDeCompra(precioDeCompra);
				this.listadoDeArticulos[posicion].setPrecioDeVenta(precioDeVenta);
				this.listadoDeArticulos[posicion].setArticleStock(articleStock);
				
				//Hemos tenido éxito
				hasSucceded = true;
				
			}//Fin IF --> Comprobación
			
		}//Fin WHILE --> Recorriendo Articulos
		
		/* Return */
		return hasSucceded;
		
	}//Fin modifyArticle()
	
	/**
	 * Método que simula la entrada de mercancía de un tipo de artículo en el almacen
	 * 
	 * @param codigoID Código Identificador del articulo
	 * @param quantity Cantidad de mercancía que entra
	 * @return hasSucceded Si la operación ha tenido éxito o no
	 */
	public boolean entradaDeMercancia(String codigoID, int quantity) {
		
		/* Declaraciones */
			/* PCC: Booleano a devolver */
		boolean hasSucceded = false;
		
			/* Contador de posiciones para buscar el articulo en concreto */
		int posicion = 0;
		
		/* Operaciones */
		//Recorremos el listado para buscar el articulo con el codigo ID en concreto
		while(!hasSucceded && posicion < this.listadoDeArticulos.length) {
			
			//Comprobación de similitud entre codigos ID
			if(codigoID.equals(this.listadoDeArticulos[posicion].getCodigoID())) {
				
				//El nuevo Stock del articulo en la posicion determinada del listado será igual a
				//	el actual Stock del articulo en la posición determinada del listado más la cantidad dada
				this.listadoDeArticulos[posicion].setArticleStock(this.listadoDeArticulos[posicion].getArticleStock()+quantity);
				
				//Hemos tenido éxito
				hasSucceded = true;
				
			}//Fin IF --> Comprobación
			
		}//Fin WHILE --> Recorriendo el listado
		
		/* Return */
		return hasSucceded;
		
	}//Fin entradaDeMercancia()
	
	/**
	 * Metodod que simula la salida de mercancía de un articulo
	 * 
	 * @param codigoID Codigo Identificador del articulo
	 * @param quantity Cantidad de mercancia que sale del almacen
	 * @return hasSucceded Si la operación ha tenido éxito o no
	 */
	public boolean salidaDeMercancia(String codigoID, int quantity) {
		
		/* Declaraciones */
			/* PCC: Booleano a devolver */
		boolean hasSucceded = false;
		
			/* Contador de posiciones para buscar el articulo en concreto */
		int posicion = 0;
		
		/* Operaciones */
		//Recorremos el listado para buscar el articulo con el codigo ID en concreto, siempre que
		//	la mercancia que sale no sea mayor a la mercancía que hay, en cuyo caso no entra en el bucle
		while(this.listadoDeArticulos[posicion].getArticleStock() - quantity > 0 && 
				!hasSucceded &&
				posicion < this.listadoDeArticulos.length) {
			
			//Comprobación de similitud entre codigos ID
			if(codigoID.equals(this.listadoDeArticulos[posicion].getCodigoID())) {
				
				//El nuevo Stock del articulo en la posicion determinada del listado será igual a
				//	el actual Stock del articulo en la posición determinada del listado menos la cantidad dada
				this.listadoDeArticulos[posicion].setArticleStock(this.listadoDeArticulos[posicion].getArticleStock()-quantity);
				
				//Hemos tenido éxito
				hasSucceded = true;
				
			}//Fin IF --> Comprobación
			
		}//Fin WHILE --> Recorriendo el listado
		
		/* Return */
		return hasSucceded;
		
	}//Fin salidaDeMercancia()
	
	
	/**
	 * Método para ejecutar la opción elegida en el menu 
	 * 
	 * @param chosenOption Opción elegida
	 * @param scannercito Scanner
	 */
	public void startEjercicio(int chosenOption, Scanner scannercito) {
		
		/* Declaraciones */
			/* Boolean que indica el exito de operaciones */
		boolean hasSucceded;
			
		//Switch para ejecutar el metodo de la opción elegida dada
		switch(chosenOption) {
		
			//El primer caso muestra los alumnos en el Aula
			case 1:
				
				//Imprimimos los datos
				System.out.println("\n" + toString());
				break;
				
			//El segundo caso añade un alumno al Aula
			case 2:
				
				/* Recogemos los datos del alumno a añadir */
				//Usamos un do-while para que la nota media no supere ni diez ni sea menor a 0
				do {
					
					//Scanner cleaning
					nombreAlumno = scannercito.nextLine();
					
					//Nombre
					System.out.print("Introduce el nombre del alumno: ");
					nombreAlumno = scannercito.nextLine();
					
					//Scanner Cleaning
					System.out.print("Confirmar (Pulse cualquier tecla): ");
					scannercito.next();
					
					//Nota Media
					System.out.print("Introduce la nota media del alumno: ");
					notaMedia = scannercito.nextDouble();
					
				}while(notaMedia < 0 || notaMedia > 10);
				
				/* Ejecutamos la función de añadir alumno */
				hasSucceded = addAlumno(nombreAlumno, notaMedia);
				
				//Mensaje de Exito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito
				
				//Break Switch Statement
				break;
				
			//El tercer caso modifica un alumno del aula
			case 3:
				
				//Scanner cleaning
				nombreAlumno = scannercito.nextLine();
				
				/* Recogemos el nombre del Alumno a modificar */
				System.out.print("Introduce el nombre del alumno a modificar: ");
				nombreAlumno = scannercito.nextLine();
				
				/* Recogemos la nueva nota */
				//Do-While evita numeros menores a 0 o mayores a 10
				do {
					
					System.out.print("Introduce la nueva nota: ");
					notaMedia = scannercito.nextDouble();
					
				}while(notaMedia < 0 || notaMedia > 10);
				
				/* Ejecutamos la funcion de modificar alumno */
				hasSucceded = modifyAlumno(nombreAlumno, notaMedia);
				
				//Mensaje de exito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito

				/* Switch Break Statement */
				break;
				
			//Opción para borrar un alumno
			case 4:
				
				//Scanner cleaning
				nombreAlumno = scannercito.nextLine();
				
				/* Recogida del Nombre del Alumno */
				System.out.print("Introduce el nombre del alumno a borrar: ");
				nombreAlumno = scannercito.nextLine();
				
				//Scanner Cleaning
				System.out.print("Confirmar (Pulse cualquier tecla): ");
				scannercito.next();
				
				/* Ejecutamos la función de borrado */
				hasSucceded = deleteAlumno(nombreAlumno);
				
				//Mensaje de éxito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito

				/* Switch Break Statement */
				break;
				
			default:
				
				
		}//Fin Switch --> Ejecutar Opción
		
	}//Fin startEjercicio()
	
}
