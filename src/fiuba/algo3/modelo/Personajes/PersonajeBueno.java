package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Componentes.Coordenada;

public interface PersonajeBueno {

    int calcularDistanciaDesde(Coordenada otraCoordenada);

    boolean ataqueBasico(PersonajeMalo unPersonaje);

    boolean ataqueBasico(PersonajeBueno unPersonaje);

    boolean ataqueEspecial(PersonajeMalo enemigo);

    void transformar(Personaje goku, Personaje gohan, Personaje piccolo);

    boolean poseeMayorPoderPelea(int poderPelea);

    void recibirDanio(int cantidad);

    void convertimeEnChocolate();

    int getVida();
}