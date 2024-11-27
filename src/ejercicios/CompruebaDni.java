package ejercicios;

import java.util.Scanner;

import excepciones.DniException;

public class CompruebaDni {
    public CompruebaDni(){
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

    //COMPROBAR DNI
    public void comprobarDni(String dni) throws DniException{

        //comprueba tamaño de cadena
        if (dni.length() != 9) throw new DniException();
        
        //comprueba parte numerica y letra
        int numDni;
        char letra = dni.charAt(dni.length()-1);
        try {
            numDni = Integer.parseInt(dni.substring(0, dni.length()-1));
        } catch (Exception e) {
            throw new DniException();
        }
         
        //comprueba letra
        String letras = "TRWAGMYFPDXBNJZSOVHLCKE";     
/*         char[] letras = {'T', 'R', 'W','A', 'G', 'M','Y', 'F', 'P',
                  'D', 'X', 'B','N', 'J', 'Z','S', 'Q', 'V',
                  'H', 'L', 'C', 'K', 'E'}; */

        int posLetra = numDni%23;

        if (letras.charAt(posLetra) != letra) throw new DniException();
        
    }

    //METODO PEDIR FRASE O PALABRA
    
    public String scString(){
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}
