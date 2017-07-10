package fiuba.algo3.eventos;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Juego.Juego;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.Personajes.UbicableV2;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.vista.Campo;
import fiuba.algo3.vista.Casillero1;
import fiuba.algo3.vista.Controlador;
import fiuba.algo3.vista.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.paint.*;

import java.awt.*;
import java.awt.Color;

/**
 * Created by noe on 08/07/17.
 */
public class BotonMoverEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private ContenedorPrincipal contenedor;
    private Casillero1 casillero;
    private UbicableV2 personaje = null;
    private Coordenada coordenadaIni = null;
    private Coordenada coordenadaFin = null;
    private Alertas alerta = new Alertas();

    public BotonMoverEventHandler(Juego juego, ContenedorPrincipal contenedor){

        this.contenedor = contenedor;
        this.juego = juego;

    }

    public void setUbicable(Casillero1 casillero){
        Coordenada coordenada = new Coordenada(casillero.getFila(),casillero.getColumna());
        if(juego.getTablero().celdaOcupadaConPersonaje(new Celda(coordenada))){
            this.coordenadaIni = coordenada;
            this.personaje = juego.getTablero().obtenerPersonajeEn(coordenada);
            this.coordenadaFin = null;
            contenedor.escribirConsola("en Set ubicable CON personaje");
        }else {
            this.coordenadaFin = coordenada;
            this.casillero = casillero;
            contenedor.escribirConsola("en Set ubicable SIN personaje");
        }

    }

    @Override
    public void handle(ActionEvent event) {
        if (this.personaje == null){
            contenedor.escribirConsola("Se presionó Mover sin tener personaje seleccionado");
            this.alertaNoSeleccionoPersonaje();
        }
        if (this.personaje != null && this.coordenadaFin == null){
            contenedor.escribirConsola("Se presionó Mover sin tener casillero destino seleccionado");
            this.alertaNoSeleccionoUnaUbicacion();
        }

        if(this.personaje != null && this.coordenadaFin != null) {
            try {
                contenedor.escribirConsola("Intentando Mover");
                juego.mover(this.coordenadaIni, this.coordenadaFin);
                contenedor.escribirConsola("Mover Exitoso");
                Controlador.getControlador().actualizar();

            } catch (PersonajeInvalidoNoEsPersonajeBuenoException e) {
                this.alertaPersonajeNoPerteceASuEquipoZ();
                this.inicializarValores();
                contenedor.escribirConsola("PersonajeInvalidoNoEsPersonajeBuenoException", javafx.scene.paint.Color.RED);
            } catch (PersonajeInvalidoNoEsPersonajeMaloException e) {
                this.alertaPersonajeNoPerteceASuEquipoEnemigo();
                this.inicializarValores();
                contenedor.escribirConsola("PersonajeInvalidoNoEsPersonajeMaloException", javafx.scene.paint.Color.RED);;
            } catch (CeldaOcupadaException e) {
                this.mensajeCeldaOcupada();
                this.inicializarValores();
                contenedor.escribirConsola("CeldaOcupadaException", javafx.scene.paint.Color.RED);
            } catch (NoSePuedeMoverPersonajeException e){
                this.mensajeVelocidadMenorALaDistancia();
                this.inicializarValores();
                contenedor.escribirConsola("NoSePuedeMoverPersonajeException", javafx.scene.paint.Color.RED);
            } catch (Exception e) {
                this.inicializarValores();
                contenedor.escribirConsola("Excepción no manejada", javafx.scene.paint.Color.RED);
            }

        }

        this.inicializarValores();
        Controlador.getControlador().inicializarBotones();
    }

    public void inicializarValores() {
        this.personaje = null;
        this.coordenadaFin=null;
        this.coordenadaIni=null;
        this.casillero = null;
    }

    private void mensajeVelocidadMenorALaDistancia() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" Distancia De Movimiento No permitida.");
        String mensaje = "Tiene que elegir un casillero acorde a su  "
                + "velocidad de estado."
                +" Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaPersonajeNoPerteceASuEquipoEnemigo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("Personaje Invalido");
        String mensaje = "Tiene que elegir un personaje que  "
                + "sea un guerrero Enemigo."
                +" Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaPersonajeNoPerteceASuEquipoZ() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("Personaje Invalido");
        String mensaje = "Tiene que elegir un personaje que  "
                + "sea un guerrero Z."
                +" Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaNoSeleccionoUnaUbicacion() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No selecciono ubicacion");
        String mensaje = "Tiene que indicar donde desea mover el "
                + "personaje."
                +" Intente nuevamente.";
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
