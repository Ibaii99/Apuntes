public class Recursividad {

	
	public double factorial(int n){
	    if (n==0) return 1; // caso base   
	    else return n*(factorial(n-1)); // Caso recursivo con decremento de la cota hasta lleagr al caso base
	}
	
	
}
