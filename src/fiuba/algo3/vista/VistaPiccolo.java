package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.Piccolo;

/**
 * Created by Nico on 9/7/2017.
 */
public class VistaPiccolo extends VistaPersonajes{

    private final Piccolo piccolo;

    public VistaPiccolo(Piccolo piccolo, ContenedorPrincipal contenedorPrincipal){
        inicializarVista(contenedorPrincipal);
        this.piccolo = piccolo;
        this.urls.put("urlImagenTablero", "file:src/fiuba/algo3/vista/imagenes/Piccolo.jpg");
        this.urls.put("urlImagenCostado", "file:src/fiuba/algo3/vista/imagenes/Piccolo.jpg");
        //Agregar las otras urls
    }

    @Override
    public void dibujarEnCostado() {
        //A Implementar
    }
}
