package fiuba.algo3.modelo.EstadosCell;

import fiuba.algo3.modelo.Estados.Estado;
import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.excepciones.NoSePuedeMoverPersonaje;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonaje;

public class EstadoNormal implements Estado {

    private int poderPelea;
    private int distanciaAtaque;
    private int velocidad;
    private int vidaAbsorbida;

    public EstadoNormal() {
        poderPelea = 20;
        distanciaAtaque = 3;
        velocidad = 2;
        vidaAbsorbida = 4;
    }

    @Override
    public void puedeMoverse(int pasos) {
        if (velocidad < pasos) {
            throw new NoSePuedeMoverPersonaje();
        }
    }

    @Override
    public Estado transformarse(int vidaActual) {
        if (vidaAbsorbida > vidaActual) {
            throw new NoSePuedeTransformarPersonaje();
        }
        return new EstadoSemiPerfecto();
    }

    @Override
    public int costoDeTransformacion() {

        return 0;
    }

    @Override
    public Estado transformarse(Gohan gohan, int ki){

        throw new NoSePuedeTransformarPersonaje();
    }
}