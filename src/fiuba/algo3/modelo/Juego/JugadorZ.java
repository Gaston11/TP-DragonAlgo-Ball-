package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JugadorZ extends Jugador{

    private Goku goku;
    private Gohan gohan;
    private Piccolo piccolo;
    private Jugador rival;
    private List<Personaje> personajesZ;

    private Equipo equipo;

    public JugadorZ(String nombreJugador) {
        this.nombre = nombreJugador;
        this.asignarEquipo();
    }

    @Override
    public void asignarEquipo() {
        this.goku = new Goku();
        this.gohan = new Gohan();
        this.piccolo = new Piccolo();
        this.personajesZ = new ArrayList<>();
        this.personajesZ.add( goku );
        this.personajesZ.add( gohan );
        this.personajesZ.add(piccolo);
    }

    @Override
    public void asignarRival(Jugador jugador) {
        this.rival = jugador;
    }

    @Override
    public void ataqueBasico(String personaje, String enemigo) {
        if (this.perteneceAEquipo(personaje)) {
            this.seleccionar(personaje).ataqueBasico(this.rival.seleccionarPersonajeMalo(enemigo));
        }else {
            throw new PersonajeInvalidoException();
        }
    }

    @Override
    public void ataqueEspecial(String personaje, String enemigo) {
        PersonajeMalo enemigos = this.rival.seleccionarPersonajeMalo(enemigo);
        if (this.perteneceAEquipo(personaje)) {
            switch (personaje) {
                case "Goku":
                    goku.kamehameha(enemigos);
                case "Gohan":
                    gohan.masenko(enemigos);
                case "Piccolo":
                    piccolo.makankosappo(enemigos);
                default: {
                    throw new PersonajeInvalidoException();
                }
            }
        }
    }

    @Override
    public Jugador getRival() {
        return this.rival;
    }

    @Override
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

    @Override
    public PersonajeBueno seleccionarPersonajeBueno(String clave) {
        switch (clave) {
            case "Goku":
                return this.goku;
            case "Gohan":
                return this.gohan;
            case "Piccolo":
                return this.piccolo;
            default: {
                throw new FuegoAmigoException();
            }
        }
    }

    @Override
    public PersonajeMalo seleccionarPersonajeMalo(String clave){
        throw new PersonajeInvalidoException();
    }

    @Override
    public void transformar(String personaje) {
        if(this.perteneceAEquipo(personaje)){
            switch (personaje){
                case "Goku":
                    goku.transformarse();
                    break;
                case "Gohan":
                    gohan.transformarse(goku,piccolo);
                    break;
                case "Piccolo":
                    piccolo.transformarse(gohan);
                    break;

                    default:{

                    }
            }
        }else {
            throw new PersonajeInvalidoException();
        }
    }

    @Override
    protected boolean perteneceAEquipo(String personaje) {
        return (personaje == "Gohan" || personaje == "Goku" || personaje == "Piccolo");
    }

    @Override
    public boolean personajesMuertos() {
        return (this.piccolo.estaMuerto() && this.goku.estaMuerto() && this.gohan.estaMuerto());
    }

    @Override
    public List<Personaje> obtenerPersonajesDeJugador(){
        return this.personajesZ;
    }

}
