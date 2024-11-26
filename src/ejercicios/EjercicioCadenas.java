package ejercicios;

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
        //ejercicio3();

        //4.- Comprobación ISBN 13.
        ejercicio4();
    }

    public void ejercicio1(){
        System.out.println("Introduce una frase:");
        String frase = scString();
        
        String[] frasePartida = frase.split(" ");

        System.out.println("Palabras de esa frase:");
        for (int i = 0; i < frasePartida.length; i++) {
            System.out.println((i+1) + ". " + frasePartida[i]);
        }

    }

    public void ejercicio2(){
        System.out.println("Introduce una frase para saber si es palindroma:");
        String frase = scString();
        String fraseModificada = frase.replace(" ", "").toLowerCase();
        System.out.println(fraseModificada);

        String fraseVolteada = voltearFrase(fraseModificada);

        if (fraseModificada.equals(fraseVolteada)) System.out.printf("'%s' es una frase palíndroma", frase);
        else System.out.printf("'%s' NO es una frase palíndroma", frase);
    }

    public void ejercicio3(){

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
    }

    public void ejercicio4(){
        System.out.println("Introduce el ISBN:");
        String isbn = scString();
        
        try {
            comprobarIsbn(isbn);
        } catch (IsbnException e) {
            System.out.println(e.getMessage());
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

    //COMPROBAR DNI
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
        
    }

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
