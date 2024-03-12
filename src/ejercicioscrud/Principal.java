package ejercicioscrud;

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
	
	/*
	 * Declaramos un scanner estatico para que toda la clase lo pueda utilizar
	 */
	public static Scanner scannercito;
	
	/* 
	 * Objeto Aula que va a guardar alumnos y sobre el que se van a hacer las operaciones
	 * 	del ejercicio 1
	 */
	public static Aula aulaDePrueba;
	
	/* 
	 * Objeto Almacen que va a guardar articulos y sobre el que se van a hacer las operaciones
	 * 	del ejercicio 2
	 */
	public static Almacen gestisimal;
	
	/**/

	/* MAIN */
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
		
			/* Array de Contadores de cuantas veces se ha elegido un menú */
		int[] contadores = new int[4];
		
		/* Operaciones */
		do {
			
			cuentaOpciones(menuElegido, contadores);
			
			//Se imprime el nuevo menu
			menuLength = menuSwitch(menuElegido);
			
			//Checkeamos que se nos introduce una opción entre 1 y el máximo numero de opciones: DO-WHILE
			chosenOption = optionChecker(menuLength);
			
			//Llamamos a la función equivalente
			startEjercicio(menuElegido, chosenOption);
				
		}while(chosenOption != menuLength);

	}//Fin eleccionDeEjercicio()

	/**
	 * Método para ejecutar la opción elegida en el menu 
	 * 
	 * @param menuElegido
	 * @param chosenOption 
	 */
	private static void startEjercicio(int menuElegido, int chosenOption) {
		
		/* Declaraciones */
			/* Boolean que indica el exito de operaciones */
		boolean hasSucceded;
		
		//Switch para ejecutar el metodo de la opción elegida dada
		hasSucceded = switch(chosenOption) {
		
			//El primer caso muestra el listado
			case 1:
				
				switchListado(menuElegido);
				
				yield true;
				
			//El segundo caso añade un subobjeto
			case 2:
				
				
				
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
		
	}

	/**
	 * @param menuElegido
	 */
	private static void switchListado(int menuElegido) {
		switch(menuElegido) {
		
		case 1:
			
			System.out.println("\n" + aulaDePrueba);
			break;
			
		case 2:
			
			System.out.println("\n" + gestisimal);
			break;
			
		};//Fin Switch Interno
	}//Fin startEjercicio()

	
	
	/**
	 * Método para imprimir si la operación ha sido realizada con exito
	 */
	private static void successMessage(boolean hasSucceded) {
		if(hasSucceded) {
			
			System.out.println("Operación realizada con éxito.");
			
		} else {
			
			System.out.println("La operación no se ha podido realizar");
			
		}//Fin IF --> Exito
	}//Fin successMessage()
	
	/**
	 * Método que coge recoge una opción
	 * @param menuLength 
	 * @return chosenOption Opción escogida
	 */
	private static int optionChecker(int menuLength) {
		int chosenOption;
		do {
			
			System.out.print("Opción Elegida: ");
			chosenOption = scannercito.nextInt();
			
			//Scanner Cleaning
			System.out.print("Confirmar (Introduzca cualquier digito): ");
			scannercito.nextLine();
			
		}while(chosenOption < 1 || chosenOption > menuLength);
		return chosenOption;
	}
	
	/**
	 * Método que muestra un menú según el menuElegido
	 * 
	 * @param menuElegido Opción elegida
	 * @return 
	 */
	public static int menuSwitch(int menuElegido) {
		
		/* Declaraciones */
			/* Numero de opciones del menu a devolver */
		int menuLength = 0;
		
		//Usamos un switch para imprimir el menu, no necesitamos breaks por el yield
		menuLength = switch(menuElegido) {
		
		case 1:
			
			//Se imprime el menú
			System.out.println(Aula.menuAula);
			
			//Se asigna el numero de opciones
			yield Aula.OPCIONES_ALUMNOS.length;
			
		case 2:
			
			//Se imprime el menu
			System.out.println(Almacen.menuAlmacen);
			
			//Se asigna el numero de opciones
			yield Almacen.OPCIONES_ALMACEN.length;
			
		default:
			
			throw new IllegalArgumentException("Unexpected value: " + menuElegido);
		
		};
		
		return menuLength;
		
	}//Fin menuSwitch
	
	/*
	 * Metodo que cuenta las veces que se ha elegido una opción, y si no se había escogido anteriormente
	 * 	se construye el objeto
	 */
	private static void cuentaOpciones(int menuElegido, int[] contadores) {
		
		//Comprobamos si el menu se a elegido previamente, si no, construimos el objeto ahora
		if(contadores[menuElegido-1] == 0) {
			
			switch(menuElegido) {
			
			case 1:
				
				aulaDePrueba = new Aula();
				break;
				
			case 2:
				
				gestisimal = new Almacen();
				break;
			
			}//Fin Switch
			
		}//Fin IF --> Comprobación
		
		//Sumamos uno al contador
		contadores[menuElegido-1] += 1;
		
	}//Fin cuentaOpciones()
	
}
