package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Gohan;
import fiuba.algo3.modelo.Personajes.Goku;
import fiuba.algo3.modelo.Personajes.Piccolo;

public class EquipoGuerrerosZ extends Equipo {
    public EquipoGuerrerosZ(){
        super.inicializarLista();
        super.agregarPersonaje(new Goku());
        super.agregarPersonaje(new Gohan());
        super.agregarPersonaje(new Piccolo());
    }

}
