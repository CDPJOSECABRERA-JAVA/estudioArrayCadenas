package ejercicios;

public class JuegoCartas {
    public JuegoCartas(){
        int[][] cartas = new int[4][10];
        String[] palos ={"E", "B", "O", "C"};
        
        int[][] jugador1 = new int[4][2];
        int[][] jugador2 = new int[4][2];
        
        String manosJ1 = "";
        String manosJ2 = "";

        for (int i = 0; i < 5; i++) {
            System.out.println(numRandom(2, 5));
        }
    }

    public static void repartirCartas(int[][] cartas, String[] palos, int[] jugador){
        

    }

    public static int numRandom(int inf, int sup){
        return (int)(Math.random()*sup-inf) + inf;
    }
}
