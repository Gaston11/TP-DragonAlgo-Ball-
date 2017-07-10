package fiuba.algo3.modelo.Componentes;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;
import fiuba.algo3.modelo.Personajes.UbicableV2;

public abstract class Consumible implements UbicableV2 {

    protected int turnos;
    protected Coordenada coordenada;

    public abstract int aumentarVida();

    public void posicionarEn(Coordenada otraCoordenada){
        this.coordenada = otraCoordenada;
    }

    public abstract Estado agregarEstado(Estado estado,Personaje personaje);

    public abstract String getDireccion();
}