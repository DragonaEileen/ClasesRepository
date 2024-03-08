package ejercicioscrud;

/**
 * Clase que define los articulos guardados en un alamacen
 * 
 * @author Eileen
 */
public class Articulo {

	/* Attributes */
	/**
	 * Código identificador del producto
	 */
	String codigoID = "";
	
	/**
	 * Descripción del producto
	 */
	String descripcionArticulo = "";
	
	/**
	 * Precio de compra del articulo
	 */
	double precioDeCompra;
	
	/**
	 * Precio de venta del articulo
	 */
	double precioDeVenta;
	
	/**
	 * Cantidad de articulos en el almacen 
	 */
	int articleStock;
	
	
	/* Constructors */
	/**
	 * Constructor SIN Parametros 
	 */
	public Articulo() {
		super();
	
	}//Fin Constructor SIN
	
	/**
	 * Constructor CON Parametros
	 * 
	 * @param codigoID Código identificador del articulo
	 * @param descripcionArticulo Descripción breve del articulo
	 * @param precioDeCompra Valor monetario de compra del articulo
	 * @param precioDeVenta Valor monetario de venta del articulo
	 * @param articleStock Cantidad de articulos iguales en el almacen
	 */
	public Articulo(String codigoID, String descripcionArticulo, double precioDeCompra, double precioDeVenta,
			int articleStock) {
		
		super();
		
		this.codigoID = codigoID;
		this.descripcionArticulo = descripcionArticulo;
		this.precioDeCompra = precioDeCompra;
		this.precioDeVenta = precioDeVenta;
		this.articleStock = articleStock;
		
	}//Fin Constructor CON

	
	/* Getters and Setters */
	/**
	 * Getter del código identificador
	 * 
	 * @return codigoID Código Identificador del producto
	 */
	public String getCodigoID() {
		return this.codigoID;
	}

	/**
	 * Setter del código identificador
	 * 
	 * @param codigoID Código Identificador del producto
	 */
	public void setCodigoID(String codigoID) {
		this.codigoID = codigoID;
	}

	/**
	 * Getter de la descripción del articulo
	 * 
	 * @return descripcionArticulo Breve descripción del articulo
	 */
	public String getDescripcionArticulo() {
		return this.descripcionArticulo;
	}

	/**
	 * Setter de la descripción del articulo
	 * 
	 * @param descripcionArticulo Breve descripción del articulo
	 */
	public void setDescripcionArticulo(String descripcionArticulo) {
		this.descripcionArticulo = descripcionArticulo;
	}

	/**
	 * Getter del precio de compra del articulo
	 * 
	 * @return precioDeCompra Valor monetario de compra del articulo
	 */
	public double getPrecioDeCompra() {
		return this.precioDeCompra;
	}

	/**
	 * Setter del precio de compra del articulo
	 * 
	 * @param precioDeCompra Valor monetario de compra del articulo
	 */
	public void setPrecioDeCompra(double precioDeCompra) {
		this.precioDeCompra = precioDeCompra;
	}

	/**
	 * Getter del precio de venta del articulo
	 * 
	 * @return precioDeVenta Valor monetario de venta del articulo
	 */
	public double getPrecioDeVenta() {
		return this.precioDeVenta;
	}

	/**
	 * Setter del precio de venta del articulo
	 * 
	 * @param precioDeVenta Valor monetario de venta del articulo
	 */
	public void setPrecioDeVenta(double precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}

	/**
	 * Getter del stok del articulo en el almacen
	 * 
	 * @return articleStock Cantidad de articulos iguales en el almacen
	 */
	public int getArticleStock() {
		return this.articleStock;
	}

	/**
	 * Setter del stok del articulo en el almacen
	 * 
	 * @param articleStock Cantidad de articulos iguales en el almacen
	 */
	public void setArticleStock(int articleStock) {
		this.articleStock = articleStock;
	}

	/* Métodos */
	/**
	 * Método toString de la clase Articulo, que transforma la información contenida en ella en ujna String
	 */
	public String toString() {
		
		/* PCC: String a devolver */
		String stringArticulo = "";
		
		stringArticulo = "Articulo --> Código: " + codigoID + ".\n"
						+ "\t Descripción: " + descripcionArticulo + ".\n"
						+ "\t Precio de Compra: " + precioDeCompra + ".\n"
						+ "\t Precio de Venta: " + precioDeVenta + ".\n"
						+ "\t Stock en Almacén: " + articleStock + ".\n";
		
		return stringArticulo;
		
	}//Fin toString()
	
}
