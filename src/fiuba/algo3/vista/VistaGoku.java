package fiuba.algo3.vista;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Nico on 5/7/2017.
 */
public class VistaGoku extends VistaUbicable implements VistaPersonajes{

    private Map<String, String> urls;

    public VistaGoku(){
        this.urls = new HashMap<>();
    }

    @Override
    public void cambiarImagenPorTransformacion() {
        this.urlVistaEnCostado = urls.get(this.urlVistaEnCostado);
        this.urlVistaEnTablero = urls.get(this.urlVistaEnTablero);
    }
}
