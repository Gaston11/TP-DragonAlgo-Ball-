package fiuba.algo3.modelo;


import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Personajes.MajinBoo;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class MajinBooTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void seUbicaPersonajeMajinBooEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        majinboo.mover(otraCoordenada);

        assertTrue(majinboo.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void noSePuedeUbicarMajinBooYFreezerEnElMismoCasillero() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);


        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        freezer.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void transformarPersonajeEstadoBooMaloDisminuyeKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.mover(otraCoordenada1);
        }

        majinboo.transformarse();

        // si esta en modo fortalecido su ki disminuye 20un
        assertTrue(majinboo.poseeKi(30));
    }

    @Test
    public void noSePuedeTransformarPersonajeEstadoBooMaloExcepcion() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        majinboo.transformarse();
    }

    @Test
    public void noSePuedeTransformarPersonajeEstadoBooOriginalExcepcion() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            majinboo.mover(otraCoordenada1);
        }

        majinboo.transformarse();

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        majinboo.transformarse();
    }

    @Test
    public void transformarEstadoBooOriginalDisminuyeKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.mover(otraCoordenada1);
        }

        majinboo.transformarse();

        for (int i = 0; i < 10; i++) {
            //va a incrementar el kif
            majinboo.mover(otraCoordenada1);
        }

        majinboo.transformarse();

        assertTrue(majinboo.poseeKi(30));
    }

    @Test
    public void majinbooNoPuedeAtacarAUnCompanieroEquipoNoProduceDanio(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada1);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            majinboo.mover(otraCoordenada1);
        }
        thrown.expect(FuegoAmigoException.class);
        majinboo.ataqueBasico(cell);

        assertTrue(cell.poseeVida(500));

    }

    @Test
    public void majinBooNaceEnUnaCeldaYseMueveArribaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = majinBoo.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void majinBooNaceEnUnaCeldaYseMueveAbajoAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        MajinBoo majinBoo= new MajinBoo();
        majinBoo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = majinBoo.moverAbajo();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void majinBooNaceEnUnaCeldaYseMueveAAIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = majinBoo.moverAIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void majinBooNaceEnUnaCeldaYseMueveADerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = majinBoo.moverADerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void majinBooNaceEnUnaCeldaYseMueveASuperiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = majinBoo.moverASuperiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void majinBooNaceEnUnaCeldaYseMueveASuperiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = majinBoo.moverASuperiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void majinBooNaceEnUnaCeldaYseMueveAInferiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = majinBoo.moverAInferiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void majinBooNaceEnUnaCeldaYseMueveAInferiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = majinBoo.moverAInferiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void transformarPersonajeMajinBooEstadoBooMaloYMoverArribaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(7,9);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(unaCoordenada);

        for (int i=0; i<4; i++){
            //va a incrementar el ki
            majinBoo.mover(unaCoordenada);
        }

        majinBoo.transformarse();
        Coordenada nuevaCoordenada = majinBoo.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void transformarPersonajeMajinBooEstadoBooOriginalYMoverArribaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(7,9);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(unaCoordenada);

        for (int i=0; i<14; i++){
            //va a incrementar el ki
            majinBoo.mover(unaCoordenada);
        }

        majinBoo.transformarse();
        majinBoo.transformarse();
        Coordenada nuevaCoordenada = majinBoo.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 4);
    }
}