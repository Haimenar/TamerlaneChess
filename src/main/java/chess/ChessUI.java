package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChessUI extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1000, 800);
        primaryStage.setTitle("Tamerlane Chess");
        primaryStage.setScene(scene);

        ChessBoardUI chessBoardUI = new ChessBoardUI();
        StackPane chessBoardContainer = new StackPane(chessBoardUI.getBoard());
        root.setCenter(chessBoardContainer);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
