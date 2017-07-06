package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.CeldaNoOcupadaException;
import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import org.junit.rules.ExpectedException;
import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

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
        List<Personaje> personajesZ = new ArrayList<>();
        List<Personaje> personajesEnemigos = new ArrayList<>();
        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Piccolo piccolo = new Piccolo();
        personajesZ.add( goku );
        personajesZ.add( gohan );
        personajesZ.add( piccolo );

        Cell cell = new Cell();
        Freezer freezer = new Freezer();
        MajinBoo majinBoo = new MajinBoo();
        personajesEnemigos.add( cell );
        personajesEnemigos.add( freezer );
        personajesEnemigos.add( majinBoo );

        tablero.ubicarEquipos(personajesZ, personajesEnemigos);
        Coordenada coordenada1 = new Coordenada( 0,9 );

        Celda celda1 = new Celda( coordenada1 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda1 );
    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoCeroOcho(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        List<Personaje> personajesZ = new ArrayList<>();
        List<Personaje> personajesEnemigos = new ArrayList<>();
        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Piccolo piccolo = new Piccolo();
        personajesZ.add( goku );
        personajesZ.add( gohan );
        personajesZ.add( piccolo );

        Cell cell = new Cell();
        Freezer freezer = new Freezer();
        MajinBoo majinBoo = new MajinBoo();
        personajesEnemigos.add( cell );
        personajesEnemigos.add( freezer );
        personajesEnemigos.add( majinBoo );

        tablero.ubicarEquipos(personajesZ, personajesEnemigos);

        Coordenada coordenada2 = new Coordenada( 0,8 );

        Celda celda2 = new Celda( coordenada2 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda2 );

    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoUnoNueve(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        List<Personaje> personajesZ = new ArrayList<>();
        List<Personaje> personajesEnemigos = new ArrayList<>();
        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Piccolo piccolo = new Piccolo();
        personajesZ.add( goku );
        personajesZ.add( gohan );
        personajesZ.add( piccolo );

        Cell cell = new Cell();
        Freezer freezer = new Freezer();
        MajinBoo majinBoo = new MajinBoo();
        personajesEnemigos.add( cell );
        personajesEnemigos.add( freezer );
        personajesEnemigos.add( majinBoo );

        tablero.ubicarEquipos(personajesZ, personajesEnemigos);

        Coordenada coordenada3 = new Coordenada( 1,9 );

        Celda celda3 = new Celda( coordenada3 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda3 );
    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoNueveCero(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        List<Personaje> personajesZ = new ArrayList<>();
        List<Personaje> personajesEnemigos = new ArrayList<>();
        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Piccolo piccolo = new Piccolo();
        personajesZ.add( goku );
        personajesZ.add( gohan );
        personajesZ.add( piccolo );

        Cell cell = new Cell();
        Freezer freezer = new Freezer();
        MajinBoo majinBoo = new MajinBoo();
        personajesEnemigos.add( cell );
        personajesEnemigos.add( freezer );
        personajesEnemigos.add( majinBoo );

        tablero.ubicarEquipos(personajesZ, personajesEnemigos);

        Coordenada coordenada4 = new Coordenada( 9,0 );

        Celda celda4 = new Celda( coordenada4 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda4 );
    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoNueveUno(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);
        List<Personaje> personajesZ = new ArrayList<>();
        List<Personaje> personajesEnemigos = new ArrayList<>();
        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Piccolo piccolo = new Piccolo();
        personajesZ.add( goku );
        personajesZ.add( gohan );
        personajesZ.add( piccolo );

        Cell cell = new Cell();
        Freezer freezer = new Freezer();
        MajinBoo majinBoo = new MajinBoo();
        personajesEnemigos.add( cell );
        personajesEnemigos.add( freezer );
        personajesEnemigos.add( majinBoo );

        tablero.ubicarEquipos(personajesZ, personajesEnemigos);

        Coordenada coordenada5 = new Coordenada( 9,1 );

        Celda celda5 = new Celda( coordenada5 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda5 );
    }

    @Test
    public void ubicarEquiposEnVerticesOpuestosDelTableroYVerificarCasilleroOcupadoOchoCero(){
        //PRUEBA PARA UN TABLERO DE 10X10
        Tablero tablero = new Tablero(10);

        List<Personaje> personajesZ = new ArrayList<>();
        List<Personaje> personajesEnemigos = new ArrayList<>();
        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Piccolo piccolo = new Piccolo();
        personajesZ.add( goku );
        personajesZ.add( gohan );
        personajesZ.add( piccolo );

        Cell cell = new Cell();
        Freezer freezer = new Freezer();
        MajinBoo majinBoo = new MajinBoo();
        personajesEnemigos.add( cell );
        personajesEnemigos.add( freezer );
        personajesEnemigos.add( majinBoo );

        tablero.ubicarEquipos(personajesZ, personajesEnemigos);

        Coordenada coordenada6 = new Coordenada( 8,0 );

        Celda celda6 = new Celda( coordenada6 );

        thrown.expect( CeldaOcupadaException.class );
        tablero.colocarCeldaEnTablero( celda6 );

    }

    @Test
    public void gokuYGohanEstanEnElTableroYGokuSeMueveALCasilleroDeGohanYTableroLoColocaEnSuCasilleroAnterior(){
        Coordenada unaCoordenada = new Coordenada( 4,4 );
        Coordenada otraCoordenada = new Coordenada( 4,6 );

        Goku goku = new Goku();
        goku.naceEn( unaCoordenada );
        Gohan gohan = new Gohan();
        gohan.naceEn( otraCoordenada );

        Celda unaCelda = new Celda( unaCoordenada );
        unaCelda.colocarPersonaje( goku );
        Celda otraCelda = new Celda(otraCoordenada);
        otraCelda.colocarPersonaje( gohan );

        Tablero mitablero = new Tablero( 10 );
        mitablero.colocarCeldaEnTablero( unaCelda );
        mitablero.colocarCeldaEnTablero( otraCelda );

        Coordenada nuevaCoordenada = goku.moverArriba();
        mitablero.moverPersonaje( goku, nuevaCoordenada );
        assertTrue(goku.estaUbicadoEn( unaCoordenada )); //vuelve a su posicion anterior
    }

    @Test
    public void gokuYCellEstanEnElTableroYGokuSeMueveALCasilleroDeCellYTableroLoColocaEnSuCasilleroAnterior(){
        Coordenada unaCoordenada = new Coordenada( 5,5 );
        Coordenada otraCoordenada = new Coordenada( 5,7 );

        Goku goku = new Goku();
        goku.naceEn( unaCoordenada );
        Cell cell = new Cell();
        cell.naceEn( otraCoordenada );

        Celda unaCelda = new Celda( unaCoordenada );
        unaCelda.colocarPersonaje( goku );
        Celda otraCelda = new Celda(otraCoordenada);
        otraCelda.colocarPersonaje( cell );

        Tablero mitablero = new Tablero( 10 );
        mitablero.colocarCeldaEnTablero( unaCelda );
        mitablero.colocarCeldaEnTablero( otraCelda );

        Coordenada nuevaCoordenada = goku.moverArriba();
        mitablero.moverPersonaje( goku, nuevaCoordenada );
        assertTrue(goku.estaUbicadoEn( unaCoordenada )); //vuelve a su posicion anterior
    }

    @Test
    public void gokuYFreezerEstanEnElTableroYGokuSeMueveALCasilleroDeFreezerYTableroLoColocaEnSuCasilleroAnterior(){
        Coordenada unaCoordenada = new Coordenada( 3,5 );
        Coordenada otraCoordenada = new Coordenada( 3,7 );

        Goku goku = new Goku();
        goku.naceEn( unaCoordenada );
        Freezer freezer = new Freezer();
        freezer.naceEn( otraCoordenada );

        Celda unaCelda = new Celda( unaCoordenada );
        unaCelda.colocarPersonaje( goku );
        Celda otraCelda = new Celda(otraCoordenada);
        otraCelda.colocarPersonaje( freezer );

        Tablero mitablero = new Tablero( 10 );
        mitablero.colocarCeldaEnTablero( unaCelda );
        mitablero.colocarCeldaEnTablero( otraCelda );

        Coordenada nuevaCoordenada = goku.moverArriba();
        mitablero.moverPersonaje( goku, nuevaCoordenada );
        assertTrue(goku.estaUbicadoEn( unaCoordenada )); //vuelve a su posicion anterior
    }

    @Test
    public void MajinBooYFreezerEstanEnElTableroYMajinBooSeMueveALCasilleroDeFreezerYTableroLoColocaEnSuCasilleroAnterior(){
        Coordenada unaCoordenada = new Coordenada( 2,5 );
        Coordenada otraCoordenada = new Coordenada( 2,7 );

        MajinBoo majinBoo = new MajinBoo();
        majinBoo.naceEn( unaCoordenada );
        Freezer freezer = new Freezer();
        freezer.naceEn( otraCoordenada );

        Celda unaCelda = new Celda( unaCoordenada );
        unaCelda.colocarPersonaje( majinBoo );
        Celda otraCelda = new Celda(otraCoordenada);
        otraCelda.colocarPersonaje( freezer );

        Tablero mitablero = new Tablero( 10 );
        mitablero.colocarCeldaEnTablero( unaCelda );
        mitablero.colocarCeldaEnTablero( otraCelda );

        Coordenada nuevaCoordenada = majinBoo.moverArriba();
        mitablero.moverPersonaje( majinBoo, nuevaCoordenada );
        assertTrue(majinBoo.estaUbicadoEn( unaCoordenada )); //vuelve a su posicion anterior
    }

    /*
    @Test
    public void ubicarEquiposEnTablero(){
        Tablero miTablero = new Tablero(10);

        miTablero.ubicarEquipos();
        Goku goku;
        Coordenada unaCoordenada = new Coordenada( 3,3 );

        miTablero.moverPersonaje( goku, unaCoordenada );

        assertEquals( 3,3 );

    }
    */
}

