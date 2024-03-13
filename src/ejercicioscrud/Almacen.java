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
			if(this.listadoDeArticulos[posicion] == null) {
				
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
		
			/* Codigo del articulo a usar */
		String codigoID = "";
		
			/* Descripción del articulo a usar */
		String articleDescription = "";
		
			/* Precio de Compra del articulo a usar */
		double precioDeCompra = 0;
			
			/* Precio de Compra del articulo a usar */
		double precioDeVenta = 0;
		
			/* Stock del articulo a usar */
		int articleStock = 0;
		
			/* Quantity de entrada o salida */
		int quantity = 0;
			
		//Switch para ejecutar el metodo de la opción elegida dada
		switch(chosenOption) {
		
			//El primer caso muestra los articulos en el Almacen
			case 1:
				
				//Imprimimos los datos
				System.out.println("\n" + toString());
				break;
				
			//El segundo caso añade un nuevo articulo al Almacen
			case 2:
				
				/* Recogemos los datos del almacen a añadir */
				//Usamos un do-while para que la nota media no supere ni diez ni sea menor a 0
				do {
					
					//Scanner cleaning
					codigoID = scannercito.nextLine();
					
					//Codigo
					System.out.print("Introduce el codigo del articulo nuevo: ");
					codigoID = scannercito.nextLine();

//					//Scanner Cleaning
//					System.out.print("Confirmar (Pulse cualquier tecla): ");
//					articleDescription = scannercito.nextLine();
					
					//Descripción
					System.out.print("Introduce la descripción del aarticulo nuevo: ");
					articleDescription = scannercito.nextLine();

//					//Scanner Cleaning
//					System.out.print("Confirmar (Pulse cualquier tecla): ");
//					scannercito.nextLine();
					
					//Precio de Compra
					System.out.print("Introduce el precio de compra del aarticulo nuevo: ");
					precioDeCompra = scannercito.nextDouble();
					
//					//Scanner Cleaning
//					System.out.print("Confirmar (Pulse cualquier tecla): ");
//					scannercito.nextLine();
					
					//Precio de Venta
					System.out.print("Introduce el precio de venta del aarticulo nuevo: ");
					precioDeVenta = scannercito.nextDouble();
					
//					//Scanner Cleaning
//					System.out.print("Confirmar (Pulse cualquier tecla): ");
//					scannercito.nextLine();
					
					//Stock
					System.out.print("Introduce el stock del aarticulo nuevo: ");
					articleStock = scannercito.nextInt();
					
				}while(precioDeCompra < 0 || precioDeVenta < 0 || articleStock < 0);
				
				/* Ejecutamos la función de añadir alumno */
				hasSucceded = darDeAlta(codigoID, articleDescription, precioDeCompra, precioDeVenta, articleStock);
				
				//Mensaje de Exito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito
				
				//Break Switch Statement
				break;
				
			//El tercer caso da de baja un articulo del almacen
			case 3:
				
				//Scanner cleaning
				codigoID = scannercito.nextLine();
				
				//Codigo
				System.out.print("Introduce el codigo del articulo nuevo: ");
				codigoID = scannercito.nextLine();
				
				/* Ejecutamos la funcion de modificar alumno */
				hasSucceded = darDeBaja(codigoID);
				
				//Mensaje de exito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito

				/* Switch Break Statement */
				break;
				
			//El cuarto caso modifica un articulo del almacen
			case 4:
				
				//Do-While for non negative values purposes
				do {
					
					//Scanner cleaning
					codigoID = scannercito.nextLine();
					
					//Codigo
					System.out.print("Introduce el codigo del articulo nuevo: ");
					codigoID = scannercito.nextLine();

					//Scanner Cleaning
					System.out.print("Confirmar (Pulse cualquier tecla): ");
					scannercito.nextLine();
					
					//Descripción
					System.out.print("Introduce la descripción del aarticulo nuevo: ");
					articleDescription = scannercito.nextLine();

					//Scanner Cleaning
					System.out.print("Confirmar (Pulse cualquier tecla): ");
					scannercito.nextLine();
					
					//Precio de Compra
					System.out.print("Introduce el precio de compra del aarticulo nuevo: ");
					precioDeCompra = scannercito.nextDouble();
					
					//Scanner Cleaning
					System.out.print("Confirmar (Pulse cualquier tecla): ");
					scannercito.nextLine();
					
					//Precio de Venta
					System.out.print("Introduce el precio de venta del aarticulo nuevo: ");
					precioDeVenta = scannercito.nextDouble();
					
					//Scanner Cleaning
					System.out.print("Confirmar (Pulse cualquier tecla): ");
					scannercito.nextLine();
					
					//Stock
					System.out.print("Introduce el stock del aarticulo nuevo: ");
					articleStock = scannercito.nextInt();
					
				}while(precioDeCompra < 0 || precioDeVenta < 0 || articleStock < 0);
				
				/* Ejecutamos la función de añadir alumno */
				hasSucceded = modifyArticle(codigoID, articleDescription, precioDeCompra, precioDeVenta, articleStock);
				
				
				//Mensaje de éxito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito

				/* Switch Break Statement */
				break;
				
				//Caso de entrada de mercancía
			case 5:
				
				do {
				
					//Scanner cleaning
					codigoID = scannercito.nextLine();
					
					//Codigo
					System.out.print("Introduce el codigo del articulo nuevo: ");
					codigoID = scannercito.nextLine();
					
					//Scanner Cleaning
					System.out.print("Confirmar (Pulse cualquier tecla): ");
					scannercito.nextLine();
					
					//Quantity
					System.out.print("Introduce la cantidad añadida: ");
					quantity = scannercito.nextInt();
				
				}while(quantity < 1);
				
				/* Ejecutamos la funcion de entrada alumno */
				hasSucceded = entradaDeMercancia(codigoID, quantity);
				
				//Mensaje de exito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito
				
				break;
				
			case 6:
				
				do {
				
					//Scanner cleaning
					codigoID = scannercito.nextLine();
					
					//Codigo
					System.out.print("Introduce el codigo del articulo nuevo: ");
					codigoID = scannercito.nextLine();
					
					//Scanner Cleaning
					System.out.print("Confirmar (Pulse cualquier tecla): ");
					scannercito.nextLine();
					
					//Quantity
					System.out.print("Introduce la cantidad sacada: ");
					quantity = scannercito.nextInt();
				
				}while(quantity < 1);
				
				/* Ejecutamos la funcion de entrada alumno */
				hasSucceded = salidaDeMercancia(codigoID, quantity);
				
				//Mensaje de exito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito
			default:
				
				
		}//Fin Switch --> Ejecutar Opción
		
	}//Fin startEjercicio()
	
}
