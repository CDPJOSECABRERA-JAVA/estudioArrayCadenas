package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Tute {

    public Tute(){

        /* Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos casos de prueba vas a realizar?");
        int casosPrueba = sc.nextInt();
        sc = null; */

        String[] baraja = {
                            "1O","2O","3O","4O","5O","6O","7O", "SO", "CO", "RO",
                            "1B","2B","3B","4B","5B","6B","7B", "SB", "CB", "RB",
                            "1C","2C","3C","4C","5C","6C","7C", "SC", "CC", "RC",
                            "1E","2E","3E","4E","5E","6E","7E", "SE", "CE", "RE"
                        };
        
        String[] jugadores = {"Jugador1","Jugador2", "Jugador3","Jugador4"};
        String[] cartasJugadores = new String[jugadores.length];
        Arrays.fill(cartasJugadores, "");


        repartirCartas(baraja, cartasJugadores);

        imprimirCartasJugadores(cartasJugadores, jugadores);
        
        //juego(cartasJugadores, jugadores);
    }

    // R E P A R T I R   C A R T A S
    private void repartirCartas(String[] baraja, String[] cartasJugadores){
        
        int random; 
        for (int i = 0; i < cartasJugadores.length; i++) {
            for (int j = 0; j < 10; j++) {
                random = (int)(Math.random()*((baraja.length-1) -0 +1) + 0);
                if(seRepite(baraja[random], cartasJugadores)) j--;
                else cartasJugadores[i]+= baraja[random];
            }
        }
    }
    // C O M P R O B A R   R E P E T I C I Ó N
    private boolean seRepite(String carta, String[] cartasJugadores){
        for (int i = 0; i < cartasJugadores.length; i++) {
            for (int j = 0; j < 10; j++) {
                
            }
        }
        return false;
    }
    // I M P R I M I R   A R R A Y   Y   J U G A D O R E S
    private void imprimirCartasJugadores(String[] cartasJugadores, String[] jugadores){
        for (int i = 0; i < cartasJugadores.length; i++) {
            System.out.println(cartasJugadores[i]);
        }
    }

    // J U E G O
    private void juego(String[][] cartasJugadores, String[]jugadores){
    
        //elección de palo ganador.
    String[] palos = {"Oro", "Basto", "Copa", "Espada"}; 
    String paloGanador = palos[(int)(Math.random()*((palos.length-1) -0 +1) + 0)];

    System.out.println("El palo ganador es: " + paloGanador);
    paloGanador = paloGanador.substring(0,1);
    }
}
