package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.excepciones.NoSePuedeCalcularLaDistanciaException;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class CoordenadaTest {
	
	@Test
	public void crearUnaCoordenada(){
		Coordenada unaCoordenada = new Coordenada(2,3);
		
		assertEquals(unaCoordenada.getCoordenadaX(), 2);
		assertEquals(unaCoordenada.getCoordenadaY(), 3);
	}

	@Test
	public void compararDosCoordenadas(){
		Coordenada unaCoordenada = new Coordenada(0, 0);
		Coordenada otraCoordenada = new Coordenada(1,0);
		Coordenada mismaCoordenada = new Coordenada(0,0);

		assertFalse(unaCoordenada.esLaMismaCoordenada(otraCoordenada));
		assertTrue(unaCoordenada.esLaMismaCoordenada(mismaCoordenada));
	}

	@Test
	public void calcularDistanciaEstreDosCoordenadasUbicadasVerticalmente(){
		Coordenada unaCoordenada = new Coordenada(0, 0);
		Coordenada otraCoordenada = new Coordenada(1,0);

		assertEquals(1, unaCoordenada.obtenerDistancia(otraCoordenada));
	}

	@Test
	public void calcularDistanciaEntreDosCoordenadasUbicadasHorizontalmente(){
		Coordenada unaCoordenada = new Coordenada(0,0);
		Coordenada otraCoordenada = new Coordenada(0,2);

		assertEquals(2, unaCoordenada.obtenerDistancia(otraCoordenada));
	}

	@Test
	public void calcularDistanciaEntreDosCoordenadasDiagonalmente(){
		Coordenada unaCoordenada = new Coordenada(0,2);
		Coordenada otraCoordenada = new Coordenada(1,3);

		assertEquals(1, unaCoordenada.obtenerDistancia(otraCoordenada));

	}

    @Rule
    public ExpectedException thrown = ExpectedException.none();

	@Test
	public void nosePuedeCalcularDistanciasEntreDosCoordenadasPorNoEstarEnUnaUbicacionValida(){
		Coordenada unaCoordenada = new Coordenada(0,2);
		Coordenada otraCoordenada = new Coordenada(1,0);

		thrown.expect(NoSePuedeCalcularLaDistanciaException.class);
		unaCoordenada.obtenerDistancia(otraCoordenada);


	}

}
