/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package colourfulcircle;

import javafx.util.Duration;
import javafx.animation.KeyValue;
import javafx.animation.KeyFrame;
import javafx.scene.Node;
import javafx.animation.Timeline;
import static java.lang.Math.random;
import javafx.scene.paint.Stop;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.shape.Rectangle;
import javafx.scene.effect.BoxBlur;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Group;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.BlendMode;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;

/**
 *
 * @author sonhal
 */
public class ColourfulCircle extends Application {
    
   @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);

      
    
    Group circles = new Group();
    for(int i = 0; i < 30; i++){
        Circle circle = new Circle(150, Color.web("white",0.05));
        circle.setStrokeType(StrokeType.OUTSIDE);
        circle.setStroke(Color.web("white", 0.16));
        circle.setStrokeWidth(4);
        circles.getChildren().add(circle);
    }
    
    
    Rectangle rek = new Rectangle(scene.getWidth(), scene.getHeight(),
    new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new 
         Stop[]{
            new Stop(0, Color.web("#f8bd55")),
            new Stop(0.14, Color.web("#c0fe56")),
            new Stop(0.28, Color.web("#5dfbc1")),
            new Stop(0.43, Color.web("#64c2f8")),
            new Stop(0.57, Color.web("#be4af7")),
            new Stop(0.71, Color.web("#ed5fc2")),
            new Stop(0.85, Color.web("#ef504c")),
            new Stop(1, Color.web("#f2660f")),}));
    rek.widthProperty().bind(scene.widthProperty());
    rek.heightProperty().bind(scene.heightProperty());
    
        circles.setEffect(new BoxBlur(10, 10, 3));
        
    Group blandings = new Group(new Group(new Rectangle(scene.getWidth(),scene.getHeight(),Color.BLACK),circles), rek);
    rek.setBlendMode(BlendMode.OVERLAY);
    
    
    
    Timeline time = new Timeline();
    for(Node circle : circles.getChildren()){
        time.getKeyFrames().addAll(
         
         new KeyFrame(Duration.ZERO, // set start position at 0
            new KeyValue(circle.translateXProperty(), random() * 800),
            new KeyValue(circle.translateYProperty(), random() * 600)
        ),
        new KeyFrame(new Duration(10000), // set end position at 40s
            new KeyValue(circle.translateXProperty(), random() * 800),
            new KeyValue(circle.translateYProperty(), random() * 600)      
         )
        );
    }
    time.play();
    
    root.getChildren().add(blandings);
        primaryStage.show();
    }
 
 public static void main(String[] args) {
        launch(args);
    }
    
}
