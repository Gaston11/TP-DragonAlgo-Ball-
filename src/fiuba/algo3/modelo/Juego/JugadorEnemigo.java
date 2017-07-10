package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoNoEsPersonajeMaloException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by noe on 25/06/17.
 */
public class JugadorEnemigo extends Jugador{

    private Jugador rival;
    private List<PersonajeMalo> personajesEnemigos;

    public JugadorEnemigo(String nombre){
        this.nombre = nombre;
    }


    @Override
    public void asignarRival(Jugador jugadorRival) {
        this.rival = jugadorRival;
    }

    @Override
    public boolean ataqueBasico(Personaje personaje, Personaje enemigo) {

        return this.obtenerPersonajeEnemigo(personaje).ataqueBasico(this.rival.obtenerPersonajeZ(enemigo));

    }

    @Override
    public boolean ataqueEspecial(Personaje personaje, Personaje enemigo) {
        return this.obtenerPersonajeEnemigo(personaje).ataqueEspecial(this.rival.obtenerPersonajeZ(enemigo));
    }

    @Override
    public void transformar(Personaje personaje) {
        this.obtenerPersonajeEnemigo(personaje).transformar();
    }

    @Override
    public void mover(Personaje personaje, Coordenada coordenada) {
        if(personajesEnemigos.contains(personaje)){
            personaje.mover(coordenada);
        }else {
            throw new PersonajeInvalidoNoEsPersonajeMaloException();
        }
    }

    @Override
    public PersonajeBueno obtenerPersonajeZ(Personaje personaje) {
        return null;
    }

    @Override
    public Jugador getRival() {
        return this.rival;
    }

    @Override
    public void asignarEquipo(ArrayList<PersonajeBueno> personajesBuenos) {

    }

    @Override
    public void asignarEquipoRival(ArrayList<PersonajeMalo> personajeMalos) {
        personajesEnemigos = personajeMalos;
    }



    @Override
    public PersonajeMalo obtenerPersonajeEnemigo(Personaje personaje){
        int i = 0;
        if (!personajesEnemigos.contains(personaje)){
            throw new PersonajeInvalidoNoEsPersonajeMaloException();
        }

        while (!personajesEnemigos.get(i).equals(personaje)) {
            i++;
        }
        return personajesEnemigos.get(i);
    }

    @Override
    public boolean personajesMuertos() {
        Boolean estaMuerto = true;
        int i =0;
        while(estaMuerto && i<personajesEnemigos.size()){
            estaMuerto = ((Personaje)personajesEnemigos.get(i)).estaMuerto();
            i++;
        }

        return estaMuerto;
    }

}
