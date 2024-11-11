package ejercicios;

public class EjerciciosArraysBidimensionales {
    public EjerciciosArraysBidimensionales(){

    //1.- Escriba un programa que permita registrar 6 números en forma de tabla 3x2. A continuación el programa
    //mostrará los valores máximo y mínimo de cada fila y de toda la tabla.
        
    //ejercicio1();
    
    /* 

    2.-Disena un programa en Java que rellene un array de 4x4 de la siguiente manera:

    1 0 0 0

    0 1 0 0

    0 0 1 0

    0 0 0 1
    A continuación muestre el contenido del array por pantalla.
    */

    //ejercicio2();

    //3.-Diseñar un programa en Java que compruebe si un array de enteros de 5x5, es un cuadrado mágico. Se considera
    //un cuadrado mágico aquel en el que las filas, las columnas y las diagonales suman igual.

    ejercicio3();

    /*
    4.- Dado un array de enteros de tamaño 5x5, diseñar un programa en Java que lo rellene como en la siguiente figura:
    0 1 2 3 4
    1 2 3 4 3
    2 3 4 3 2
    3 4 3 2 1
    4 3 2 1 0
    */
    }
    
    private void ejercicio1(){

        int[][] arr = {{3,2},{50,7},{1,11}};
        int numMenor = arr[0][0], numMayor = arr[0][0];
        

        for(int i = 0; i < arr.length; i++){
            
            if (arr[i][0] == arr[i][1]) {
                System.out.println("Fila son iguales.");
            }else if(arr[i][0] > arr[i][1]){
                System.out.println("Fila " + (i+1) + ": Num mayor: " + arr[i][0] + " Num menor: " + arr[i][1]);
            }else{
                System.out.println("Fila " + (i+1) + ": Num mayor: " + arr[i][1] + " Num menor: " + arr[i][0]);
            }          
            
            for(int j = 0; j < arr[i].length; j++){               
                if (arr[i][j] < numMenor) numMenor = arr[i][j];
                if (arr[i][j] > numMayor) numMayor = arr[i][j];
            }
        }
        System.out.println(numMayor + " " + numMenor);
        
    }

    private void ejercicio2(){
        int[][] arr = new int[5][5];

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void ejercicio3(){
        int[][] arr = new int[5][5];
        int num = 0;

        for (int f = 0; f < arr.length; f++) {
            for (int c = 0; c < arr.length; c++) {
                
            }
        }
    }
}
