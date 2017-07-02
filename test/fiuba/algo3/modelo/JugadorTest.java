package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Juego.JugadorEnemigo;
import fiuba.algo3.modelo.Juego.JugadorZ;
import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;
import fiuba.algo3.modelo.Juego.Jugador;
import fiuba.algo3.modelo.Personajes.Personaje;
import org.junit.Test;

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

}