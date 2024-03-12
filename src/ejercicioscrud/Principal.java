package ejercicioscrud;

import java.util.Scanner;

public class Principal {
	
	/* Declaramos un scanner estatico para que toda la clase lo pueda utilizar */
	public static Scanner scannercito;

	/* Metodo Main */
	public static void main(String[] args) {

		/* Declaraciones */
			/* Opciones del Main Menu */
		final String[] OPCIONES_MAIN = new String[]{
				"Alumnos", 
				"Almacén", 
				"Pizzeria", 
				"Cuentas Corrientes",
				"Salir"};
		
		
		
			/* Menú de menús */
		Menu mainMenu = new Menu(OPCIONES_MAIN);
		
			/* Opción elegida de los menus */
		int chosenOption;
		
		/* Apertura de Scanner */
		scannercito = new Scanner(System.in);
		
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
				
			//LLamamos a la elección del ejercicio
			eleccionDeEjercicio(chosenOption);
			
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
	private static void eleccionDeEjercicio(int menuElegido) {
		
		/* Declaraciones */
			/* Opción elegida de los menus */
		int chosenOption;
		
			/* Longitud de menu */
		int menuLength = 0;
		
		/* Operaciones */
		do {
			
			//Se imprime el nuevo menu
			menuLength = menuSwitch(menuElegido);
			
			//Checkeamos que se nos introduce una opción entre 1 y el máximo numero de opciones: DO-WHILE
			chosenOption = optionChecker();
			
			//Llamamos a la función equivalente
			startEjercicio(chosenOption);
				
		}while(chosenOption != menuLength.length);

		//Reset chosenOption si se sale 
		chosenOption = 0;
		
	}//Fin eleccionDeEjercicio()

	

	/**
	 * Método para ejecutar la opción elegida en el menu 
	 * 
	 * @param chosenOption
	 */
	private static void startEjercicio(int chosenOption) {
		
		/* Declaraciones */
			/* Boolean que indica el exito de operaciones */
		boolean hasSucceded;
			
			/* Nombre del alumno a añadir */
		String nombreAlumno = "";
		
			/* Nota Media del Alumno a añadir */
		double notaMedia = 0;
		
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
				
				//Mensaje de éxito
				successMessage(hasSucceded);
				
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
				
				//Mensaje de éxito
				successMessage(hasSucceded);

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
				successMessage(hasSucceded);

				/* Switch Break Statement */
				break;
				
			default:
				
				
		}//Fin Switch --> Ejecutar Opción
		
	}//Fin startEjercicio()

	
	
	/**
	 * Método para imprimir si la operación ha sido realizada con exito
	 */
	private void successMessage(boolean hasSucceded) {
		if(hasSucceded) {
			
			System.out.println("Operación realizada con éxito.");
			
		} else {
			
			System.out.println("La operación no se ha podido realizar");
			
		}//Fin IF --> Exito
	}//Fin successMessage()
	
	/**
	 * Método que coge recoge una opción
	 * @return chosenOption Opción escogida
	 */
	private static int optionChecker() {
		int chosenOption;
		do {
			
			System.out.print("Opción Elegida: ");
			chosenOption = scannercito.nextInt();
			
			//Scanner Cleaning
			System.out.print("Confirmar (Introduzca cualquier digito): ");
			scannercito.nextLine();
			
		}while(chosenOption < 1 || chosenOption > item.length);
		return chosenOption;
	}
	
	/**
	 * Método que muestra un menú según el menuElegido
	 * 
	 * @param menuElegido Opción elegida
	 */
	public static void menuSwitch(int menuElegido) {
		
		/* Declaraciones */
		switch(menuElegido) {
		
		case 1:
			
			System.out.println(Aula.menuAula);
			break;
			
		case 2:
			
			System.out.println(Almacen.menuAlmacen);
			break;
		
		};
		
	}
	
}
