package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Componentes.Coordenada;

public interface PersonajeBueno {

    int calcularDistanciaDesde(Coordenada otraCoordenada);

    void ataqueBasico(PersonajeMalo unPersonaje);

    void ataqueBasico(PersonajeBueno unPersonaje);

    boolean poseeMayorPoderPelea(int poderPelea);

    void recibirDanio(int cantidad);

    void convertimeEnChocolate();

    int getVida();
}