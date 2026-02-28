import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

public class RegistrationApp extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.getColumnConstraints().add(new ColumnConstraints(300));
        grid.getColumnConstraints().add(new ColumnConstraints(300));

        // TODO: Create Labels and TextFields

        Label lable = new Label("Student Name: ");
        Label classLabel = new Label("Select Course Here");
        var TextField = new TextField("Type Your Name");
        grid.add(lable, 0, 0);
        grid.add(TextField, 0, 1);
        grid.add(classLabel, 1, 0);
        // combobox
        String classOptions[] = { "CMP 500", "CMP 600", "CMP 700" };
        ComboBox combo = new ComboBox(FXCollections.observableArrayList(classOptions));
        TilePane tile = new TilePane(combo);
        grid.add(tile, 1, 1);

        // TODO: Create the Register Button
        Button button = new Button("Register");
        grid.add(button, 0, 3);

        // TODO: Implement the Button Action using a Lambda
        button.setOnAction(event -> {
            String inputName = TextField.getText();
            Label selectedClass = new Label(
                    "Registration Successful for " + inputName + " in " + combo.getValue() + "!");
            grid.add(selectedClass, 0, 4);

        });

        Scene scene = new Scene(grid, 600, 250);
        primaryStage.setTitle("Lehman Course Registration");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
