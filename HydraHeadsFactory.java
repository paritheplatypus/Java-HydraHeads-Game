package CS3330.hydragame;

import javafx.scene.image.Image;

public class HydraHeadsFactory {
    private static Image headSize1;
    private static Image headSize2;
    private static Image headSize3;
    private static Image headSize4;
    private static Image headSize5;
    private static Image headSize6;

    private HydraHeadsFactory() {
    }

    public static HydraHead getHead(int size) {
        HydraHead head = null;

        //System.out.println("Hi");
        switch (size) {
            case 1:
                headSize1 = new Image("file:src/resources/HeadSize1.png", 40, 40, false, false);
                head = new HydraHead(headSize1, 1);
                break;
            case 2:
                headSize2 = new Image("file:src/resources/headSize2.png", 40, 40, false, false);
                head = new HydraHead(headSize2, 2);
                break;
            case 3:
                headSize3 = new Image("file:src/resources/headSize3.png", 40, 40, false, false);
                head = new HydraHead(headSize3, 3);
                break;
            case 4:
                headSize4 = new Image("file:src/resources/headSize4.png", 40, 40, false, false);
                head = new HydraHead(headSize4, 4);
                break;
            case 5:
                headSize5 = new Image("file:src/resources/headSize5.png", 40, 40, false, false);
                head = new HydraHead(headSize5, 5);
                break;
            case 6:
                headSize6 = new Image("file:src/resources/headSize6.png", 40, 40, false, false);
                head = new HydraHead(headSize6, 6);
                break;
            default:
                throw new IllegalArgumentException("Invalid head size: " + size);
        }

        // Return a new HydraHead with the appropriate image and size
        //System.out.println(head);
        return head;
    }
}
