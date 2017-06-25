package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.modelo.Componentes.Coordenada;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class GohanTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void seUbicaPersonajeGohanEnCasilleroYSeLoMueve() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada = new Coordenada(0, 2);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        gohan.mover(otraCoordenada);

        assertTrue(gohan.estaUbicadoEn(otraCoordenada));

    }

    @Test
    public void transformarPersonajeGohanEstadoSuperSayajinFase1() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            gohan.mover(unaCoordenada);
        }

        gohan.transformarse(goku, piccolo);

        // si esta en modo fortalecido su ki disminuye 10un
        assertTrue(gohan.poseeKi(40));
    }

    @Test
    public void noSePuedeTransformarPersonajeGohanEstadoSuperSayajinFase1() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        gohan.transformarse(goku,piccolo);
    }

    @Test
    public void transformarPersonajeGokuEstadoSuperSayajin2DisminuyeKI() {

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);


        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }

        gohan.transformarse(goku,piccolo);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }

        goku.recibirDanio(350);
        piccolo.recibirDanio(350);

        gohan.transformarse(goku,piccolo);

        assertTrue(gohan.poseeKi(35));
    }

    @Test
    public void noSePuedeTransformarGokuEstadoSuperSayajin2UnCompanieroNotieneEstadoCritico() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);


        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }

        gohan.transformarse(goku,piccolo);

        for (int i = 0; i < 10; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }
        piccolo.recibirDanio(350);

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        gohan.transformarse(goku,piccolo);

    }

    @Test
    public void noSePuedeTransformarGokuEstadoSuperSayajin2NoPoseeKiSuficiente(){
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);


        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        for (int i = 0; i < 5; i++) {
            //va a incrementar el ki
            gohan.mover(otraCoordenada1);
        }

        gohan.transformarse(goku,piccolo);

        piccolo.recibirDanio(350);
        goku.recibirDanio(350);

        thrown.expect(NoSePuedeTransformarPersonajeException.class);
        gohan.transformarse(goku,piccolo);

    }

    @Test
    public void ataqueMasenkoGohanDisminuye10unKi(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada = new Coordenada(1,1);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada1);

        for(int i=0; i<5 ; i++){
            gohan.mover(otraCoordenada);
        }

        gohan.masenko(majinboo);
        assertTrue(gohan.poseeKi(15));
    }

    @Test
    public void ataqueMasenkoGohanAtacaAMajibooDisminuyeVidaUn25porcMasQueBasico(){

        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada = new Coordenada(1,1);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        MajinBoo majinboo = new MajinBoo();
        majinboo.naceEn(otraCoordenada1);

        for(int i=0; i<5 ; i++){
            gohan.mover(otraCoordenada);
        }

        gohan.masenko(majinboo);
        //como majinboo tiene mayor poder de pelea el ataque de gohan disminuye un 20%
        assertTrue(majinboo.poseeVida(285));
    }

    @Test
    public void ataqueMasenkoAunCompanieroExcepcionNoProduceDanioNiDisminuyeSuKi() {
        Coordenada unaCoordenada = new Coordenada(0, 0);
        Coordenada otraCoordenada1 = new Coordenada(0, 1);
        Coordenada otraCoordenada = new Coordenada(2, 0);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Goku goku = new Goku();
        goku.naceEn(otraCoordenada1);

        for(int i=0; i<5 ; i++){
            gohan.mover(unaCoordenada);
        }

        thrown.expect(FuegoAmigoException.class);
        gohan.masenko(goku);

        assertTrue(gohan.poseeKi(25));
    }

    @Test
    public void gohanNaceEnUnaCeldaYseMueveArribaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = gohan.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void gohanNaceEnUnaCeldaYseMueveAbajoAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = gohan.moverAbajo();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 5);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void gohanNaceEnUnaCeldaYseMueveAAIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = gohan.moverAIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void gohanNaceEnUnaCeldaYseMueveADerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = gohan.moverADerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 5);
    }

    @Test
    public void gohanNaceEnUnaCeldaYseMueveASuperiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = gohan.moverASuperiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void gohanNaceEnUnaCeldaYseMueveASuperiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = gohan.moverASuperiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 7);
    }

    @Test
    public void gohanNaceEnUnaCeldaYseMueveAInferiorIzquierdaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = gohan.moverAInferiorIzquierda();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 3);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);
    }

    @Test
    public void gohanNaceEnUnaCeldaYseMueveAInferiorDerechaAcordeAsuEstado() {
        Coordenada unaCoordenada = new Coordenada(5, 5);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);
        Coordenada nuevaCoordenada = gohan.moverAInferiorDerecha();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 7);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 3);

    }
    /*
    @Test
    public void testTransformarPersonajeGohanEstadoSuperSayajin1YMoverArribaAcordeASuModo(){
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(7,9);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        for (int i=0; i<2; i++){
            //va a incrementar el ki
            gohan.mover(unaCoordenada);
        }

        gohan.transformarse();
        Coordenada nuevaCoordenada = gohan.moverArriba();

        assertEquals(nuevaCoordenada.getCoordenadaX(), 0);
        assertEquals(nuevaCoordenada.getCoordenadaY(), 2);
    }
    */

}