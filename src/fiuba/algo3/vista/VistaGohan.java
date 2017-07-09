package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.Gohan;

/**
 * Created by Nico on 9/7/2017.
 */
public class VistaGohan extends VistaPersonajes {

    private final Gohan gohan;

    public VistaGohan(Gohan gohan, ContenedorPrincipal contenedorPrincipal){
        inicializarVista(contenedorPrincipal);
        this.gohan = gohan;
        this.urls.put("urlImagenTablero", "file:src/fiuba/algo3/vista/imagenes/Gohan.jpg");
        this.urls.put("urlImagenCostado", "file:src/fiuba/algo3/vista/imagenes/Gohan.jpg");
        //Agregar las otras urls  y cambiar la de vista al costado
    }

    @Override
    public void dibujarEnCostado() {
        //Implementar
    }
}
