package ejercicioscrud;

import java.util.Arrays;

/**
 * Clase para generar un menu para cada ejercicio
 */
public class Menu {
	
	/* Atributos */
	/**
	 * Listado de opciones para cada ejercicio
	 */
	String listado[];
	
	/* Constructor */
	/**
	 * Constructor con parametros
	 * 
	 * @param listado Lista de opciones
	 */
	public Menu(String listado[]) {
		
		this.listado = listado;
		
	}//Fin Constructor

	/* Metodos */
	/**
	 * Metodo para imprimir el menu por pantalla
	 */
	public String toString() {

		/* PCC: String a devolver */
		String listaOpciones = "========== \n";
		
		/* Recorremos */
		for(int i = 0; i < this.listado.length; i++) {
			
			listaOpciones += i + ".- " + this.listado[i] + ". \n";
			
		}//Fin FOR --> recorre array
		
		/* Return */
		return listaOpciones;
		
	}//Fin toString
	
	/**
	 * Metodo para seleccionar una opción del listado
	 */
	

}
