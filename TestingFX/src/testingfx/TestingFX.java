/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testingfx;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.Group;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author sonhal
 */
public class TestingFX extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       Group root = new Group();
       Scene scene = new Scene(root,600,500,Color.GREY);
       primaryStage.setScene(scene);
       primaryStage.show();
       
     
       Canvas canvas = new Canvas(scene.getWidth(),scene.getHeight());
       GraphicsContext gc = canvas.getGraphicsContext2D();
       drawShapes(gc);
       
       
       
       
    }
    
      int[][] boards = {{0,1,0},
                        {1,0,1},
                        {0,1,0}};
      
    
    
    private void drawShapes(GraphicsContext gc) {
    
    }
    
    public void draw2DRect(boards[i][i],boards[i][]){
        
    }
    
    
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
