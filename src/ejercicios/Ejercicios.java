package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

import excepciones.ContrasenaException;

public class Ejercicios {
    public Ejercicios(){
                //tarjeta claves
        //TarjetaClaves tarjetaClaves = new TarjetaClaves();

        //Ejercicio codigo de barras
        //CodigoBarras codigoBarras = new CodigoBarras();

        //Ejercicio que encripte y desencripte una frase "Atacaremos al amanecer de la primera luna de Marzo"
        // int[] clave = {3,4,9,6,1,7,0,8,5,2} de 10 en 10 caracteres
        //ejercicio2();
/*      
        2.- Crea un metodo que comprueba si una contraseña es segura:
        min 8 caracteres, mayusculas, minusculas, numeros y caracteres especiales. */
        //ejercicio3();

        /* 3.- Escribe un programa que rellene un array de 15 elementos con números enteros comprendidos entre 0 y 500
        (ambos incluidos) */
        ejercicio4();
    }

    public void ejercicio2(){
        System.out.println("Introduce una frase para encriptar:");
        String frase = scString();
        
        String fraseEncriptada = encriptar(frase);
        System.out.println(fraseEncriptada);
        String fraseDesencriptada = desencriptar(fraseEncriptada);
        System.out.println(fraseDesencriptada);
        
    }

    public void ejercicio3(){
        System.out.println("Introduce una contraseña:");
        String contrasena = scString();

        try {
            comprobarContrasena(contrasena);
        } catch (ContrasenaException e) {
            System.out.println(e.getMessage());
        }
            }
                    // ---------- EJERCICIO 3 ----------
            
            public void ejercicio4(){
                int[] arr = rellenarArrUni(15);
                System.out.println(Arrays.toString(arr));

                int[] arrCincuerizado = cincuerizarArr(arr);
                System.out.println(Arrays.toString(arrCincuerizado));
            }

            private int[] cincuerizarArr(int[] arr){
                int[] arrCincuerizado = new int[arr.length];

                int suma;

                for (int i = 0; i < arrCincuerizado.length; i++) {
                    if (arr[i]%5 == 0) arrCincuerizado[i] = arr[i];
                    else{
                        suma = (arr[i]-(arr[i]%10))+5;
                        arrCincuerizado[i] = suma;
                    }
                }

                return arrCincuerizado;
            }
            
            private int[] rellenarArrUni(int posiciones){
                int[] arr =  new int[posiciones];
                Arrays.fill(arr, -1);
                int num;
                
                for (int i = 0; i < arr.length; i++) {
                num = (int)(Math.random()*(500-0 +1) + 0);
                if (seRepite(num, arr)) i--;
                else arr[i] = num;
                }

                return arr;
            }
            
            private boolean seRepite(int num, int[] arr){
                for (int i = 0; i < arr.length; i++) {
                    if (num == arr[i]) return true;
                }               
                return false;
            }
            
                    // ---------- EJERCICIO 3 ----------
            private void comprobarContrasena(String contrasena) throws ContrasenaException{
                
                if (contrasena.length() < 8) throw new ContrasenaException("La contraseña no debe tener menos de 8 caracteres");

                boolean letrasMinus =false, letrasMayus =false, numeros =false, carEspeciales = false, 
                contrasenaValida = false;
                char caracter;
                for (int i = 0; i < contrasena.length(); i++) {
                     caracter = contrasena.charAt(i);

                     if (letrasMinus && letrasMayus && numeros && carEspeciales){
                        contrasenaValida = true;
                        break;
                     }

                    if (!numeros && Character.isDigit(caracter)) numeros = true;
                    else if(!letrasMinus && caracter == Character.toLowerCase(caracter)) letrasMinus = true;
                    else if(!letrasMayus && caracter == Character.toUpperCase(caracter)) letrasMayus = true;
                    else if (!carEspeciales && !Character.isDigit(caracter) && !Character.isLetter(caracter)) carEspeciales = true;
                }

                if (!contrasenaValida) throw new ContrasenaException();
                else System.out.println("La contraseña es válida");
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
        private String scString(){
            Scanner sc = new Scanner(System.in);
            return sc.nextLine();         
        }

}
