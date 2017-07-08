package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class EquipoTest {
    @Test
    public void crearEquipoGuerrerosZYVerificarPersonajes(){
        EquipoGuerrerosZ equipo = new EquipoGuerrerosZ();
        //
    }

    @Test
    public void crearEquipoEnemigosYVerificarPersonajes() {
        EquipoEnemigos equipo = new EquipoEnemigos();
        Personaje personajeEnemigo = equipo.obtenerPersonaje(0);
        Goku goku = new Goku();
        int vidaInicial = personajeEnemigo.getVida();
        //goku.ataqueBasico(personajeEnemigo);

    }

}
