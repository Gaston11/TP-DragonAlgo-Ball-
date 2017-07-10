package fiuba.algo3.eventos;

import javafx.scene.control.Alert;

/**
 * Created by noe on 10/07/17.
 */
public final class Alertas {

    private Alert alerta;

    public static void alertaNoSePuedeTransformar() {
        alertaGenerica("Intente nuevamente", "No se puede transformar");
    }

    public static void alertaNoPerteneceEquipoEnemigo() {
        alertaGenerica("Intente nuevamente", "No pertenece a equipo Enemigo de la Tierra");
    }

    public static void alertaNoPerteneceEquipoZ() {
        alertaGenerica("Intente nuevamente", "No pertenece a Equipo Z");
    }

    public static void alertaPersonajeAtacadoNoSeEncuentraDentroDeDistanciaDeAtaque() {
        alertaGenerica("Intente nuevamente", "No se encuentra dentro del rango de ataque");
    }

    public static void alertaPersonajeAtacadoNoSePuedeCalcularDistancia() {
        alertaGenerica("Intente nuevamente", "Modo de ataque en lína recta.");
    }

    public static void alertaPersonajeNoEsZ() {
        alertaGenerica("Intente nuevamente", "No pertenece a equipo Z");
    }

    public static void alertaPersonajeNoEsEnemigo() {
        alertaGenerica("Intente nuevamente", "No pertenece a equipo enemigo");
    }

    public static void alertaNoSeleccionoNingunPersonaje() {
        alertaGenerica("Intente nuevamente", "No seleccionó ningún personaje");
    }

    public static void alertaNoPoseeSuficienteKiParaRealizarElAtaque() {
        alertaGenerica("Intente nuevamente", "No posee suficiente ki para atacar" );
    }

    public static void alertaPersonajeEnEstadoChocolate() {
        alertaGenerica("Personaje en estado chocolate");
    }

    public static void alertaGenerica(String texto){
        alertaGenerica(texto, "error");
    }

    public static void alertaGenerica(String texto, String header){
        alertaGenerica(texto, header, "Error");
    }

    public static void alertaGenerica(String texto, String header, String titulo){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(texto);
        alerta.show();
    }

}
