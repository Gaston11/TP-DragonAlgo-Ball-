package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;

public interface PersonajeMalo {

    int calcularDistanciaDesde(Coordenada otraCoordenada);

    boolean poseeMayorPoderPelea(int poderPelea);

    boolean ataqueBasico(PersonajeMalo unPersonaje);

    boolean ataqueBasico(PersonajeBueno unPersonaje);

    boolean ataqueEspecial(PersonajeBueno enemigo);

    void  transformar();

    void recibirDanio(int cantidad);

    int getVida();
}