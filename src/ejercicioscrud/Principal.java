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
							
						}while(chosenOption < 1 || chosenOption > OPCIONES_ALUMNOS.length);
						
						//Llamamos a la función equivalente
						aulaDePrueba.startEjercicio(chosenOption);
						
					}while(chosenOption != OPCIONES_ALUMNOS.length);
			
					//Reset chosenOption si se sale 
					chosenOption = 0;
					
					break;
					
				default:
					
					break;
					
			};//Fin switch
			
		}while(chosenOption != OPCIONES_MAIN.length);
		
		/* Cierre de Scanner */
		scannercito.close();
		
	}

}
