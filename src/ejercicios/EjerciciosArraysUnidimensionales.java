package ejercicios;

import java.util.Scanner;

public class EjerciciosArraysUnidimensionales {
    public EjerciciosArraysUnidimensionales() {
        // Llena un array de 10 elementos con números aleatorios entre 1 y 100. 
        //Luego, recorre el array para encontrar y mostrar el valor mínimo y el valor máximo
        
        //ejercicio1();

        //Crea un array de 20 números enteros entre 1 y 10 (pueden ser aleatorios). 
        //Muestra cuántas veces aparece cada número en el array.:
        
        //ejercicio2();

        //Crea un array de 6 elementos y permite que el usuario los ingrese. 
        // Invierte el orden de los elementos y muestra el array resultante.
        
        //ejercicio3();

        //Crea dos arrays de 5 elementos cada uno con valores ingresados por el usuario.
        //Genera un tercer array que intercale los valores de los dos primeros arrays
        //(es decir, el primer elemento del primer array, seguido del primer elemento del segundo array, y así sucesivamente).
        //Muestra el array resultante
        
        //ejercicio4();
    }

    private void ejercicio1(){
        
        int numRandom, numMenor, numMayor;
        numMayor = Integer.MIN_VALUE;
        numMenor = Integer.MAX_VALUE;
        String arrString = "";

        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++){
            numRandom = (int)(Math.floor(Math.random()*100+1));
            arr[i] = numRandom;
            arrString += arr[i] + " ";
            if (numMenor > numRandom) numMenor = numRandom;
            if(numMayor < numRandom) numMayor = numRandom;
        }
        System.out.println(arrString);

        System.out.printf("Número mayor: %3d%nNúmero menor: %3d%n", numMayor, numMenor);

    }

    private void ejercicio2(){
        int uno=0,dos=0,tres=0,cuatro=0,cinco=0,seis=0,siete=0,ocho=0,nueve=0,diez=0;
        int numRandom;
        String arrString = "";

        int[] numeros = new int[20];

        for(int i = 0; i < numeros.length; i++){
            numRandom = (int)(Math.floor(Math.random()*10 +1));
            numeros[i] = numRandom;
            arrString += numeros[i] + " ";
            switch (numeros[i]) {
                case 1:
                    uno++;
                    break;
                case 2:
                    dos++;
                    break;
                case 3:
                    tres++;
                    break;
                case 4:
                    cuatro++;
                    break;
                case 5:
                    cinco++;
                    break;
                case 6:
                    seis++;
                    break;
                case 7:
                    siete++;
                    break;
                case 8:
                    ocho++;
                    break;
                case 9:
                    nueve++;
                    break;
                case 10:
                    diez++;
                    break;
            }
        }
        System.out.println(arrString);
        System.out.printf("Uno: %2d%nDos: %2d%nTres: %2d%nCuatro: %2d%nCinco: %2d%nSeis: %2d%nSiete: %2s%nOcho: %2d%nNueve: %2d%nDiez: %2d%n",
        uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,diez);
    }

    private void ejercicio3(){
        
        Scanner sc = new Scanner(System.in);
        int[] numeros = new int[6];
        int numUsuario;

        for(int i = numeros.length -1; i >= 0; i--){
            System.out.println("Introduce un número para meterlo al array:");
            numUsuario = sc.nextInt();

            numeros[i] = numUsuario;
        }

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("- " + numeros[i]);
        }

    }

    private void ejercicio4(){
        Scanner sc = new Scanner(System.in);
        int numUsuario,contador=0;
        int[] arr1 = new int[5];
        int[] arr2 = new int[5];
        int[] arr3 = new int[arr1.length * 2];

        System.out.println("Rellena el array 1 con números:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.println("Posición " + i + ":");
            numUsuario = sc.nextInt();
            arr1[i] = numUsuario;

        }

        System.out.println("Rellena el array 2 con números:");
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Posición " + i + ":");
            numUsuario = sc.nextInt();
            arr2[i] = numUsuario;

        }

        for (int i = 0; i < arr3.length; i++) {
            if(i%2 == 0){
                arr3[i] = arr1[contador];              
            }else{
                arr3[i] = arr2[contador];
                contador++;
            }            
        }
        
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(" - " + arr3[i]);
        }
        
        
    }
}
