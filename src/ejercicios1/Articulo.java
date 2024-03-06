package ejercicios1;

/**
 * Clase que define un articulo de una tienda o almacen.
 * 
 * @author Eileen
 */
public class Articulo {

	/* Atributos */
	/**
	 * Porcentaje de IVA
	 */
	public static float IVA = 21f;
	
	/**
	 * Nombre del Articulo
	 */
	private String articleName = "";
	
	/**
	 * Valor monetario del articulo sin aplicar el IVA
	 */
	private double articlePrice;
	
	/**
	 * Cantidad de productos que quedan en el almacen
	 */
	private int articleStock;
	
	
	/* Constructores */
	/**
	 * Constructor con Parametros
	 * 
	 * @param articleName Nombre del articulo
	 * @param articlePrice Valor monetario del articulo
	 * @param articleStock Cantidad de articulos en el almacen
	 */
	public Articulo(String articleName, double articlePrice, int articleStock) {
		
		this.articleName = articleName;
		this.articlePrice = articlePrice;
		this.articleStock = articleStock;
		
	}//Fin Constructor
	
	
	/* Metodos */
	/**
	 * Método para imprimir la información del artículo por pantalla.
	 */
	public String toString() {
		return "Articulo [articleName=" + articleName + ", articlePrice=" + articlePrice + ", articleStock="
				+ articleStock + "]";
	}//Fin toString
	
	/**
	 * Metodo que devuelva el precio de venta al público (PVP) con iva incluido.
	 * 
	 * @return PVP Precio de Venta al Publico
	 */
	public double getPVP() {
		
		return  this.articlePrice + (this.articlePrice*21/100); 
		
	}//Fin getPVP()
	
	/**
	 * Metodo que devuelve el PVP con un descuento pasado como argumento. 
	 * 
	 * @param discount Porcentaje de descuento
	 * @return discountPVP Precio de Venta al Público con Descuento
	 */
	public double getPVPDescuento(double discount) {
		
		return getPVP() - (getPVP()*discount/100);
		
	}//Fin getPVPDescuento()
	
	/**
	 * Método vender que actualiza los atributos del 
	 * objeto tras vender una cantidad ‘x’ (si es posible).
	 * Devolverá true si ha sido posible (false en caso contrario). 
	 * 
	 * @param quantity Cantidad de productos a vender
	 * @return result Si ha sido posible o no
	 */
	public boolean vender(int quantity) {
		
		/* Declaraciones */
			/* PCC: Booleano a devolver */
		boolean result = false;
		
		/* Operaciones */
		if(this.articleStock - quantity > 0) {
			
			//Se Vende
			this.articleStock = this.articleStock - quantity;
			
			//Éxito
			result = true;
			
		}//Fin Comprobacion
		
		/* Return */
		return result;
		
	}//Fin vender()
	
	/**
	 * Método almacenar que actualiza los atributos del objeto 
	 * tras almacenar una cantidad ‘x’.
	 * 
	 * @param quantity Cantidad almacenada
	 */
	public void almacenar(int quantity) {
		
		this.articleStock += quantity;
		
	}//Fin almacenar()
	
}
