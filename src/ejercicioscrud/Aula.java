package ejercicioscrud;

import java.util.Scanner;

/**
 * Clase que funciona como un aula de alumnos, pudiendo borrarlos o añadir nuevos
 * 
 * @author Eileen
 */
public class Aula {

	/* Atributos */
	/**
	 * Listado de los ALumnos que hay en el Aula
	 */
	private Alumno[] alumnosEnAula = new Alumno[30];

	
	/* Constructor */
	/* No necesitamos constructor por que no vamos a recibir ni modificar aytributos */
	
	/* Métodos */
	/**
	 * Método en el que se van a enseñar los alumnos que haya en el Aula, es decir, las posiciones que no sean nulas
	 * 
	 * @return alumniString Cadena que incluye la información de los alumnos
	 */
	public String toString() {
		
		/* PCC: Cadena a construir */
		String alumniString = "Lista de Alumnos:\n\n";
		
		/* Concatenacion */
		//Recorremos alumno por alumno
		for(Alumno alumno: alumnosEnAula) {
			
			//Si alumno no es nulo, se añade a la String
			if(!(alumno == null)) {alumniString += "-->" + alumno + "\n";};
			
		}//Fin FOR-EACH --> Recorre Array
		
		/* Return */
		return alumniString;
		
	}//Fin toString()
	
	/**
	 * Método para añadir un nuevo alumno al Aula en la primera posición nula
	 * 
	 * @param nombreAlumno Nombre del Alumno
	 * @param notaMedia Nota Media del Alumno
	 * @return result Si el añadir ha tenido éxito o no.
	 */
	public boolean addAlumno(String nombreAlumno, double notaMedia) {
		
		/* Declaraciones */
			/* Declaramos el nuevo alumno */
		Alumno alumnoX;
		
			/* PCC: Booleano a devolver */
		boolean result = false;
		
			/* Contador para recorrer el Aula */
		int posicion = 0;
		
		/* Comnprobamos que hay alguna posición nula */
		//Para ello hacemos un bucle que iterará mientras no encuentre un nulo o llegue al máximo del listado de alumnos
		while(!result && posicion < this.alumnosEnAula.length) {
			
			//Comprobamos si en la posición del contador hay un nulo
			if(this.alumnosEnAula[posicion] == null) {
				
				//Construimos el alumno aqui para no gastar memoria antes o si no hay hueco
				alumnoX = new Alumno(nombreAlumno, notaMedia);
				
				//Lo situamos en la posición nula encontrada
				this.alumnosEnAula[posicion] = alumnoX;
				
				//Damos el visto bueno a la operación
				result = true;
				
			}//Fin IF --> comprobación
			
			//Vamos a la siguiente iteracion si no ha encontrado hueco libre
			posicion += 1;
			
		}//Fin While --> recorrer lista buscando huecos nulos
		
		/* Return  */
		return result;
		
	}//Fin addAlumno()
	
	/**
	 * Método que modifica la nota de un alumno dado por la nota dada
	 * 
	 * @param nombreAlumno Nombre del alumno a modificar
	 * @param nuevaNotaMedia Nueva nota del Alumno
	 * @return hasSucceded Si la operación ha tenido éxito
	 */
	public boolean modifyAlumno(String nombreAlumno, double nuevaNotaMedia) {
		
		/* Declaraciones */
			/* PCC: booleano a devolver */
		boolean hasSucceded = false;
		
			/* Contador de posiciones */
		int posicion = 0;
		
		/* Buscamos el alumno en el Aula */
		//Para ello recorremos el array viendo si el nombre de algun alumno coincide con el dado
		while(!hasSucceded && posicion < this.alumnosEnAula.length) {
			
			//Comprobamos si coinciden los nombres, mirando el nombre del alumno en la posicion del contador
			if(nombreAlumno.equals(this.alumnosEnAula[posicion].getStudentName())) {
				
				//Con el setter de alumno de la nota media asignamos la nueva nota media
				this.alumnosEnAula[posicion].setAverageGrade(nuevaNotaMedia);
				
				//Hemos tenido exito
				hasSucceded = true;
				
			}//Fin IF --> Comprobación de nombres
			
		}//Fin While --> Recorre Aula
		
		/* Return */
		return hasSucceded;
		
	}//Fin modifyAlumno
	
