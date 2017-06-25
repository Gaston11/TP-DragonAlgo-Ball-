package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Personajes.*;

import java.util.HashMap;

public class JugadorZ extends Jugador{
    private String nombre;
    private HashMap<String,PersonajeBueno> equipo;
    private JugadorEnemigo rival;

    public JugadorZ(String nombreJugador) {
        this.nombre = nombreJugador;
        equipo = new HashMap<String , PersonajeBueno>();
        asignarEquipo();
    }

    public void asignarEquipo() {
        equipo.put("Goku",new Goku());
        equipo.put("Gohan",new Gohan());
        equipo.put("Piccolo", new Piccolo());
    }

    @Override
    public void asignarRival(JugadorZ jugador) {

    }

    public void asignarRival(JugadorEnemigo jugadorRival) {
        this.rival = jugadorRival;

    }

    @Override
    public void ataqueBasico(String clave, PersonajeBueno enemigo) {

    }

    public void ataqueBasico(String claveEquipo, PersonajeMalo enemigo){
        PersonajeBueno personaje = equipo.get(claveEquipo);
        //personaje.ataqueBasico(enemigo); codigo minimo
        enemigo.recibirDanio(20);
    }

    public Jugador getRival() {
        return this.rival;
    }


    public PersonajeBueno seleccionarPersonaje(String clave) {
        return equipo.get(clave);
    }


    public String getNombre(){
        return nombre;
    }
}
