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

    //ejercicio3();

    /*
    4.- Dado un array de enteros de tamaño 5x5, diseñar un programa en Java que lo rellene como en la siguiente figura:
    0 1 2 3 4
    1 2 3 4 3
    2 3 4 3 2
    3 4 3 2 1
    4 3 2 1 0
    */

    //ejercicio4();

    /*
        5. Crear una matriz de 5x5 con todos los números enteros comprendidos entre 1 y 25 de forma que cincida la suma
        de los elementos de cada fila, de cada columna o de las diagonales principales.
    */

    //ejercicio5();

    /* 
        6.- Diseñar un programa que me permita almacenar 10 boletos de primitiva, luego genere un sorteo y me diga
            cuantos aciertos tiene cada boleto.
    */

    //ejercicio6();
    
    /* 
        7.- Diseñar un programa que genere un sorteo de primitiva y luego empiece a generar boletos hasta que tengamos 6
        aciertos.
    */

    ejercicio7();
    
}
    
    private void ejercicio1(){

        int[][] arr = {{3,2},
                       {50,7},
                       {1,11}
                    };

        int numMayorTabla = arr[0][0], numMenorTabla = arr[0][0];
        int menorFila, mayorFila;

        int[] mayoresFilaArr = new int[arr.length];
        int[] menoresFilaArr = new int[arr.length];
        
        for(int i = 0; i < arr.length; i++){
            menorFila = arr[i][0];
            mayorFila = arr[i][0];
            for(int j = 0; j < arr[i].length; j++){                               
                
                if(arr[i][j] <= menorFila) menoresFilaArr[i] = arr[i][j];
                if (arr[i][j] >= mayorFila) mayoresFilaArr[i] = arr[i][j];

                if(numMayorTabla < arr[i][j]) numMayorTabla = arr[i][j];
                if (numMenorTabla > arr[i][j]) numMenorTabla = arr[i][j];
            }

            System.out.printf("Fila %d: Mayor: %d Menor: %d%n", i, mayoresFilaArr[i], menoresFilaArr[i]);
        }
        System.out.printf("%nNUMERO MAYOR: %d%nNUMERO MENOR: %d", numMayorTabla, numMenorTabla);
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
        int sumaFilas = 0, sumaColumnas = 0, diagonal = 0, diagonalInversa = 0, contArrSumas = 0;
        boolean magico = true;
        String resultado = "";
        int[][] arr = {
                        {1,15,14,4},
                        {12,6,7,9},
                        {8,10,11,5},
                        {13,3,2,16}
                    };
        int[] arrSumas = new int[arr.length*2+2];
    
        for (int i = 0; i < arr.length; i++) {        

            diagonal+= arr[i][i];
            diagonalInversa+= arr[i][arr.length-i-1];

            for (int j = 0; j < arr.length; j++) {         
                sumaFilas += arr[i][j];
                sumaColumnas += arr[j][i];
            }

            arrSumas[contArrSumas] = sumaFilas;
            arrSumas[contArrSumas+1] = sumaColumnas;

            sumaFilas = 0;
            sumaColumnas = 0;
            contArrSumas+=2;           
        }
        
        arrSumas[contArrSumas] = diagonal;
        arrSumas[contArrSumas+1] = diagonalInversa;

        System.out.println(Arrays.toString(arrSumas));

        for (int i = 1; i < arrSumas.length; i++) {
            if (arrSumas[i] != arrSumas[i-1]) {
                magico = false;
                break;
            }
        }

        resultado += (magico) ? "El cuadrado es mágico" : "El cuadrado no es mágico";
        System.out.println(resultado);
    /*
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
    */
    }
    
    private void ejercicio4(){
        int[][] arr =  new int[5][5];

        int cont = 1;

        int diagonal = 0;
        int diagonalInv = arr.length -1;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < cont; j++) {
                arr[j][i+diagonal] = cont-1;
                arr[arr.length-1-j][diagonalInv-i] = cont-1;

                diagonal--;
                diagonalInv++;
            }
            diagonal = 0;
            diagonalInv = arr.length -1;
            cont++;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }


    }

    private void ejercicio5(){
        
        int[][] arr =  new int[5][5];
        int x = 0, y = Math.round(arr[0].length/2);

        for (int i = 1; i <= arr.length*arr.length; i++) {
            
            if(i%5 == 0) arr[x++][y] = i;
            else arr[x--][y++] = i;

            if (x < 0) x = arr.length -1;
            if (y > arr.length-1) y = 0;
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }

    }

    private void ejercicio6(){
        int[][] boletosPrimitivas = new int[10][6];
        int[] sorteoPrimitiva = new int[6];

        // LLENAR LAS 10 PRIMITIVAS DE NÚMEROS QUE NO SE REPITAN
        for (int i = 0; i < boletosPrimitivas.length; i++) {
            boletosPrimitivas[i] = rellenarBoleto(boletosPrimitivas[i]);
        }

        //LLENAR EL SORTEO.
        sorteoPrimitiva = rellenarBoleto(sorteoPrimitiva);

        //COMPARAR BOLETOS CON SORTEO Y SACAR RESULTADOS
        int aciertos = 0;

        for (int i = 0; i < boletosPrimitivas.length; i++) {
            System.out.println("SORTEO: " + Arrays.toString(sorteoPrimitiva)+"\n");
            for (int j = 0; j < boletosPrimitivas[i].length; j++) {
               if (seRepite(sorteoPrimitiva, boletosPrimitivas[i][j])){               
                aciertos++;
                System.out.printf("%3d!!", boletosPrimitivas[i][j]);

               }else System.out.printf("%3d", boletosPrimitivas[i][j]);
            }
            System.out.println("\nBoleto " + (i+1) + ": " + aciertos + " aciertos.\n");
            System.out.println();
            aciertos = 0;

        }

    }

    private void ejercicio7(){
        int[] sorteoPrimitiva = new int[6], primitiva = new int[6];
        sorteoPrimitiva = rellenarBoleto(sorteoPrimitiva);

        int intentos = 0, aciertos;

        do {
            intentos++;
            aciertos = 0;

            primitiva = rellenarBoleto(primitiva);

            for (int i = 0; i < primitiva.length; i++) {
                
                if (seRepite(sorteoPrimitiva, primitiva[i])) aciertos++;
            }
        } while (aciertos != 6);

        System.out.println("Te ha tocado la primitiva en " + intentos + " intentos");
        System.out.println("El boleto premiado es: " + Arrays.toString(primitiva));
        System.out.println("El boleto del sorteo es: " + Arrays.toString(sorteoPrimitiva));



        
        
    }
    // - M E T O D O S  E X T E R N O S
    
    private int[] rellenarBoleto(int[] boleto){
        for (int i = 0; i < boleto.length; i++) {
            boleto[i] = generarNumRandomSinRepetir(boleto);       
        }
        return boleto;
    }

    private int generarNumRandomSinRepetir(int[] boleto){       
        int num;
        do {            
            num = generarNumRandomBoleto();           
        } while (seRepite(boleto, num));
        return num;
    }

    private boolean seRepite(int[] boleto, int n){
        for (int i = 0; i < boleto.length; i++) {
            if (boleto[i] == n) return true; 
        }
        return false;
    }
    
    private int generarNumRandomBoleto(){
        return (int)(Math.floor(Math.random()*49+1));
    }
}
