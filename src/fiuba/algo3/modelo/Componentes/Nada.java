package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Personaje;

public class Nada extends Consumible {

    @Override
    public int aumentarVida() {
        return 0;
    }

    @Override
    public Estado agregarEstado(Estado estado, Personaje personaje) {
        return estado;
    }

    @Override
    public String getDireccion() {
        return "";
    }

    @Override
    public String getNombre() {
        return "Nada";
    }

    @Override
    public boolean esUnPersonaje() {
        return false;
    }

    @Override
    public Coordenada getCoordenada() {
        return null;
    }
}