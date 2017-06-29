package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.EquipoEnemigos;
import fiuba.algo3.modelo.Personajes.EquipoGuerrerosZ;
import fiuba.algo3.modelo.excepciones.CeldaNoOcupadaException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;

public class TableroTest {

	
	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void colocarPersonajeEnCasilleroOcupadoPorOtroYLanzarExcepcion(){
        Coordenada unaCoordenada = new Coordenada(1,2);
        
        Celda unaCelda = new Celda(unaCoordenada);
        Celda otraCelda = new Celda(unaCoordenada);
        
        Tablero tablero = new Tablero(6);
        tablero.colocarCeldaEnTablero(unaCelda);
        
        thrown.expect(CeldaOcupadaException.class);
        tablero.colocarCeldaEnTablero(otraCelda);
        
	}

	@Test
    public void liberarCeldaNoOcupadaYRecibirExcepcion(){
	    Coordenada unaCoordenada = new Coordenada(1, 2);
	    Tablero tablero = new Tablero(6);

	    thrown.expect(CeldaNoOcupadaException.class);
	    tablero.liberarCeldaEnTablero(unaCoordenada);
    }

    /*
    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTablero(){
        Tablero tablero = new Tablero(10);
        EquipoEnemigos enemigos = new EquipoEnemigos();
        EquipoGuerrerosZ guerrerosZ = new EquipoGuerrerosZ();
        tablero.ubicarEquipos(enemigos, guerrerosZ);
    }
	*/
}

