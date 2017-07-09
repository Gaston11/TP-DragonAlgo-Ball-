package fiuba.algo3.vista;

import fiuba.algo3.eventos.BotonMoverEventHandler;
import fiuba.algo3.eventos.BotonTransformarEventHandler;
import fiuba.algo3.modelo.Personajes.UbicableV2;

/**
 * Created by noe on 08/07/17.
 */
public class Controlador {

    private static Controlador instance = null;
    private BotonMoverEventHandler botonMover;
    private ContenedorPrincipal contenedor;
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
    }

    public void actualizar(){
        this.contenedor.actualizar();
    }

    public void setBotonTransformar(BotonTransformarEventHandler botonTransformar) {
        this.botonTransformar = botonTransformar;
    }
}
