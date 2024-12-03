package ejercicios;

import java.util.Arrays;
import java.util.Scanner;

public class Tute {

    public Tute(){

        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cuántos casos de prueba vas a realizar?");
        int casosPrueba = sc.nextInt();
        sc = null;

        String[] baraja = {
                            "1O","2O","3O","4O","5O","6O","7O", "SO", "CO", "RO",
                            "1B","2B","3B","4B","5B","6B","7B", "SB", "CB", "RB",
                            "1C","2C","3C","4C","5C","6C","7C", "SC", "CC", "RC",
                            "1E","2E","3E","4E","5E","6E","7E", "SE", "CE", "RE"
                        };
        
        String[] jugadores = {"Jugador1","Jugador2", "Jugador3","Jugador4"};
        String[] cartasJugadores = new String[jugadores.length];
        Arrays.fill(cartasJugadores, "");

        for (int i = 0; i < casosPrueba; i++) {
            repartirCartas(baraja, cartasJugadores);              

            imprimirCartasJugadores(cartasJugadores, jugadores);
            
            juego(cartasJugadores, jugadores);

            Arrays.fill(cartasJugadores, "");
        }

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

        String cartaActual = "";
        int salto = 0;
        for (int i = 0; i < cartasJugadores.length; i++) {
            for (int j = 0; j < cartasJugadores[i].length()/2; j++) {
                cartaActual = cartasJugadores[i].substring(salto, salto+2);
                if (carta.equals(cartaActual)) return true;
                salto+=2;
            }
            salto=0;
        }
        return false;
    }
    // I M P R I M I R   A R R A Y   Y   J U G A D O R E S
    private void imprimirCartasJugadores(String[] cartasJugadores, String[] jugadores){
        
        int salto = 0;
        String carta;

        for (int i = 0; i < cartasJugadores.length; i++) {
            System.out.printf("%2s", jugadores[i]);
            for (int j = 0; j < 10; j++) {
                carta = cartasJugadores[i].substring(salto, salto+2);
                System.out.printf(" %2s ", carta);
                salto+=2;
            }
            salto = 0;
            System.out.println();
        }

    }

    // J U E G O
    private void juego(String[] cartasJugadores, String[]jugadores){
    
        //elección de palo ganador.
    String[] palos = {"Oro", "Basto", "Copa", "Espada"}; 
    String paloGanador = palos[(int)(Math.random()*((palos.length-1) -0 +1) + 0)];

    System.out.println("El palo ganador es: " + paloGanador);
    String paloGanadorLetra = paloGanador.substring(0,1);

    String cartaActual, paloCartaActual, numCartaActual;
    int salto = 0;
    int copaP = 0, espadaP = 0, bastoP = 0, oroP = 0, paloGanadorP = 0;
    
    for (int i = 0; i < palos.length; i++) {       
        for (int j = 0; j < 10; j++) {
            cartaActual = cartasJugadores[i].substring(salto, salto+2);
            paloCartaActual = cartaActual.substring(1, 2);
            numCartaActual = cartaActual.substring(0, 1);
            
            if (numCartaActual.equals("C") || numCartaActual.equals("R")) {
                
                if (paloCartaActual.equals(paloGanadorLetra)) paloGanadorP++;
                else if(paloCartaActual.equals("C")) copaP++;
                else if(paloCartaActual.equals("E")) espadaP++;
                else if(paloCartaActual.equals("B")) bastoP++;
                else if(paloCartaActual.equals("O")) oroP++;
            }
            salto+=2;
        }    
        if (paloGanadorP == 2){

            System.out.println(jugadores[i] + " puede cantar cuarenta en " + paloGanador);
        }

        if (copaP == 2){
            System.out.println(jugadores[i] + " puede cantar veinte en copas");
        } 
        if (espadaP == 2){
            System.out.println(jugadores[i] + " puede cantar veinte en espadas");
        } 
        if (bastoP == 2){
            System.out.println(jugadores[i] + " puede cantar veinte en bastos");
        } 
        if (oroP == 2){
            System.out.println(jugadores[i] + " puede cantar veinte en oro");
        }
        salto = 0; copaP = 0; espadaP = 0; bastoP = 0; oroP = 0; paloGanadorP = 0;
    }
    System.out.println("Fin");
    System.out.println();
    }

}
