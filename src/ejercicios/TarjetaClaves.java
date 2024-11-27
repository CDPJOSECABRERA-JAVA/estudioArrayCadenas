package ejercicios;

import java.util.Scanner;

public class TarjetaClaves {
        //5.- MOSTRAR POR PANTALLA UNA TARJETA DE CLAVES
        //  1   2   3   4   5   6
    //  A  rellenar de números del 100 al 999 que no se repitan.
    //  B  El programa pregunta por una coordenada (ej c4) y mirara si es correcto.
    //  C  3 intentos. (La misma coordenada)
    //  D
    //  E
    public TarjetaClaves(){
        int[][] tablaClaves = new int[5][6];
        rellenarArrayBidi(tablaClaves);
        imprimirTablaClaves(tablaClaves);

        String fStr = "ABCDE";

        int f = (int)Math.floor(Math.random()*5);
        int c = (int)Math.floor(Math.random()*6);
        
        int intentos = 0;
        int claveIntroducida;
       
        do {
            System.out.println("Introduce la clave: " + fStr.charAt(f) +""+ (c+1));
            claveIntroducida = scInt();

            if (claveIntroducida == tablaClaves[f][c]) {
                System.out.println("Clave acertada.");
                System.out.println("Has acertado la clave en " + (intentos+1) + " intentos.");
                break;
            }else{
                System.out.println("La clave introducida no es correcta");
                intentos++;
                System.out.println("Te quedan " +  (3-intentos) + " intentos.");
            }
            
        } while (intentos < 3);
    }

    
    //METODO RELLENAR ARRAY BIDI
    public void rellenarArrayBidi(int[][] tablaClaves){

        int numRandom;
        for (int i = 0; i < tablaClaves.length; i++) {
            for (int j = 0; j < tablaClaves[i].length; j++) {
                numRandom = (int)(Math.random()*(999-100 +1) + 100);
                if (comprobarRepeticion(numRandom, tablaClaves)) j--;
                else tablaClaves[i][j] = numRandom;
            }
        }


    }
    
    
    //METODO COMPROBAR REPETICION ARRAY BIDI
    boolean comprobarRepeticion(int n, int[][] tabla){
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                if (n == tabla[i][j]) return true;
            }
        }
        return false;
    }

    //METODO IMPRIMIR TABLA CLAVES
    public void imprimirTablaClaves(int[][] tabla){
        String[] filas = {"A", "B", "C", "D", "E"};
        System.out.printf("%5s", "");
        for (int i = 0; i < tabla[0].length; i++) {     
            System.out.printf("%6d", i+1);
        }
        System.out.println();
        
        for (int i = 0; i < tabla.length; i++) {
            
            System.out.printf("%6s", filas[i]);
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.printf("%6d", tabla[i][j]);
            }
            System.out.println();
        }
    }

    //PEDIR STRING
    public int scInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
