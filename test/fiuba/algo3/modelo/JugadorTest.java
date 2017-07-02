package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Juego.JugadorEnemigo;
import fiuba.algo3.modelo.Juego.JugadorZ;
import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;
import fiuba.algo3.modelo.Juego.Jugador;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class JugadorTest {
    @Test
    public void crearJugadoresAsignandoRivalesTrivial(){

        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");

        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        assertEquals("Juan", jugadorEnemigo.getRival().getNombre());
        assertEquals("Fede", jugador.getRival().getNombre());

    }

    @Test
    public void jugadorZAtaquesBasicoAJugadorEnemigoVerificaDanioDeFreezer(){
        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");
        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Personaje freezer = jugadorEnemigo.seleccionar("Freezer");
        Personaje goku = jugador.seleccionar("Goku");
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.mover(unaCoordenada);
        goku.mover(otraCoordenada);

        jugador.ataqueBasico("Goku", "Freezer");

        assertEquals(380, jugadorEnemigo.seleccionar("Freezer").getVida());

    }

    @Test
    public void jugadorEnemigoAtaquesBasicoAJugadorZVerificaDanioDeGoku(){
        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");

        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Personaje freezer = jugadorEnemigo.seleccionar("Freezer");
        Personaje goku = jugador.seleccionar("Goku");
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.mover(unaCoordenada);
        goku.mover(otraCoordenada);

        jugadorEnemigo.ataqueBasico("Freezer", "Goku");

        assertEquals(480, jugador.seleccionar("Goku").getVida());

    }

    @Test
    public void cadaJugadorTransformaAunPersonajeDisminuyeKi(){
        JugadorZ jugador = new JugadorZ("Jz");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("JEnemigo");

        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Personaje freezer = jugadorEnemigo.seleccionar("Freezer");
        Personaje goku = jugador.seleccionar("Goku");
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        for (int i=0; i<4; i++){
           freezer.mover(unaCoordenada);
           goku.mover(otraCoordenada);
        }

        jugador.transformar("Goku");
        jugadorEnemigo.transformar("Freezer");

        assertTrue(goku.poseeKi(0));
        assertTrue(freezer.poseeKi(0));
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void jugadorQuiereTransformarAunPersonajeQueNoEsSuyoYNoDisminuyeKi(){
        JugadorZ jugador = new JugadorZ("Jz");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("JEnemigo");

        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Personaje freezer = jugadorEnemigo.seleccionar("Freezer");
        Personaje goku = jugador.seleccionar("Goku");
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        for (int i=0; i<4; i++){
            freezer.mover(unaCoordenada);
            goku.mover(otraCoordenada);
        }

        thrown.expect(PersonajeInvalidoException.class);
        jugadorEnemigo.transformar("Goku");

        assertTrue(goku.poseeKi(20));
    }

    @Test
    public void jugadorQuiereatacarAUnCompanieroDeEquipoFuegoAmigoException(){
        JugadorZ jugador = new JugadorZ("Jz");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("JEnemigo");

        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Personaje freezer = jugadorEnemigo.seleccionar("Freezer");
        Personaje goku = jugador.seleccionar("Goku");
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        thrown.expect(FuegoAmigoException.class);
        jugador.ataqueBasico("Goku","Gohan");

    }

    @Test
    public void jugadorQuiereAtacarConUnPersonajeDelOtroJugadorPersonajeInvalidoException(){

        JugadorZ jugador = new JugadorZ("Jz");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("JEnemigo");

        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        Personaje freezer = jugadorEnemigo.seleccionar("Freezer");
        Personaje goku = jugador.seleccionar("Goku");
        Coordenada unaCoordenada = new Coordenada(0,0);
        Coordenada otraCoordenada = new Coordenada(2,0);
        freezer.naceEn(unaCoordenada);
        goku.naceEn(otraCoordenada);

        thrown.expect(PersonajeInvalidoException.class);
        jugadorEnemigo.ataqueBasico("Goku","Gohan");


    }
}