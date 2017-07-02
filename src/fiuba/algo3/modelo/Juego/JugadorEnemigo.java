package fiuba.algo3.modelo.Juego;

import fiuba.algo3.modelo.Personajes.*;
import fiuba.algo3.modelo.excepciones.FuegoAmigoException;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoException;

import java.util.HashMap;

/**
 * Created by noe on 25/06/17.
 */
public class JugadorEnemigo extends Jugador{

    private MajinBoo majinBoo;
    private Cell cell;
    private Freezer freezer;
    private Jugador rival;

    public JugadorEnemigo(String nombre){
        this.nombre = nombre;
        asignarEquipo();

    }

    @Override
    public void asignarEquipo() {
        this.majinBoo = new MajinBoo();
        this.cell = new Cell();
        this.freezer = new Freezer();
    }

    @Override
    public void asignarRival(Jugador jugadorRival) {
        this.rival = jugadorRival;
    }

    @Override
    public void ataqueBasico(String claveEquipo, String enemigo) {

        if (this.perteneceAEquipo(claveEquipo)) {
            this.seleccionar(claveEquipo).ataqueBasico(this.rival.seleccionarPersonajeBueno(enemigo));
        }else {
            throw new PersonajeInvalidoException();
        }
    }

    @Override
    public void ataqueEspecial(String personaje, String enemigo) {
        PersonajeBueno enemigoBueno = this.rival.seleccionarPersonajeBueno(enemigo);
        if (this.perteneceAEquipo(personaje)) {
            switch (personaje) {
                case "Freezer":
                    freezer.rayoMortal(enemigoBueno);
                case "MajinBoo":
                    majinBoo.convertirEnChocolate(enemigoBueno);
                case "Cell":
                    cell.absorber(enemigoBueno);
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
            case "MajinBoo":
                return this.majinBoo;
            case "Cell":
                return this.cell;
            case "Freezer":
                return this.freezer;
            default: {
                throw new PersonajeInvalidoException();
            }
        }

    }

    @Override
    public PersonajeMalo seleccionarPersonajeMalo(String clave) {

        switch (clave) {
            case "MajinBoo":
                return this.majinBoo;
            case "Cell":
                return this.cell;
            case "Freezer":
                return this.freezer;
            default: {
                throw new FuegoAmigoException();
            }
        }

    }

    @Override
    public void transformar(String personaje) {
        if(this.perteneceAEquipo(personaje)){
            switch (personaje){
                case "Freezer":
                    freezer.transformarse();
                    break;
                case "Cell":
                    cell.transformarse();
                    break;
                case "MajinBoo":
                    majinBoo.transformarse();
                    break;
            }
        }else {
            throw new PersonajeInvalidoException();
        }
    }

    @Override
    protected boolean perteneceAEquipo(String personaje) {
        return (personaje == "Cell" || personaje == "MajinBoo" || personaje == "Freezer");
    }

    @Override
    public boolean personajesMuertos() {
        return (this.freezer.estaMuerto() && this.cell.estaMuerto() && this.majinBoo.estaMuerto());
    }

    @Override
    public PersonajeBueno seleccionarPersonajeBueno(String clave){
        throw new PersonajeInvalidoException();
    }

}
