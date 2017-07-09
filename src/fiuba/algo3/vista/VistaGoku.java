package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.Goku;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nico on 5/7/2017.
 */
public class VistaGoku extends VistaPersonajes{


    private final Goku goku;

    public VistaGoku(Goku goku, ContenedorPrincipal contenedorPrincipal){
        inicializarVista(contenedorPrincipal);
        this.goku = goku;
        this.urls.put("urlImagenTablero", "file:src/fiuba/algo3/vista/imagenes/goku.png");
        this.urls.put("urlImagenCostado", "file:src/fiuba/algo3/vista/imagenes/goku.png");
        //Agregar las otras urls
    }

    @Override
    public void dibujarEnCostado() {
        //A impleementar
    }
}
