package chess;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ChessUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ChessGame chessGame = new ChessGame();

        ChessBoardUI chessBoardUI = new ChessBoardUI(chessGame);
        StackPane chessBoardContainer = new StackPane(chessBoardUI.getBoard());

        BorderPane root = new BorderPane();
        root.setCenter(chessBoardContainer);

        Scene scene = new Scene(root,800, 800);

        primaryStage.setTitle("Tamerlane Chess");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
