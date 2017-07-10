package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Personaje;

public class Semilla extends Consumible {

    private int vida;

    public Semilla(){
        turnos = 0;
        vida = 100;
    }

    @Override
    public int aumentarVida(){
        return vida;
    }

    @Override
    public Estado agregarEstado(Estado estado,Personaje personaje) {
        return estado;
    }


    @Override
    public String getNombre() {
        return "Semilla del ermitaño";
    }

    @Override
    public boolean esUnPersonaje() {
        return false;
    }

    @Override
    public Coordenada getCoordenada() {
        return this.coordenada;
    }

    @Override
    public String getDireccion(){
        return "file:src/fiuba/algo3/vista/imagenes/semilla2.png";
    }
}