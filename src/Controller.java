import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    //Geral
    private String lastFXML;

    private Stage mainWindow;

    public String getLastFXML() {
        return lastFXML;
    }

    public void setLastFXML(String lastFXML) {
        this.lastFXML = lastFXML;
    }

    public void setMainWindow(Stage mainWindow) {
        this.mainWindow = mainWindow;
    }

    public Stage getMainWindow() {
        return mainWindow;
    }

    @FXML
    void onClickBack(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(lastFXML));
            Parent backRoot = loader.load();

            Controller backController = loader.getController();
            backController.setMainWindow(mainWindow);

            mainWindow.setScene(new Scene(backRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Login

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField pwdText;

    @FXML
    private TextField usrText;

    @FXML
    void onClickLogin(ActionEvent event) {
        String username = usrText.getText();
        String password = pwdText.getText();

        if (username.equals("admin") && password.equals("admin")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Menu.fxml"));
                Parent menuRoot = loader.load();

                Controller menuController = loader.getController();
                menuController.setMainWindow(mainWindow);

                mainWindow.setScene(new Scene(menuRoot));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("Login inválido");
        }
    }

    //Menu

    @FXML
    private Button carsButton;

    @FXML
    private Button clientsButton;

    @FXML
    private Button emplyButton;

    @FXML
    void onClickCars(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("ShowOrReserve.fxml"));
            Parent choiceRoot = loader.load();

            Controller choiceController = loader.getController();
            choiceController.setMainWindow(mainWindow);
            choiceController.setLastFXML("Menu.fxml");

            mainWindow.setScene(new Scene(choiceRoot));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onClickClient(ActionEvent event) {

    }

    @FXML
    void onClickEmply(ActionEvent event) {

    }

    //Escolha showroom ou pátio

    @FXML
    private Button backButton;

    @FXML
    private Button reserveButton;

    @FXML
    private Button showrButton;


    @FXML
    void onClickReserve(ActionEvent event) {

    }

    @FXML
    void onClickShowroom(ActionEvent event) {

    }
}
