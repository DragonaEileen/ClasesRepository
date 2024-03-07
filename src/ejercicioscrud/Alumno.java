package ejercicioscrud;

/**
 * Clase que define un alumno de una organización escolar
 * 
 * @author Eileen
 */
public class Alumno {
	
	/* Atributos */
	/**
	 * Nombre del Alumno
	 */
	private String studentName = "";
	
	/**
	 * Valor de la nota media del alumno
	 */
	private double averageGrade;
	
	
	/* Constructores */
	/**
	 * Constructor SIN Parametros 
	 */
	public Alumno() {}
	
	/**
	 * Constructor CON Parametros
	 * 
	 * @param studentName Nombre del alumno
	 * @param averageGrade Nota Media del Alumno
	 */
	public Alumno(String studentName, double averageGrade) {
		
		this.studentName = studentName;
		this.averageGrade = averageGrade;
		
	}//Constructor con Parametros
	
	/* Getters */
	/**
	 * Metodo para obtener el nombre del alumno
	 * 
	 * @return studentName Nombre del alumno
	 */
	public String getStudentName() {
		
		return this.studentName;
		
	}//Fin getStudentName()
	
	/**
	 * Metodo para obtener la nota media del alumno
	 * 
	 * @return averageGrade
	 */
	public double getAverageGrade() {
		
		return this.averageGrade;
		
	}//Fin getAverageGrade
	
	/* Setters */
	/**
	 * Metodo para asociar un nombre al alumno
	 * 
	 * @param studentName Nombre del Alumno
	 */
	public void setStudentName(String studentName) {
		
		this.studentName = studentName;
		
	}//Fin setStudentName()
	
	/**
	 * Metodo para sociar una nota media al alumno
	 * 
	 * @param averageGrade Nota Media del Alumno
	 */
	public void setAverageGrade(double averageGrade) {
		
		this.averageGrade = averageGrade;
		
	}//Fin setAverageGrade()

	/* Metodos */
	/**
	 * Método para convertir la información del alumno en una String
	 * 
	 * @return stringAlumno Cadena con la información del alumno
	 */
	public String toString() {
		
		String stringAlumno = "Alumno: " + studentName + ". Nota Media: " + averageGrade;
		
		return stringAlumno;
		
	}//Fin toString
	
	
	
}
