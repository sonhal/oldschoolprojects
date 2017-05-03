/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gol;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/**
 *
 * @author sonhal
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private MenuBar menuBar;
	@FXML private Canvas graphics;
	@FXML private ColorPicker colorPicker;
	@FXML private Slider sizeSlider;
	private List<Point> plist;
    
    private void draw() {
		GraphicsContext gc = graphics.getGraphicsContext2D();
		gc.clearRect(0, 0, graphics.widthProperty().doubleValue(), graphics.heightProperty().doubleValue());
		for ( Point p : plist ) {
			p.draw(gc, colorPicker.getValue(), sizeSlider.getValue());
		}
	}
    
    @FXML
    private Label label;
    
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @FXML
    private void handleB2Action() {
     System.out.println("mas");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
