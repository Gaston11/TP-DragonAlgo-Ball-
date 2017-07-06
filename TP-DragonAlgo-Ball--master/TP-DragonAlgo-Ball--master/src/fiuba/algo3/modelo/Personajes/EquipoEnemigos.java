package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Personajes.Cell;
import fiuba.algo3.modelo.Personajes.Freezer;
import fiuba.algo3.modelo.Personajes.MajinBoo;

public class EquipoEnemigos extends Equipo {
    public EquipoEnemigos(){
        super.inicializarLista();
        super.agregarPersonaje(new Cell());
        super.agregarPersonaje(new Freezer());
        super.agregarPersonaje(new MajinBoo());
    }

}
