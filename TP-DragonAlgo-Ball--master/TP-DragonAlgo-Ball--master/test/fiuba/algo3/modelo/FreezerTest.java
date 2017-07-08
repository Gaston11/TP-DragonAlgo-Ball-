package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonajeException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FreezerTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void seUbicaPersonajeFreezerEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        freezer.mover(otraCoordenada);

        assertTrue(freezer.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void noSePuedeUbicarGokuYFreezerEnElMismoCasillero() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada);

        freezer.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void transformarPersonajeFreezerEstadoSegundaForma() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }

        freezer.transformarse();

        // si esta en modo segunda forma su ki disminuye 20un
        assertTrue(freezer.poseeKi(30));
    }

    @Test
    public void noSePuedeTransformarPersonajeFreezerEstadoSegundaForma() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        freezer.transformarse();

        assertTrue(freezer.poseeKi(0));
    }

    @Test
    public void noSePuedeTransformarPersonajeFreezerEnEstadoDefinitivo() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }

        freezer.transformarse();

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        freezer.transformarse();

        assertTrue(freezer.poseeKi(5));
    }

    @Test
    public void transformarFreezerEstadoDefinitivoKiDisminuye() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }

        freezer.transformarse();

        for (int i = 0; i < 10; i++) {
            //va a incrementar el kif
            freezer.mover(otraCoordenada1);
        }

        freezer.transformarse();
        assertTrue(freezer.poseeKi(30));
    }

    @Test
    public void ataqueRayoMortalDeFrizzerAGohanCuesta20deKi(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        Gohan gohan =new Gohan();
        gohan.naceEn(otraCoordenada1);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }
        freezer.rayoMortal(gohan);
        assertTrue(freezer.poseeKi(30));
    }

    @Test
    public void ataqueRayoMortalDeFrizzerAGohanDisminuyeVida50porcMasQueElBasico(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        Gohan gohan =new Gohan();
        gohan.naceEn(otraCoordenada1);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            freezer.mover(otraCoordenada1);
        }
        freezer.rayoMortal(gohan);
        assertTrue(gohan.poseeVida(270));
    }

    @Test
    public void freezerAtaqueBasicoAGokuEnEstadoSuperSayajinDanioDisminuye20porc(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

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

        freezer.ataqueBasico(goku);

        assertTrue(goku.poseeVida(484));
    }

    @Test
    public void freezerNoPuedeAtacarAsuCompanieroDeEquipoException(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        Cell cell = new Cell();
        cell.naceEn(otraCoordenada1);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            freezer.mover(unaCoordenada);
        }

        thrown.expect(FuegoAmigoException.class);
        freezer.rayoMortal(cell);
    }

    @Test
    public void freezerNaceEnUnaCeldaYseMueveArribaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = freezer.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 9);
    }

    @Test
    public void freezerNaceEnUnaCeldaYseMueveAbajoAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = freezer.moverAbajo();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 1);
    }

    @Test
    public void freezerNaceEnUnaCeldaYseMueveAAIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = freezer.moverAIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 1);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void freezerNaceEnUnaCeldaYseMueveADerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = freezer.moverADerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 9);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void freezerNaceEnUnaCeldaYseMueveASuperiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = freezer.moverASuperiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 1);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 9);
    }

    @Test
    public void freezerNaceEnUnaCeldaYseMueveASuperiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = freezer.moverASuperiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 9);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 9);
    }

    @Test
    public void freezerNaceEnUnaCeldaYseMueveAInferiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = freezer.moverAInferiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 1);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 1);
    }

    @Test
    public void freezerNaceEnUnaCeldaYseMueveAInferiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = freezer.moverAInferiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 9);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 1);
    }

    @Test
    public void transformarPersonajeFreezerAEstadoSegundaFormaYMoverArribaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        for (int i=0; i<4; i++){
            //va a incrementar el ki
            freezer.moverArriba();
        }

        freezer.transformarse();
        Coordenada nuevaCoordenada = freezer.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 20);
    }

    @Test
    public void transformarPersonajeFreezerAEstadoDefinitivoYMoverArribaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        for (int i=0; i<16; i++){
            //va a incrementar el ki
            freezer.moverArriba();
        }

        freezer.transformarse();
        freezer.transformarse();
        Coordenada nuevaCoordenada = freezer.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 70);
    }

}