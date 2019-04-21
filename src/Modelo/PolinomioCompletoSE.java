package Modelo;

import java.util.NoSuchElementException;

public class PolinomioCompletoSE {
	private Nodo primerTermino;

	public PolinomioCompletoSE() {
		this.primerTermino = null;
	}

	public PolinomioCompletoSE(double[] vector) {
		this.agregarVector(vector);
	}

	public Nodo getPrimerTermino() {
		return primerTermino;
	}

	public void setPrimerTermino(Nodo primerTermino) {
		this.primerTermino = primerTermino;
	}

	public boolean agregar(double coeficiente) {
		if (coeficiente != 0) {
			Nodo nuevoNodo = new Nodo(coeficiente);
			Nodo actual = primerTermino;
			Nodo anterior = null;

			while (actual != null) {
				anterior = actual;
				actual = actual.getNodoSiguiente();
			}

			if (anterior == null) {
				primerTermino = nuevoNodo;
			} else {
				anterior.cambiarSiguiente(nuevoNodo);
			}
			return true;
		}
		return false;
	}

	public double coeficiente(int exponente) throws NoSuchElementException {
		if (!this.estaVacio()) {
			int iterator = 0;
			Nodo aux = this.primerTermino;

			while (aux != null) {
				if (iterator == exponente) {
					return aux.getCoeficiente();
				}

				iterator++;
				aux = aux.getNodoSiguiente();
			}
		}
		throw new NoSuchElementException();
	}

	private void agregarVector(double[] vector) {
		for (int i = 0; i < vector.length; i++) {
			if (vector[i] != 0) {
				this.agregar(vector[i]);
			}
		}
	}

	public boolean estaVacio() {
		if (primerTermino == null) {
			return true;
		}
		return false;
	}

	public double evaluar(double x) {
		double valueTermino = this.primerTermino.getCoeficiente();
		return valueTermino + (evaluar(x, this.primerTermino.getNodoSiguiente(), 1));
	}

	private double evaluar(double x, Nodo nodo, int exponente) {
		if (nodo != null) {
			return ((nodo.getCoeficiente()) * (Math.pow(x, exponente)))
					+ evaluar(x, nodo.getNodoSiguiente(), (exponente + 1));
		} else {
			return 0;
		}
	}

	public boolean esIgual(PolinomioCompletoSE otro) {
		Nodo aux = this.primerTermino;
		Nodo auxOtro = otro.getPrimerTermino();
		boolean response = false;
		
		if (this.cantidadTerminos() == otro.cantidadTerminos()) {
			response = true;
			while (aux != null) {
				response = response && aux.getCoeficiente() == auxOtro.getCoeficiente();

				aux = aux.getNodoSiguiente();
				auxOtro = auxOtro.getNodoSiguiente();
			}
		}
		return response;
	}

	public int cantidadTerminos() {
		int cantidadTerminos = 0;
		Nodo aux = this.primerTermino;
		while (aux != null) {
			cantidadTerminos++;
			aux = aux.getNodoSiguiente();
		}
		return cantidadTerminos;
	}
	
	public int grado() {
		return this.cantidadTerminos() - 1; 
	}

	public PolinomioCompletoSE clonar(){
		PolinomioCompletoSE clon = new PolinomioCompletoSE();
		Nodo aux = this.primerTermino;
		
		while(aux != null) {
			clon.agregar(aux.getCoeficiente());
			aux = aux.getNodoSiguiente();
		}
		
		return clon;
	}
	
	
	   @Override
	    public String toString() {
	        String cadena = "";
	        Nodo actual = this.primerTermino;
	        int exponente = -1;

	        while (actual != null) {
	            double coeficiente = actual.getCoeficiente();
	            exponente++;
	            String signo = "";

	            if (actual.getNodoSiguiente() != null) {
	                if (coeficiente < 0) {
	                    signo = " - ";
	                } else {
	                    signo = " + ";
	                }
	            } else if (coeficiente < 0) {
	                signo = "-";
	            }
	            cadena = signo + convertirTermino(coeficiente, exponente) + cadena;
	            actual = actual.getNodoSiguiente();
	        }
	        return cadena;
	    }
	   
	   private String convertirTermino(double coeficiente, int exponente) {
	        coeficiente = Math.abs(coeficiente);
	        int valorEntero = (int) coeficiente;
	        String cadena = "";

	        if (valorEntero == coeficiente) {
	            cadena += valorEntero;
	        } else {
	            cadena += coeficiente;
	        }
	        if (exponente > 0) {
	            if (coeficiente == 1) {
	                cadena = "";
	            }
	            if (exponente == 1) {
	                cadena += "x";
	            } else {
	                cadena += "x^" + exponente;
	            }
	        }
	        return cadena;
	    }
}
