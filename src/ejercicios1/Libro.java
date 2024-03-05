package ejercicios1;

/**
 * Class that contains information of the library's books 
 * 
 * @author Eileen
 */
public class Libro {

	/* Attributes */
	/**
	 * Title of the book
	 */
	private String bookTitle = "";
	
	/**
	 * Author of the book
	 */
	private String bookAuthor = "";
	
	/**
	 * Stock of an specific book
	 */
	private int bookStock;
	
	/**
	 * Quantity of specific borrowed books
	 */
	private int booksBorrowed;
	
	
	/* Constructor */
	/**
	 * Constructor without parameters
	 */
	public Libro() {}
	
	/**
	 * Constructor with all the attributes as parameters
	 * 
	 * @param bookTitle Title of the book
	 * @param bookAuthor Author of the book
	 * @param bookStock Stock of an specific book
	 * @param booksBorrowed Quantity of specific borrowed books
	 */
	public Libro(String bookTitle, String bookAuthor, int bookStock, int booksBorrowed) {
		
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookStock = bookStock;
		this.booksBorrowed = booksBorrowed;
		
	}//Constructor WITH
	
	
	/* Methods */
	/**
	 * Method that manages the borrowing of books
	 * 
	 * @return bookIsBorrowed If the borrowing was succesful or not
	 */
	public boolean borrowBook() {
		
		/* Declarations */
			/* PCC: boolean to return */
		boolean bookIsBorrowed = false;
		
		//Stock Comprobation
		if(this.bookStock > 0 ) {
			
			//Operations
			this.bookStock = this.bookStock - 1;
			this.booksBorrowed = this.booksBorrowed + 1;
			
			bookIsBorrowed = true;
			
		}//Fin IF --> Stock Comprobation
		
		/* Return */
		return bookIsBorrowed;
		
	}//Fin borrowBook()
	
	/**
	 * Method to turn this book into a String
	 */
	@Override
	public String toString() {
		return "Libro [bookTitle=" + bookTitle + ", bookAuthor=" + bookAuthor + ", bookStock=" + bookStock
				+ ", booksBorrowed=" + booksBorrowed + "]";
	}

	/**
	 * Method to manage book returning
	 * 
	 * @return bookIsReturned If the return of the book was succesful or not
	 */
	public boolean returnBook() {
		
		/* Declarations */
			/* PCC: boolean to return */
		boolean bookIsReturned = false;
		
		//Stock Comprobation
		if(this.booksBorrowed > 0 ) {
			
			//Operations
			this.bookStock = this.bookStock + 1;
			this.booksBorrowed = this.booksBorrowed - 1;
			
			bookIsReturned = true;
			
		}//Fin IF --> Stock Comprobation
		
		/* Return */
		return bookIsReturned;
		
	}//Fin returnBook()
	
}
