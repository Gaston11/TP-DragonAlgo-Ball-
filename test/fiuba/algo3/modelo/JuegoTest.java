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
    public void JuegoIntegracionTurnoDeCadaJugadorCuandoMuevePersonajeCambiaTurnoJuegaJugadorEnemigo() {

        Juego juego = new Juego("Miqui","Giu");

        Coordenada unaCoordenada = new Coordenada(0,9);
        Coordenada unaCoordenada1 = new Coordenada(1,8);

        juego.mover(unaCoordenada,unaCoordenada1);

        assertEquals("Giu", juego.getJugadorActual().getNombre());

    }

    @Test
    public void JuegoJugadorZIntentaSeleccionarUnaPosicionDeTableroQueNoTienePersonajeException() {
        Juego juego = new Juego("Miqui","Giu");

        Coordenada unaCoordenada1 = new Coordenada(2,2);

        thrown.expect(NoSeleccionoNingunPersonajeException.class);
        juego.mover(unaCoordenada1, unaCoordenada1);
    }

    @Test
    public void jugadorRealizaUnAtaqueBAsicoCambiaElTurno(){
        Juego juego = new Juego("Miqui","Giu");
        Coordenada cGoku = new Coordenada(0,9);
        Coordenada cGoku1 = new Coordenada(1,8);

        juego.mover(cGoku,cGoku1);

        Coordenada cEnemigo = new Coordenada(9,0);
        Coordenada coordenada = new Coordenada(8,1);
        cGoku = new Coordenada(3,6);

        juego.mover(cEnemigo,coordenada);

        cEnemigo = new Coordenada(6,3);
        juego.mover(cGoku1,cGoku);
        juego.mover(coordenada,cEnemigo);
        cGoku1 = new Coordenada(5,3);
        juego.mover(cGoku,cGoku1);

        juego.atacar(cEnemigo, cGoku1);

        assertEquals("Miqui", juego.getJugadorActual().getNombre());
    }

    @Test
    public void jugadorRealizaUnAtaqueEspecialCambiaElTurno(){
        Juego juego = new Juego("Miqui","Giu");
        Coordenada cGoku = new Coordenada(0,9);
        Coordenada cGoku1 = new Coordenada(1,8);

        juego.mover(cGoku,cGoku1);

        Coordenada cEnemigo = new Coordenada(9,0);
        Coordenada coordenada = new Coordenada(8,1);
        cGoku = new Coordenada(3,6);

        juego.mover(cEnemigo,coordenada);

        cEnemigo = new Coordenada(6,3);
        juego.mover(cGoku1,cGoku);
        juego.mover(coordenada,cEnemigo);
        cGoku1 = new Coordenada(5,4);
        juego.mover(cGoku,cGoku1);
        coordenada = new Coordenada(4,3);
        juego.mover(cEnemigo, coordenada);
        cGoku = new Coordenada(5,3);
        juego.mover(cGoku1,cGoku);

        cEnemigo = new Coordenada(4,4);
        juego.mover(coordenada,cEnemigo);
        juego.atacarEspecial(cGoku,cEnemigo);

        assertEquals("Giu", juego.getJugadorActual().getNombre());

    }

    @Test
    public void jugadorRealizaUnaTransformacionYNoCambiaElTurno(){
        Juego juego = new Juego("Miqui","Giu");
        Coordenada cGoku = new Coordenada(0,9);
        Coordenada cGoku1 = new Coordenada(1,8);

        juego.mover(cGoku,cGoku1);

        Coordenada cEnemigo = new Coordenada(9,0);
        Coordenada coordenada = new Coordenada(8,1);
        cGoku = new Coordenada(3,6);

        juego.mover(cEnemigo,coordenada);

        cEnemigo = new Coordenada(6,3);
        juego.mover(cGoku1,cGoku);
        juego.mover(coordenada,cEnemigo);
        cGoku1 = new Coordenada(5,4);
        juego.mover(cGoku,cGoku1);
        coordenada = new Coordenada(4,3);
        juego.mover(cEnemigo, coordenada);
        cGoku = new Coordenada(5,3);
        juego.mover(cGoku1,cGoku);

        cEnemigo = new Coordenada(4,4);
        juego.mover(coordenada,cEnemigo);
        juego.transformar(cGoku);

        assertEquals("Miqui",juego.getJugadorActual().getNombre());

    }
}