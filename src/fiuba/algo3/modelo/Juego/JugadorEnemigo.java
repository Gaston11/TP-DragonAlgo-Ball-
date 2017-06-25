package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Personajes.*;

import java.util.HashMap;

/**
 * Created by noe on 25/06/17.
 */
public class JugadorEnemigo extends Jugador{

    private String nombre;
    private HashMap<String, PersonajeMalo> equipo;
    private JugadorZ rival;

    public JugadorEnemigo(String nombre){
        this.nombre = nombre;
        equipo = new HashMap<String,PersonajeMalo>();
        asignarEquipo();

    }

    public void asignarEquipo() {
        equipo.put("Freezer",new Freezer());
        equipo.put("Cell",new Cell());
        equipo.put("MajinBoo", new MajinBoo());
    }

    public void asignarRival(JugadorZ jugadorRival) {
        this.rival = jugadorRival;
    }

    @Override
    public void asignarRival(JugadorEnemigo jugador) {

    }

    public void ataqueBasico(String claveEquipo, PersonajeBueno enemigo){
        PersonajeMalo personaje = equipo.get(claveEquipo);
        //personaje.ataqueBasico(enemigo); codigo minimo
        enemigo.recibirDanio(20);
    }

    @Override
    public void ataqueBasico(String clave, PersonajeMalo enemigo) {

    }


    public Jugador getRival() {
        return this.rival;
    }

    public PersonajeMalo seleccionarPersonaje(String clave) {
        return equipo.get(clave);
    }

    public String getNombre(){
        return nombre;
    }
}
