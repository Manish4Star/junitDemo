package core;

import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

import javafx.scene.control.TextField;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class HomeScreen extends Application {
	
	private Button solnButton;
	private TextField answerTxtBox;
	private TextField leftOperandTxtBox;
	private TextField rightOperandTxtBox;
	private ComboBox<String> operatorDropdown;
	 
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		initUI(primaryStage);
		
	}

	private void initUI(Stage primaryStage) {
		// TODO Auto-generated method stub
		Pane canvas = new Pane();
		//canvas.setStyle("-fx-background-color: black");
		
		addControlsToCanvas(canvas);
	
		Scene scene = new Scene(canvas,320, 200);
		primaryStage.setScene(scene);
		primaryStage.setTitle("simple calculator");
		primaryStage.show();
	}

	private void addControlsToCanvas(Pane canvas) {
		// TODO Auto-generated method stub
		int row1 = 20;
		int row2 = 60;
		int txtBoxWidth = 50;
		
		Label label = new Label("Simple Calculator");
		label.relocate(row1, row1);
		
		
		leftOperandTxtBox = new TextField();
		leftOperandTxtBox.setMaxWidth(txtBoxWidth);
		leftOperandTxtBox.relocate(row1,row2);
		
		operatorDropdown = new ComboBox<String>();
		operatorDropdown.getItems().addAll("+","-","x","/","%");
		operatorDropdown.setValue("+");
		operatorDropdown.relocate(row1*4, row2);
		
		solnButton = new Button("=");
		solnButton.relocate(txtBoxWidth*4, row2);
		
		answerTxtBox = new TextField();
		answerTxtBox.setMaxWidth(txtBoxWidth);
		answerTxtBox.relocate(txtBoxWidth*5, row2);
		answerTxtBox.setEditable(false);
		
		rightOperandTxtBox = new TextField();
		rightOperandTxtBox.setMaxWidth(txtBoxWidth);
		rightOperandTxtBox.relocate(txtBoxWidth*3,row2);
		
		setSolnButtonClickHandler();
		
		canvas.getChildren().addAll(label, 
				leftOperandTxtBox, rightOperandTxtBox, 
				operatorDropdown, solnButton, answerTxtBox);
	}

	private void setSolnButtonClickHandler() {
		// TODO Auto-generated method stub
		solnButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Double leftOperand = Double.valueOf(leftOperandTxtBox.getText());
				Double rightOperand = Double.valueOf(rightOperandTxtBox.getText());
				String operator = operatorDropdown.getValue();
				
				ArithmiticSolver solver = new ArithmiticSolver();
				String answer = String.valueOf(solver.solve(operator, leftOperand, rightOperand));
				
				
				answerTxtBox.setText(answer);
			}
		});
	}

	
}
