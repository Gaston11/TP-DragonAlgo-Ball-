package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.MajinBoo;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class CellTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void seUbicaPersonajeCellEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        cell.mover(otraCoordenada);

        assertTrue(cell.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void noSePuedeUbicarMajinBooYCellEnElMismoCasillero() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);
        Celda celdaNacimiento = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(otraCoordenada);
        Tablero tablero = new Tablero(4);


        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        tablero.colocarCeldaEnTablero(celdaNacimiento);
        tablero.colocarCeldaEnTablero(otraCelda);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada);

        cell.mover(otraCoordenada);
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);

    }

    @Test
    public void transformarPersonajeEstadoSemiPerfectoAbsorbeVidaVerificaLaAbsorcion() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        cell.recibirDanio(200);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        for (int i=0; i<4; i++){
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }

        cell.transformarse();

        assertTrue(cell.poseeVida(380));
    }

    @Test
    public void noSePuedeTransformarPersonajeSemiPerfectoPorNoAbsorberVida() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        cell.transformarse();
    }

    @Test
    public void noSePuedeTransformarPersonajeEstadoPerfectoExcepcion() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        for (int i = 0; i < 4; i++) {
            //va a incrementar el ki
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }

        cell.transformarse();

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        cell.transformarse();
    }

    @Test
    public void absorberVidaTeniendoLaVidaLlenaYQueNoSupereVidaDeCellMaxima(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        for (int i = 0; i < 4; i++) {
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }
        assertEquals(500, cell.getVida());
    }

    @Test
    public void transformarEstadoPerfectoAbsorbeVidaDeGokuVerificaSiSumoLaSuya() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);


        cell.recibirDanio(200);
        for (int i = 0; i < 4; i++) {
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }
        assertEquals(380, cell.getVida());

        cell.transformarse();

        cell.recibirDanio(220);
        for (int i = 0; i < 8; i++) {
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }
        cell.transformarse();

        assertTrue(cell.poseeVida(480));
    }

    @Test
    public void cellAbsorbeVidaDeGoku4VecesEnEstadoNormal() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        for (int i = 0; i < 4; i++) {
            cell.mover(otraCoordenada1);
            cell.absorber(goku);
        }

        cell.transformarse();

        assertTrue(goku.poseeVida(420));
    }

    @Test
    public void absorberVidaAGokuEstadoKaioKenProduce20porcMenosDeDanio(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(0,3);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada);

        for(int i=0; i<10;i++){
            cell.mover(otraCoordenada);
            goku.mover(unaCoordenada);
        }
        goku.transformarse();
        cell.absorber(goku);

        assertTrue(goku.poseeVida(484));

    }

    @Test
    public void cellNoPuedeAbsorberVidaPOrFaltaDeKi(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        thrown.expect(NoSePuedeAbsorberPersonajeException.class);
        cell.absorber(goku);

        assertTrue(cell.poseeKi(0));
        assertTrue(goku.poseeKi(0));
    }

    @Test
    public void cellNoPuedeAbsorberVidaDeMajinBooNoProduceDanio(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn(otraCoordenada1);

        cell.mover(unaCoordenada);

        try{
            cell.absorber(majinBoo);
        }catch (FuegoAmigoException ignored){

        }

        assertTrue(majinBoo.poseeVida(300));
    }

    @Test
    public void cellNaceEnUnaCeldaYseMueveArribaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void cellNaceEnUnaCeldaYseMueveAbajoAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverAbajo();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void cellNaceEnUnaCeldaYseMueveAAIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverAIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void cellNaceEnUnaCeldaYseMueveADerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverADerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void cellNaceEnUnaCeldaYseMueveASuperiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverASuperiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void cellNaceEnUnaCeldaYseMueveASuperiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverASuperiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void cellNaceEnUnaCeldaYseMueveAInferiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverAInferiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void cellNaceEnUnaCeldaYseMueveAInferiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = cell.moverAInferiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    /*
    @Test
    public void testTransformarPersonajeCellEnEstadoSemiPerfectoYMoverArribaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(7,9);

        Cell cell = new Cell();
        cell.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada);

        cell.mover(unaCoordenada);
        cell.mover(unaCoordenada);
        for (int i=0; i<10; i++){
            //va a incrementar el ki
            cell.mover(unaCoordenada);
            goku.mover(otraCoordenada);

        }

        cell.transformarse();
        Coordenada nuevaCoordenada = cell.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    */
}