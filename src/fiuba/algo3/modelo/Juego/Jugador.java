package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
;

public abstract class Jugador {

    public abstract void asignarEquipo();

    public abstract void asignarRival(JugadorZ jugador);

    public abstract void asignarRival(JugadorEnemigo jugador);

    public abstract void ataqueBasico(String clave, PersonajeBueno enemigo);

    public abstract void ataqueBasico(String clave, PersonajeMalo enemigo);

    public abstract String getNombre();

    public abstract Jugador getRival();


    //public abstract void inicializarPersonajesEnTablero();
}