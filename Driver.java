import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Point2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Driver extends Application {
    private int mode = 0;
    Group shapes = new Group();
    //Mode 0 is the default, and does not allow the user to draw. Once the user
    //presses a button, the mode will change and they can draw the corresponding shape.
    //NOTE: This class uses lowercase-m mode. Draw uses Mode.

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Paint Program FX-9000");
        //Think of root as a stage that holds a scene.
        Group root = new Group();
        Scene scene = new Scene(root, 1200, 800, Color.WHITE); //Dimensions and color for the window.
        //                       /\This assigns the scene to root.

        primaryStage.addEventHandler(MouseEvent.MOUSE_RELEASED, e -> mouseReleased(e));
        primaryStage.addEventHandler(MouseEvent.MOUSE_PRESSED, e -> mousePressed(e));

        Button rectangle_Button = new Button(); //Mode 1
        rectangle_Button.setText("Rectangle - Outline");
        rectangle_Button.setOnAction(e -> {
            mode = 1;
            //Draw.getMode(mode);
        });

        Button rectangle_Filled_Button = new Button(); //Mode 2
        rectangle_Filled_Button.setText("Rectangle - Filled");
        rectangle_Filled_Button.setOnAction(e -> {
            mode = 2;
            //Draw.getMode(mode);
        });

        Button oval_Button = new Button(); //Mode 3
        oval_Button.setText("Oval - Outline");
        oval_Button.setOnAction(e -> {
            mode = 3;
            //Draw.getMode(mode);
        });

        Button oval_Filled_Button = new Button(); //Mode 4
        oval_Filled_Button.setText("Oval - Filled");
        oval_Filled_Button.setOnAction(e -> {
            mode = 4;
            //Draw.getMode(mode);
        });

        Button line_Button = new Button(); //Mode 5
        line_Button.setText("Line");
        line_Button.setOnAction(e -> {
            mode = 5;
            //Draw.getMode(mode);
        });

        Button clear_Button = new Button(); //Mode 6, then 0.
        clear_Button.setText("Clear");
        clear_Button.setOnAction(e -> {
            mode = 6;
            //Draw.getMode(mode);
        });

        VBox vbox = new VBox(10); //This is a vertical layout for the buttons. The 10 is the spacing between buttons (padding).
        vbox.setPadding(new Insets(1)); //Or this might be padding. I forget what this does.

        vbox.getChildren().addAll(rectangle_Button, rectangle_Filled_Button, oval_Button, oval_Filled_Button, line_Button, clear_Button, shapes);
        //Add all of the nodes to the vbox
        root.getChildren().add(vbox);
        //Add the vbox to the root group.


        primaryStage.setScene(scene);//Assigns the scene to the stage.
        primaryStage.show();//Set the window to be visible.
    }



    //Following code is to handle mouse events.

    double x1, y1, x2, y2;

    public void mousePressed(MouseEvent e) {
        x1 = e.getSceneX();
        y1 = e.getSceneY();
    }

    public void mouseReleased(MouseEvent e) {
        //x2 = e.getSceneX();
        y2 = e.getSceneY();
        System.out.println(y2);

        switch (mode){
            case 0:
                break;
            case 5:
                Line line = new Line();
                line.setStartX(x1);
                line.setStartY(y1);
                line.setEndX(x2);
                line.setEndY(y2);
                shapes.getChildren().add(line);
                break;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }



}

