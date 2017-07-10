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
            Alertas.alertaNoSeleccionoNingunPersonaje();
        }

        try {
            juego.atacarEspecial(coordAtacante,coordAtacado);
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
        } catch (NoSePuedeAtacarPersonajePorNoPoseerKiSuficienteException e){
            Alertas.alertaNoPoseeSuficienteKiParaRealizarElAtaque();
            this.inicializarValores();
        } catch (PersonajeEnEstadoChocolateExcepcion ignored) {
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
}
