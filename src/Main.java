import Modelo.PolinomioCompletoSE;

public class Main {

	public static void main(String[] args) {
		double[] vector = new double[] {1,2,3,4,5,6,7,8,9};
		PolinomioCompletoSE polinomio = new PolinomioCompletoSE(vector);
		System.out.println(polinomio.toString());
		System.out.println(polinomio.estaVacio());
		System.out.println(polinomio.coeficiente(5));
		System.out.println(polinomio.evaluar(1));
		System.out.println(polinomio.esIgual(polinomio.clonar())); 
		System.out.println(polinomio.grado());
		System.out.println(polinomio.cantidadTerminos());
		System.out.println(polinomio.derivar());
		System.out.println(polinomio.clonar().toString());
	}

}
