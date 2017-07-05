package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;

public interface PersonajeMalo {

    int calcularDistanciaDesde(Coordenada otraCoordenada);

    boolean poseeMayorPoderPelea(int poderPelea);

    void ataqueBasico(PersonajeMalo unPersonaje);

    void ataqueBasico(PersonajeBueno unPersonaje);

    void ataqueEspecial(PersonajeBueno enemigo);

    void  transformar();

    void recibirDanio(int cantidad);

    int getVida();
}