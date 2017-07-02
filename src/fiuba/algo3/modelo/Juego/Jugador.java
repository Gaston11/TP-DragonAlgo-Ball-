package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonajeException;
;import java.util.HashMap;

public abstract class Jugador {

    protected String nombre;

    public abstract Jugador getRival();

    public abstract void asignarEquipo();

    public abstract void asignarRival(Jugador jugador);

    public abstract void ataqueBasico(String clave, String enemigo);

    public abstract void ataqueEspecial(String personaje, String enemigo);

    public abstract Personaje seleccionar(String clave);

    public String getNombre(){
        return this.nombre;
    }

    public abstract PersonajeBueno seleccionarPersonajeBueno(String enemigo);

    public abstract PersonajeMalo seleccionarPersonajeMalo(String clave);

    public Coordenada mover(Personaje personaje, String direccion){

        switch (direccion){
            case "Arriba":
                return personaje.moverArriba();
            case "Abajo":
                return personaje.moverAbajo();
            case "Derecha":
                return personaje.moverADerecha();
            case "Izquierda":
                return personaje.moverAIzquierda();
            default: {
                throw new NoSePuedeMoverPersonajeException();
            }
        }
    }

    public abstract boolean personajesMuertos();


    //public abstract void inicializarPersonajesEnTablero();
}