package CS3330.hydragame;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import java.io.IOException;

public class HydraGameApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("file:src/resources/hydraGame-view.fxml"));
        //BorderPane root = (BorderPane) fxmlLoader.load();
        HydraGameController controller = new HydraGameController();
        controller.initialize(null, null);
        fxmlLoader.setController(controller);
        //System.out.println("hey");
        Scene scene = new Scene(controller.getView(), 800, 850);
        //System.out.println("Hello");
        stage.setTitle("Hydra Game");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
