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
    public void crearUnVersorDireccionYObtenerUnaDireccionHaciaArriba(){
        Coordenada unaCoordenada = new Coordenada(2,1);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaArriba = unVersor.moverArriba();
        assertEquals(coordenadaHaciaArriba.getCoordenadaX(), 2);
        assertEquals(coordenadaHaciaArriba.getCoordenadaY(), 2);

    }

    @Test
    public void crearUnVersorDireccionYObtenerUnaDireccionHaciaAbajo(){
        Coordenada unaCoordenada = new Coordenada(2,1);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverAbajo();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 2);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 0);

    }

    @Test
    public void crearUnVersorDireccionYObtenerUnaDireccionHaciaIzquierda(){
        Coordenada unaCoordenada = new Coordenada(2,1);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverAIzquierda();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 1);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 1);

    }

    @Test
    public void crearUnVersorDireccionYObtenerUnaDireccionHaciaDerecha(){
        Coordenada unaCoordenada = new Coordenada(2,1);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverADerecha();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 3);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 1);

    }

    @Test
    public void crearUnVersorDireccionYObtenerUnaDireccionHaciaSuperiorIzquierda() {
        Coordenada unaCoordenada = new Coordenada(2, 1);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverASuperiorIzquierda();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 1);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 2);

    }

    @Test
    public void crearUnVersorDireccionYObtenerUnaDireccionHaciaSuperiorDerecha() {
        Coordenada unaCoordenada = new Coordenada(2, 1);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverASuperiorDerecha();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 3);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 2);

    }

    @Test
    public void crearUnVersorDireccionYObtenerUnaDireccionHaciaInferiorIzquierda() {
        Coordenada unaCoordenada = new Coordenada(2, 1);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverAInferiorIzquierda();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 1);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 0);

    }

    @Test
    public void crearUnVersorDireccionYObtenerUnaDireccionHaciaInferiorDerecha() {
        Coordenada unaCoordenada = new Coordenada(2, 1);
        VersorDireccion unVersor = new VersorDireccion(unaCoordenada);

        Coordenada coordenadaHaciaAbajo = unVersor.moverAInferiorDerecha();
        assertEquals(coordenadaHaciaAbajo.getCoordenadaX(), 3);
        assertEquals(coordenadaHaciaAbajo.getCoordenadaY(), 0);

    }

}
