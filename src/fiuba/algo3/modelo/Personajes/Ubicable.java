package fiuba.algo3.modelo.Personajes;

import fiuba.algo3.modelo.Componentes.Coordenada;
import javafx.scene.image.ImageView;

public interface Ubicable {

    ImageView dibujar();

    boolean esUnPersonaje();

    Coordenada getCoordenada();
}