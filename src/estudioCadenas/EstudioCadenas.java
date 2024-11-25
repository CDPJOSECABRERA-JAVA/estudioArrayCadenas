package estudioCadenas;

import java.util.Arrays;

public class EstudioCadenas {
    public EstudioCadenas(){
        System.out.println("=====================");
        System.out.println("PROPIEDADES CADENAS");
        System.out.println("=====================");

        String cadena = "Bienvenido a la clase de programación   ";
        String cad2 = "AAA";
        //devuelve la longitud de del string incluyendo espacios en blanco
        int tam = cadena.length();
        System.out.println("El tamaño de '" + cadena + "' es: " + tam);


        System.out.println("====CharAt====");
        
        System.out.println("Caracter = " + cadena.charAt(0));
        for (int i = 0; i < cadena.length(); i++) {
            System.out.print(cadena.charAt(i) + "-");
        }
        System.out.println();

        System.out.println("====subString====");
        System.out.println(cadena.substring(0, 10));
        System.out.println(cadena.substring(2));

        boolean a = cadena.substring(0, 1).equals("B");
        System.out.println(a);

        System.out.println("====indexOf====");
        System.out.println(cadena.indexOf("clase"));
        System.out.println(cadena.indexOf("o"));
        System.out.println(cadena.indexOf("x"));

        System.out.println("====equals====");
        String nombre = "Antonio", nombre2 = "Antonio";
        System.out.println(nombre.equals(nombre2));
        nombre = "antonio";
        System.out.println(nombre.equals(nombre2));

        System.out.println("====compareTo====");
        nombre = "Ana";
        System.out.println(nombre.compareTo(nombre2));

        System.out.println("====trim====");
        String cad3 = cadena.trim();
        System.out.println(cad3.length());

        System.out.println("====toLowerCase====");
        System.out.println(cadena.toLowerCase());
        System.out.println("====toUpperCase====");
        System.out.println(cadena.toUpperCase());

        System.out.println("====replace====");
        System.out.println(cadena.replace(" ", ""));
        System.out.println(cadena.replace("a", "*"));

        System.out.println("====Starts with y contains====");
        System.out.println(cadena.startsWith("Bienvenido"));
        System.out.println(cadena.contains("ido"));

        System.out.println("====split====");
        String alumno = "Jesus,DAW,Programacion,BBDD";
        String[] rompeCadena = alumno.split(",");
        System.out.println(Arrays.toString(rompeCadena));

        System.out.println("====toCharArray====");
        String asignatura = "Programación";
        char[] caracteres = asignatura.toCharArray();
        System.out.println(Arrays.toString(caracteres));

    }
}
