package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Juego.JugadorEnemigo;
import fiuba.algo3.modelo.Juego.JugadorZ;
import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;
import fiuba.algo3.modelo.Juego.Jugador;
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

        jugador.ataqueBasico("Goku", jugadorEnemigo.seleccionarPersonaje("Freezer"));

        assertEquals(380, jugadorEnemigo.seleccionarPersonaje("Freezer").getVida());

    }

    @Test
    public void jugadorEnemigoAtaquesBasicoAJugadorZVerificaDanioDeGoku(){
        JugadorZ jugador = new JugadorZ("Juan");
        JugadorEnemigo jugadorEnemigo = new JugadorEnemigo("Fede");

        jugador.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugador);

        jugadorEnemigo.ataqueBasico("Freezer", jugador.seleccionarPersonaje("Goku"));

        assertEquals(480, jugador.seleccionarPersonaje("Goku").getVida());

    }

}