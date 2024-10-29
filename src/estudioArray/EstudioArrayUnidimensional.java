package estudioArray;

import java.util.Scanner;

public class EstudioArrayUnidimensional {

    public EstudioArrayUnidimensional(){
        System.out.println("Estudio de arrays unidimensionales.");
        int[] enteros; enteros = new int[5];
        enteros[0] = 1; enteros[1] = 3; enteros[2] = 8; enteros[3] = 2; enteros[4] = 9;
        int[] notas = {2,4,6,8,10,6,4,9,2,3};
        int suspensos = 0, aprobados = 0;
        for (int i = 0; i < notas.length; i++) {
            if(notas[i] < 5) suspensos++;
            else aprobados++;
        }
        System.out.printf("Aprobados: %d Suspendidos: %d", aprobados, suspensos);

        //int[] notas2 = notas; esto no crea una copia, ocupan la misma posicion en memoria y es el mismo array.
        int numero = 5;
        double media = calcularMedia(notas, numero);
        System.out.println("\nLa media es: " + media);
        System.out.println(numero);

        int[] primitiva = generaPrimitiva();

        for (int i : primitiva) {
            System.out.print(" - " + i);
        }
        System.out.println("\n");

        String[] nombres = {"Juan", "Pepe", "Luis", "Jose", "Antonio", "Felipe", "Manolo", "Nobita", "John", "Arthur"};

        //ARRAYS PARALELOS
        for(int i = 0; i < nombres.length; i++) System.out.printf("%7s %2d %n", nombres[i], notas[i]);
        int notable = 0, sobresaliente = 0, bien = 0, suficiente = 0, insuficiente = 0;
        suspensos = 0; 
        aprobados = 0;
        
        for(int i = 0; i < notas.length; i++){
            if (notas[i] >= 5) {
                aprobados++;
                if (notas[i] == 5) {
                    suficiente++;
                }else if(notas[i] <= 6){
                    bien++;
                }else if(notas[i] <= 8){
                    notable++;
                }else if(notas[i] <= 10){
                    sobresaliente++;
                }
            }else{
                suspensos++;
                insuficiente++;
            }
        }
        
        System.out.println("\nESTADISTICAS DE NOTAS: \n");
        System.out.printf("Aprobados: %2d Suspensos: %2d%n", aprobados, suspensos);
        System.out.printf("Insuficientes: %2d%nSuficientes: %2d%nBien: %2d%nNotable: %2d%nSobresaliente:%2d%n", insuficiente, suficiente, bien, notable, sobresaliente);
        // ARRAY BIDIMENSIONAL
        /*
        System.out.println("\nARRAY BIDIMENSIONAL");

        int[][] tabla = new int[10][10];
        int cont = 0;
        for(int i = 0; i < tabla.length; i++){
            System.out.println("\n");
            for(int j = 0; j < tabla.length; j++){
                tabla[i][j] = cont;
                System.out.printf("%3d", tabla[i][j]);
                cont++;
            }
        }
        */
        
        
    
        // GENERAR NUMEROS ALEATORIOS Y QUE NO SE REPITAN
        int[] numerosAleatorios = generaAleatorios();

        for (int i : numerosAleatorios) {
            System.out.print("- " + i);
        }

    }



    // ----------------------------------------------------------------------------------------------

    private int[] generaAleatorios(){
        Scanner sc = new Scanner(System.in);
        int cantidad, numeroMin, numeroMax, numRandom;
        boolean numEncotrado = false;
        
        System.out.println("¿Cuántos números aleatorios quieres generar?");
        cantidad = sc.nextInt();
        int[] arrRandoms = new int[cantidad];

        System.out.println("¿Cuál es el valor mínimo?");
        numeroMin = sc.nextInt();

        System.out.println("¿Cuál es el valor máximo?");
        numeroMax = sc.nextInt();

        if (numeroMin > numeroMax) {
            int c = numeroMax;
            numeroMax = numeroMin;
            numeroMin = c;
        }

        for(int i = 0; i < arrRandoms.length; i++){
            numRandom = (int)(Math.floor(Math.random() * (numeroMax - numeroMin + 1)) + numeroMin);

            for (int j = 0; j < arrRandoms.length; j++) {
                if (numRandom == arrRandoms[j]) {
                    numEncotrado = true;
                    break;
                }
            }
            if (numEncotrado) i--;
            else arrRandoms[i] = numRandom;

            numEncotrado = false;
            
        }


        return arrRandoms;
    }

    private int[] generaPrimitiva() {
            int[] primitiva = new int[10];
            for (int i = 0; i < primitiva.length; i++) {
                primitiva[i] = (int)(Math.floor(Math.random() * 49 + 1));
            }
            return primitiva;
    }

    private double calcularMedia(int[] notas, int num){
        num = 10; // LOS OBJETOS A LOS METODOS SE PASA LA REFERENCIA PERO LOS TIPOS PRIMITIVOS UNA COPIA.
        double suma = 0,media;
        for(int i = 0; i < notas.length; i++){
            suma += notas[i];
        }
        
        media = suma/notas.length;
        return media;
    }


    
}
