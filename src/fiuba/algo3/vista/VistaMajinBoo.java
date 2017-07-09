package fiuba.algo3.vista;

import fiuba.algo3.modelo.Personajes.MajinBoo;

/**
 * Created by Nico on 9/7/2017.
 */
public class VistaMajinBoo extends VistaPersonajes{

    private final MajinBoo majinBoo;

    public VistaMajinBoo(MajinBoo majinBoo, ContenedorPrincipal contenedorPrincipal){
        inicializarVista(contenedorPrincipal);
        this.majinBoo = majinBoo;
        this.urls.put("urlImagenTablero", "file:src/fiuba/algo3/vista/imagenes/majinBoo.png");
        this.urls.put("urlImagenCostado", "file:src/fiuba/algo3/vista/imagenes/majinBoo.png");
        //Agregar las otras urls
    }

    @Override
    public void dibujarEnCostado() {

    }
}
