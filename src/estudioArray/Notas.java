package estudioArray;

import java.util.Scanner;

public class Notas {

    int[][] notas={
        {1,6,7,5,7,3,4,6,8,1,8,10},
        {2,4,5,3,7,6,8,4,9,10,7,10},
        {4,3,8,7,6,7,4,5,6,2,7,10},
        {3,8,9,6,5,7,7,8,9,10,5,10}
        };

    String[] nombres = {"Juan", "Ana", "Luis", "Maria", "Felipe", "Antonio", "Rosa", "Pedro", "Carmen", "Pablo", "Cristian", "Rodrigo"};
    String[] asignaturas = {"Matemáticas", "Lengua", "Inglés", "Física"};
    
    public Notas(){
        
        Scanner sc = new Scanner(System.in);
        int indice;
        do {
            System.out.println("GESTIÓN DE NOTAS");

            // CASE 2 IMPRIMIR TAMBIEN NOTA MEDIA SI HA APROBADO.
            System.out.println("""
            ***************MENÚ***************
            *                                *
            *  1. Ver notas de asignaturas   *
            *  2. Ver notas de alumnos       * 
            *  3.                            *
            *  4.                            *
            *  5. Salir                      *
            **********************************
            """);
            indice = sc.nextInt();
            switch (indice) {
                case 1:
                    mostrarNotasAsignatura();
                    break;
                case 2:
                    mostrarNotasAlumnos();
                    break;
                case 3: 
                    menuAsignaturas();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    return;
                default:
                    break;
            }
        }while(true);
        
    }
    private void mostrarNotasAsignatura(){
            int i = menuAsignaturas();

            for (int x = 0; x < notas[i].length; x++) {
                System.out.printf("%10s - %2d%n",nombres[x], notas[i][x]);
            }
    }
    
    private void mostrarNotasAlumnos(){
        int indice = menuAlumnos();
        double sumaNotas = 0;
        double mediaCurso = 0;
        String notasAlumno = "Notas de " + nombres[indice] + ":\n";
        for (int i = 0; i < asignaturas.length; i++) {
            notasAlumno += asignaturas[i] + " - " + notas[i][indice]+"\n";
            
            sumaNotas += notas[i][indice];
        }
        mediaCurso = sumaNotas / asignaturas.length;
        System.out.println(notasAlumno);

        if (mediaCurso >= 5) {
            System.out.println("Nota media de " + nombres[indice] + ": " + mediaCurso);
        }else System.out.println(nombres[indice] + " ha suspendido");
    }

    // INDICES MENÚS
    
    private int menuAsignaturas(){
        String asigString = "";
        int indice;
        System.out.println("ELIJA UNA ASIGNATURA");
        for (int i = 0; i < asignaturas.length; i++) {
            asigString += i+1 + ". " + asignaturas[i] + "\n";
        }
        System.out.println(asigString);
        Scanner sc = new Scanner(System.in);
        indice = sc.nextInt()-1;
        System.out.println(asignaturas[indice]);
        
        return indice;
    }


    private int menuAlumnos(){
        String alumString = "";
        int indice;
        System.out.println("ELIJA UN ALUMNO");
        for (int i = 0; i < nombres.length; i++) {
            alumString += i+1 + ". " + nombres[i] + "\n";
        }
        System.out.println(alumString);
        Scanner sc = new Scanner(System.in);
        indice = sc.nextInt()-1;
        System.out.println(nombres[indice]);
        return indice;
    }
}
