package fiuba.algo3.eventos;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Juego.Juego;
import fiuba.algo3.modelo.Personajes.Ubicable;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoNoEsPersonajeBuenoException;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoNoEsPersonajeMaloException;
import fiuba.algo3.vista.Campo;
import fiuba.algo3.vista.Casillero1;
import fiuba.algo3.vista.Vista;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

import java.awt.*;

/**
 * Created by noe on 08/07/17.
 */
public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Campo campo;
    private Casillero1 casillero;
    private Ubicable personaje = null;
    private Coordenada coordenadaIni = null;
    private Coordenada coordenadaFin = null;

    public BotonMoverEventHandler(Juego juego, Campo tablero){

        this.campo = tablero;
        this.juego = juego;

    }

    public void setUbicable(Casillero1 casillero){
        Coordenada coordenada = new Coordenada(casillero.getFila(), casillero.getColumna());
        if(casillero.getUbicable().esUnPersonaje()){
            this.personaje = casillero.getUbicable();
            this.coordenadaIni = coordenada;
            this.casillero.borrarImagen();
        }else {
            this.coordenadaFin = coordenada;
            this.casillero = casillero;
        }
    }

    @Override
    public void handle(ActionEvent event) {

        if (this.coordenadaIni == null && this.coordenadaFin == null){
            this.alertaNoSeleccionoPersonaje();
        }
        if (this.coordenadaIni != null && this.coordenadaFin == null){
            this.alertaNoSeleccionoUnaUbicacion();
        }

        try {
            juego.mover(this.coordenadaIni,this.coordenadaFin);
            this.casillero.dibujarUbicable(this.personaje);
        }catch (PersonajeInvalidoNoEsPersonajeBuenoException e){

        }catch (PersonajeInvalidoNoEsPersonajeMaloException e){

        }catch (CeldaOcupadaException e){
            this.mensajeCeldaOcupada();
        }
    }

    private void alertaNoSeleccionoUnaUbicacion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No selecciono ubicacion");
        String mensaje = "Tiene que indicar donde desea mover el personaje."
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaNoSeleccionoPersonaje() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No selecciono ningun personaje");
        String mensaje = "Intente nuevamente";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void mensajeCeldaOcupada() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No no puede mover personaje a ese casillero");
        String mensaje = "Casillero ocupado por otro personaje."
                + " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();

    }
}
