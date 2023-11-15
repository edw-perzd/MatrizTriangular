package matriztriangular;

import java.util.Scanner;

public class MatrizTriangular {
    static Scanner en = new Scanner(System.in);;
    public static void main(String[] args) { 
        
        int dim;
        int[][] matriz;
        
        System.out.println("Matriz triangular");
        System.out.println("Ingresa la dimension de la matriz: ");
        dim = en.nextInt();
        
        matriz = llenar(dim);
        
        imprimir(matriz);
        
        comprobar(matriz);
        
    }
    
    public static int[][] llenar(int dim){
        int[][] matriz = new int[dim][dim];
        
        for(int i=0; i<dim; i++){
            for(int j=0; j<dim; j++){
                System.out.println("Ingresa el valor de la posicion [" + i + "][" + j + "]: ");
                matriz[i][j] = en.nextInt();
            }
        }
        
        return matriz;
    }
    
    public static void imprimir(int[][] matriz){
        for(int i=0; i<matriz.length; i++){
            for(int j=0; j<matriz.length; j++){
                System.out.print(matriz[i][j] + "   ");
            }
            System.out.println();
        }
    }
    
    public static void comprobar(int[][] matriz){
        int superior=0, inferior=0;
        int aux = 2;
        //int k=matriz.length-1;
        /* Superior */
        for(int i=matriz.length-1; i>=1; i--){
            
            for(int j=matriz.length-aux; j>=0; j--){
                if(matriz[i][j]==0){
                    superior = 1;
                }
                else{
                    superior = 0;
                    break;
                }
            }
            if(superior==0){
                break;
            }
            aux++;
        }
        /* Inferior */
        /*for(int i=matriz.length-1; i>=1; i--){
            for(int j=matriz.length-2; j>=0; j--){
                if(matriz[i][j]==0){
                    inferior = 1;
                }
                else{
                    superior = 0;
                }
            }
        }*/
        if(superior == 1){
            System.out.println("Es una matriz triangular superior");
        }
        /*if(inferior == 1){
            System.out.println("Es una matriz triangular inferior");
        }
        if(superior == 1 && inferior == 1){
            System.out.println("Ni inferior ni superior");
        }*/
    }
}
