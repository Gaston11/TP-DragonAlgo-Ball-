package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Tablero;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.JugadorYaRealizoAtaqueException;
import fiuba.algo3.modelo.excepciones.JugadorYaRealizoMovimientoException;
import fiuba.algo3.modelo.excepciones.TenemosUnGanadorException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Juego {

    private Tablero tablero;
    private Jugador jugadorActual;
    private ArrayList<PersonajeBueno> personajesZ;
    private ArrayList<PersonajeMalo> personajesEnemigos;
    private Jugador jugadorGanador;
    private boolean yaMovio;
    private boolean yaAtaco;


    public Juego(String jZ, String jEnemigo) {
        tablero = new Tablero(10);
        personajesZ = new ArrayList<PersonajeBueno>();
        personajesEnemigos = new ArrayList<PersonajeMalo>();
        this.crearPersonajes();
        this.crearJugadorActual(jZ, jEnemigo);
    }

    private void crearPersonajes() {
        ArrayList<Personaje> personajesBuenos = new ArrayList<Personaje>();
        ArrayList<Personaje> personajesMalos = new ArrayList<Personaje>();
        Goku goku = new Goku();
        Gohan gohan = new Gohan();
        Piccolo piccolo = new Piccolo();
        personajesZ.add(goku);
        personajesZ.add(gohan);
        personajesZ.add(piccolo);

        Freezer freezer = new Freezer();
        MajinBoo majinBoo = new MajinBoo();
        Cell cell = new Cell();
        personajesEnemigos.add(freezer);
        personajesEnemigos.add(majinBoo);
        personajesEnemigos.add(cell);

        personajesBuenos.add(goku);
        personajesBuenos.add(gohan);
        personajesBuenos.add(piccolo);

        personajesMalos.add(freezer);
        personajesMalos.add(majinBoo);
        personajesMalos.add(cell);

        tablero.ubicarEquipos(personajesBuenos, personajesMalos);
    }

    private void crearJugadorActual(String jZ, String jEnemigo) {
        Jugador jugadorZ = new JugadorZ(jZ);
        Jugador jugadorEnemigo = new JugadorEnemigo(jEnemigo);
        jugadorZ.asignarRival(jugadorEnemigo);
        jugadorEnemigo.asignarRival(jugadorZ);
        jugadorZ.asignarEquipo(personajesZ);
        jugadorZ.asignarEquipoRival(personajesEnemigos);
        this.jugadorActual = jugadorZ; //Tendria que ser random
    }

    public void mover(Coordenada coordenadaIni, Coordenada coordenadaFin){
        if(yaMovio)
            throw new JugadorYaRealizoMovimientoException();

        Personaje personaje = tablero.obtenerPersonajeEn(coordenadaIni);
        jugadorActual.mover(personaje, coordenadaFin);
        yaMovio = tablero.mover(coordenadaIni, coordenadaFin);
        this.cambiarTurno();
    }

    public void atacar(Coordenada coordenadaAtaca, Coordenada coordenadaAtacado) {
        if(yaAtaco)
            throw new JugadorYaRealizoAtaqueException();
        Personaje personajeAtaca = tablero.obtenerPersonajeEn(coordenadaAtaca);
        Personaje personajeAtacado = tablero.obtenerPersonajeEn(coordenadaAtacado);
        yaAtaco = jugadorActual.ataqueBasico(personajeAtaca, personajeAtacado);
        this.cambiarTurno();
        //Borrar
        //this.finalizarTurnoJugadorActual();
    }

    public void finalizarTurnoJugadorActual(){
        yaAtaco = true;
        yaMovio = true;
        cambiarTurno();
    }

    public void atacarEspecial(Coordenada coordenadaAtaca, Coordenada coordenadaAtacado){
        if(yaAtaco)
            throw new JugadorYaRealizoAtaqueException();
        Personaje personajeAtaca = tablero.obtenerPersonajeEn(coordenadaAtaca);
        Personaje personajeAtacado = tablero.obtenerPersonajeEn(coordenadaAtacado);
        yaAtaco = jugadorActual.ataqueEspecial(personajeAtaca, personajeAtacado);
        this.cambiarTurno();
        //Borrar
        //this.finalizarTurnoJugadorActual();
    }
    public Jugador getJugadorActual() {
        return jugadorActual;
    }

    private void cambiarTurno() {
        if(yaMovio && yaAtaco) {
            if (!jugadorActual.personajesMuertos()) {
                jugadorActual = jugadorActual.getRival();
                jugadorActual.nuevoTurno();
                yaAtaco = false;
                yaMovio = false;
            } else {
                jugadorGanador = jugadorActual.getRival();
                throw new TenemosUnGanadorException();
            }
        }
    }

    public String obtenerGanador(){
        return jugadorGanador.getNombre();
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void transformar(Coordenada cGoku) {
        Personaje personaje = tablero.obtenerPersonajeEn(cGoku);
        jugadorActual.transformar(personaje);
    }

}