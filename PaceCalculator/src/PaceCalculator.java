// Justin Terry
// Class (CECS 274-05)
// Project Name (Prog 1 - Pace Calculator)
// Due Date (Sep 21, 2017)


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class PaceCalculator extends Application {

	public void start(Stage mainStage) {
		// Creating pace object
		Pace pace = new Pace();
		// Changing title on the window
		mainStage.setTitle("Marathon Pace Calculator");
		mainStage.setMaxHeight(400);
		mainStage.setMinHeight(400);
		mainStage.setMaxWidth(600);
		mainStage.setMinWidth(600);

		// Creating and adjusting layout
		GridPane grid = new GridPane();
		Scene mainScene = new Scene(grid, 600, 400);
		grid.setPadding(new Insets(25, 25, 25, 25));
		grid.setVgap(10);
		grid.setHgap(15);

		// Sizing columns
		ColumnConstraints col1 = new ColumnConstraints();
		col1.setPercentWidth(35);
		ColumnConstraints col2 = new ColumnConstraints();
		col2.setPercentWidth(20);
		ColumnConstraints col3 = new ColumnConstraints();
		col3.setPercentWidth(45);
		grid.getColumnConstraints().addAll(col1, col2, col3);

		// Creating labels and text fields
		Label milesLabel = new Label("How many miles did you run?");
		Label hoursLabel = new Label("How many hours did it take?");
		Label minutesLabel = new Label("How many minutes did it take?");
		Label secondsLabel = new Label("How many seconds did it take?");
		Label thisPace = new Label("Pace this run: ");
		Label maraPace = new Label("Marathon time: ");
		Label tenKPace = new Label("10K time: ");
		Label nameOut = new Label("");
		Label thisPaceNum = new Label("--");
		Label maraPaceNum = new Label("--");
		Label tenKPaceNum = new Label("--");
		Label errorText = new Label("Input error, try again.");
		errorText.setTextFill(Color.web("#ff0000"));
		errorText.setVisible(false);
		TextField miles = new TextField();
		TextField hours = new TextField();
		TextField minutes = new TextField();
		TextField seconds = new TextField();
		TextField name  = new TextField();

		// Submit Button and Event Handler
		Button submit = new Button("Submit");
		submit.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				// Hide error message
				errorText.setVisible(false);
				// Check for correct number types in text fields, if correct get and display paces
				if (checkDouble(miles.getText()) && checkInt(hours.getText()) && checkInt(minutes.getText())
						&& checkInt(seconds.getText())) {
					pace.calcPace(Double.parseDouble(miles.getText()), Integer.parseInt(hours.getText()),
							Integer.parseInt(minutes.getText()), Integer.parseInt(seconds.getText()));
					if(name.getText().matches("")) {
						errorText.setVisible(true);
						
					}else {
						nameOut.setText("Great run " + name.getText() + "!");
						thisPaceNum.setText(pace.getThisPace() + " minutes per mile.");
						maraPaceNum.setText(pace.getMaraPace());
						tenKPaceNum.setText(pace.getTenKPace());
					}
					

				} else {
					// If not correct type display error message
					errorText.setVisible(true);
				}
			}
		});
		// End Submit Button

		// Populating GridPane
		grid.add(milesLabel, 0, 1);
		grid.add(hoursLabel, 0, 2);
		grid.add(minutesLabel, 0, 3);
		grid.add(secondsLabel, 0, 4);
		grid.add(new Label ("What's you name?"), 0, 0);
		grid.add(name, 2, 0);
		grid.add(miles, 2, 1);
		grid.add(hours, 2, 2);
		grid.add(minutes, 2, 3);
		grid.add(seconds, 2, 4);
		grid.add(submit, 1, 5);
		grid.add(thisPace, 1, 6);
		grid.add(thisPaceNum, 2, 6);
		grid.add(maraPace, 1, 7);
		grid.add(maraPaceNum, 2, 7);
		grid.add(tenKPace, 1, 8);
		grid.add(tenKPaceNum, 2, 8);
		grid.add(nameOut, 1, 9);
		grid.add(errorText, 0, 10);

		// Assigning scene to stage and starting stage
		mainStage.setScene(mainScene);
		mainStage.show();
	}

	public static void main(String args[]) {
		Application.launch(args);
	}

	// Error Checking Methods
	public static boolean checkInt(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	public static boolean checkDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
	// End Error Checking
}
