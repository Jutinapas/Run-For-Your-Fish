package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class StartPageController {

    @FXML
    private Pane pane;

    private GingerCat gingerCat;
    private SmokeyCat smokeyCat;
    private SunnyCat sunnyCat;

    @FXML
    public void initialize() {
        gingerCat = new GingerCat(300, 300);
        smokeyCat = new SmokeyCat(100,300);
        sunnyCat = new SunnyCat(0,100);
        display();
    }

    @FXML
    public void display() {
        pane.getChildren().clear();
        gingerCat.draw();
        smokeyCat.draw();
        sunnyCat.draw();
        pane.getChildren().addAll(gingerCat, smokeyCat ,sunnyCat);
    }


}
