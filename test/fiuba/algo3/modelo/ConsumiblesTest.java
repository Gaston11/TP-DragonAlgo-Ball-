package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.*;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Piccolo;
import org.junit.Test;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class ConsumiblesTest {

    @Test
    public void gokuObtieneUnConsumibleSemilla(){
        Coordenada unaCoordenada = new Coordenada(2,0);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Semilla semilla = new Semilla();
        semilla.posicionarEn(otraCoordenada);

        goku.recibirDanio(150);

        celdaConConsumible.colocarConsumible(semilla);
        goku.mover(otraCoordenada);

        celdaConConsumible.colocarPersonaje(goku);

        assertEquals(450, goku.getVida());
        assertTrue(goku.poseeVida(450));
    }


    @Test
    public void gokuObtieneUnConsumibleSemillaPeroTieneVidaLLenaYNoPasaNada(){
        Coordenada unaCoordenada = new Coordenada(2,0);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Goku goku = new Goku();
        goku.naceEn(unaCoordenada);

        Semilla semilla = new Semilla();
        semilla.posicionarEn(otraCoordenada);

        celdaConConsumible.colocarConsumible(semilla);
        goku.mover(otraCoordenada);

        celdaConConsumible.colocarPersonaje(goku);

        assertEquals(500, goku.getVida());
    }

    @Test
    public void gohanObtieneUnaEsferaDelDragonSuAtaqueBasicoAumentaUn25porc(){
        Coordenada unaCoordenada = new Coordenada(2,0);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Gohan gohan = new Gohan();
        gohan.naceEn(unaCoordenada);

        Freezer freezer = new Freezer();
        Coordenada otraCoordenada1 = new Coordenada(1,1);
        freezer.naceEn(otraCoordenada1);

        EsferaDelDragon esfera = new EsferaDelDragon();
        celdaConConsumible.colocarConsumible(esfera);

        gohan.mover(otraCoordenada);
        celdaConConsumible.colocarPersonaje(gohan);

        gohan.ataqueBasico(freezer);

        assertTrue(freezer.poseeVida(385));

    }

    @Test
    public void freezerObtieneUnaEsferaDelDragonSuAtaqueBasicoAumentaUn25porc(){
        Coordenada unaCoordenada = new Coordenada(2,0);
        Coordenada otraCoordenada = new Coordenada(0,0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Gohan gohan = new Gohan();
        Coordenada otraCoordenada1 = new Coordenada(1,1);
        gohan.naceEn(otraCoordenada1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        EsferaDelDragon esfera = new EsferaDelDragon();
        celdaConConsumible.colocarConsumible(esfera);

        freezer.mover(otraCoordenada);
        celdaConConsumible.colocarPersonaje(freezer);

        freezer.ataqueBasico(gohan);

        assertTrue(gohan.poseeVida(275));

    }

    @Test
    public void freezerObtieneUnaEsferaDelDragonSuAtaqueBasicoAumentaUn25porcLoUsaEnDosTurnos() {
        Coordenada unaCoordenada = new Coordenada(2, 0);
        Coordenada otraCoordenada = new Coordenada(0, 0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Gohan gohan = new Gohan();
        Coordenada otraCoordenada1 = new Coordenada(1, 1);
        gohan.naceEn(otraCoordenada1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        EsferaDelDragon esfera = new EsferaDelDragon();
        celdaConConsumible.colocarConsumible(esfera);

        freezer.mover(otraCoordenada);
        celdaConConsumible.colocarPersonaje(freezer);

        freezer.ataqueBasico(gohan);

        freezer.ataqueBasico(gohan);

        assertTrue(gohan.poseeVida(250));

    }

    @Test
    public void freezerObtieneUnaEsferaDelDragonSuAtaqueBasicoAumentaUn25porcLoUsaEnDosTurnosAlTerceroVuelveASuEstadoNormal() {
        Coordenada unaCoordenada = new Coordenada(2, 0);
        Coordenada otraCoordenada = new Coordenada(0, 0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Gohan gohan = new Gohan();
        Coordenada otraCoordenada1 = new Coordenada(1, 1);
        gohan.naceEn(otraCoordenada1);

        Freezer freezer = new Freezer();
        freezer.naceEn(unaCoordenada);

        EsferaDelDragon esfera = new EsferaDelDragon();
        celdaConConsumible.colocarConsumible(esfera);

        freezer.mover(otraCoordenada);
        celdaConConsumible.colocarPersonaje(freezer);

        freezer.ataqueBasico(gohan);

        freezer.ataqueBasico(gohan);

        freezer.ataqueBasico(gohan);

        assertTrue(gohan.poseeVida(230));

    }

    @Test
    public void piccoloObtieneUnaNubeVoladoraSuVelocidadSeDuplica(){
        Coordenada unaCoordenada = new Coordenada(2, 0);
        Coordenada otraCoordenada = new Coordenada(0, 0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        NubeVoladora nube = new NubeVoladora();
        nube.posicionarEn(otraCoordenada);
        celdaConConsumible.colocarConsumible(nube);
        piccolo.mover(otraCoordenada);
        celdaConConsumible.colocarPersonaje(piccolo);
        piccolo.moverAbajo();
        Coordenada coordenadaEsperada = new Coordenada(0,-4);

        assertTrue(piccolo.estaUbicadoEn(coordenadaEsperada));
    }

    @Test
    public void piccoloObtieneUnaNubeVoladoraSuVelocidadSeDuplicaPorDosTurnos(){
        Coordenada unaCoordenada = new Coordenada(2, 0);
        Coordenada otraCoordenada = new Coordenada(0, 0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        NubeVoladora nube = new NubeVoladora();
        nube.posicionarEn(otraCoordenada);
        celdaConConsumible.colocarConsumible(nube);
        piccolo.mover(otraCoordenada);
        celdaConConsumible.colocarPersonaje(piccolo);
        piccolo.moverAbajo();
        Coordenada coordenadaEsperada = new Coordenada(4,-4);
        piccolo.moverADerecha();

        assertTrue(piccolo.estaUbicadoEn(coordenadaEsperada));
    }

    @Test
    public void piccoloObtieneUnaNubeVoladoraSuVelocidadSeDuplicaPorDosTurnosAlTerceroVuelveAlEstadoAnterior(){
        Coordenada unaCoordenada = new Coordenada(2, 0);
        Coordenada otraCoordenada = new Coordenada(0, 0);
        Celda celdaConConsumible = new Celda(otraCoordenada);

        Piccolo piccolo = new Piccolo();
        piccolo.naceEn(unaCoordenada);

        NubeVoladora nube = new NubeVoladora();
        nube.posicionarEn(otraCoordenada);
        celdaConConsumible.colocarConsumible(nube);
        piccolo.mover(otraCoordenada);
        celdaConConsumible.colocarPersonaje(piccolo);
        piccolo.moverAbajo();
        Coordenada coordenadaEsperada = new Coordenada(2,-4);
        piccolo.moverADerecha();
        piccolo.moverAIzquierda();

        assertTrue(piccolo.estaUbicadoEn(coordenadaEsperada));
    }

}