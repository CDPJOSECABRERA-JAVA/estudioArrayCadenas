package ejercicios;

import java.util.Scanner;
import excepciones.CccException;

public class CuentaBancaria {
    public CuentaBancaria(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la cuenta bancaria:");
        String ccc = sc.nextLine();
        sc = null;
        try {
            comprobarDigitos(ccc);
            comprobarCuenta(ccc);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    private void comprobarDigitos (String ccc) throws CccException{

        if (ccc.length() != 20) throw new CccException();

        for (int i = 0; i < ccc.length(); i++) {
            char charActual = ccc.charAt(i);

            if (!Character.isDigit(charActual)) throw new CccException();
        }
    }

    private void comprobarCuenta(String ccc) throws CccException{
        String entidadYsucursal = ccc.substring(0, 8);
        String dc = ccc.substring(8, 10);
        String numCuenta = ccc.substring(10, 20);
        
        int[] multiplicador = {1,2,4,8,5,10,9,7,3,6};

        //COMPROBAR DIGITO D
        int suma = 0, digito;

        for (int i = 0; i < entidadYsucursal.length(); i++) {
            digito = Integer.parseInt(Character.toString(entidadYsucursal.charAt(i)));

            suma += digito*multiplicador[i+2];
        }
        int moduloD = 11-(suma%11);

        if (moduloD == 10) digito = 1;
        else if( moduloD == 11) digito = 0;

        String moduloDstr = String.valueOf(moduloD);

        if (!moduloDstr.equals(dc.substring(0,1))) throw new CccException();

        //COMPROBAR DIGITO C
        suma = 0;
        digito = 0;

        for (int i = 0; i < numCuenta.length(); i++) {
            digito = Integer.parseInt(Character.toString(numCuenta.charAt(i)));
            
            suma+= digito*multiplicador[i];
        }
        int moduloC = 11-(suma%11);
        
        if (moduloC == 10) digito = 1;
        else if( moduloC == 11) digito = 0;

        String moduloCstr = String.valueOf(moduloC);
        if (!moduloCstr.equals(dc.substring(1))) throw new CccException();

        System.out.println("La cuenta bancaria es correcta");
    }
}
