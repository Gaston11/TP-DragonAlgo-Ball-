package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.Juego.Juego;
import fiuba.algo3.modelo.Juego.Jugador;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.Personaje;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JuegoTest {

    @Test
    public void JuegoIntegracionTurnoDeCadaJugadorAtacaYMuevueCambiaTurno(){

        Juego juego = new Juego("Miqui","Giu");
        Jugador jugadorActual = juego.getJugadorActual();
        Personaje goku = jugadorActual.seleccionar("Goku");
        Personaje freezer = jugadorActual.getRival().seleccionar("Freezer");
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada dosCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada2 = new Coordenada(5,1);

        Celda celdaGoku = new Celda(unaCoordenada);
        Celda celdaFreezer = new Celda(dosCoordenada);
        Tablero tablero = juego.getTablero();
        tablero.colocarCeldaEnTablero(celdaGoku);
        goku.naceEn(unaCoordenada);
        tablero.colocarCeldaEnTablero(celdaFreezer);
        freezer.naceEn(dosCoordenada);

        juego.mover("Goku", "Arriba");
        juego.atacar("Goku","Freezer","Basico");

        assertTrue(goku.estaUbicadoEn(otraCoordenada));
        assertEquals(380, freezer.getVida());
        assertEquals("Giu", juego.getJugadorActual().getNombre());

        juego.atacar("Freezer","Goku","Basico");
        juego.mover("Freezer","Derecha");

        assertEquals(480, goku.getVida());
        assertTrue(freezer.estaUbicadoEn(otraCoordenada2));

    }
/*
    @Test
    public void JuegoIntegracionPasanVariosTurnosYSeRealizanAtaquesEspeciales(){

        Juego juego = new Juego("Miqui","Giu");
        Jugador jugadorActual = juego.getJugadorActual();
        Personaje goku = jugadorActual.seleccionar("Goku");
        Personaje freezer = jugadorActual.getRival().seleccionar("Freezer");

        juego.mover("Goku", "Arriba");
        juego.atacar("Goku","Freezer","Basico");

        assertEquals(380, freezer.getVida());
        assertEquals("Giu", juego.getJugadorActual().getNombre());

        juego.atacar("Freezer","Goku","Basico");
        juego.mover("Freezer","Derecha");

        assertEquals(480, goku.getVida());

        juego.mover("Gohan", "Arriba");
        juego.atacar("Goku","Freezer","Basico");

        assertEquals(380, freezer.getVida());
        assertEquals("Giu", juego.getJugadorActual().getNombre());

        juego.atacar("MajinBoo","Goku","Basico");
        juego.mover("Freezer","Derecha");

        assertEquals(450, goku.getVida());

        juego.mover("Goku", "Arriba");
        juego.atacar("Gohan","Freezer","Basico");

        assertEquals(365, freezer.getVida());
        assertEquals("Miqui", juego.getJugadorActual().getNombre());

        juego.atacar("Freezer","Goku","Basico");
        juego.mover("Freezer","Derecha");

        assertEquals(430, goku.getVida());

        juego.mover("Goku", "Arriba");
        juego.atacar("Goku","Freezer","Basico");

        assertEquals(345, freezer.getVida());
        assertEquals("Giu", juego.getJugadorActual().getNombre());

        juego.atacar("Freezer","Goku","Basico");
        juego.mover("Freezer","Derecha");

        assertEquals(410, goku.getVida());
    }*/
}