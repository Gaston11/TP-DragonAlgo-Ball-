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
    public void JuegoIntegracion(){

        Juego juego = new Juego("Miqui","Giu");
        Jugador jugadorActual = juego.getJugadorActual();
        Personaje goku = jugadorActual.seleccionar("Goku");
        Personaje freezer = jugadorActual.getRival().seleccionar("Freezer");
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada dosCoordenada = new Coordenada(1,1);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada2 = new Coordenada(9,1);

        Celda celdaGoku = new Celda(unaCoordenada);
        Celda celdaFreezer = new Celda(dosCoordenada);
        Tablero tablero = juego.getTablero();
        tablero.colocarCeldaEnTablero(celdaGoku);
        goku.naceEn(unaCoordenada);
        tablero.colocarCeldaEnTablero(celdaFreezer);
        freezer.naceEn(dosCoordenada);

        juego.mover("Goku", "Arriba");

        assertTrue(goku.estaUbicadoEn(otraCoordenada));

        //juego.atacar("Goku","Freezer","Basico");

        //assertEquals(380, freezer.getVida());

        //juego.atacar("Goku","Freezer","Especial");

        //assertEquals(370, freezer.getVida());

        //juego.cambiarTurno();
        assertEquals("Giu", juego.getJugadorActual().getRival().getNombre());

        jugadorActual.getRival().mover(freezer,"Derecha");
        jugadorActual.getRival().mover(freezer,"Derecha");
        jugadorActual.getRival().mover(freezer, "Izquierda");
        jugadorActual.getRival().mover(freezer,"Izquierda");
        assertTrue(freezer.estaUbicadoEn(dosCoordenada));

        //juego.atacar("Freezer","Goku","Especial");
        //assertEquals(470, goku.getVida());
    }
}