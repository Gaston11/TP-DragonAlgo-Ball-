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


    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoCeroNueve(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        EquipoEnemigos enemigos = new EquipoEnemigos();
        EquipoGuerrerosZ guerrerosZ = new EquipoGuerrerosZ();
        tablero.ubicarEquipos(enemigos, guerrerosZ);
        Coordenada coordenada1 = new Coordenada( 0,9 );

        Celda celda1 = new Celda( coordenada1 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda1 );
    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoCeroOcho(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        EquipoEnemigos enemigos = new EquipoEnemigos();
        EquipoGuerrerosZ guerrerosZ = new EquipoGuerrerosZ();
        tablero.ubicarEquipos(enemigos, guerrerosZ);
        Coordenada coordenada2 = new Coordenada( 0,8 );

        Celda celda2 = new Celda( coordenada2 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda2 );

    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoUnoNueve(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        EquipoEnemigos enemigos = new EquipoEnemigos();
        EquipoGuerrerosZ guerrerosZ = new EquipoGuerrerosZ();
        tablero.ubicarEquipos(enemigos, guerrerosZ);
        Coordenada coordenada3 = new Coordenada( 1,9 );

        Celda celda3 = new Celda( coordenada3 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda3 );
    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoNueveCero(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        EquipoEnemigos enemigos = new EquipoEnemigos();
        EquipoGuerrerosZ guerrerosZ = new EquipoGuerrerosZ();
        tablero.ubicarEquipos(enemigos, guerrerosZ);
        Coordenada coordenada4 = new Coordenada( 9,0 );

        Celda celda4 = new Celda( coordenada4 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda4 );
    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoNueveUno(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        EquipoEnemigos enemigos = new EquipoEnemigos();
        EquipoGuerrerosZ guerrerosZ = new EquipoGuerrerosZ();
        tablero.ubicarEquipos(enemigos, guerrerosZ);
        Coordenada coordenada5 = new Coordenada( 9,1 );

        Celda celda5 = new Celda( coordenada5 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda5 );
    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoOchoCero(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        EquipoEnemigos enemigos = new EquipoEnemigos();
        EquipoGuerrerosZ guerrerosZ = new EquipoGuerrerosZ();
        tablero.ubicarEquipos(enemigos, guerrerosZ);

        Coordenada coordenada6 = new Coordenada( 8,0 );

        Celda celda6 = new Celda( coordenada6 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda6 );

    }
}

