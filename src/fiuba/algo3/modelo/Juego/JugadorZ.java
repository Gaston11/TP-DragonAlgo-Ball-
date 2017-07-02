package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoException;

import java.util.HashMap;

public class JugadorZ extends Jugador{

    private Goku goku;
    private Gohan gohan;
    private Piccolo piccolo;
    private Jugador rival;

    public JugadorZ(String nombreJugador) {
        this.nombre = nombreJugador;
        this.asignarEquipo();
    }

    public void asignarEquipo() {
        this.goku = new Goku();
        this.gohan = new Gohan();
        this.piccolo = new Piccolo();
    }

    public void asignarRival(Jugador jugador) {
        this.rival = jugador;
    }

    public void ataqueBasico(String personaje, String enemigo) {
        this.seleccionar(personaje).ataqueBasico(this.rival.seleccionarPersonajeMalo(enemigo));
    }

    @Override
    public void ataqueEspecial(String personaje, String enemigo) {
        PersonajeMalo enemigos = this.rival.seleccionarPersonajeMalo(enemigo);
        switch (personaje){
            case "Goku":
                goku.kamehameha(enemigos);
            case "Gohan":
                gohan.masenko(enemigos);
            case "Piccolo":
                piccolo.makankosappo(enemigos);
                default:{
                    throw new PersonajeInvalidoException();
                }
        }
    }

    public Jugador getRival() {
        return this.rival;
    }

    public Personaje seleccionar(String clave){
        switch (clave){
            case "Goku":
                return this.goku;
            case "Gohan":
                return this.gohan;
            case "Piccolo":
                return this.piccolo;
            default: {
                throw new PersonajeInvalidoException();
            }
        }
    }

    public PersonajeBueno seleccionarPersonajeBueno(String clave) {
        switch (clave) {
            case "Goku":
                return this.goku;
            case "Gohan":
                return this.gohan;
            case "Piccolo":
                return this.piccolo;
            default: {
                throw new PersonajeInvalidoException();
            }
        }
    }

    public PersonajeMalo seleccionarPersonajeMalo(String clave){
        throw new PersonajeInvalidoException();
    }

    @Override
    public boolean personajesMuertos() {
        return (this.piccolo.estaMuerto() && this.goku.estaMuerto() && this.gohan.estaMuerto());
    }

}
