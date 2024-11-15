package estudioExcepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EstudioExcepciones {
    public EstudioExcepciones(){
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

    }
}
