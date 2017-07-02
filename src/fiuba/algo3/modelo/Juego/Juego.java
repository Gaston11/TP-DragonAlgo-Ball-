package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Personajes.*;

import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {

    private Tablero tablero;
    private Jugador jugadorActual;
    private int accionMover;
    private int accionAtacar;
    private Jugador jugadorGanador;

    public Juego(String jZ, String jEnemigo){

        tablero = new Tablero(10);
        this.crearJugadorActual(jZ, jEnemigo);
        accionMover = 0;
        accionAtacar =0;
    }

    private void crearJugadorActual(String jZ, String jEnemigo) {
        Jugador jugadorZ = new JugadorZ(jZ);
        Jugador jugadorEnemigo = new JugadorEnemigo(jEnemigo);
        jugadorZ.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugadorZ);
        this.jugadorActual = jugadorZ; //Tendria que ser random
    }

    public void mover(String personaje, String direccion){

        if(accionMover==0) {
            if (!jugadorActual.personajesMuertos()) {
                accionMover+=1;
                Personaje personaje1 = jugadorActual.seleccionar(personaje);
                tablero.moverPersonaje(personaje1, jugadorActual.mover(personaje1, direccion));

            } else {
                jugadorGanador = jugadorActual.getRival();
                //throw new TenemosUnGanador();
            }
        }else {
            this.cambiarTurno();
        }
    }

    public void atacar(String personajeAtaca, String personajeAtacado, String tipoAtaque) {
        if (accionAtacar == 0) {
            accionAtacar += 1;
            if (tipoAtaque == "Basico") {
                jugadorActual.ataqueBasico(personajeAtaca, personajeAtacado);
            } else {
                jugadorActual.ataqueEspecial(personajeAtaca, personajeAtacado);
            }
        } else {
            this.cambiarTurno();
        }
    }


    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    public void cambiarTurno() {
        if(accionMover==1 && accionAtacar ==1){
            jugadorActual = jugadorActual.getRival();
            accionMover = 0;
            accionAtacar = 0;
        }
    }

    public Tablero getTablero() {
        return tablero;
    }
}
