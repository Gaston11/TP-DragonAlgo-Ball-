package fiuba.algo3.eventos;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import javafx.event.EventHandler;

import java.awt.*;

/**
 * Created by noe on 30/06/17.
 */
public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent>{

    Stage stage;
    MenuItem opcionPantallaCompleta;

    public OpcionPantallaCompletaEventHandler(Stage stage, MenuItem opcionPantallaCompleta) {
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!stage.isFullScreen()) {
            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            stage.show();
        }
    }
}
