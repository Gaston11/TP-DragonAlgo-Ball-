package fiuba.algo3.eventos;

import fiuba.algo3.modelo.Componentes.Ubicable;
import fiuba.algo3.vista.VistaGoku;
import fiuba.algo3.vista.VistaUbicable;

import java.util.HashMap;
import java.util.Map;


public class ControladorContenedorPrincipal {
    Map<String, VistaUbicable> diccionarioVistas;

    public ControladorContenedorPrincipal(){
        diccionarioVistas = new HashMap<>();
        diccionarioVistas.put("Goku", new VistaGoku());
    }



}
