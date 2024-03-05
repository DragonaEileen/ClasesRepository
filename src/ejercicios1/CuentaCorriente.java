package ejercicios1;

/**
 * Class that contains the DNI, name and money, alongside operation with the money
 * 
 * @author Eileen
 */
public class CuentaCorriente {
	
	/* Attributes */
	/**
	 * National Identifier Number of the account's owner
	 */
	private String DNI = "";
	
	/**
	 * Name of the account's owner
	 */
	private String personName = "";
	
	/**
	 * Quantity of monetary units that the account has in the present moment
	 */
	private double accountMoney;
	
	
	/* Constructors */
	/**
	 * Constructor with the "DNI" and an initial "accountMoney"
	 * 
	 * @param DNI National Identifier Number of the account's owner
	 * @param initialMoney Initial quantity of monetary units that the account will have
	 */
	public CuentaCorriente(final String DNI, double initialMoney) {
		
		this.DNI = DNI;
		this.accountMoney = initialMoney;
		
	}//Fin Constructor(DNI, initialMoney)
	
	/**
	 * Constructor with the "DNI", "personName", and an initial "accountMoney"
	 * 
	 * @param DNI National Identifier Number of the account's owner
	 * @param initialMoney Initial quantity of monetary units that the account will have
	 * @param personName Name of the account's owner
	 */
	public CuentaCorriente(final String DNI, double initialMoney, String personName) {
		
		this.DNI = DNI;
		this.accountMoney = initialMoney;
		this.personName = personName;
		
	}//Fin Constructor(DNI, initialMoney, personName)	
	
	
	/* Methods */
	/**
	 * Method to turn all the account's information in a String to print directly the object
	 */
	public String toString() {
		
		return "CuentaCorriente [DNI=" + DNI + ", personName=" + personName + ", accountMoney=" + accountMoney + "]";
		
	}//Fin toString()
	
	/**
	 * Method in order to increase (or decrease) the "accountMoney"
	 * 
	 * @param modifier Value in that the "accountMoney" increases or decreases by
	 */
	private void modifyMoney(double modifier) {
		
		this.accountMoney = this.accountMoney + modifier;
		
	}//Fin modifyMoney()
	
	/**
	 * Method to get money out of the account
	 * 
	 * @param takeAwayMoney Quantity of monetary units that is taken from the account
	 */
	public void takeAway(double takeAwayMoney) {
		
		modifyMoney(-takeAwayMoney);
		
	}//Fin takeAway()
	
	/**
	 * Method to insert money into the account
	 * 
	 * @param insertedMoney Quantity of monetary units that are inserted into the account
	 */
	public void insertMoney(double insertedMoney) {
		
		modifyMoney(insertedMoney);
		
	}//Fin insertMoney()
	
}
