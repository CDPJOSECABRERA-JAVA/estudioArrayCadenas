package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class JuegoCartas {
    public JuegoCartas(){
        String manosJ1 = "JUGADOR 1\n";
        String manosJ2 = "JUGADOR 2\n";

        String manoJ1actual ="";
        String manoJ2actual="";
        
        int[] cartas = {1,2,3,4,5,6,7,10,11,12};
        String[] palos ={"E", "B", "O", "C"};

        int[][] jugador1 = new int[4][2];
        int[][] jugador2 = new int[4][2];
        
        int i = 0;
        while (i < 10) {

            System.out.println("""
                    ELIGE UNA OPCIÓN
                    1. VER HISTORIAL DE MANOS.
                    2. SEGUIR REPARTIENDO CARTAS.
                    3. SALIR
                    """);

            switch (scInt()) {
                case 1:
                    System.out.println(manosJ1 + manosJ2);

                    break;
                case 2:
                    resetBaraja(jugador1);
                    resetBaraja(jugador2);
    
                    System.out.println("Repartiendo cartas...");
    
                    repartirCartas(cartas, palos, jugador1, jugador2);
                    manoJ1actual = anadirCartas(jugador1, palos);
                    manoJ2actual = anadirCartas(jugador2, palos);
    
                    System.out.println("JUGADOR 1: " + manoJ1actual);
                    System.out.println("JUGADOR 2: " + manoJ2actual);
    
                    manosJ1 += manoJ1actual;
                    manosJ2 += manoJ2actual;
                    i++;
                    if (i == 10) {
                        System.out.println("EL JUEGO HA FINALIZADO DEBIDO A QUE SE HA JUGADO 10 RONDAS");
                        System.out.println("HISTORIAL DE CARTAS:");
                        System.out.println(manosJ1 + manosJ2);
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Número desconocido.");
                    break;
            }


        }
    }
    
    public static void repartirCartas(int[] cartas, String[] palos, int[][] j1, int[][] j2){
        int randomNum, randomPalo;

        for (int i = 0; i < j1.length; i++) {
            randomNum = generarNumRandom(0, 9);
            randomPalo = generarNumRandom(0, 3);

            if (buscarRepetidos(j1, j2, randomNum, randomPalo, cartas)) {
                i--;
            }else{
                j1[i][0] = cartas[randomNum];
                j1[i][1] = randomPalo;
            }
        }

        for (int i = 0; i < j2.length; i++) {
            randomNum = generarNumRandom(0, 9);
            randomPalo = generarNumRandom(0, 3);

            if (buscarRepetidos(j1, j2, randomNum, randomPalo, cartas)) {
                i--;
            }else{
                j2[i][0] = cartas[randomNum];
                j2[i][1] = randomPalo;
            }
        }
    }

    public static int generarNumRandom(int inf, int sup){
        return (int)(Math.random()*(sup-inf +1) + inf);
    }

    public static boolean buscarRepetidos(int[][] j1, int[][] j2, int randomNum, int randomPalo, int[] cartas){

        for (int i = 0; i < j1.length; i++) {
            if ((j1[i][0] == cartas[randomNum] && j1[i][1] == randomPalo) || (j2[i][0] == cartas[randomNum] && j2[i][1] == randomPalo)) return true;
        }
        return false;
    }

    public static String anadirCartas(int[][] jugador, String[] palos){
        String mano = "";

        for (int i = 0; i < jugador.length; i++) {
            if (jugador[i][0] == 10) mano+= "S";
            else if (jugador[i][0] == 11) mano+= "C";
            else if (jugador[i][0] == 12) mano+= "R";
            else mano+= jugador[i][0];

            mano+=palos[jugador[i][1]];

            mano+="  ";
        }
        mano+="\n";
        return mano;
    }

    public static void resetBaraja(int[][] jugador){
        for (int i = 0; i < jugador.length; i++) {
            for (int j = 0; j < jugador[i].length; j++) {
                jugador[i][j] = 0;
            }
        }
    }

    public static int scInt(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
}
