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
            Alertas.alertaNoSeleccionoNingunPersonaje();
        }

        try {
            juego.atacar(coordAtacante,coordAtacado);
            Controlador.getControlador().actualizar();
            }catch (PersonajeInvalidoNoEsPersonajeMaloException e){
                Alertas.alertaPersonajeNoEsEnemigo();
                this.inicializarValores();
            }catch (PersonajeInvalidoNoEsPersonajeBuenoException e){
                Alertas.alertaPersonajeNoEsZ();
                this.inicializarValores();
            }catch (NoSePuedeCalcularLaDistanciaException e){
                Alertas.alertaPersonajeAtacadoNoSePuedeCalcularDistancia();
                this.inicializarValores();
            }catch (NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException e){
                Alertas.alertaPersonajeAtacadoNoSeEncuentraDentroDeDistanciaDeAtaque();
                this.inicializarValores();
            }catch (NoSeleccionoNingunPersonajeException e) {
                Alertas.alertaNoSeleccionoNingunPersonaje();
                this.inicializarValores();
            }catch (PersonajeEnEstadoChocolateExcepcion e) {
                Alertas.alertaPersonajeEnEstadoChocolate();
                this.inicializarValores();
            }catch (PersonajeEstaMuertoException e){
                juego.getTablero().liberarCeldaEnTablero(coordAtacado);
                Controlador.getControlador().actualizar();
            } catch (TenemosUnGanadorException e){
                Alertas.mostrarGanador(juego.obtenerGanador());
            }catch (JugadorYaRealizoAtaqueException ex) {
                Alertas.alertaGenerica("Ya realizó un ataque este turno. O bien mueva un personaje " +
                        "o seleccione Finalizar Turno");
                this.inicializarValores();
            }

        Controlador.getControlador().inicializarBotones();
        this.inicializarValores();

    }

    public void inicializarValores() {
        coordAtacado = null;
        coordAtacante = null;
        atacado = null;
        atacante = null;
    }

}
