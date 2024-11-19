package ejercicios;

import java.util.Arrays;

public class JuegoCartas {
    public JuegoCartas(){
        int[][] cartas = new int[4][10];
        String[] palos ={"E", "B", "O", "C"};
        arrLlenarCartas(cartas);
        cartasToString(cartas);


        int[][] jugador1 = new int[4][2];
        int[][] jugador2 = new int[4][2];
        
        String manosJ1 = "";
        String manosJ2 = "";

    }
    
    public static void repartirCartas(int[][] cartas, String[] palos, int[][] jugador){
        int fila, columna;
        int cont = 0;
        for (int i = 0; i < jugador.length; i++) {
                jugador[i][0] = numRandom(0, 4);
                jugador[i][1] = numRandom(0, 10);
            }
        }
    }

    public static int numRandom(int inf, int sup){
        return (int)(Math.random()*(sup-inf +1) + inf);
    }

    
    public static void arrLlenarCartas(int[][] cartas){
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas[i].length; j++) {
                cartas[i][j] = j+1;
            }
        }
    }

    public static void cartasToString(int[][] cartas){
        for (int i = 0; i < cartas.length; i++) {
            System.out.println(Arrays.toString(cartas[i]));
        }
    }
}
