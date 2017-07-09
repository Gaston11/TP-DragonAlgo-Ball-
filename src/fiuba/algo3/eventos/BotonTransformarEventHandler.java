package fiuba.algo3.eventos;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Componentes.Ubicable;
import fiuba.algo3.modelo.Juego.Juego;
import fiuba.algo3.modelo.excepciones.NoSePuedeTransformarPersonajeException;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoNoEsPersonajeBuenoException;
import fiuba.algo3.modelo.excepciones.PersonajeInvalidoNoEsPersonajeMaloException;
import fiuba.algo3.vista.Campo;
import fiuba.algo3.vista.Casillero1;
import fiuba.algo3.vista.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 * Created by noe on 08/07/17.
 */
public class BotonTransformarEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Coordenada coordenada = null;

    public BotonTransformarEventHandler(Juego juego){
        this.juego = juego;
    }

    public void setUbicable(Casillero1 casillero) {

        if (casillero.getUbicable().esUnPersonaje()){
            coordenada = new Coordenada(casillero.getFila(),casillero.getColumna());
        }

    }

    @Override
    public void handle(ActionEvent event) {

        if(coordenada == null){
            this.alertaNoSeleccionoNingunPersonaje();
        }

        if (coordenada != null){
            try {
                juego.transformar(coordenada);
            }catch (PersonajeInvalidoNoEsPersonajeBuenoException e){
                this.alertaNoPerteneceEquipoZ();
                this.inicializarValores();
            } catch (PersonajeInvalidoNoEsPersonajeMaloException e){
                this.alertaNoPerteneceEquipoEnemigo();
                this.inicializarValores();
            }catch (NoSePuedeTransformarPersonajeException e){
                this.alertaNoSePuedeTransformar();
                this.inicializarValores();
            }
        }
        Controlador.getControlador().actualizar();
        Controlador.getControlador().inicializarBotones();
        this.inicializarValores();
    }

    private void alertaNoSePuedeTransformar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No se puede transformar.");
        String mensaje = "Intente nuevamente";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaNoPerteneceEquipoEnemigo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No pertenece a equipo enemigo.");
        String mensaje = "Intente nuevamente";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaNoPerteneceEquipoZ() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No pertenece a equipo Z");
        String mensaje = "Intente nuevamente";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaNoSeleccionoNingunPersonaje() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No selecciono ningun personaje.");
        String mensaje = "Intente nuevamente";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void inicializarValores() {

        this.coordenada = null;
    }


}
