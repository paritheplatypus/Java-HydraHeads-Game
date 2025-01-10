package CS3330.hydragame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.*;
//import javafx.scene.layout.HBox;
//import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.Random;
import java.util.HashSet;
import java.util.Set;

public class HydraGameController {

    @FXML
    private VBox vbox;
    @FXML
    private Button play;
    @FXML
    private Button reset;
    @FXML
    private GridPane board; // The board to place heads
    @FXML
    private Slider headSizeSlider; // Slider to select the head size

    private Random random; // Random number generator for random placement
    private Set<String> occupiedPositions; // Set to keep track of occupied grid positions

    public void initialize(URL url, ResourceBundle rb) {
        random = new Random();  // Initialize the random object
        play = new Button("Play");
        play.setStyle("fx-padding: 20");
        play.setOnAction(this::play);
        reset = new Button("Reset");
        reset.setStyle("fx-padding: 20");
        reset.setOnAction(this::reset);
        board = new GridPane();

//        ColumnConstraints col1 = new ColumnConstraints();
//        col1.setPrefWidth(100);
//        ColumnConstraints col2 = new ColumnConstraints();
//        col2.setPrefWidth(100);
//        board.getColumnConstraints().addAll(col1, col2...16);
//        // same thing for rows
//        board.getRowConstraints().addAll(row1...16);
        board.setStyle("fx-padding: 20");
        headSizeSlider = new Slider(2, 6, 4);
        headSizeSlider.setShowTickLabels(true);
        headSizeSlider.setShowTickMarks(true);
        headSizeSlider.setMinorTickCount(0);
        headSizeSlider.setMajorTickUnit(1);
        headSizeSlider.setSnapToTicks(true);
        headSizeSlider.setStyle("fx-padding: 20");
        occupiedPositions = new HashSet<>(); // Initialize the set to track occupied positions
        headSizeSlider.setValue(4);
    }

    public void reset(ActionEvent event) {
        board.getChildren().clear();
        occupiedPositions.clear();
        //System.out.println("Game reset");
    }

    public void play(ActionEvent event) {
        int headSize = (int) headSizeSlider.getValue();
        // System.out.println("Head size is " + headSize);

        int gridX, gridY;
        do {
            gridX = random.nextInt(15);  // Random x-coordinate (assuming 8 columns, adjust as needed)
            gridY = random.nextInt(15);  // Random y-coordinate (assuming 8 rows, adjust as needed)
        }

        // Ensure the new position is not already occupied
        while (occupiedPositions.contains(gridX + "," + gridY));

        // Mark the position as occupied
        occupiedPositions.add(gridX + "," + gridY);

        // Create a new head with the selected size
        HydraHead head = HydraHeadsFactory.getHead(headSize);


        //System.out.println(gridX + "," + gridY);
        // Place the head at the random position on the board
        head.putIn(gridX, gridY, board);
        head.setOnMouseClicked((event1) -> {
            int randomHeads = random.nextInt(2,3);
            for (int i = 0; i < randomHeads; i++) {
                int a, b;
                do {
                    a = random.nextInt(15);  // Random x-coordinate (assuming 8 columns, adjust as needed)
                    b = random.nextInt(15);  // Random y-coordinate (assuming 8 rows, adjust as needed)
                }

                // Ensure the new position is not already occupied
                while (occupiedPositions.contains(a + "," + b));
                System.out.println(a + "," + b);
                // Mark the position as occupied
                occupiedPositions.add(a + "," + b);

                // Create a new head with the selected size
                HydraHead newHead = HydraHeadsFactory.getHead(headSize);


                //System.out.println(gridX + "," + gridY);
                // Place the head at the random position on the board
                newHead.putIn(a, b, board);
            }

            // how it's processed
            // generate 2/3 random heads
            // headsize -1
            // place in random positions
            // remove clicked head - remove from positions and board or make invisible
        });
    }

    public void setHeadSize(MouseEvent event) {
        int size = (int) headSizeSlider.getValue();
        //System.out.println("Head size set to: " + size);
    }

    public VBox getView() {
        HBox hbox = new HBox(play, headSizeSlider, reset);
        hbox.setStyle("-fx-padding: 20; -fx-alignment: center;");
        vbox = new VBox(hbox, board);
        vbox.setStyle("-fx-padding: 20;");
        return vbox;
    }
}
