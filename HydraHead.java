package CS3330.hydragame;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class HydraHead extends ImageView {
    private int headSize;
    private int currentGridX;
    private int currentGridY;
    private Image myImage;

    public HydraHead(Image image, int size) {
        headSize = size;
        myImage = image;
        this.currentGridX = -1;
        this.currentGridY = -1;
    }

    public int getHeadSize() {
        return headSize;
    }

    public int getGridX() {
        return currentGridX;
    }

    public int getGridY() {
        return currentGridY;
    }

    public void putIn(int gridX, int gridY, GridPane board) {
        this.currentGridX = gridX; // Update position
        this.currentGridY = gridY; // Update position

        ImageView headImageView = new ImageView(myImage); // Create an ImageView for the image
        headImageView.setFitWidth(40);  // Set the image width to match the size of heads (adjust as needed)
        headImageView.setFitHeight(40); // Set the image height to match the size of heads (adjust as needed)

        // Add the image view to the GridPane at the given coordinates
        board.add(headImageView, gridX, gridY);
    }
}
