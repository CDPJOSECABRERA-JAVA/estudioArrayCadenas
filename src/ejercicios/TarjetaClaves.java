package ejercicios;

import java.lang.reflect.Array;
import java.util.Arrays;
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
        String[][] tablaClaves = {
            {"", "1", "2", "3", "4", "5","6"},
            {"A", "", "", "", "", "", ""},
            {"B", "", "", "", "", "", ""},
            {"C", "", "", "", "", "", ""},
            {"D", "", "", "", "", "", ""},
            {"E", "", "", "", "", "", ""}
        };
        
        rellenarArrayBidi(tablaClaves);
        imprimirTablaClaves(tablaClaves);

        int f = (int)Math.floor(Math.random()*5+1);
        System.out.println(f);

        int c = (int)Math.floor(Math.random()*6+1);
        
        int intentos = 0;
        int claveIntroducida;
      
         do {
            System.out.println("Introduce la clave: " + tablaClaves[f][0] +""+ c);
            claveIntroducida = scInt();

            if (String.valueOf(claveIntroducida).equals(tablaClaves[f][c])) {
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
    public void rellenarArrayBidi(String[][] tablaClaves){

        int numRandom;
        for (int i = 1; i < tablaClaves.length; i++) {
            for (int j = 1; j < tablaClaves[i].length; j++) {
                numRandom = (int)(Math.random()*(999-100 +1) + 100);
                if (comprobarRepeticion(String.valueOf(numRandom), tablaClaves)) j--;
                else tablaClaves[i][j] = String.valueOf(numRandom);
            }
        }


    }
    
    
    //METODO COMPROBAR REPETICION ARRAY BIDI
    boolean comprobarRepeticion(String n, String[][] tabla){
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla.length; j++) {
                if (n.equals(tabla[i][j])) return true;
            }
        }
        return false;
    }

    //METODO IMPRIMIR TABLA CLAVES
    public void imprimirTablaClaves(String[][] tabla){
        for (int i = 0; i < tabla.length; i++) {
            for (int j = 0; j < tabla[i].length; j++) {
                System.out.printf("%6s",tabla[i][j]);  
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
