package fiuba.algo3.eventos;

import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Juego.Juego;
import fiuba.algo3.modelo.Personajes.Personaje;
import fiuba.algo3.modelo.excepciones.*;
import fiuba.algo3.vista.Casillero1;
import fiuba.algo3.vista.Controlador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 * Created by noe on 10/07/17.
 */
public class BotonAtaqueEspecialEventHandler implements EventHandler<ActionEvent>{

    private Juego juego;
    private Personaje atacante = null;
    private Personaje atacado = null;
    private Coordenada coordAtacante;
    private Coordenada coordAtacado;
    private Alertas alerta = new Alertas();

    public BotonAtaqueEspecialEventHandler(Juego juego){
        this.juego = juego;

    }

    public void setUbicable(Casillero1 casillero){
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

    private void inicializarValores() {
        atacado = null;
        atacante = null;
        coordAtacante = null;
        coordAtacado = null;
    }

    @Override
    public void handle(ActionEvent event) {

        if (atacante == null && atacado == null){
            alerta.alertaNoSeleccionoNingunPersonaje();
        }

        try {
            juego.atacarEspecial(coordAtacante,coordAtacado);
            Controlador.getControlador().actualizar();
        }catch (PersonajeInvalidoNoEsPersonajeMaloException e){
            alerta.alertaPersonajeNoEsEnemigo();
            this.inicializarValores();
        }catch (PersonajeInvalidoNoEsPersonajeBuenoException e){
            alerta.alertaPersonajeNoEsZ();
            this.inicializarValores();
        }catch (NoSePuedeCalcularLaDistanciaException e){
            alerta.alertaPersonajeAtacadoNoSePuedeCalcularDistancia();
            this.inicializarValores();
        }catch (NoSePuedeAtacarPersonajePorNoEstarEnDistanciaDeAtaqueException e){
            alerta.alertaPersonajeAtacadoNoSeEncuentraDentroDeDistanciaDeAtaque();
            this.inicializarValores();
        }catch (NoSeleccionoNingunPersonajeException e) {
            alerta.alertaNoSeleccionoNingunPersonaje();
            this.inicializarValores();
        } catch (NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException e){
            alerta.alertaNoPoseeSuficienteKiParaRealizarElAtaque();
            this.inicializarValores();
        } catch (PersonajeEnEstadoChocolateExcepcion ignored){
            alerta.alertaPersonajeEnEstadoChocolate();
            this.inicializarValores();
        }

        Controlador.getControlador().inicializarBotones();
        this.inicializarValores();
    }
}
