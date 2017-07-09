package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.Cell;

/**
 * Created by Nico on 9/7/2017.
 */
public class VistaCell extends VistaPersonajes{

    private final Cell cell;

    public VistaCell(Cell cell, ContenedorPrincipal contenedorPrincipal){
        inicializarVista(contenedorPrincipal);
        this.cell = cell;
        this.urls.put("urlImagenTablero", "file:src/fiuba/algo3/vista/imagenes/Cell.jpg");
        this.urls.put("urlImagenCostado", "file:src/fiuba/algo3/vista/imagenes/Cell.jpg");
        //Agregar las otras urls
    }

    @Override
    public void dibujarEnCostado() {

    }
}
