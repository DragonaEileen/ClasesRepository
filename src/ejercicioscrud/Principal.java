package ejercicioscrud;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		/* Declaraciones */
			/* Opciones del Main Menu */
		final String[] OPCIONES_MAIN = new String[]{
				"Alumnos", 
				"Almacén", 
				"Pizzeria", 
				"Cuentas Corrientes",
				"Salir"};
		
			/* Opciones de Alumnos */
		final String[] OPCIONES_ALUMNOS = new String[] {
				 "Listado",
				 "Nuevo Alumno",
				 "Modificar",
				 "Borrar",
				 "Salir"};
		
			/* Opciones GESTISIMAL */
		final String[] OPCIONES_ALMACEN = new String[] {
				"Listado",
				"Alta",
				"Baja",
				"Modificación",
				"Entrada de Mercancía",
				"Salida de Mercancía",
				"Salir"};
		
			/* Menú de menús */
		Menu mainMenu = new Menu(OPCIONES_MAIN);
		
			/* Menú del Ejercicio */
		Menu menuEjercicio = null;
		
			/* Aula de Alumnos */
		Aula aulaDePrueba = new Aula();
		
			/* Opción elegida de los menus */
		int chosenOption;
		
		/* Apertura de Scanner */
		Scanner scannercito = new Scanner(System.in);
		
		/* Operaciones */
		do {
			
			//Resets
			chosenOption = 0;
			
			//Print del Main Menu
			System.out.println(mainMenu);
			
			//Selección de opción del Main Menu, se repite si no esta entre las opciones del Main Menu
			do {
				
				System.out.print("Opción Elegida: ");
				chosenOption = scannercito.nextInt();
				
			}while(chosenOption < 1 || chosenOption > OPCIONES_MAIN.length);
				
			//Según la opción usamos un switch para seleccionar el menu ejercicio
			switch(chosenOption) {
			
			//Caso del Ejercicio de los Alumnos
				case 1:
					
					//Se selecciona el Menu Alumnos
					menuEjercicio = new Menu(OPCIONES_ALUMNOS);
					
					/* Operaciones de Alumnos */
					do {
						
						//Se imprime el nuevo menu
						System.out.println(menuEjercicio);
						
						//Checkeamos que se nos introduce una opción entre 1 y el máximo numero de opciones: DO-WHILE
						do {
							
							System.out.print("Opción Elegida: ");
							chosenOption = scannercito.nextInt();
							
							//Scanner Cleaning
							System.out.print("Confirmar (Introduzca cualquier digito): ");
							scannercito.nextLine();
							
						}while(chosenOption < 1 || chosenOption > OPCIONES_ALUMNOS.length);
						
						//Llamamos a la función equivalente
						aulaDePrueba.startEjercicio(chosenOption, scannercito);
						
					}while(chosenOption != OPCIONES_ALUMNOS.length);
			
					//Reset chosenOption si se sale 
					chosenOption = 0;
					
					break;
					
			//Caso del ejercicio del Almacen
				case 2:
					
					//Se selecciona el Menu Almacen
					menuEjercicio = new Menu(OPCIONES_ALMACEN);
					
					/* Operaciones de Almacen */
					do {
						
						//Se imprime el nuevo menu
						System.out.println(menuEjercicio);
						
						//Checkeamos que se nos introduce una opción entre 1 y el máximo numero de opciones: DO-WHILE
						do {
							
							System.out.print("Opción Elegida: ");
							chosenOption = scannercito.nextInt();
							
							//Scanner Cleaning
							System.out.print("Confirmar (Introduzca cualquier digito): ");
							scannercito.nextLine();
							
						}while(chosenOption < 1 || chosenOption > OPCIONES_ALUMNOS.length);
						
						//Llamamos a la función equivalente
						aulaDePrueba.startEjercicio(chosenOption, scannercito);
						
					}while(chosenOption != OPCIONES_ALMACEN.length);
			
					//Reset chosenOption si se sale 
					chosenOption = 0;
					
					break;
					
					
				default:
					
					break;
					
			};//Fin switch
			
		}while(chosenOption != OPCIONES_MAIN.length);
		
		/* Cierre de Scanner */
		scannercito.close();
		
	}//FIN MAIN
	
	/**
	 * Método que evita la redundancia al elegir un ejercicio
	 * 
	 * @param OPCIONES Lista de Opciones del Menu del Ejercicio
	 * @param listadoDeObjetos Lista de Objetos con la que el ejercicio va a trabajar
	 * @param scannercito Scanner con el objetivo de no abrir dos scanners al mismo tiempo
	 */
	private void eleccionDeEjercicio(final String[] OPCIONES, Object objetoPrincipal, Scanner scannercito) {
		
		/* Declaraciones */
			/* Menú del ejercicio */
		Menu menuEjercicio = null;
		
			/* Opción elegida de los menus */
		int chosenOption;
		
		/* Operaciones */
		//Se selecciona el Menu Almacen
		menuEjercicio = new Menu(OPCIONES);
		
		/* Operaciones de Almacen */
		do {
			
			//Se imprime el nuevo menu
			System.out.println(menuEjercicio);
			
			//Checkeamos que se nos introduce una opción entre 1 y el máximo numero de opciones: DO-WHILE
			do {
				
				System.out.print("Opción Elegida: ");
				chosenOption = scannercito.nextInt();
				
				//Scanner Cleaning
				System.out.print("Confirmar (Introduzca cualquier digito): ");
				scannercito.nextLine();
				
			}while(chosenOption < 1 || chosenOption > OPCIONES.length);
			
			//Llamamos a la función equivalente
			objetoPrincipal.startEjercicio(chosenOption, scannercito);
			
		}while(chosenOption != OPCIONES.length);

		//Reset chosenOption si se sale 
		chosenOption = 0;
		
	}//Fin eleccionDeEjercicio()

}
