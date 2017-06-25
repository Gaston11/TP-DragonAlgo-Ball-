package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Rule;

public class PiccoloTest{

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void seUbicaPersonajePiccoloEnCasilleroYSeLoMueve(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
            
        piccolo.mover(otraCoordenada);

        assertTrue(piccolo.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void noSePuedeUbicarPiccoloYGohanEnElMismoCasillero(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(otraCoordenada);

        gohan.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void transformarPersonajePiccoloEstadoFortalecido(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        for (int i=0; i<10; i++){
            //va a incrementar el ki
            piccolo.mover(otraCoordenada1);
        }

        piccolo.transformarse(gohan);

        // si esta en modo fortalecido su ki disminuye 20un
        assertTrue(piccolo.poseeKi(30));
    }

    @Test
    public void noSePuedeTransformarPersonajePiccoloEstadoFortalecido(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        piccolo.transformarse(gohan);
    }

    @Test
    public void noSePuedeTransformarPersonajePiccoloEnEstadoProtector(){

        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        for (int i=0; i<10; i++){
            //va a incrementar el ki
            piccolo.mover(otraCoordenada1);
        }

        piccolo.transformarse(gohan);

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        piccolo.transformarse(gohan);
    }

    @Test
    public void transformarPiccoloEnEstadoProtectorGohanPoseeVidaCritica(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,2);
        Coordenada otraCoordenada1 = new Coordenada(0,1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        for (int i=0; i<10; i++){
            //va a incrementar el ki
            piccolo.mover(otraCoordenada1);
            gohan.recibirDanio(24);
        }

        piccolo.transformarse(gohan);

        piccolo.transformarse(gohan);

        assertTrue(gohan.estadoVidaCritica());
    }

    @Test
    public void piccoloNaceEnUnaCeldaYseMueveArribaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = piccolo.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void piccoloNaceEnUnaCeldaYseMueveAbajoAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = piccolo.moverAbajo();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void piccoloNaceEnUnaCeldaYseMueveAAIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = piccolo.moverAIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void piccoloNaceEnUnaCeldaYseMueveADerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = piccolo.moverADerecha();


        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void piccoloNaceEnUnaCeldaYseMueveASuperiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = piccolo.moverASuperiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void piccoloNaceEnUnaCeldaYseMueveASuperiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = piccolo.moverASuperiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void piccoloNaceEnUnaCeldaYseMueveAInferiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = piccolo.moverAInferiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void piccoloNaceEnUnaCeldaYseMueveAInferiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = piccolo.moverAInferiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

/*
    @Test
    public void testTransformarPersonajePiccoloEstadoFortalecidoYMoverArribaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(7,9);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(otraCoordenada);

        for (int i=0; i<10; i++){
            //va a incrementar el ki
            piccolo.moverArriba();
        }

        piccolo.transformarse(gohan);
        Coordenada nuevaCoordenada = piccolo.moverArriba();


        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 22);
    }

    */

}