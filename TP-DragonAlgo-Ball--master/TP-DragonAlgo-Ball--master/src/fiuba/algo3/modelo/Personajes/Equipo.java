package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Personaje;

import java.util.ArrayList;
import java.util.List;

public abstract class Equipo {
    protected List<Personaje> pensonajes;

    protected void inicializarLista(){
        this.pensonajes = new ArrayList<>();
    }

    protected void agregarPersonaje(Personaje personaje){
        this.pensonajes.add(personaje);
    }

    public Personaje obtenerPersonaje(int indice){
        return this.pensonajes.get(indice);
    }
}
