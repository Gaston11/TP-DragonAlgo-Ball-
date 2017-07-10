package fiuba.algo3.eventos;

import javafx.scene.control.Alert;

/**
 * Created by noe on 10/07/17.
 */
public class Alertas {

    public void alertaNoSePuedeTransformar() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No se puede transformar.");
        String mensaje = "Intente nuevamente";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void alertaNoPerteneceEquipoEnemigo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No pertenece a equipo enemigo.");
        String mensaje = "Intente nuevamente";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void alertaNoPerteneceEquipoZ() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No pertenece a equipo Z");
        String mensaje = "Intente nuevamente";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void alertaPersonajeAtacadoNoSeEncuentraDentroDeDistanciaDeAtaque() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("No se encuentra dentro de la distancia de ataque.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void alertaPersonajeAtacadoNoSePuedeCalcularDistancia() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" Modo de ataque en lineas rectas.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void alertaPersonajeNoEsZ() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" No pertenece a equipo Z.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void alertaPersonajeNoEsEnemigo() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" No pertenece a equipo enemigo.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void alertaNoSeleccionoNingunPersonaje() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" No selecciono ningun personaje.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void alertaNoPoseeSuficienteKiParaRealizarElAtaque() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText(" No posee suficiente ki para atacar.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void alertaPersonajeEnEstadoChocolate() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("Personaje en estado chocolate.");
        String mensaje = " Intente nuevamente.";
        alert.setContentText(mensaje);
        alert.show();
    }

    public void mostrarGanador(String s) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Excepcion");
        alert.setHeaderText("Tenemos un ganador!");
        String mensaje = s;
        alert.setContentText(mensaje);
        alert.show();
    }
}
