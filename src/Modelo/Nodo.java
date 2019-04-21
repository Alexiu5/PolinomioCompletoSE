package Modelo;

public class Nodo {

	private double coeficiente;
	private Nodo nodoSiguiente;

	public Nodo(double coeficiente) {
		this.coeficiente = coeficiente;
		this.nodoSiguiente = null;
	}

	public Nodo(double coeficiente, Nodo nodoSiguiente) {
		this.coeficiente = coeficiente;
		this.nodoSiguiente = nodoSiguiente;
	}

	public double getCoeficiente() {
		return coeficiente;
	}

	public void setCoeficiente(double coeficiente) {
		this.coeficiente = coeficiente;
	}

	public Nodo getNodoSiguiente() {
		return nodoSiguiente;
	}

	public void setNodoSiguiente(Nodo nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	
	// Custom methods
	
	public void cambiarSiguiente(Nodo siguiente) {
		this.nodoSiguiente = siguiente;
	}

}
