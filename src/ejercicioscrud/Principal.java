package ejercicioscrud;

public class Principal {

	public static void main(String[] args) {

		/* Declaraciones */
			/* Opciones del Main Menu */
		String[] listadoMain = new String[]{
				"Alumnos", 
				"Almacén", 
				"Pizzeria", 
				"Cuentas Corrientes"};
		
			/* Opciones de Alumnos */
		String[] listadoAlumnos = new String[] {
				 "Listado",
				 "Nuevo Alumno",
				 "Modificar",
				 "Borrar",
				 "Salir"};
		
			/* Menú de menús */
		Menu mainMenu = new Menu(listadoMain);
		
		
		/* Operaciones */
		//Print del Main Menu
		System.out.println(mainMenu);
		
	}

}
