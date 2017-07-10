package fiuba.algo3.eventos;

import fiuba.algo3.modelo.Componentes.Celda;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Juego.Juego;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.vista.Casillero1;
import fiuba.algo3.vista.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;

/**
 * Created by noe on 08/07/17.
 */
public class BotonAtaqueBasicoEventHandler implements EventHandler<ActionEvent> {

    private Juego juego;
    private Personaje atacante = null;
    private Coordenada coordAtacante;
    private Personaje atacado = null;
    private Coordenada coordAtacado;

    public BotonAtaqueBasicoEventHandler(Juego juego){
        this.juego = juego;
    }

    public void setUbicable(Casillero1 casillero) {
        Coordenada coordenada = new Coordenada(casillero.getFila(), casillero.getColumna());
        if (juego.getTablero().celdaOcupadaConPersonaje(coordenada)) {
            if (atacante == null && atacado == null) {
                coordAtacante = coordenada;
                atacante = juego.getTablero().obtenerPersonajeEn(coordenada);
            } else if (atacante != null && atacado == null) {
                coordAtacado = coordenada;
                atacado = juego.getTablero().obtenerPersonajeEn(coordenada);
            } else {
                this.inicializarValores();
                coordAtacante = coordenada;
                atacante = juego.getTablero().obtenerPersonajeEn(coordenada);
            }
        } else {
            this.inicializarValores();
        }
    }

    @Override
    public void handle(ActionEvent event) {

        if(atacado == null || atacante == null){
            this.alertaNoSeleccionoNingunPersonaje();
        }

        try {
            juego.atacar(coordAtacante,coordAtacado);
            //juego.getJugadorActual().ataqueBasico(atacante,atacado);
            Controlador.getControlador().actualizar();
            }catch (PersonajeInvalidoNoEsPersonajeMaloException e){
                this.alertaPersonajeNoEsEnemigo();
                this.inicializarValores();
            }catch (PersonajeInvalidoNoEsPersonajeBuenoException e){
                this.alertaPersonajeNoEsZ();
                this.inicializarValores();
            }catch (NoSePuedeCalcularLaDistanciaException e){
                this.alertaPersonajeAtacadoNoSePuedeCalcularDistancia();
                this.inicializarValores();
            }catch (NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException e){
                this.alertaPersonajeAtacadoNoSeEncuentraDentroDeDistanciaDeAtaque();
                this.inicializarValores();
            }catch (NoSeleccionoNingunPersonajeException e) {
                this.alertaNoSeleccionoNingunPersonaje();
                this.inicializarValores();
            }




        Controlador.getControlador().inicializarBotones();
        this.inicializarValores();

    }

    private void alertaPersonajeAtacadoNoSeEncuentraDentroDeDistanciaDeAtaque() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No se encuentra dentro de la distancia de ataque.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaPersonajeAtacadoNoSePuedeCalcularDistancia() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" Modo de ataque en lineas rectas.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaPersonajeNoEsZ() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" No pertenece a equipo Z.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void inicializarValores() {
        coordAtacado = null;
        coordAtacante = null;
        atacado = null;
        atacante = null;
    }

    private void alertaPersonajeNoEsEnemigo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" No pertenece a equipo enemigo.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    private void alertaNoSeleccionoNingunPersonaje() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" No selecciono ningun personaje.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

}
