package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonajeException;
;import java.util.ArrayList;

public abstract class Jugador {

    protected String nombre;

    public abstract Jugador getRival();

    public abstract void asignarEquipo(ArrayList<PersonajeBueno> personajesBuenos);

    public abstract void asignarEquipoRival(ArrayList<PersonajeMalo> personajeMalos);

    public abstract void asignarRival(Jugador jugador);

    public abstract boolean ataqueBasico(Personaje personaje, Personaje enemigo);

    public abstract boolean ataqueEspecial(Personaje personaje, Personaje enemigo);

    public abstract void transformar(Personaje personaje);

    public abstract void mover(Personaje personaje, Coordenada coordenada);

    public String getNombre(){
        return this.nombre;
    }

    public abstract PersonajeBueno obtenerPersonajeZ(Personaje enemigo);

    public abstract PersonajeMalo obtenerPersonajeEnemigo(Personaje personaje);

    public abstract boolean personajesMuertos();

}