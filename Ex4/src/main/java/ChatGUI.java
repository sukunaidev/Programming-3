import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.PrintWriter;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

public class ChatGUI extends Application {

    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;
    String username;
    boolean isUsernameSet = false;

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);

        // TextField to Type
        var TextArea = new TextArea();
        TextArea.setEditable(false);
        grid.add(TextArea, 0, 1);
        var TextField = new TextField("Type To Chat");
        TextField.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode() == KeyCode.ENTER) {
                    if (out != null) {
                        out.println(TextField.getText());
                        TextField.clear();
                    } else if (TextField.getText() == "QUIT") {
                        out.print(username + "Left the chat!");
                        if (socket != null) {
                            try {
                                socket.close();
                            } catch (IOException e) {
                                System.err.println("Error closing socket: " + e.getMessage());
                            }
                        }

                    }
                    ke.consume();

                }
            }
        });

        grid.add(TextField, 0, 2);
        Button button = new Button("Send");
        grid.add(button, 1, 2);
        Button connectbutton = new Button("Connect");
        grid.add(connectbutton, 3, 0);

        // create a field to connect to a chat server via a socket

        var portText = new TextField("Enter Your Port");
        var IPText = new TextField("Enter Your IP");
        grid.add(portText, 0, 0);
        grid.add(IPText, 1, 0);

        connectbutton.setOnAction(event -> {

            String PortName = portText.getText();
            String IP = IPText.getText();
            int port = Integer.parseInt(PortName);

            try {

                socket = new Socket(IP, port);
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
                new Thread(() -> {
                    try {
                        String line;

                        while ((line = in.readLine()) != null) {
                            final String currentLine = line;
                            Platform.runLater(() -> TextArea.appendText(currentLine + "\n"));
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }).start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        button.setOnAction(event -> {
            if (!isUsernameSet) {
                out.println(TextField.getText());
                // TextArea.appendText("\n" + TextField.getText());
                username = TextField.getText();
                isUsernameSet = true;

                if (TextField.getText() == "QUIT") {
                    out.print(username + "Left the chat!");
                    if (socket != null) {
                        try {
                            socket.close();
                        } catch (IOException e) {
                            System.err.println("Error closing socket: " + e.getMessage());
                        }
                    }

                }

            } else {
                out.println(TextField.getText());
                // TextArea.appendText("\n" + TextField.getText());
            }

            TextField.clear();
        });

        Scene scene = new Scene(grid, 600, 250);
        primaryStage.setTitle("Chat");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
