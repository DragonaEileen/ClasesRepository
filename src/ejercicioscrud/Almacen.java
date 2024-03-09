package ejercicioscrud;


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
		
		/* Return */
		return hasSucceded;
		
	}//Fin modifYaRT
	
}
