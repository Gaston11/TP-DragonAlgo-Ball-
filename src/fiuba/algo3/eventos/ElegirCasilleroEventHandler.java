package fiuba.algo3.eventos;

import fiuba.algo3.modelo.Personajes.UbicableV2;
import fiuba.algo3.vista.Casillero1;
import fiuba.algo3.vista.ContenedorPersonaje;
import fiuba.algo3.vista.Controlador;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

/**
 * Created by noe on 08/07/17.
 */
public class ElegirCasilleroEventHandler implements EventHandler<MouseEvent> {

    private Casillero1 casillero;

    public ElegirCasilleroEventHandler(Casillero1 casillero){
        this.casillero = casillero;

    }

    @Override
    public void handle(MouseEvent arg0) {
        Controlador.getControlador().setUbicable(casillero);
    }
}
