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
            } catch (NoSePuedeMoverPersonajeException e) {
                this.mensajeVelocidadMenorALaDistancia();
                this.inicializarValores();
                contenedor.escribirConsola("NoSePuedeMoverPersonajeException", javafx.scene.paint.Color.RED);
<<<<<<< HEAD
            } catch (TenemosUnGanadorException e){
                alerta.mostrarGanador(juego.obtenerGanador());
                this.inicializarValores();
=======
            }catch (JugadorYaRealizoMovimientoException e){
                this.inicializarValores();
                contenedor.escribirConsola("Jugador ya realizó movimiento", javafx.scene.paint.Color.RED);
                Alertas.alertaGenerica("Ya realizó movimiento. O ejecute un ataque o seleccione Finalizar turno");
>>>>>>> 5c6b3b07ba698aaa415789bea46d207d05b8afb2
            } catch (Exception e) {
                this.inicializarValores();
                contenedor.escribirConsola("Excepción no manejada", javafx.scene.paint.Color.RED);
                Alertas.alertaGenerica("Movimiento inválido");
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
        String mensaje = "Tiene que elegir un casillero acorde a su  "
                + "velocidad de estado."
                +" Intente nuevamente.";
        Alertas.alertaGenerica(mensaje, " Distancia De Movimiento No permitida.");
    }

    private void alertaPersonajeNoPerteceASuEquipoEnemigo() {
        String mensaje = "Tiene que elegir un personaje que  "
                + "sea un guerrero Enemigo."
                +" Intente nuevamente.";
        Alertas.alertaGenerica(mensaje, "Personaje incorrecto");
    }

    private void alertaPersonajeNoPerteceASuEquipoZ() {
        String mensaje = "Tiene que elegir un personaje que  "
                + "sea un guerrero Z."
                +" Intente nuevamente.";
        Alertas.alertaGenerica(mensaje, "Personaje Incorrecto" );
    }

    private void alertaNoSeleccionoUnaUbicacion() {
        String mensaje = "Tiene que indicar donde desea mover el "
                + "personaje."
                +" Intente nuevamente.";
        Alertas.alertaGenerica(mensaje, "No seleccionó ubicación");
    }

    private void alertaNoSeleccionoPersonaje() {
        Alertas.alertaGenerica("Intente nuevamente", "No seleccionó ningún personaje");
    }

    private void mensajeCeldaOcupada() {
        String mensaje = "Casillero ocupado por otro personaje."
                + " Intente nuevamente.";
        Alertas.alertaGenerica(mensaje, "No puede mover personaje a ese casillero");
    }
}
