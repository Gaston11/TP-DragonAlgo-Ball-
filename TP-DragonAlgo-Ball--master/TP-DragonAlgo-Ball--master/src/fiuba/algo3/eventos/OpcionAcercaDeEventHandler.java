package fiuba.algo3.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Created by noe on 30/06/17.
 */
public class OpcionAcercaDeEventHandler implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent actionEvent) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Acerca de...");
            alert.setHeaderText("Moverse");
            String mensaje = "75.07 Algoritmos y  programación III.";
            alert.setContentText(mensaje);
            alert.show();
        }
}
