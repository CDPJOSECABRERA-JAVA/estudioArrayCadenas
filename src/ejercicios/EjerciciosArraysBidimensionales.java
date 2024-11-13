package ejercicios;

import java.util.Arrays;

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

    //ejercicio4();
    }
    
    private void ejercicio1(){

        int[][] arr = {{3,2},{50,7},{1,11}};
        int numMenorF, numMayorF, numMayor = arr[0][0], numMenor = arr[0][0];
        
        for(int i = 0; i < arr.length; i++){
            numMayorF = arr[i][0];
            numMenorF = arr[i][0];
            for(int j = 0; j < arr[i].length; j++){               
                if (arr[i][j] > numMayorF) numMayorF = arr[i][j];
                if (arr[i][j] < numMenorF) numMenorF = arr[i][j];

                if (numMayorF > numMayor) numMayor = numMayorF;
                if (numMenorF < numMenor) numMenor = numMenorF;
            }
            System.out.printf("%nFila %d:%n Numero mayor: %d.%n Numero menor: %d.", i+1, numMayorF, numMenorF);
        } 
        System.out.printf("%nNUMERO MAYOR: %d%nNUMERO MENOR: %d", numMayor, numMenor);     
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
        int[][] arr = {
                        {1,15,14,4},
                        {12,6,7,9},
                        {8,10,11,5},
                        {13,3,2,16}
                    };
        int sum = 0, sumaF = 0, sumaC = 0, sumaD = 0, sumaDI = 0;
        boolean magico = false;

        for (int f = 0; f < arr.length; f++) {
                sumaD += arr[f][f];
                sumaDI += arr[f][arr.length-1-f];
            for (int c = 0; c < arr.length; c++) {
                sumaF+= arr[f][c];
                sumaC+= arr[c][f];
            }         
        }

        magico = (double)sumaF/arr.length == (double)sumaC/arr.length && (double)sumaF/arr.length == sumaD && (double)sumaF/arr.length == sumaDI;

        if (magico) {
            System.out.println("es magico");
        }else System.out.println("no");
        
        System.out.printf("%d, %d, %d, %d", sumaF/arr.length, sumaC/arr.length, sumaD, sumaDI);
    }

    private void ejercicio4(){
        int[][] arr = new int[5][5];
    }
}
