import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class App extends javafx.application.Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("teste");

        // Botão com evento de clique
        Button button = new Button("teste de botão");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent arg0) {
                System.out.println("Clicou no botão");
            }
        });

        // Layout e cena
        StackPane root = new StackPane();
        root.getChildren().addAll(button);
        primaryStage.setScene(new Scene(root, 300, 250));

        // Mostra a janela
        primaryStage.show();
    }
}
