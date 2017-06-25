package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;


public class GokuTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void seUbicaPersonajeGokuEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        goku.mover(otraCoordenada);

        assertTrue(goku.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void noSePuedeUbicarGokuYGohanEnElMismoCasillero() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada);

        gohan.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void transformarPersonajeGokuEstadoKaioKenDisminuyeKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();

        // si esta en modo KaioKen su ki disminuye 20un
        assertTrue(goku.poseeKi(30));
    }

    @Test
    public void noSePuedeTransformarPersonajeGokuEstadoKaioKenExcepcion() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        goku.transformarse();
    }

    @Test
    public void noSePuedeTransformarPersonajeGokuEstadoSuperSayajinExcepcion() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        goku.transformarse();
    }

    @Test
    public void transformarGokuEstadoSuperSayajinDisminuyeKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(otraCoordenada1);
        }

        goku.transformarse();

        assertTrue(goku.poseeKi(30));
    }

    @Test
    public void gokuAtacaACellConKamehamehaDisminuyKIgoku(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Cell cell = new Cell();
        cell.naceEn(otraCoordenada1);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.kamehameha(cell);
        assertTrue(goku.poseeKi(30));
    }

    @Test
    public void gokuAtacaConKamehamehaACellDisminuyeLaVida30unKi(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Cell cell = new Cell();
        cell.naceEn(otraCoordenada1);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.kamehameha(cell);
        assertTrue(cell.poseeVida(470));
    }

    @Test
    public void gokuNoPuedeAtacarConKamehamehaAUnCompanieroDeEquipoEsteNoSufreDanio(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada1);

        for(int i= 0; i<10; i++){
            goku.mover(unaCoordenada);
        }

        thrown.expect(FuegoAmigoException.class);
        goku.kamehameha(gohan);

        assertTrue(gohan.poseeVida(300));
    }

    @Test
    public void gokuNaceEnUnaCeldaYseMueveArribaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = goku.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void gokuNaceEnUnaCeldaYseMueveAbajoAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = goku.moverAbajo();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void gokuNaceEnUnaCeldaYseMueveAAIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = goku.moverAIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void gokuNaceEnUnaCeldaYseMueveADerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = goku.moverADerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void gokuNaceEnUnaCeldaYseMueveASuperiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = goku.moverASuperiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void gokuNaceEnUnaCeldaYseMueveASuperiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = goku.moverASuperiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void gokuNaceEnUnaCeldaYseMueveAInferiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = goku.moverAInferiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void gokuNaceEnUnaCeldaYseMueveAInferiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = goku.moverAInferiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void transformarPersonajeGokuAEstadoKaioKenYMoverArribaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i=0; i<4; i++){
            //va a incrementar el ki
            goku.moverArriba();
        }

        goku.transformarse();
        Coordenada nuevaCoordenada = goku.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 11);
    }

    @Test
    public void transformarPersonajeGokuAEstadoSuperSayayinYMoverArribaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i=0; i<14; i++){
            //va a incrementar el ki
            goku.moverArriba();
        }

        goku.transformarse();
        goku.transformarse();
        Coordenada nuevaCoordenada = goku.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 33);
    }

    @Test
    public void transformarPersonajeGokuAEstadoKaioKenYMoverAbajoAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i=0; i<4; i++){
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.transformarse();
        Coordenada nuevaCoordenada = goku.moverAbajo();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), -3);
    }

    @Test
    public void transformarPersonajeGokuAEstadoSuperSayayinYMoverAbajoAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i=0; i<14; i++){
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.transformarse();
        goku.transformarse();
        Coordenada nuevaCoordenada = goku.moverAbajo();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), -5);
    }

    @Test
    public void transformarPersonajeGokuAEstadoKaioKenYMoverAIzquierdaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i=0; i<4; i++){
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.transformarse();
        Coordenada nuevaCoordenada = goku.moverAIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), -3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 0);
    }

    @Test
    public void transformarPersonajeGokuAEstadoSuperSayayinYMoverAIzquierdaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i=0; i<14; i++){
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.transformarse();
        goku.transformarse();
        Coordenada nuevaCoordenada = goku.moverAIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), -5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 0);
    }

    @Test
    public void transformarPersonajeGokuAEstadoKaioKenYMoverADerechaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i=0; i<4; i++){
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.transformarse();
        Coordenada nuevaCoordenada = goku.moverADerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 0);
    }

    @Test
    public void transformarPersonajeGokuAEstadoSuperSayayinYMoverADerechaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i=0; i<14; i++){
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.transformarse();
        goku.transformarse();
        Coordenada nuevaCoordenada = goku.moverADerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 0);
    }

    @Test
    public void transformarPersonajeGokuAEstadoKaioKenYMoverASuperiorDerechaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        for (int i=0; i<4; i++){
            //va a incrementar el ki
            goku.mover(unaCoordenada);
        }

        goku.transformarse();
        Coordenada nuevaCoordenada = goku.moverASuperiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }
}