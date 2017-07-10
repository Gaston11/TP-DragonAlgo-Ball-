package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;
import javafx.scene.image.ImageView;

public interface UbicableV2 {

    String getDireccion();

    String getNombre();

    boolean esUnPersonaje();

    Coordenada getCoordenada();
}