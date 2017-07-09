package fiuba.algo3.vista;

import fiuba.algo3.eventos.BotonAtaqueBasicoEventHandler;
import fiuba.algo3.eventos.BotonMoverEventHandler;
import fiuba.algo3.eventos.BotonTransformarEventHandler;
import fiuba.algo3.modelo.Personajes.Ubicable;

/**
 * Created by noe on 08/07/17.
 */
public class Controlador {

    private static Controlador instance = null;
    private BotonMoverEventHandler botonMover;
    private ContenedorPrincipal contenedor;
    private BotonAtaqueBasicoEventHandler botonAtaqueBasico;
    private BotonTransformarEventHandler botonTransformar;


    public static Controlador getControlador(){
        if (Controlador.instance == null){
            Controlador.instance = new Controlador();
        }
        return Controlador.instance;
    }

    public void setBotonMover(BotonMoverEventHandler botonMover){
        this.botonMover = botonMover;
    }

    public void setContenedor(ContenedorPrincipal contenedor){
        this.contenedor = contenedor;
    }

    public void setUbicable(Casillero1 casillero){
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
