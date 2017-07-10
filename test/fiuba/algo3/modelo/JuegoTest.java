package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.Juego.Juego;
import fiuba.algo3.modelo.Juego.Jugador;
import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;
import fiuba.algo3.modelo.excepciones.NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonajeException;
import fiuba.algo3.modelo.excepciones.NoSeleccionoNingunPersonajeException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JuegoTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test //Puede atacar o transformarse Pero no significa que cambia el turno pero solo lo puede hacer una vez
    public void cuandoMuevePersonajeNoCambiaTurnoSiNoEjecutoAtaque() {

        Juego juego = new Juego("Miqui","Giu");

        Coordenada unaCoordenada = new Coordenada(0,9);
        Coordenada unaCoordenada1 = new Coordenada(1,8);

        juego.mover(unaCoordenada,unaCoordenada1);

        assertEquals("Miqui", juego.getJugadorActual().getNombre());

    }


    @Test
    public void JuegoJugadorZIntentaSeleccionarUnaPosicionDeTableroQueNoTienePersonajeException() {
        Juego juego = new Juego("Miqui","Giu");

        Coordenada unaCoordenada1 = new Coordenada(2,2);

        thrown.expect(NoSeleccionoNingunPersonajeException.class);
        juego.mover(unaCoordenada1, unaCoordenada1);
    }

    @Test
    public void jugadorRealizaUnAtaqueBasicoLuegoDeMoverYCambiaElTurno(){
        Juego juego = new Juego("Miqui","Giu");
        Coordenada cGoku = new Coordenada(0,9);
        Coordenada cGoku1 = new Coordenada(1,8);

        //Turno miqui
        juego.mover(cGoku,cGoku1);
        juego.finalizarTurnoJugadorActual();

        Coordenada cEnemigo = new Coordenada(9,0);
        Coordenada coordenada = new Coordenada(8,1);
        cGoku = new Coordenada(3,6);
        //Turno Giu
        juego.mover(cEnemigo,coordenada);
        juego.finalizarTurnoJugadorActual();
        //Turno Miqui
        cEnemigo = new Coordenada(6,3);
        juego.mover(cGoku1,cGoku);
        juego.finalizarTurnoJugadorActual();
        //Turno Giu
        juego.mover(coordenada,cEnemigo);
        juego.finalizarTurnoJugadorActual();
        //Turno Miqui
        cGoku1 = new Coordenada(5,4);
        juego.mover(cGoku,cGoku1);
        juego.atacar(cGoku1, cEnemigo);

        assertEquals("Giu", juego.getJugadorActual().getNombre());
    }

    @Test
    public void jugadorRealizaUnAtaqueEspecialLuegoDeMoverYCambiaElTurno(){
        Juego juego = new Juego("Miqui","Giu");
        Coordenada cGoku = new Coordenada(0,9);
        Coordenada cGoku1 = new Coordenada(1,8);
        //Turno Miqui
        juego.mover(cGoku,cGoku1);
        juego.finalizarTurnoJugadorActual();
        //Turno Giu
        Coordenada cEnemigo = new Coordenada(9,0);
        Coordenada coordenada = new Coordenada(8,1);
        cGoku = new Coordenada(3,6);
        juego.mover(cEnemigo,coordenada);
        juego.finalizarTurnoJugadorActual();
        //Turno Miqui
        cEnemigo = new Coordenada(6,3);
        juego.mover(cGoku1,cGoku);
        juego.finalizarTurnoJugadorActual();
        //Turno Giu
        juego.mover(coordenada,cEnemigo);
        juego.finalizarTurnoJugadorActual();
        //Turno Miqui
        cGoku1 = new Coordenada(5,4);
        juego.mover(cGoku,cGoku1);
        juego.finalizarTurnoJugadorActual();
        //Turno Giu
        coordenada = new Coordenada(4,3);
        juego.mover(cEnemigo, coordenada);
        juego.finalizarTurnoJugadorActual();
        //Turno Miqui
        cGoku = new Coordenada(5,3);
        juego.mover(cGoku1,cGoku);
        juego.finalizarTurnoJugadorActual();
        //Turno Giu
        cEnemigo = new Coordenada(4,4);
        juego.mover(coordenada,cEnemigo);
        juego.atacarEspecial(cEnemigo,cGoku);

        assertEquals("Miqui", juego.getJugadorActual().getNombre());
    }

    @Test
    public void jugadorRealizaUnaTransformacionYNoCambiaElTurno(){
        Juego juego = new Juego("Miqui","Giu");
        Coordenada cGoku = new Coordenada(0,9);
        Coordenada cGoku1 = new Coordenada(1,8);
        //Turno Miqui
        juego.mover(cGoku,cGoku1);
        juego.finalizarTurnoJugadorActual();
        //Turno Giu
        Coordenada cEnemigo = new Coordenada(9,0);
        Coordenada coordenada = new Coordenada(8,1);
        cGoku = new Coordenada(3,6);
        juego.mover(cEnemigo,coordenada);
        juego.finalizarTurnoJugadorActual();
        //Turno Miqui
        cEnemigo = new Coordenada(6,3);
        juego.mover(cGoku1,cGoku);
        juego.finalizarTurnoJugadorActual();
        //Turno Giu
        juego.mover(coordenada,cEnemigo);
        juego.finalizarTurnoJugadorActual();
        //Turno Miqui
        cGoku1 = new Coordenada(5,4);
        juego.mover(cGoku,cGoku1);
        juego.finalizarTurnoJugadorActual();
        //Turno Giu
        coordenada = new Coordenada(4,3);
        juego.mover(cEnemigo, coordenada);
        juego.finalizarTurnoJugadorActual();
        //Turno Miqui
        cGoku = new Coordenada(5,3);
        juego.mover(cGoku1,cGoku);
        juego.finalizarTurnoJugadorActual();
        //Turno Giu
        cEnemigo = new Coordenada(4,4);
        juego.mover(coordenada,cEnemigo);
        juego.finalizarTurnoJugadorActual();
        //Turno Miqui
        juego.transformar(cGoku);

        assertEquals("Miqui",juego.getJugadorActual().getNombre());

    }
}