package ejercicios1;

public class Principal {

	public static void main(String[] args) {

		/* Declaraciones */
			/* CuentaCorriente 1 */
		CuentaCorriente accountA = new CuentaCorriente("DNIExample", 10.0);
		
			/* CuentaCorriente 2 */
		CuentaCorriente accountB = new CuentaCorriente("DNI_Example", 11.1, "Test");
		
			/* Libro */
		Libro bookieWookie = new Libro("Wookie's Recommendations", "Chewookie", 5, 5);
		
			/* Articulo */
		Articulo vouiton = new Articulo("Vouiton", 299.99, 20);
		
		/* CuentaCorriente Operations */
			/* Initial Prints */
		System.out.println(accountA);
		System.out.println(accountB);
		
			/* Operations */
		accountA.takeAway(5);
		accountB.insertMoney(4.4);
		
			/* Final Prints */
		System.out.println(accountA);
		System.out.println(accountB);
		
		
		/* Libro Operations */
		System.out.println(bookieWookie);
		
		//Borrow
		bookieWookie.borrowBook();
		System.out.println(bookieWookie);
		
		//Return
		bookieWookie.returnBook();
		System.out.println(bookieWookie);
		
		
		/* Operaciones Articulo */
		System.out.println(vouiton);
		System.out.println(vouiton.getPVP());
		System.out.println(vouiton.getPVPDescuento(10));
		
		//Vender
		vouiton.vender(10);
		vouiton.almacenar(5);
		System.out.println(vouiton);
		
	}

}
