package estudioExcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

import excepciones.MenorEdadException;

public class EstudioExcepciones {
    public EstudioExcepciones() throws MenorEdadException{
        try {
            
            //int div = 4/0;
            //System.out.println(div);
            int[] arr = {1,2,3};
            System.out.println(arr[2]);

        } catch (ArithmeticException e) {

            System.out.println("esto es un Arithmetic exception");
            System.out.println(e.getMessage());

        } catch (IndexOutOfBoundsException e){

            System.out.println("no existe esta posicion del array");
        
        }catch (Exception e){

            System.out.println("excepción desconocida");
        }finally{
            System.out.println("finally");
        }


        try {
            String texto = null;
            System.out.println(texto.length()); 
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        
        boolean sigue = false;
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Introduce un número");
                int n = sc.nextInt();
                System.out.println("Número introducido: " + n);
                
                
            } catch (InputMismatchException e) {
                //System.out.println(e.getMessage());
                System.out.println("Debe introducir un numero");
                sigue = true;
            }
        } while (sigue);
        
            calculaEdad(17);
       
        
            }
        
            private void calculaEdad(int edad) throws MenorEdadException {
                // TODO Auto-generated method stub
                if(edad<18) throw new MenorEdadException();
            }
}
