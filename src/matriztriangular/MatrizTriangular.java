package matriztriangular;

import java.util.Scanner;

public class MatrizTriangular {
    static Scanner en = new Scanner(System.in);;
    public static void main(String[] args) { 
        
        int dim;
        double[][] matriz;
 
        System.out.println("Matriz triangular");
        // Se le pide al usuario ingresar la dimensión de la matriz
        System.out.println("Ingresa la dimension de la matriz: ");
        dim = en.nextInt();
        
        // Se llena la matriz pidiendo los datos del usuario
        matriz = llenar(dim);
        
        // Se muestra la matriz ingresada
        System.out.println("Matriz ingresada");
        imprimir(matriz);

        // Solicitar el tipo de matriz al usuario y mostrar solo la matriz solicitada
        solicitarYMostrarMatriz(matriz);

    }
    
    // Método que llena la matriz
    public static double[][] llenar(int dim){
        double[][] matriz = new double[dim][dim];
        
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                System.out.println("Ingresa el valor de la posicion [" + i + "][" + j + "]: ");
                matriz[i][j] = en.nextInt();
            }
        }
        
        return matriz;
    }
    
    // Método que imprime matriz
    public static void imprimir(double[][] matriz){
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++){
                System.out.print(matriz[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
    // Método que calcula la matriz superior
    private static double[][] calcularSup(double[][] s) {

        for (int k = 0; k < s.length; k++) {

            for (int i = k + 1; i < s.length; i++) {
                double factor = s[i][k] / s[k][k];

                for (int j = k; j < s.length; j++) {
                    s[i][j] -= factor * s[k][j];
                }
            }
        }
	return s;
    }

    // Método que calcula la matriz inferior
    private static double[][] calcularInf(double[][] inf){

	for (int k = inf.length - 1; k > -1; k--){
	    
	    for (int i = k - 1; i > -1; i--){
		double f = inf[i][k] / inf[k][k];

		for (int j = k; j > -1; j--){
		    inf[i][j] -= f * inf[k][j];
		}
	    }
	}
	
	return inf;
    }
    
    // Método que solicita e imprime el tipo de matriz se desea mostrar
    private static void solicitarYMostrarMatriz(double[][] r) {
        System.out.println("Inserta la letra, para la opcion que deseas calcular");
        System.out.println("(a) - Matriz triangular superior");
        System.out.println("(b) - Matriz triangular inferior");

        char tipMatriz = en.next().charAt(0);

        System.out.println("");
        System.out.println("Matriz solicitada:");
        System.out.println();

        if (tipMatriz == 'a' || tipMatriz == 'A') {
            System.out.println("Matriz triangular superior");
            imprimir(calcularSup(r));
            
        } else if (tipMatriz == 'b' || tipMatriz == 'B') {
            System.out.println("Matriz triangular inferior");
            imprimir(calcularInf(r));
        } else {
            System.out.println("Opción no valida");
        }
    }
}
