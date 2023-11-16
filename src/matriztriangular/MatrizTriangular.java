package matriztriangular;

import java.util.Scanner;

public class MatrizTriangular {
    static Scanner en = new Scanner(System.in);;
    public static void main(String[] args) { 
        
        int dim;
        double[][] matriz;
        double[][] superior;
        double[][] inferior;
        
        System.out.println("Matriz triangular");
        System.out.println("Ingresa la dimension de la matriz: ");
        dim = en.nextInt();
        
        superior=new double[dim][dim];
        inferior=new double[dim][dim];
        // Se llena la matriz
        matriz = llenar(dim);
        // Se calcula tanto la matriz superior como la inferior de la matriz original
        calcularM(matriz, inferior, superior);
        
        // Imprimimos todas las matrices
        System.out.println("Matriz original");
        imprimir(matriz);
        System.out.println("");
        System.out.println("Matriz triangular superior");
        imprimir(superior);
        System.out.println("");
        System.out.println("Matriz triangular inferior");
        imprimir(inferior);
        
    }
    
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
    
    public static void imprimir(double[][] matriz){
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++){
                System.out.print(matriz[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
    private static void calcularM(double[][] original, double[][] inferior, double[][] superior) {

        for (int k = 0; k < original.length; k++) {
            inferior[k][k] = 1; // Diagonal principal de la matriz inferior es 1

            for (int i = k + 1; i < original.length; i++) {
                double factor = original[i][k] / original[k][k];
                inferior[i][k] = factor;

                for (int j = k; j < original.length; j++) {
                    original[i][j] -= factor * original[k][j];
                }
            }

            for (int j = k; j < original.length; j++) {
                superior[k][j] = original[k][j];
            }
        }
    }
}
