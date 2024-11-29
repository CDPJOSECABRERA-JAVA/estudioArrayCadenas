package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicios {
    public Ejercicios(){
                //tarjeta claves
        //TarjetaClaves tarjetaClaves = new TarjetaClaves();

        //Ejercicio codigo de barras
        //CodigoBarras codigoBarras = new CodigoBarras();

        //Ejercicio que encripte y desencripte una frase "Atacaremos al amanecer de la primera luna de Marzo"
        // int[] clave = {3,4,9,6,1,7,0,8,5,2} de 10 en 10 caracteres
        ejercicio2();
    }

    public void ejercicio2(){
        System.out.println("Introduce una frase para encriptar:");
        String frase = scString();
        
        String fraseEncriptada = encriptar(frase);
        System.out.println(fraseEncriptada);
        String fraseDesencriptada = desencriptar(fraseEncriptada);
        System.out.println(fraseDesencriptada);
        
    }

                
                            // ---------- EJERCICIO 2 ----------
            private String encriptar(String frase) {
          
                int[] claves = {3,4,9,6,1,7,0,8,5,2};

                String fraseCortada = "";
                String fraseEncriptada = "";
                int pos = 0;

                while (fraseEncriptada.length() != frase.length()) {
                    
                    // CONTROLO EL FINAL DE LA CADENA PARA NO SALIRME Y COGER SOLO LOS ULTIMOS CARACTERES EN CASO DE QUE
                    // SUMANDO 10 SUPERE EL LENGHT DE LA CADENA, EN ESE CASO SE COGERIA DESDE LA POSICION ACTUAL HASTA EL ULTIMO CARACTER.
                    if (pos+10 > frase.length()-1) fraseCortada = frase.substring(pos, frase.length());
                    else fraseCortada = frase.substring(pos, pos+10);
                    
                    
                    pos +=10;

                    //ESTE CONDICIONAL SIRVE PARA SABER SI LA CADENA CORTADA ES IGUAL O MENOR A 10, EN CASO DE QUE SEA MENOR SOLO COGERA LOS DIGITOS DE CLAVE QUE SIRVAN COMO
                    // INDICE EN LA CADENA CORTADA.
                    if (fraseCortada.length() == 10) {
                        for (int i = 0; i < fraseCortada.length(); i++) {
                            fraseEncriptada+=fraseCortada.charAt(claves[i]);
                            
                        }
                    }else{   
                        for (int i = 0; i < fraseCortada.length(); i++) {
                            fraseEncriptada+=fraseCortada.charAt(i);
                        }
                    }
                }
                return fraseEncriptada;
                
            }
                           
            private String desencriptar(String frase) {
                //int[] claves = {3,4,9,6,1,7,0,8,5,2};
                String claves = "3496170852";

                String fraseCortada = "";
                String fraseDesencriptada = "";
                int pos = 0;

                while (fraseDesencriptada.length() != frase.length()) {
                    
                    // CONTROLO EL FINAL DE LA CADENA PARA NO SALIRME Y COGER SOLO LOS ULTIMOS CARACTERES EN CASO DE QUE
                    // SUMANDO 10 SUPERE EL LENGHT DE LA CADENA, EN ESE CASO SE COGERIA DESDE LA POSICION ACTUAL HASTA EL ULTIMO CARACTER.
                    if (pos+10 > frase.length()-1) fraseCortada = frase.substring(pos, frase.length());
                    else fraseCortada = frase.substring(pos, pos+10);
                    
                    
                    pos +=10;

                    //ESTE CONDICIONAL SIRVE PARA SABER SI LA CADENA CORTADA ES IGUAL O MENOR A 10, EN CASO DE QUE SEA MENOR SOLO COGERA LOS DIGITOS DE CLAVE QUE SIRVAN COMO
                    // INDICE EN LA CADENA CORTADA.
                     if (fraseCortada.length() == 10) {
                        for (int i = 0; i < fraseCortada.length(); i++) {
                            fraseDesencriptada+=fraseCortada.charAt(claves.indexOf(Integer.toString(i)));
                            
                        }
                    }else{
                        for (int i = 0; i < fraseCortada.length(); i++) {
                            fraseDesencriptada+=fraseCortada.charAt(i);
                        }
                    }
                }
                return fraseDesencriptada;
            }
        
    //------------ M E T O D O S   G E N E R A L E S------------
        
    //Pedir String
        public String scString(){
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();         
        }

}
