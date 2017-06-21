package fiuba.algo3.modelo.Estados;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.VersorDireccion;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.PersonajeBueno;
import fiuba.algo3.modelo.Personajes.PersonajeMalo;

public interface Estado {

    public abstract void puedeMoverse(int pasos);

    public abstract void sumarVidaAbsorbida();

    public abstract void aumentarVida(Personaje cell);

    public abstract void ataqueBasico(PersonajeMalo enemigo, Personaje personaje);

    public abstract void ataqueBasico(PersonajeBueno enemigo, Personaje personaje);

    public abstract void ataqueEspecial(PersonajeMalo enemigo, Personaje personaje);

    public abstract void ataqueEspecial(PersonajeBueno enemigo, Personaje personaje);

    public abstract Estado transformarse(int condicion);

    public abstract Estado transformarse(Gohan gohan, int kiActual);

    public abstract Estado transformarse(Personaje personaje1, Personaje personaje2, int ki);

    public abstract int costoDeTransformacion();

    public abstract int moverPorEstado();

    public abstract Coordenada moverArriba(VersorDireccion unVersor);
}
