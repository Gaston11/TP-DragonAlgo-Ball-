package fiuba.algo3.vista;

import fiuba.algo3.eventos.BotonAtaqueBasicoEventHandler;
import fiuba.algo3.eventos.BotonMoverEventHandler;
import fiuba.algo3.eventos.BotonTransformarEventHandler;
import fiuba.algo3.modelo.Componentes.Coordenada;
import fiuba.algo3.modelo.Juego.Juego;
import fiuba.algo3.modelo.Personajes.UbicableV2;

/**
 * Created by noe on 08/07/17.
 */
public class Controlador {

    private static Controlador instance = null;
    private BotonMoverEventHandler botonMover;
    private ContenedorPrincipal contenedor;
    private BotonAtaqueBasicoEventHandler botonAtaqueBasico;
    private BotonTransformarEventHandler botonTransformar;
    private Casillero1 casilleroAnterior;
    private Juego juego;


    public static Controlador getControlador(){
        if (Controlador.instance == null){
            Controlador.instance = new Controlador();
        }
        return Controlador.instance;
    }

    private Controlador(){
        this.casilleroAnterior = new Casillero1(0,0);
    }

    public void setBotonMover(BotonMoverEventHandler botonMover){
        this.botonMover = botonMover;
    }

    public void setContenedor(ContenedorPrincipal contenedor){
        this.contenedor = contenedor;
    }

    public void setJuego(Juego juego) { this.juego = juego; }


    public void setUbicable(Casillero1 casillero){
        Coordenada coordenada = new Coordenada(this.casilleroAnterior.getFila(), this.casilleroAnterior.getColumna());
        if(!juego.getTablero().celdaOcupadaConPersonaje(coordenada))
            this.casilleroAnterior.desmarcarCelda();
        casillero.marcarBorde();
        this.casilleroAnterior = casillero;
        botonMover.setUbicable(casillero);
        botonAtaqueBasico.setUbicable(casillero);
        botonTransformar.setUbicable(casillero);
    }

    public void actualizar(){
        this.contenedor.actualizar();
    }

    public void setBotonTransformar(BotonTransformarEventHandler botonTransformar) {
        this.botonTransformar = botonTransformar;
    }

    public void setBotonAtaqueBasico(BotonAtaqueBasicoEventHandler botonAtaqueBasico) {
        this.botonAtaqueBasico = botonAtaqueBasico;
    }

    public void inicializarBotones() {
        botonMover.inicializarValores();
        botonAtaqueBasico.inicializarValores();
        botonTransformar.inicializarValores();
    }
}
