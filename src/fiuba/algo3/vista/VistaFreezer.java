package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.Freezer;


/**
 * Created by Nico on 9/7/2017.
 */
public class VistaFreezer extends VistaPersonajes{

    private final Freezer freezer;

    public VistaFreezer(Freezer freezer, ContenedorPrincipal contenedorPrincipal){
        inicializarVista(contenedorPrincipal);
        this.freezer = freezer;
        this.urls.put("urlImagenTablero", "file:src/fiuba/algo3/vista/imagenes/freezer.jpg");
        this.urls.put("urlImagenCostado", "file:src/fiuba/algo3/vista/imagenes/freezer.jpg");
        //Agregar las otras urls
    }

    @Override
    public void dibujarEnCostado() {
        //Implementar
    }
}
