package fiuba.algo3.vista;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.HashMap;
import java.util.Map;

public abstract class VistaPersonajes implements VistaUbicable{

    protected Map<String, String> urls;
    ContenedorPrincipal contenedorPrincipal;

    protected void inicializarVista(ContenedorPrincipal contenedor){
        this.contenedorPrincipal = contenedor;
        this.urls = new HashMap<>();
    }

    public void dibujarEnCampo(){

    }

    public abstract void dibujarEnCostado();

    public ImageView dibujar() {
        Image imagen = new Image(urls.get("urlImagenTablero"));
        ImageView contenedorImage = new ImageView();
        contenedorImage.setFitHeight(50);
        contenedorImage.setFitWidth(50);
        contenedorImage.setImage(imagen);
        contenedorImage.setOpacity(1);
        return contenedorImage;
    }

    public void cambiarImagenPorTransformacion() {
        String urlImagenTableroActual = this.urls.get("urlImagenTablero");
        String urlImagenCostadoActual = this.urls.get("urlImagenCostado");

        String urlImagenTableroTransformado = this.urls.get(urlImagenTableroActual);
        String urlImagenCostadoTransformado = this.urls.get(urlImagenCostadoActual);

        this.urls.put("urlImagenTablero", urlImagenTableroTransformado);
        this.urls.put("urlCostado", urlImagenCostadoTransformado);
    }

    public abstract ImageView dibujarTransformacion();
}
