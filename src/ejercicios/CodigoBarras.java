package ejercicios;
import java.util.Scanner;
import excepciones.CodigoBarrasException;

public class CodigoBarras {
    public CodigoBarras(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el código de barras:");
        String codigoBarras = sc.nextLine();
        sc = null;

        try{
            comprobarCodigoBarras(codigoBarras);
        }catch(CodigoBarrasException e){
            System.out.println(e.getMessage());
        }

    }

    public void comprobarCodigoBarras(String codigoBarras) throws CodigoBarrasException{
        if(codigoBarras.length() != 13) throw new CodigoBarrasException();

        long codigo;
        int control;

        try {
            codigo = Long.parseLong(codigoBarras.substring(0, codigoBarras.length()-1));
            control = Integer.parseInt(codigoBarras.substring(codigoBarras.length()-1));
        } catch (Exception e) {
            throw new CodigoBarrasException();
        }
        String codigoStr = Long.toString(codigo);
        int digito;
        int suma = 0;

        for (int i = 0; i < codigoStr.length(); i++) {
            digito = Integer.parseInt(codigoStr.substring(i, i+1));

            if ((i+1)%2 != 0) suma += digito;
            else suma += digito*3;
        }
        System.out.println(suma);
    }
}