	/**
	 * Método para borrar un alumno de nombre dado
	 * 
	 * @param nombreAlumno Nombre del Alumno a borrar
	 * @return hasSucceded Si la operación ha salido bien o no
	 */
	public boolean deleteAlumno(String nombreAlumno) {
		
		/* Declaraciones */
			/* PCC: Booleano a devolver */
		boolean hasSucceded = false;
		
			/* Contador de posiciones del Aula */
		int posicion = 0;
		
		/* Busqueda del alumno en el Aula */
		//Recorremos el Aula hasta dar con el Alumno o terminar de recorrerla
		while(!hasSucceded || posicion < this.alumnosEnAula.length) {
			
			//Comprobamos si el nombre coincide con el alumno en la posicion del contador
			if(nombreAlumno.equals(this.alumnosEnAula[posicion].getStudentName())) {
				
				//"Borramos el alumno", es decir, lo sustituimos por null y ya llegará el recolector de basura
				this.alumnosEnAula[posicion] = null;
				
				//Hemos tenido éxito
				hasSucceded = true;
				
			}//Fin comprobación de nombres
			
		}//Fin WHILE --> Busca Alumnos
		
		/* Return */
		return hasSucceded;
		
	}//Fin deleteAlumno()
	
	
	/* Start del Ejercicio */
	/**
	 * Método para ejecutar la opción elegida en el menu 
	 * 
	 * @param chosenOption
	 */
	public void startEjercicio(int chosenOption) {
		
		/* Declaraciones */
			/* Boolean que indica el exito de operaciones */
		boolean hasSucceded;
			
			/* Nombre del alumno a añadir */
		String nombreAlumno;
		
			/* Nota Media del Alumno a añadir */
		double notaMedia = 0;
		
		//Switch para ejecutar el metodo de la opción elegida dada
		switch(chosenOption) {
		
			//El primer caso muestra los alumnos en el Aula
			case 1:
				
				//Imprimimos los datos
				System.out.println(toString());
				break;
				
			//El segundo caso añade un alumno al Aula
			case 2:
				
				/* Apertura de Scanner */
				Scanner scannerOpcion2 = new Scanner(System.in);
				
				/* Recogemos los datos del alumno a añadir */
				//Usamos un do-while para que la nota media no supere ni diez ni sea menor a 0
				do {
					
					//Nombre
					System.out.print("Introduce el nombre del alumno: ");
					nombreAlumno = scannerOpcion2.nextLine();
					
					//Nota Media
					System.out.print("Introduce la nota media del alumno: ");
					notaMedia = scannerOpcion2.nextDouble();
					
				}while(notaMedia < 0 || notaMedia > 10);
				
				/* Ejecutamos la función de añadir alumno */
				hasSucceded = addAlumno(nombreAlumno, notaMedia);
				
				//Mensaje de Exito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito
				
				/* Cierre de Scanner */
				scannerOpcion2.close();
				
				//Break Switch Statement
				break;
				
			//El tercer caso modifica un alumno del aula
			case 3:
				
				/* Apertura de Scanner */
				Scanner scannerOpcion3 = new Scanner(System.in);
				
				/* Recogemos el nombre del Alumno a modificar */
				System.out.print("Introduce el nombre del alumno a modificar: ");
				nombreAlumno = scannerOpcion3.nextLine();
				
				/* Recogemos la nueva nota */
				//Do-While evita numeros menores a 0 o mayores a 10
				do {
					
					System.out.print("Introduce la nueva nota: ");
					notaMedia = scannerOpcion3.nextDouble();
					
				}while(notaMedia < 0 || notaMedia > 10);
				
				/* Ejecutamos la funcion de modificar alumno */
				hasSucceded = modifyAlumno(nombreAlumno, notaMedia);
				
				//Mensaje de exito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito
				
				/* Cierre de Scanner */
				scannerOpcion3.close();
				
				/* Switch Break Statement */
				break;
				
			//Opción para borrar un alumno
			case 4:
				
				/* Apertura de Scanner */
				Scanner scannerOpcion4 = new Scanner(System.in);
				
				/* Recogida del Nombre del Alumno */
				System.out.print("Introduce el nombre del alumno a borrar: ");
				nombreAlumno = scannerOpcion4.nextLine();
				
				/* Ejecutamos la función de borrado */
				hasSucceded = deleteAlumno(nombreAlumno);
				
				//Mensaje de éxito
				if(hasSucceded) {
					
					System.out.println("Operación realizada con éxito.");
					
				} else {
					
					System.out.println("La operación no se ha podido realizar");
					
				}//Fin IF --> Exito
				
				/* Cierre de Scanner */
				scannerOpcion4.close();
				
				/* Switch Break Statement */
				break;
				
			default:
				
				
		}//Fin Switch --> Ejecutar Opción
		
	}//Fin startEjercicio()
	
}
