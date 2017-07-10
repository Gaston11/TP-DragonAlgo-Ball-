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
    private Casillero1 casillero;
    private Alertas alerta = new Alertas();

    public BotonTransformarEventHandler(Juego juego){
        this.juego = juego;
    }

    public void setUbicable(Casillero1 casillero) {

        if (casillero.getUbicable().esUnPersonaje()){
            this.coordenada = new Coordenada(casillero.getFila(),casillero.getColumna());
            this.casillero = casillero;
        }

    }

    @Override
    public void handle(ActionEvent event) {

        if(coordenada == null){
            alerta.alertaNoSeleccionoNingunPersonaje();
        }

        if (coordenada != null){
            try {
                juego.transformar(coordenada);
                casillero.dibujarPersonajeTransformado(casillero.getUbicable());
            }catch (PersonajeInvalidoNoEsPersonajeBuenoException e){
                alerta.alertaNoPerteneceEquipoZ();
                this.inicializarValores();
            } catch (PersonajeInvalidoNoEsPersonajeMaloException e){
                alerta.alertaNoPerteneceEquipoEnemigo();
                this.inicializarValores();
            }catch (NoSePuedeTransformarPersonajeException e){
                alerta.alertaNoSePuedeTransformar();
                this.inicializarValores();
            }
        }
        Controlador.getControlador().actualizar();
        Controlador.getControlador().inicializarBotones();
        this.inicializarValores();
    }

    public void inicializarValores() {

        this.coordenada = null;
    }


}
