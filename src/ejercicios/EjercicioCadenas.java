package ejercicios;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

import excepciones.DniException;
import excepciones.IsbnException;

public class EjercicioCadenas {
    public EjercicioCadenas(){
        //1.- Rompe cadenas: Crea un programa que me pida una frase y me la rompa en palabras.
        //ejercicio1();
        
        //2.- Un programa que me pida una frase y e diga si es palíndroma. Busca frases palíndromas en internet.
        //ejercicio2();
        
        //3.-Crea un programa que compruebe si un dni es correcto (8 números y una letra) Recordad que la letra 
        //se calcula dividiendo el numero entre 23 y mirando el resto (Mirad en internet la letra con que se 
        //corresponde) si el dni no es correcto, manda una excepion DniException;
        //CompruebaDni compruebaDni = new CompruebaDni();

        //4.- Comprobación ISBN 13.
        //ejercicio4();

        //5.- MOSTRAR POR PANTALLA UNA TARJETA DE CLAVES
        //  1   2   3   4   5   6
    //  A  rellenar de números del 100 al 999 que no se repitan.
    //  B  El programa pregunta por una coordenada (ej c4) y mirara si es correcto.
    //  C  3 intentos. (La misma coordenada)
    //  D
    //  E
        ejercicio5();
    }

    public void ejercicio1(){
        System.out.println("Introduce una frase:");
        String frase = scString();

        String palabra = "";
        char caracter;
        int cont = 0;
        
        for (int i = 0; i < frase.length(); i++) {
            caracter = frase.charAt(i);
            if(caracter != ' '){
                palabra += caracter;
                cont++;
            }
                if(caracter == ' ' || i == frase.length()-1){
                if(cont > 0) System.out.println(palabra);
                palabra = "";
                cont = 0;
            }

            
            
        }

    }

    public void ejercicio2(){
        System.out.println("Introduce una frase para saber si es palindroma:");
        String frase = scString();
        String fraseModificada = frase.replace(" ", "").toLowerCase();
        System.out.println(fraseModificada);
       
        char letraActual, letraLadoOpuesto;
        boolean esPalindroma = true;

        for (int i = 0; i < (fraseModificada.length()-1) /2; i++) {
            letraActual = fraseModificada.charAt(i);
            letraLadoOpuesto = fraseModificada.charAt(fraseModificada.length()-1-i);

            if (letraActual != letraLadoOpuesto) {
                esPalindroma = false;
                break;
            }
        }

        if (esPalindroma) System.out.printf("La frase: '%s' ES palíndroma.", frase);
        else System.out.printf("La frase: '%s' NO es palíndroma.", frase);
        /* String fraseVolteada = voltearFrase(fraseModificada);

        if (fraseModificada.equals(fraseVolteada)) System.out.printf("'%s' es una frase palíndroma", frase);
        else System.out.printf("'%s' NO es una frase palíndroma", frase); */
    }

    
    
    /* public void ejercicio3(){

        System.out.println("Introduce el DNI:");
        String dni = scString();
        boolean correcto = true;
        
        try {
            comprobarDni(dni);
        } catch (DniException e) {
            correcto = false;
            System.out.println(e.getMessage());
        }
        if (correcto) System.out.println("El dni " + dni + " es correcto");
    } */


    public void ejercicio4(){
        System.out.println("Introduce el ISBN:");
        String isbn = scString();
        
        try {
            comprobarIsbn(isbn);
        } catch (IsbnException e) {
            System.out.println(e.getMessage());
        }


    }
    
    public void ejercicio5(){
        int[][] tablaClaves = new int[5][6];
        rellenarArrayBidi(tablaClaves);
        
        imprimirTablaClaves(tablaClaves);
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
        System.out.printf("%s", "");
        for (int i = 0; i < filas.length; i++) {     
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
    //METODO PARA DAR LA VUELTA A UNA FRASE
    public String voltearFrase(String frase){
        String fraseVolteada = "";
        for (int i = frase.length()-1; i >= 0 ; i--) {
            fraseVolteada += frase.charAt(i);
        }

        System.out.println(fraseVolteada);
        return fraseVolteada;
    }

    //METODO PEDIR FRASE O PALABRA
    
    public String scString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    /* //COMPROBAR DNI
    public void comprobarDni(String dni) throws DniException{

        //comprueba tamaño de cadena
        if (dni.length() != 9) throw new DniException();
        
        //comprueba parte numerica y letra
        int numDni;
        char letra;
        try {
            numDni = Integer.parseInt(dni.substring(0, dni.length()-1));
            letra = dni.charAt(dni.length()-1);
        } catch (Exception e) {
            throw new DniException();
        }
         
        //comprueba letra       
        char[] letras = {'T', 'R', 'W','A', 'G', 'M','Y', 'F', 'P',
                  'D', 'X', 'B','N', 'J', 'Z','S', 'Q', 'V',
                  'H', 'L', 'C', 'K', 'E'};

        int posLetra = numDni%23;

        if (letras[posLetra] != letra) throw new DniException();
        
    } */

    //COMPROBAR ISBN
    public void comprobarIsbn(String isbn) throws IsbnException{
        //Comprobar tamaño de cadena
        if (isbn.length() != 17) throw new IsbnException();

        //Separar los digitos y comparar cuantos numeros tiene
        String[] isbnArray;
        try {
            isbnArray = isbn.split("-");
        } catch (Exception e) {
            throw new IsbnException();
        }
        if (isbnArray.length != 5) throw new IsbnException();

        String isbnSinGuion = isbn.replace("-", "");
        

        String[] digitos = isbnSinGuion.split("");

        //Realizar operaciones
        int suma = 0;
        int n = 0;
        try {
            for (int i = 0; i < digitos.length -1; i++) {
                n = Integer.parseInt(digitos[i]);
                if ((i+1)%2 != 0) suma += n;
                else suma += (n*3);
            }
        } catch (Exception e) {
            throw new IsbnException();
        }
        int digitoCalculado = 10 - (suma%10);


        // Comparar ultimo digito con el digito calculado
        if (Integer.parseInt(digitos[digitos.length-1]) != digitoCalculado) throw new IsbnException();
        else System.out.println("el ISBN: '" + isbn + "', es correcto.");


        
    }
}
