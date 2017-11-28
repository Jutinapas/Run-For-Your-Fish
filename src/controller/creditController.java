package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class creditController {

    @FXML
    private Button backButton;
    @FXML
    private Label creditLabel;

    public void initialize() {
        creditLabel.setText("นายจุตินภัส คลังเจริญกุล 5810400973\n\t - powered by JavaFX -");
    }

    public void handleBackButton() {
        Stage stage = (Stage) backButton.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/startPage.fxml"));
        try {
            stage.setScene(new Scene(loader.load(), 600, 600));
            stage.show();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

}
