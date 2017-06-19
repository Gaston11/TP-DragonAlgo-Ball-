package fiuba.algo3.modelo;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by gaston on 18/06/17.
 */
public class VersorDireccionTest {

    	@Test
    public void test01CrearUnVersorDireccionYObtenerUnaDireccionHaciaArriba(){
        Coordenada unaCoordenada = new Coordenada(1,2);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaArriba = unVersor.moverArriba();
        assertEquals(coordenadaHaciaArriba.getCoordenadaX(), 0);
        assertEquals(coordenadaHaciaArriba.getCoordenadaY(), 2);

    }

    @Test
    public void test02CrearUnVersorDireccionYObtenerUnaDireccionHaciaAbajo(){
        Coordenada unaCoordenada = new Coordenada(1,2);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverAbajo();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 2);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 2);

    }

    @Test
    public void test03CrearUnVersorDireccionYObtenerUnaDireccionHaciaIzquierda(){
        Coordenada unaCoordenada = new Coordenada(1,2);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverAIzquierda();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 1);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 1);

    }

    @Test
    public void test04CrearUnVersorDireccionYObtenerUnaDireccionHaciaDerecha(){
        Coordenada unaCoordenada = new Coordenada(1,2);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverADerecha();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 1);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 3);

    }

    @Test
    public void test05CrearUnVersorDireccionYObtenerUnaDireccionHaciaSuperiorIzquierda() {
        Coordenada unaCoordenada = new Coordenada(1, 2);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverASuperiorIzquierda();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 0);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 1);

    }

    @Test
    public void test06CrearUnVersorDireccionYObtenerUnaDireccionHaciaSuperiorDerecha() {
        Coordenada unaCoordenada = new Coordenada(1, 2);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverASuperiorDerecha();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 0);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 3);

    }

    @Test
    public void test07CrearUnVersorDireccionYObtenerUnaDireccionHaciaInferiorIzquierda() {
        Coordenada unaCoordenada = new Coordenada(1, 2);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverAInferiorIzquierda();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 2);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 1);

    }

    @Test
    public void test08CrearUnVersorDireccionYObtenerUnaDireccionHaciaInferiorDerecha() {
        Coordenada unaCoordenada = new Coordenada(1, 2);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverAInferiorDerecha();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 2);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 3);

    }

}
