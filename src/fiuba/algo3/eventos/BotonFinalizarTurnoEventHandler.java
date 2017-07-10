package fiuba.algo3.eventos;

import fiuba.algo3.modelo.Juego.Juego;
import fiuba.algo3.vista.Controlador;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.event.ActionEvent;
import java.beans.EventHandler;

/**
 * Created by Nico on 10/7/2017.
 */
public class BotonFinalizarTurnoEventHandler implements javafx.event.EventHandler<javafx.event.ActionEvent> {

    private final Juego juego;

    public BotonFinalizarTurnoEventHandler(Juego juego){
        this.juego = juego;
    }

    @Override
    public void handle(javafx.event.ActionEvent event) {
        juego.finalizarTurnoJugadorActual();
        Controlador.getControlador().actualizar();
        Controlador.getControlador().inicializarBotones();
    }
}
