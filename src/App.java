import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends javafx.application.Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginPage.fxml"));
        Parent root = loader.load();
        Controller controller = loader.getController();
        controller.setMainWindow(primaryStage);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        primaryStage.setOnCloseRequest(event -> {
            try {
                controller.getGerenciador().encerrarBanco();
                System.out.println("O programa está fechando...");
            } catch (Exception e) {
                System.err.println("Erro ao encerrar o banco: " + e.getMessage());
                event.consume();
            }
        });
        
    }
}
