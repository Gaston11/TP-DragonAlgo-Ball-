package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoNoEsPersonajeBuenoException;

import java.util.ArrayList;
import java.util.List;

public class JugadorZ extends Jugador{

    private List<PersonajeBueno> personajesZ;
    private Jugador rival;

    public JugadorZ(String nombreJugador) {
        this.nombre = nombreJugador;
    }

    @Override
    public void asignarEquipo(ArrayList<PersonajeBueno> personajeBuenos) {

        this.personajesZ = personajeBuenos;
    }

    @Override
    public void asignarEquipoRival(ArrayList<PersonajeMalo> personajeMalos) {
        rival.asignarEquipoRival(personajeMalos);
    }

    @Override
    public void asignarRival(Jugador jugador) {
        this.rival = jugador;
    }

    @Override
    public void ataqueBasico(Personaje personaje, Personaje enemigo) {
        this.obtenerPersonajeZ(personaje).ataqueBasico(this.rival.obtenerPersonajeEnemigo(enemigo));
    }

    @Override
    public void ataqueEspecial(Personaje personaje, Personaje enemigo) {
        this.obtenerPersonajeZ(personaje).ataqueEspecial(this.rival.obtenerPersonajeEnemigo(enemigo));
    }

    @Override
    public void transformar(Personaje personaje){

        Personaje goku = (Personaje)personajesZ.get(0);
        Personaje gohan = (Personaje) personajesZ.get(1);
        Personaje piccolo = (Personaje) personajesZ.get(2);
        this.obtenerPersonajeZ(personaje).transformar(goku,gohan,piccolo);

    }

    @Override
    public Jugador getRival() {
        return this.rival;
    }

    @Override
    public PersonajeBueno obtenerPersonajeZ(Personaje personaje) {
        int i=0;
        if (!personajesZ.contains(personaje)){
            throw new PersonajeInvalidoNoEsPersonajeBuenoException();
        }

        while (!personajesZ.get(i).equals(personaje)){
            i++;
        }
        return personajesZ.get(i);
    }

    @Override
    public PersonajeMalo obtenerPersonajeEnemigo(Personaje personaje) {
        return null;
    }

    @Override
    public boolean personajesMuertos() {
        Boolean estaMuerto = true;
        int i =0;
        while(estaMuerto && i<personajesZ.size()){
            estaMuerto = ((Personaje)personajesZ.get(i)).estaMuerto();
            i++;
        }

        return estaMuerto;
    }

    @Override
    public void mover(Personaje personaje, Coordenada coordenada){
        if(personajesZ.contains(personaje)){
            personaje.mover(coordenada);
        }else {
            throw new PersonajeInvalidoNoEsPersonajeBuenoException();
        }

    }
}
