package estudioArray;

import java.util.Scanner;

public class Notas {

    int[][] notas={
        {5,6,7,5,7,3,4,6,8,1},
        {2,4,5,3,7,6,8,4,9,10},
        {4,3,8,7,6,7,4,5,6,2},
        {7,8,9,6,5,7,7,8,9,10}
        };

    String[] nombres = {"Juan", "Ana", "Luis", "Maria", "Felipe", "Antonio", "Rosa", "Pedro", "Carmen", "Pablo"};
    String[] asignaturas = {"Matemáticas", "Lengua", "Inglés", "Física"};
    
    public Notas(){
        System.out.println("GESTIÓN DE NOTAS");

        System.out.println("""
        ***************MENÚ***************
        *                                *
        *  1. Ver notas de asignaturas   *
        *  2. Salir.                     *
        *                                *
        **********************************
        """);
        

        
        Scanner sc = new Scanner(System.in);
        int indice = sc.nextInt();
        switch (indice) {
            case 1:
                mostrarNotasAsignatura(); // OTRO MENU CON ASIGNATURAS Y MOSTRAR NOTAS DE CADA ALUMNO
                break;
        
            default:
                break;
        }
    }
    private void mostrarNotasAsignatura(){
            int i = menuAsignaturas();

            for (int x = 0; x < notas[i-1].length; x++) {
                System.out.printf("%10s - %2d%n",nombres[x], notas[i-1][x]);
            }
    }
    private int menuAsignaturas(){
        System.out.println("""
        *******ELIJA UNA ASIGNATURA*******
        *                                *
        *       1. Matemáticas.          *
        *       2. Lengua.               *
        *       3. Inglés.               *
        *       4. Física.               *
        *                                *
        **********************************
                """);
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
