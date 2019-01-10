import java.util.Timer;
import java.util.TimerTask;

public class JavaFuncional {
	public static void main(String[] args) {
		funcional();
	}
	public static void funcional() {
		
		// For each
		String[] ejemplo = {"a","b","c"};
		String ej ="";
		for(String e : ejemplo) { //los dos puntos es lo mismo que: int e = 0; e<ejemplo.length;e++ 
			ej+=e;	//se podria hacer con chars o otra cosa para hacer algo
		}
		
		System.out.println("For each funcional creado, el ejemplo es: "+ej);
		
		
		// Para no tener que hacer splits ni ostias esto le quita los espacios al string si los tiene
		ej.trim();
		
		// Para no tener que hacer un hilo que de la hora o que haga lo que sea se puede usar la clase timer
		// Que es igual que un hilo pero es mas facil.
		TimerTask taskNew = new TimerTask() { //Tarea que se repetirá periodicamente
			private int time=0;
			@Override
			public void run() {
				time+=1;
				System.out.println("Tic, tac... "+time);}
			};
		Timer timer = new Timer();	// El timer que repetira la tarea
		timer.scheduleAtFixedRate(taskNew, 0, 1000); // Asignamos la tarea al timer y ponemos el tiempo segun como querams
		
		
		//En los hilos:
		//El metodo runnable se puede definir como "() ->" y empezar el metodo con las llaves { y terminarlo }
		Thread t = new Thread( 
				() -> { 
					for (String i : ejemplo) {
						System.out.println("Lo que cojones quieras hacer");;
						try { Thread.sleep( 2000 ); } catch (InterruptedException e) {}
						}
				}
			);
			t.start();

		//Interfaces predefinidos clásicos para notación lambda:  
		//(excepto Runnable, todos en java.util.function)
		//
		//Runnable --> run()
		//Consumer<T> --> void accept(T)
		//Predicate<T> --> boolean test(T)
		//Supplier<T> --> T get()
		//Function<T,R> --> R apply(T)
		
		// Las funciones de lambda son funciones a las que se les define el valor despues de crearlas
		// Es decir, podran hacer cualquier cosa que no sea un return, incluyendo editar atributos,
		// imprimir en pantalla o cualquier cosa que asignes
	
		LambdaFunction lbF = (String l)-> System.out.println("Ejemplo de java funcional con lambda");
		lbF.call(null);
		
		LambdaFunctionSuma lbfSuma = (int r,int a) -> System.out.println("La suma es "+ (r+a));
		lbfSuma.call(4, 9);
		
		LambdaFunctionCuadrado lbfCuadrado = (int s) -> cuadrado(s);
		lbfCuadrado.call(8);
		System.out.println("El resultado del cuadrado es: "+ cuad); // lo imprimo para demostrarlo
	}
	// Se pueden modificar atributos
	private static int cuad;
	public static void cuadrado(int a) {	cuad= a*a;	}
	interface LambdaFunctionCuadrado{	void call (int a);	}

	interface LambdaFunction{	void call (String s);	}
	
	interface LambdaFunctionSuma{	void call (int a, int b);	}
	
}
